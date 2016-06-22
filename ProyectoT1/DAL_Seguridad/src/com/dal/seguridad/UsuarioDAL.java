package com.dal.seguridad;

import java.sql.*;

import com.dal.comunes.*;
import com.el.comunes.*;
import com.el.seguridad.UsuarioEnt;

public class UsuarioDAL {
	
	//Singleton
			public static UsuarioDAL _Instancia;
			private UsuarioDAL(){}
			public static UsuarioDAL Instancia(){
				if(_Instancia==null)
				{
					_Instancia = new UsuarioDAL();
				}
				
				return _Instancia;
			}
    //endSingleton
			
			public UsuarioEnt VerificarAcceso(String _user, String _passw)throws Exception{
				Connection cn = conexion.Instancia().Conectar();
				UsuarioEnt u = null;
				try{
				
				CallableStatement cst = cn.prepareCall("{call sp_VerificarAccesoUsuario(?,?)}");
				cst.setString(1, _user);
				cst.setString(2, _passw);
				ResultSet rs = cst.executeQuery();
				if(rs.next())
				{
					u = new UsuarioEnt();
					u.setIdUsuario(rs.getInt("IdUsuario"));
					u.setUsuario(rs.getString("Usuario"));
					u.setActivo(rs.getBoolean("Activo"));
					EmpleadoEnt p = new EmpleadoEnt();
					   p.setNombre(rs.getString("Nombre"));
					   p.setApellidos(rs.getString("Apellidos"));
					   p.setDNI(rs.getString("DNI"));
					   p.setSexo(rs.getString("Sexo"));
					u.setEmpleado(p);
				}
				}catch(Exception e)
				{
					throw e;
				}finally{cn.close();}
				return u;
			}	

}
