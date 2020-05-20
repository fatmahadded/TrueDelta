package client.ManagedBeans.contractBean;

import Entities.*;
import java.io.Serializable;

import javax.faces.bean.*;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "data") 
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;
public type_contract[] gettypes_contracts() 
{ return type_contract.values(); }
}