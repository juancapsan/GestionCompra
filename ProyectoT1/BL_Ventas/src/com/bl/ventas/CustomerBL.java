package com.bl.ventas;

import java.util.ArrayList;

import com.dal.ventas.CustomerDAL;
import com.el.ventas.CustomerEnt;

public class CustomerBL {

	//Singleton
	public static CustomerBL _Instancia;
	private CustomerBL(){}
	public static CustomerBL Instancia(){
		if(_Instancia==null)
		{
			_Instancia = new CustomerBL();
		}
		
		return _Instancia;
	}
//endSingleton
	
	public ArrayList<CustomerEnt> ListarCustomer() throws Exception{
		try{
			return CustomerDAL.Instancia().ListarCustomer();
		}catch(Exception e){throw e;
		}
	}
	
	public CustomerEnt DevuelveCustomer(int IdCustomer) throws Exception{
		try{
			return CustomerDAL.Instancia().DevuelveCustomer(IdCustomer);
		}catch(Exception e){throw e;}
	}
	
	public boolean AgregarCustomer(CustomerEnt c,String Usuario) throws Exception{
		try{
			return CustomerDAL.Instancia().AgregarCustomer(c, Usuario);
		}catch(Exception e){throw e;}
	}
	
	public boolean ActualizarCustomer(CustomerEnt c,String Usuario) throws Exception{
		try{
			return CustomerDAL.Instancia().ActualizarCustomer(c, Usuario);
		}catch(Exception e){throw e;}
	}
	
	public boolean EliminarCustomer(int IdCustomer) throws Exception{
		try{
			return CustomerDAL.Instancia().EliminarCustomer(IdCustomer);
		}catch(Exception e){throw e;}
	}
}
