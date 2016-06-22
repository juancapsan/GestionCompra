package com.dal.ventas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import com.dal.comunes.conexion;
import com.el.ventas.PizzaEnt;

public class PizzaDAL {
	
	//Singleton
		public static PizzaDAL _Instancia;
		private PizzaDAL(){}
		public static PizzaDAL Instancia(){
			if(_Instancia==null)
			{
				_Instancia = new PizzaDAL();
			}
			
			return _Instancia;
		}
	//endSingleton
		
		public ArrayList<PizzaEnt> ListarPizza()throws Exception{
			Connection cn = conexion.Instancia().Conectar();
			ArrayList<PizzaEnt> lista = new ArrayList<PizzaEnt>();
			try{
			
			CallableStatement cst = cn.prepareCall("{call sp_listarPizzas()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next())
			{
				PizzaEnt p = new PizzaEnt();
				p.setIdPizza(rs.getInt("IdPizza"));
				p.setNombre(rs.getString("Nombre"));
				p.setDescripcion(rs.getString("Descripcion"));
				p.setPrecio(rs.getDouble("Precio"));
				p.setMasa(rs.getString("Masa"));
				p.setTipo(rs.getString("Tipo"));
				lista.add(p);
			}
			}catch(Exception e)
			{
				throw e;
			}finally{cn.close();}
			return lista;
		}
		
		public boolean AgregarPizza(PizzaEnt c) throws Exception{
			Connection cn = conexion.Instancia().Conectar();
			Boolean inserto = false;
			try{
				CallableStatement cst = cn.prepareCall("{call spVEN_AgregarPizza(?,?,?,?,?)}");
				cst.setString(1, c.getNombre());
				cst.setString(2, c.getDescripcion());
				cst.setDouble(3, c.getPrecio());
				cst.setString(4, c.getMasa());
				cst.setString(5, c.getTipo());
				int i = cst.executeUpdate();
				if(i>0){ inserto = true; }	
			}catch(Exception e){throw e;
			}finally{cn.close();}
			return inserto;
		}	
		
		public boolean ActualizarPizza(PizzaEnt c) throws Exception{
			Connection cn = conexion.Instancia().Conectar();
			Boolean editar = false;
			try{
				CallableStatement cst = cn.prepareCall("{call sp_ActualizarPizza(?,?,?,?,?,?)}");
				cst.setInt(1, c.getIdPizza() );
				cst.setString(2, c.getNombre());
				cst.setString(3, c.getDescripcion());
				cst.setDouble(4, c.getPrecio());
				cst.setString(5, c.getMasa());
				cst.setString(6, c.getTipo());
				int i = cst.executeUpdate();
				if(i>0){  editar = true; }
			}catch(Exception e){throw e;
			}finally{cn.close();}
			return editar;
		}	
		
		public PizzaEnt DevuelvePizza(int IdPizza) throws Exception{
			Connection cn = conexion.Instancia().Conectar();		
			PizzaEnt c = null;
			try{
				CallableStatement cst = cn.prepareCall("{call sp_DevuelvePizza(?)}");
				cst.setInt(1, IdPizza);
				ResultSet rs = cst.executeQuery();
				if(rs.next()){ 
					c = new PizzaEnt();  
					c.setIdPizza(rs.getInt("IdPizza"));
					c.setNombre(rs.getString("Nombre"));
					c.setDescripcion(rs.getString("Descripcion"));
					c.setPrecio(rs.getDouble("Precio"));
					c.setMasa(rs.getString("Masa"));
					c.setTipo(rs.getString("Tipo"));
			    }			
			}catch(Exception e){throw e;
			}finally{cn.close();}
			return c;
		}
		
		public boolean EliminarPizza(int IdPizza) throws Exception{
			Connection cn = conexion.Instancia().Conectar();
			Boolean eliminar = false;
			try{
				CallableStatement cst = cn.prepareCall("{call EliminarPizza(?)}");
				cst.setInt(1, IdPizza);
				int i = cst.executeUpdate();
				if(i>0){  eliminar = true; }
			   	
			}catch(Exception e){throw e;
			}finally{cn.close();}
			return eliminar;
		}	

}
