package com.bl.ventas;

import java.util.ArrayList;

import com.dal.ventas.AgregadoDAL;
import com.el.ventas.AgregadoEnt;

public class AgregadoBL {

	//Singleton
	public static AgregadoBL _Instancia;
	private AgregadoBL(){}
	public static AgregadoBL Instancia(){
		if(_Instancia==null)
		{
			_Instancia = new AgregadoBL();
		}
		
		return _Instancia;
	}
//endSingleton
	
	public ArrayList<AgregadoEnt> ListarAgregados() throws Exception{
		try{
			return AgregadoDAL.Instancia().ListarAgregados();
		}catch(Exception e){throw e;
		}
	}
	
	public AgregadoEnt DevuelveAgregados(int IdAgregado) throws Exception{
		try{
			return AgregadoDAL.Instancia().DevuelveAgregado(IdAgregado);
		}catch(Exception e){throw e;}
	}
	
	public boolean InsertarAgregados(AgregadoEnt  c) throws Exception{
		try{
			return AgregadoDAL.Instancia().InsertarAgregados(c);
		}catch(Exception e){throw e;}
	}
	
	public boolean ActualizarAgregados(AgregadoEnt c) throws Exception{
		try{
			return AgregadoDAL.Instancia().ActualizarAgregados(c);
		}catch(Exception e){throw e;}
	}
	
	public boolean EliminarAgregados(int IdAgregado) throws Exception{
		try{
			return AgregadoDAL.Instancia().EliminarAgregado(IdAgregado);
		}catch(Exception e){throw e;}
	}
}
