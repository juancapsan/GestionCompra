package com.bl.comunes;

import java.util.ArrayList;

import com.dal.comunes.MenuDal;
import com.el.comunes.MenuEnt;


public class MenuBL {
	
	//Singleton
			public static MenuBL _Instancia;
			private MenuBL(){}
			public static MenuBL Instancia(){
				if(_Instancia==null)
				{
					_Instancia = new MenuBL();
				}
				
				return _Instancia;
			}
		//endSingleton
			
			public ArrayList<MenuEnt> ListarMenu(String Usuario) throws Exception{
				try{
					return MenuDal.Instancia().ListarMenu(Usuario);
				}catch(Exception e){throw e;
				}
			}

}
