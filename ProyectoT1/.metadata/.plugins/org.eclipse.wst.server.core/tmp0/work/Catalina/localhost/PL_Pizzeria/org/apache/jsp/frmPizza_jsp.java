/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-09-18 18:16:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bl.ventas.*;
import com.el.ventas.*;
import java.util.*;

public final class frmPizza_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("     <h3>Registro Pizza</h3>\r\n");
      out.write("   ");

                    PizzaEnt c = new PizzaEnt();
					if(request.getParameter("IdPizza")!=null){
						int id = Integer.parseInt(request.getParameter("IdPizza"));
						c = PizzaBL.Instancia().DevuelvePizza(id);
					}					
	 
      out.write("\t\r\n");
      out.write("\t \r\n");
      out.write("\t <form method=\"post\" action=\"sFrmPizza\">\r\n");
      out.write("    <table border=\"1\">\r\n");
      out.write("    <tr><td>idPizza:</td><td><input type=\"text\" name=\"txtIdPizza\" value=\"");
      out.print(c.getIdPizza());
      out.write("\" /></td></tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Nombre</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"txtNombre\" value=\"");
      out.print(c.getNombre());
      out.write("\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Descripcion</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"txtDescripcion\" value=\"");
      out.print(c.getDescripcion() );
      out.write("\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Precio</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"txtPrecio\" value=\"");
      out.print(c.getPrecio() );
      out.write("\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("      <td>Masa</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"txtMasa\" value=\"");
      out.print(c.getMasa() );
      out.write("\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("      <td>Tipo</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"txtTipo\" value=\"");
      out.print(c.getTipo() );
      out.write("\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td colspan=\"2\">\r\n");
      out.write("\t\t <input type=\"submit\" name=\"btnGrabar\" value=\"Grabar\"/>\r\n");
      out.write("\t\t <input type=\"submit\" name=\"btnEliminar\" value=\"Eliminar\" ");
if(request.getParameter("IdPizza")==null){out.print("disabled");} 
      out.write(" />\r\n");
      out.write("\t  </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("  </form>\r\n");
      out.write("  \r\n");
      out.write("   ");

	out.print("<p style='color: blue'>"+request.getParameter("msj")+"</p>");
	
      out.write("\r\n");
      out.write("  <br/>\r\n");
      out.write("  \r\n");
      out.write("  <table border=\"1\" style=\"width=100%\">\r\n");
      out.write("      <thead style=\"background-color:yellow\">\r\n");
      out.write("         <tr>\r\n");
      out.write("           <th>Nombre</th>\r\n");
      out.write("           <th>Descripcion</th>\r\n");
      out.write("           <th>Precio</th>\r\n");
      out.write("           <th>Masa</th>\r\n");
      out.write("           <th>Tipo</th>\r\n");
      out.write("           <th>----</th>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </thead>\r\n");
      out.write("       <tbody>\r\n");
      out.write("       ");

       try{
         ArrayList<PizzaEnt> lista = PizzaBL.Instancia().ListarPizza();
         for(int i=0;i<lista.size();i++)
         {
        	 out.print("<tr>");
        	 out.print("<td>"+lista.get(i).getNombre()+"</td>");
        	 out.print("<td>"+lista.get(i).getDescripcion()+"</td>");
        	 out.print("<td>"+lista.get(i).getPrecio()+"</td>");
        	 out.print("<td>"+lista.get(i).getMasa()+"</td>");
        	 out.print("<td>"+lista.get(i).getTipo()+"</td>");
        	 out.print("<td><a href='frmPizza.jsp?IdPizza="+
						lista.get(i).getIdPizza()+"'>Editar</a></td>");
        	 out.print("</tr>");
         }
      }catch(Exception e)
       {
    	   out.print("<h3>"+e.getMessage()+"</h3>");
       }
       
      out.write("\r\n");
      out.write("       \r\n");
      out.write("       </tbody>\r\n");
      out.write("  </table>    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
