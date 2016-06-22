package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.ventas.AgregadoBL;
import com.el.ventas.AgregadoEnt;

import java.io.PrintWriter;

/**
 * Servlet implementation class sFrmAgregados
 */
@WebServlet("/sFrmAgregados")
public class sFrmAgregados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sFrmAgregados() {
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
			if(request.getParameter("btnEliminar")!=null){	
				
			int id =Integer.parseInt(request.getParameter("txtIdAgregado")==null?"0":request.getParameter("txtIdAgregado"));
			AgregadoBL.Instancia().EliminarAgregados(id);	
			}
			
		      AgregadoEnt p = new AgregadoEnt();
		      int id =Integer.parseInt(request.getParameter("txtIdAgregado")==null?"0":request.getParameter("txtIdAgregado")); 
		      p.setIdAgregado(id);
		      p.setNombre(request.getParameter("txtNombre"));
		   	  p.setDescripcion(request.getParameter ("txtDescripcion"));
		   	  p.setPrecio(Double.valueOf(request.getParameter("txtPrecio")));
		      p.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
		      p.setPrecioOferta(Double.valueOf(request.getParameter("txtPrecioOferta")));
			    String Mensaje = "";
				String Opcion = Integer.parseInt(request.getParameter("txtIdAgregado")==null?"0":request.getParameter("txtIdAgregado"))>0?"E":"N";
				if(Opcion.equals("N")){			
					boolean x = AgregadoBL.Instancia().InsertarAgregados(p);
					if(x){Mensaje = "Se Inserto satisfactoriamente";}
				}
				if(Opcion.equals("E")){
					boolean x = AgregadoBL.Instancia().ActualizarAgregados(p);
					if(x){Mensaje = "Se Edito satisfactoriamente";}
				}
				
				response.sendRedirect("frmAgregados.jsp?msj="+Mensaje);
		    
		}catch(Exception e){
			out.print("<script>alert('"+e.getMessage()+"')</script>");
			
		}
	}

}
