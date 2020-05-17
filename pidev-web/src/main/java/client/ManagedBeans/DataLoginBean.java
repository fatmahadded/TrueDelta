package client.ManagedBeans;

import Entities.*;
import java.io.Serializable;

import javax.faces.bean.*;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "login_data") 
@ApplicationScoped
public class DataLoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	public Role[] getRoles() 
	{ return Role.values(); }
	}
