package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.ventas.PizzaBL;
import com.el.ventas.PizzaEnt;

import java.io.PrintWriter;

/**
 * Servlet implementation class sFrmPizza
 */
@WebServlet("/sFrmPizza")
public class sFrmPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sFrmPizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		try{
			if(request.getParameter("btnEliminar")!=null)
			{	
				
			int id =Integer.parseInt(request.getParameter("txtIdPizza")==null?"0":request.getParameter("txtIdPizza"));
			PizzaBL.Instancia().EliminarPizza(id);		
			}
			
		      PizzaEnt p = new PizzaEnt();
		      int id =Integer.parseInt(request.getParameter("txtIdPizza")==null?"0":request.getParameter("txtIdPizza")); 
		      p.setIdPizza(id);
		      p.setNombre(request.getParameter("txtNombre"));
		   	  p.setDescripcion(request.getParameter ("txtDescripcion"));
		   	  p.setPrecio(Double.valueOf(request.getParameter("txtPrecio")));
		      p.setMasa(request.getParameter("txtMasa"));
		      p.setTipo(request.getParameter("txtTipo"));
			    String Mensaje = "";
				String Opcion = Integer.parseInt(request.getParameter("txtIdPizza")==null?"0":request.getParameter("txtIdPizza"))>0?"E":"N";
				if(Opcion.equals("N")){			
					boolean x = PizzaBL.Instancia().AgregarPizza(p);
					if(x){Mensaje = "Se Inserto satisfactoriamente";}
				}
				if(Opcion.equals("E")){
					boolean x = PizzaBL.Instancia().ActualizarPizza(p);
					if(x){Mensaje = "Se Edito satisfactoriamente";}
				}
				
				response.sendRedirect("frmPizza.jsp?msj="+Mensaje);
		    
		}catch(Exception e){
			out.print("<script>alert('"+e.getMessage()+"')</script>");
			
		}
		
		
		
	}

}
