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
 <h3>Registro Customer</h3>
   <%
                    CustomerEnt c = new CustomerEnt();
					if(request.getParameter("idCustomer")!=null){
						int id = Integer.parseInt(request.getParameter("idCustomer"));
						c = CustomerBL.Instancia().DevuelveCustomer(id);
					}					
	 %>	
	 
	 <form method="post" action="sFrmCustomer">
    <table border="1">
    <tr><td>idCustomer:</td><td><input type="text" name="txtIdCustomer" value="<%=c.getIdCustomer() %>" /></td></tr>
    <tr>
      <td>Codigo</td>
      <td><input type="text" name="txtCodigo" value="<%=c.getCodigo() %>"/></td>
    </tr>
    <tr>
      <td>RazonSocial</td>
      <td><input type="text" name="txtRazSocial" value="<%=c.getRazSocial() %>"/></td>
    </tr>
    <tr>
      <td>Direccion</td>
      <td><input type="text" name="txtDireccion" value="<%=c.getDireccion() %>"/></td>
    </tr>
     <tr>
      <td>Telefono</td>
      <td><input type="text" name="txtTelefono" value="<%=c.getTelefono() %>"/></td>
    </tr>
     <tr>
      <td>Mail</td>
      <td><input type="text" name="txtMail" value="<%=c.getMail() %>"/></td>
    </tr>
    <tr>
      <td>Tipocte</td>
      <td><input type="text" name="txtTipocte" value="<%=c.getTipocte() %>"/></td>
    </tr>
    <tr>
      <td colspan="2">
		 <input type="submit" name="btnGrabar" value="Grabar"/>
		 <input type="submit" name="btnEliminar" value="Eliminar" <%if(request.getParameter("idCustomer")==null){out.print("disabled");} %> />
	  </td>
    </tr>
    </table>
    
     <%
	out.print("<p style='color: blue'>"+request.getParameter("msj")+"</p>");
	%>
  <br/>
  <table border="1" style="width=100%">
      <thead style="background-color:yellow">
         <tr>
           <th>Codigo</th>
           <th>RazonSocial</th>
           <th>Direccion</th>
           <th>Telefono</th>
           <th>Mail</th>
           <th>Tipocte</th>
           <th>----</th>
         </tr>
      </thead>
       <tbody>
       <%
       try{
         ArrayList<CustomerEnt> lista = CustomerBL.Instancia().ListarCustomer();
         for(int i=0;i<lista.size();i++)
         {
        	 out.print("<tr>");
        	 out.print("<td>"+lista.get(i).getCodigo()+"</td>");
        	 out.print("<td>"+lista.get(i).getRazSocial()+"</td>");
        	 out.print("<td>"+lista.get(i).getDireccion()+"</td>");
        	 out.print("<td>"+lista.get(i).getTelefono()+"</td>");
        	 out.print("<td>"+lista.get(i).getMail()+"</td>");
        	 out.print("<td>"+lista.get(i).getTipocte()+"</td>");
        	 out.print("<td><a href='frmCustomer.jsp?idCustomer="+
						lista.get(i).getIdCustomer()+"'>Editar</a></td>");
        	 out.print("</tr>");
         }
      }catch(Exception e)
       {
    	   out.print("<h3>"+e.getMessage()+"</h3>");
       }
       %>
       
       </tbody>
  </table>    
  </form>
  
  
  
</body>
</html>