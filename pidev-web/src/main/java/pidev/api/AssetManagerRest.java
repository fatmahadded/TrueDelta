package pidev.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.AssetManager;
import interfaces.AssetManagerRemote;

@Path("/AssetManager")

public class AssetManagerRest {

	@EJB
	AssetManagerRemote Am;

	@Path("/AddAssetManager")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response addAssetManager(AssetManager assetMan) {
		Am.addAssetManager(assetMan);
		return Response.ok("added asset manager").build();
	}
	
	
	@POST
    @Path("/editEtatAm/{IdAssetManager}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editAssetManager(@PathParam("IdAssetManager") int idAssetManager) {
		
    	Am.updateEtatAssetManager(idAssetManager);
        return Response.ok(Am.getAssetManagerById(idAssetManager)).build();

    	//return Response.ok(cols.findAllCollection()).build();
    }
	
	
	

	@GET
	@Path("/AssetManagerByEtat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAssetManagerByEtat() {
		return Response.ok(Am.GetAllAssetManagerByEtat()).build();
		

	}
	@GET
	@Path("CalculPValue/{idAsset}/{idTrans}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response CalculDuPvalueAuCoursDelajournée(@PathParam("idAsset") int idAsset,@PathParam("idTrans") int idTrans) {
		return Response.ok(Am.CalculDuPvalueAuCoursDelajournée(idAsset,idTrans)).build();
}            }
