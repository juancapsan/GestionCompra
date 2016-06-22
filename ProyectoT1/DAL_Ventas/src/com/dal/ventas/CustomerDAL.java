package com.dal.ventas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dal.comunes.conexion;
import com.el.ventas.CustomerEnt;
public class CustomerDAL {
	
	//Singleton
			public static CustomerDAL _Instancia;
			private CustomerDAL(){}
			public static CustomerDAL Instancia(){
				if(_Instancia==null)
				{
					_Instancia = new CustomerDAL();
				}
				
				return _Instancia;
			}
    //endSingleton
			
		
			public ArrayList<CustomerEnt> ListarCustomer()throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				ArrayList<CustomerEnt> lista = new ArrayList<CustomerEnt>();
				try{
				
				CallableStatement cst = cn.prepareCall("{call sp_listarCustomer()}");
				ResultSet rs = cst.executeQuery();
				while(rs.next())
				{
					CustomerEnt p = new CustomerEnt();
					p.setIdCustomer(rs.getInt("idCustomer"));
					p.setCodigo(rs.getString("Codigo"));
					p.setRazSocial(rs.getString("RazSocial"));
					p.setDireccion(rs.getString("Direccion"));
					p.setTelefono(rs.getString("Telefono"));
					p.setMail(rs.getString("mail"));
					p.setTipocte(rs.getString("Tipocte"));
					lista.add(p);
				}
				}catch(Exception e)
				{
					throw e;
				}finally{cn.close();}
				return lista;
			}
			
			
			public boolean AgregarCustomer(CustomerEnt c,String Usuario) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean inserto = false;
				try{
					CallableStatement cst = cn.prepareCall("{call spVEN_AgregarCustomer(?,?,?,?,?,?,?)}");
					cst.setString(1, c.getCodigo());
					cst.setString(2, c.getRazSocial());
					cst.setString(3, c.getDireccion());
					cst.setString(4, c.getTelefono());
					cst.setString(5, c.getMail());
					cst.setString(6, c.getTipocte());
					cst.setString(7, Usuario);
					int i = cst.executeUpdate();
					if(i>0){ inserto = true; }	
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return inserto;
			}	
			
			public boolean ActualizarCustomer(CustomerEnt c,String Usuario) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean editar = false;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_ActualizarCustomer(?,?,?,?,?,?,?,?)}");
					cst.setInt(1, c.getIdCustomer() );
					cst.setString(2, c.getCodigo());
					cst.setString(3, c.getRazSocial());
					cst.setString(4, c.getDireccion());
					cst.setString(5, c.getTelefono());
					cst.setString(6, c.getMail());
					cst.setString(7, c.getTipocte());
					cst.setString(8, Usuario);
					int i = cst.executeUpdate();
					if(i>0){  editar = true; }
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return editar;
			}	
			
			public CustomerEnt DevuelveCustomer(int IdCustomer) throws Exception{
				Connection cn = conexion.Instancia().Conectar();		
				CustomerEnt c = null;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_DevuelveCustomer(?)}");
					cst.setInt(1, IdCustomer);
					ResultSet rs = cst.executeQuery();
					if(rs.next()){ 
						c = new CustomerEnt();  
						c.setIdCustomer(rs.getInt("idCustomer"));
						c.setCodigo(rs.getString("Codigo"));
						c.setRazSocial(rs.getString("RazSocial"));
						c.setDireccion(rs.getString("Direccion"));
						c.setTelefono(rs.getString("Telefono"));
						c.setMail(rs.getString("mail"));
						c.setTipocte(rs.getString("Tipocte"));
				    }			
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return c;
			}
			
			public boolean EliminarCustomer(int IdCustomer) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean eliminar = false;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_EliminarCustomer(?)}");
					cst.setInt(1, IdCustomer);
					int i = cst.executeUpdate();
					if(i>0){  eliminar = true; }
				   	
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return eliminar;
			}	

}
