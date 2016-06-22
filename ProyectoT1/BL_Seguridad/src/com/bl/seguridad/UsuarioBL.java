package com.bl.seguridad;

import com.dal.seguridad.UsuarioDAL;
import com.el.seguridad.UsuarioEnt;

public class UsuarioBL {
	
	//Singleton
	public static UsuarioBL _Instancia;
	private UsuarioBL(){}
	public static UsuarioBL Instancia(){
		if(_Instancia==null)
		{
			_Instancia = new UsuarioBL();
		}
		
		return _Instancia;
	}
//endSingleton

	public 	UsuarioEnt VerificarAcceso(String _user,String _passw)throws Exception{
		try{
			UsuarioEnt u = UsuarioDAL.Instancia().VerificarAcceso(_user, _passw);
			if(u==null)
			{
				throw new Exception("Usuario o Password no Valido");
			}else{
				if(!u.isActivo()){
					throw new Exception("Su usuario ha sido dado de baja!");
				}
			}
			
			return u;
			
		}catch(Exception e){
			throw e;
		}
	}
	
}
