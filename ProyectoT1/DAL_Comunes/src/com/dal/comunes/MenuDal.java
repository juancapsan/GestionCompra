package com.dal.comunes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.el.comunes.MenuEnt;

public class MenuDal {

	//Singleton
		public static MenuDal _Instancia;
		private MenuDal(){}
		public static MenuDal Instancia(){
			if(_Instancia==null)
			{
				_Instancia = new MenuDal();
			}
			
			return _Instancia;
		}
	//endSingleton
		
		public ArrayList<MenuEnt> ListarMenu(String Usuario)throws Exception{
			Connection cn = conexion.Instancia().Conectar();
			ArrayList<MenuEnt> lista = new ArrayList<MenuEnt>();
			try{
			
			CallableStatement cst = cn.prepareCall("{call sp_listarMenu(?)}");
			cst.setString(1, Usuario);
			ResultSet rs = cst.executeQuery();
			while(rs.next())
			{
				MenuEnt p = new MenuEnt();
				p.setIdMenu(rs.getInt("IdMenu"));
				p.setNombre(rs.getString("Nombre"));
				p.setComponente(rs.getString("Componente"));
				lista.add(p);
			}
			}catch(Exception e)
			{
				throw e;
			}finally{cn.close();}
			return lista;
		}
}
