<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.bl.ventas.*" %>
<%@page import="com.el.ventas.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h3>Registro Pizza</h3>
   <%
                    PizzaEnt c = new PizzaEnt();
					if(request.getParameter("IdPizza")!=null){
						int id = Integer.parseInt(request.getParameter("IdPizza"));
						c = PizzaBL.Instancia().DevuelvePizza(id);
					}					
	 %>	
	 
	 <form method="post" action="sFrmPizza">
    <table border="1">
    <tr><td>idPizza:</td><td><input type="text" name="txtIdPizza" value="<%=c.getIdPizza()%>" /></td></tr>
    <tr>
      <td>Nombre</td>
      <td><input type="text" name="txtNombre" value="<%=c.getNombre()%>"/></td>
    </tr>
    <tr>
      <td>Descripcion</td>
      <td><input type="text" name="txtDescripcion" value="<%=c.getDescripcion() %>"/></td>
    </tr>
    <tr>
      <td>Precio</td>
      <td><input type="text" name="txtPrecio" value="<%=c.getPrecio() %>"/></td>
    </tr>
     <tr>
      <td>Masa</td>
      <td><input type="text" name="txtMasa" value="<%=c.getMasa() %>"/></td>
    </tr>
     <tr>
      <td>Tipo</td>
      <td><input type="text" name="txtTipo" value="<%=c.getTipo() %>"/></td>
    </tr>
    <tr>
      <td colspan="2">
		 <input type="submit" name="btnGrabar" value="Grabar"/>
		 <input type="submit" name="btnEliminar" value="Eliminar" <%if(request.getParameter("IdPizza")==null){out.print("disabled");} %> />
	  </td>
    </tr>
    </table>
  </form>
  
   <%
	out.print("<p style='color: blue'>"+request.getParameter("msj")+"</p>");
	%>
  <br/>
  
  <table border="1" style="width=100%">
      <thead style="background-color:yellow">
         <tr>
           <th>Nombre</th>
           <th>Descripcion</th>
           <th>Precio</th>
           <th>Masa</th>
           <th>Tipo</th>
           <th>----</th>
         </tr>
      </thead>
       <tbody>
       <%
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
       %>
       
       </tbody>
  </table>    
</body>
</html>