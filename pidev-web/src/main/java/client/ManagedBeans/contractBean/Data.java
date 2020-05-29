package client.ManagedBeans.contractBean;

import Entities.Choix;
import Entities.Type;
import java.io.Serializable;

import javax.faces.bean.*;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "data") 
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;
public Type[] getTypes() { return Type.values(); }
public Choix[] getChoixs() { return Choix.values(); }


}