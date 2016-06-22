package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.ventas.CustomerBL;
import com.el.seguridad.UsuarioEnt;
import com.el.ventas.CustomerEnt;

import java.io.PrintWriter;

/**
 * Servlet implementation class sFrmCustomer
 */
@WebServlet("/sFrmCustomer")
public class sFrmCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sFrmCustomer() {
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
				
			int id =Integer.parseInt(request.getParameter("txtIdCustomer")==null?"0":request.getParameter("txtIdCustomer"));
			CustomerBL.Instancia().EliminarCustomer(id);	
			}
			
		      CustomerEnt p = new CustomerEnt();
		      int id =Integer.parseInt(request.getParameter("txtIdCustomer")==null?"0":request.getParameter("txtIdCustomer")); 
		      p.setIdCustomer(id);
		      p.setCodigo(request.getParameter("txtCodigo"));
		   	  p.setRazSocial(request.getParameter ("txtRazSocial"));
		   	  p.setDireccion(request.getParameter("txtDireccion"));
		      p.setTelefono(request.getParameter("txtTelefono"));
		      p.setMail(request.getParameter("txtMail"));
		      p.setTipocte(request.getParameter("txtTipocte"));
		      
		        HttpSession s = request.getSession();
				UsuarioEnt u = (UsuarioEnt)s.getAttribute("usuario");
			    String Mensaje = "";
				String Opcion = Integer.parseInt(request.getParameter("txtIdCustomer")==null?"0":request.getParameter("txtIdCustomer"))>0?"E":"N";
				if(Opcion.equals("N")){			
					boolean x = CustomerBL.Instancia().AgregarCustomer(p, u.getUsuario());
					if(x){Mensaje = "Se Inserto satisfactoriamente";}
				}
				if(Opcion.equals("E")){
					boolean x = CustomerBL.Instancia().ActualizarCustomer(p, u.getUsuario());
					if(x){Mensaje = "Se Edito satisfactoriamente";}
				}
				
				response.sendRedirect("frmCustomer.jsp?msj="+Mensaje);
		    
		}catch(Exception e){
			out.print("<script>alert('"+e.getMessage()+"')</script>");
			
		}
		
	}

}
