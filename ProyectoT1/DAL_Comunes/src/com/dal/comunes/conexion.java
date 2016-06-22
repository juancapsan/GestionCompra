package com.dal.comunes;
import java.sql.*;
public class conexion {
	
	//Singleton
		public static conexion _Instancia;
		private conexion(){}
		public static conexion Instancia(){
			if(_Instancia==null)
			{
				_Instancia = new conexion();
			}
			
			return _Instancia;
		}
	//endSingleton
		
		public Connection Conectar() throws Exception{
			Connection cn = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
				"databaseName=PizzeriaBD","sa","123456");
				
			}catch(Exception e){
				throw e;
			}
			return cn;
		}

}
