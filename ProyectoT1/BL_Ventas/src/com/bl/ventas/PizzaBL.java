package com.bl.ventas;

import java.util.ArrayList;

import com.dal.ventas.PizzaDAL;
import com.el.ventas.PizzaEnt;

public class PizzaBL {
	
	//Singleton
			public static PizzaBL _Instancia;
			private PizzaBL(){}
			public static PizzaBL Instancia(){
				if(_Instancia==null)
				{
					_Instancia = new PizzaBL();
				}
				
				return _Instancia;
			}
	//endSingleton
			
			public ArrayList<PizzaEnt> ListarPizza() throws Exception{
				try{
					return PizzaDAL.Instancia().ListarPizza();
				}catch(Exception e){throw e;
				}
			}
			
			public PizzaEnt DevuelvePizza(int IdPizza) throws Exception{
				try{
					return PizzaDAL.Instancia().DevuelvePizza(IdPizza);
				}catch(Exception e){throw e;}
			}
			
			public boolean AgregarPizza(PizzaEnt c) throws Exception{
				try{
					return PizzaDAL.Instancia().AgregarPizza(c);
				}catch(Exception e){throw e;}
			}
			
			public boolean ActualizarPizza(PizzaEnt c) throws Exception{
				try{
					return PizzaDAL.Instancia().ActualizarPizza(c);
				}catch(Exception e){throw e;}
			}
			
			public boolean EliminarPizza(int IdPizza) throws Exception{
				try{
					return PizzaDAL.Instancia().EliminarPizza(IdPizza);
				}catch(Exception e){throw e;}
			}


}
