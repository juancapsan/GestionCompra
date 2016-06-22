package com.bl.comunes;

import java.util.ArrayList;

import com.dal.comunes.*;
import com.el.comunes.*;

public class EmpleadoBL {
	
	
	//Singleton
		public static EmpleadoBL _Instancia;
		private EmpleadoBL(){}
		public static EmpleadoBL Instancia(){
			if(_Instancia==null)
			{
				_Instancia = new EmpleadoBL();
			}
			
			return _Instancia;
		}
	//endSingleton
		
		public ArrayList<EmpleadoEnt> ListarEmpleado() throws Exception{
			try{
				return EmpleadoDal.Instancia().ListadoEmpleado();
			}catch(Exception e){throw e;
			}
		}
		
		public EmpleadoEnt DevuelveEmpleado(int idEmpleado) throws Exception{
			try{
				return EmpleadoDal.Instancia().DevuelveEmpleado(idEmpleado);
			}catch(Exception e){throw e;}
		}
		
		public boolean AgregarEmpleado(EmpleadoEnt c) throws Exception{
			try{
				return EmpleadoDal.Instancia().AgregarPersona(c);
			}catch(Exception e){throw e;}
		}
		
		public boolean ActualizarEmpleado(EmpleadoEnt c) throws Exception{
			try{
				return EmpleadoDal.Instancia().ActualizarPersona(c);
			}catch(Exception e){throw e;}
		}
		
		public boolean EliminarEmpleado(int IdEmpleado) throws Exception{
			try{
				return EmpleadoDal.Instancia().EliminarPersona(IdEmpleado);
			}catch(Exception e){throw e;}
		}

}
