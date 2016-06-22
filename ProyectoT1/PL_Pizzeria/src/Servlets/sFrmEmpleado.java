package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.bl.comunes.EmpleadoBL;
import com.el.comunes.*;
/**
 * Servlet implementation class sFrmEmpleado
 */
@WebServlet("/sFrmEmpleado")
public class sFrmEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sFrmEmpleado() {
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
				
			int id =Integer.parseInt(request.getParameter("txtidEmpleado")==null?"0":request.getParameter("txtidEmpleado"));
			EmpleadoBL.Instancia().EliminarEmpleado(id);		
			}
		      EmpleadoEnt p = new EmpleadoEnt();
		      int id =Integer.parseInt(request.getParameter("txtidEmpleado")==null?"0":request.getParameter("txtidEmpleado")); 
		      p.setIdEmpleado(id);
		      p.setNombre(request.getParameter("txtNombre"));
		   	  p.setApellidos(request.getParameter ("txtApellidos"));
		   	  p.setSexo(request.getParameter("txtSexo"));
		      p.setEmail(request.getParameter("txtEmail"));
		      p.setDNI(request.getParameter("txtDni"));
			    String Mensaje = "";
				String Opcion = Integer.parseInt(request.getParameter("txtidEmpleado")==null?"0":request.getParameter("txtidEmpleado"))>0?"E":"N";
				if(Opcion.equals("N")){			
					boolean x = EmpleadoBL.Instancia().AgregarEmpleado(p);
					if(x){Mensaje = "Se Inserto satisfactoriamente";}
				}
				if(Opcion.equals("E")){
					boolean x = EmpleadoBL.Instancia().ActualizarEmpleado(p);
					if(x){Mensaje = "Se Edito satisfactoriamente";}
				}
				
				response.sendRedirect("frmEmpleado.jsp?msj="+Mensaje);
		    
		}catch(Exception e){
			out.print("<script>alert('"+e.getMessage()+"')</script>");
			
		}
	}

}
