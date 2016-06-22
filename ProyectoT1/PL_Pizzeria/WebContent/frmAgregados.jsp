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
         <h3>Registro Agregados</h3>
   <%
                    AgregadoEnt c = new  AgregadoEnt();
					if(request.getParameter("IdAgregado")!=null){
						int id = Integer.parseInt(request.getParameter("IdAgregado"));
						c = AgregadoBL.Instancia().DevuelveAgregados(id);
					}					
	 %>	
	 
	 <form method="post" action="sFrmAgregados">
    <table border="1">
    <tr><td>IdAgregado:</td><td><input type="text" name="txtIdAgregado" value="<%=c.getIdAgregado() %>" /></td></tr>
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
      <td>Cantidad</td>
      <td><input type="text" name="txtCantidad" value="<%=c.getCantidad() %>"/></td>
    </tr>
     <tr>
      <td>Oferta</td>
      <td><input type="text" name="txtPrecioOferta" value="<%=c.getPrecioOferta() %>"/></td>
    </tr>
    <tr>
      <td colspan="2">
		 <input type="submit" name="btnGrabar" value="Grabar"/>
		 <input type="submit" name="btnEliminar" value="Eliminar" <%if(request.getParameter("IdAgregado")==null){out.print("disabled");} %> />
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
           <th>Cantidad</th>
           <th>Oferta</th>
           <th>----</th>
         </tr>
      </thead>
       <tbody>
       <%
       try{
         ArrayList<AgregadoEnt> lista = AgregadoBL.Instancia().ListarAgregados();
         for(int i=0;i<lista.size();i++)
         {
        	 out.print("<tr>");
        	 out.print("<td>"+lista.get(i).getNombre()+"</td>");
        	 out.print("<td>"+lista.get(i).getDescripcion()+"</td>");
        	 out.print("<td>"+lista.get(i).getPrecio()+"</td>");
        	 out.print("<td>"+lista.get(i).getCantidad()+"</td>");
        	 out.print("<td>"+lista.get(i).getPrecioOferta()+"</td>");
        	 out.print("<td><a href='frmAgregados.jsp?IdAgregado="+
						lista.get(i).getIdAgregado()+"'>Editar</a></td>");
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