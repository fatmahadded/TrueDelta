package ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class IndexBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String page_name = "Index";

	
	
	public IndexBean() {
		super();
	}

	public String getPage_name() {
		return page_name;
	}

	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	
	
	
}
