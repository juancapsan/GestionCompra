package com.dal.ventas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dal.comunes.conexion;
import com.el.ventas.AgregadoEnt;

public class AgregadoDAL {
	//Singleton
			public static AgregadoDAL _Instancia;
			private AgregadoDAL(){}
			public static AgregadoDAL Instancia(){
				if(_Instancia==null)
				{
					_Instancia = new AgregadoDAL();
				}
				
				return _Instancia;
			}
		//endSingleton
			
			public ArrayList<AgregadoEnt> ListarAgregados()throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				ArrayList<AgregadoEnt> lista = new ArrayList<AgregadoEnt>();
				try{
				
				CallableStatement cst = cn.prepareCall("{call sp_listarAgregados()}");
				ResultSet rs = cst.executeQuery();
				while(rs.next())
				{
					AgregadoEnt p = new AgregadoEnt();
					p.setIdAgregado(rs.getInt("IdAgregado"));
					p.setNombre(rs.getString("Nombre"));
					p.setDescripcion(rs.getString("Descripcion"));
					p.setPrecio(rs.getDouble("Precio"));
					p.setCantidad(rs.getInt("Cantidad"));
					p.setPrecioOferta(rs.getDouble("PrecioOferta"));
					lista.add(p);
				}
				}catch(Exception e)
				{
					throw e;
				}finally{cn.close();}
				return lista;
			}
			
			
			public boolean InsertarAgregados(AgregadoEnt c) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean inserto = false;
				try{
					CallableStatement cst = cn.prepareCall("{call spVEN_InsertarAgregados(?,?,?,?,?)}");
					cst.setString(1, c.getNombre());
					cst.setString(2, c.getDescripcion());
					cst.setDouble(3, c.getPrecio());
					cst.setInt(4, c.getCantidad());
					cst.setDouble(5, c.getPrecioOferta());
					int i = cst.executeUpdate();
					if(i>0){ inserto = true; }	
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return inserto;
			}	
			
			public boolean ActualizarAgregados(AgregadoEnt c) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean editar = false;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_ActualizarAgregados(?,?,?,?,?,?)}");
					cst.setInt(1, c.getIdAgregado() );
					cst.setString(2, c.getNombre());
					cst.setString(3, c.getDescripcion());
					cst.setDouble(4, c.getPrecio());
					cst.setInt(5, c.getCantidad());
					cst.setDouble(6, c.getPrecioOferta());
					int i = cst.executeUpdate();
					if(i>0){  editar = true; }
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return editar;
			}	
			
			public AgregadoEnt DevuelveAgregado(int IdAgregado) throws Exception{
				Connection cn = conexion.Instancia().Conectar();		
				AgregadoEnt c = null;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_DevuelveAgregado(?)}");
					cst.setInt(1, IdAgregado);
					ResultSet rs = cst.executeQuery();
					if(rs.next()){ 
						c = new AgregadoEnt();  
						c.setIdAgregado(rs.getInt("IdAgregado"));
						c.setNombre(rs.getString("Nombre"));
						c.setDescripcion(rs.getString("Descripcion"));
						c.setPrecio(rs.getDouble("Precio"));
						c.setCantidad(rs.getInt("Cantidad"));
						c.setPrecioOferta(rs.getDouble("PrecioOferta"));
				    }			
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return c;
			}
			
			public boolean EliminarAgregado(int IdAgregado) throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				Boolean eliminar = false;
				try{
					CallableStatement cst = cn.prepareCall("{call sp_EliminarAgregado(?)}");
					cst.setInt(1, IdAgregado);
					int i = cst.executeUpdate();
					if(i>0){  eliminar = true; }
				   	
				}catch(Exception e){throw e;
				}finally{cn.close();}
				return eliminar;
			}	
}
