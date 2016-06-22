package com.dal.comunes;

import java.sql.*;
import java.util.ArrayList;

import com.el.comunes.EmpleadoEnt;

public class EmpleadoDal {
	
//Singleton
	public static EmpleadoDal _Instancia;
	private EmpleadoDal(){}
	public static EmpleadoDal Instancia(){
		if(_Instancia==null)
		{
			_Instancia = new EmpleadoDal();
		}
		
		return _Instancia;
	}
//endSingleton
	
	
	public ArrayList<EmpleadoEnt> ListadoEmpleado()throws Exception{
		Connection cn = conexion.Instancia().Conectar();
		ArrayList<EmpleadoEnt> lista = new ArrayList<EmpleadoEnt>();
		try{
		
		CallableStatement cst = cn.prepareCall("{call spjcs_listarEmpleado()}");
		ResultSet rs = cst.executeQuery();
		while(rs.next())
		{
			EmpleadoEnt p = new EmpleadoEnt();
			p.setIdEmpleado(rs.getInt("IdEmpleado"));
			p.setNombre(rs.getString("Nombre"));
			p.setApellidos(rs.getString("Apellidos"));
			p.setSexo(rs.getString("Sexo"));
			p.setEmail(rs.getString("Email"));
			p.setDNI(rs.getString("DNI"));
			lista.add(p);
		}
		}catch(Exception e)
		{
			throw e;
		}finally{cn.close();}
		return lista;
	}
	
	
	public boolean AgregarPersona(EmpleadoEnt c) throws Exception{
		Connection cn = conexion.Instancia().Conectar();
		Boolean inserto = false;
		try{
			CallableStatement cst = cn.prepareCall("{call spVEN_AgregarPersona(?,?,?,?,?)}");
			cst.setString(1, c.getNombre());
			cst.setString(2, c.getApellidos());
			cst.setString(3, c.getSexo());
			cst.setString(4, c.getEmail());
			cst.setString(5, c.getDNI());
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }	
		}catch(Exception e){throw e;
		}finally{cn.close();}
		return inserto;
	}	
	
	public boolean ActualizarPersona(EmpleadoEnt c) throws Exception{
		Connection cn = conexion.Instancia().Conectar();
		Boolean editar = false;
		try{
			CallableStatement cst = cn.prepareCall("{call sp_ActualizarEmpleado(?,?,?,?,?,?)}");
			cst.setInt(1, c.getIdEmpleado() );
			cst.setString(2, c.getNombre());
			cst.setString(3, c.getApellidos());
			cst.setString(4, c.getSexo());
			cst.setString(5, c.getEmail());
			cst.setString(6, c.getDNI());
			int i = cst.executeUpdate();
			if(i>0){  editar = true; }
		}catch(Exception e){throw e;
		}finally{cn.close();}
		return editar;
	}	
	
	public EmpleadoEnt DevuelveEmpleado(int IdEmpleado) throws Exception{
		Connection cn = conexion.Instancia().Conectar();		
		EmpleadoEnt c = null;
		try{
			CallableStatement cst = cn.prepareCall("{call sp_DevuelveEmpleado(?)}");
			cst.setInt(1, IdEmpleado);
			ResultSet rs = cst.executeQuery();
			if(rs.next()){ 
				c = new EmpleadoEnt();  
				c.setIdEmpleado(rs.getInt("IdEmpleado"));
				c.setNombre(rs.getString("Nombre"));
				c.setApellidos(rs.getString("Apellidos"));
				c.setSexo(rs.getString("Sexo"));
				c.setEmail(rs.getString("Email"));
				c.setDNI(rs.getString("DNI"));
		    }			
		}catch(Exception e){throw e;
		}finally{cn.close();}
		return c;
	}
	
	
	public boolean EliminarPersona(int IdEmpleado) throws Exception{
		Connection cn = conexion.Instancia().Conectar();
		Boolean eliminar = false;
		try{
			CallableStatement cst = cn.prepareCall("{call sp_EliminarEmpleado(?)}");
			cst.setInt(1, IdEmpleado);
			int i = cst.executeUpdate();
			if(i>0){  eliminar = true; }
		   	
		}catch(Exception e){throw e;
		}finally{cn.close();}
		return eliminar;
	}	


}
