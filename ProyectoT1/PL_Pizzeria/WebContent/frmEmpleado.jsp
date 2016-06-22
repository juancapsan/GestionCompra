<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.bl.comunes.*" %>
<%@page import="com.el.comunes.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

     <h3>Registro Empleado</h3>
   <%
                    EmpleadoEnt c = new EmpleadoEnt();
					if(request.getParameter("IdEmpleado")!=null){
						int id = Integer.parseInt(request.getParameter("IdEmpleado"));
						c = EmpleadoBL.Instancia().DevuelveEmpleado(id);
					}					
	 %>	
	<form method="post" action="sFrmEmpleado">
    <table border="1">
    <tr><td>idPersona:</td><td><input type="text"  name="txtidEmpleado" value="<%=c.getIdEmpleado()%>" /></td></tr>
    <tr>
      <td>Nombre</td>
      <td><input type="text" name="txtNombre" value="<%=c.getNombre()%>"/></td>
    </tr>
    <tr>
      <td>Apellidos</td>
      <td><input type="text" name="txtApellidos" value="<%=c.getApellidos()%>"/></td>
    </tr>
    <tr>
      <td>Sexo</td>
      <td><input type="text" name="txtSexo" value="<%=c.getSexo()%>"/></td>
    </tr>
     <tr>
      <td>Email</td>
      <td><input type="text" name="txtEmail" value="<%=c.getEmail()%>"/></td>
    </tr>
     <tr>
      <td>DNI</td>
      <td><input type="text" name="txtDni" value="<%=c.getDNI()%>"/></td>
    </tr>
    <tr>
      <td colspan="2">
		 <input type="submit" name="btnGrabar" value="Grabar"/>
		 <input type="submit" name="btnEliminar" value="Eliminar" <%if(request.getParameter("IdEmpleado")==null){out.print("disabled");} %> />
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
           <th>Apellidos</th>
           <th>Sexo</th>
           <th>Email</th>
           <th>DNI</th>
           <th>----</th>
         </tr>
      </thead>
       <tbody>
       <%
       try{
         ArrayList<EmpleadoEnt> lista = EmpleadoBL.Instancia().ListarEmpleado();
         for(int i=0;i<lista.size();i++)
         {
        	 out.print("<tr>");
        	 out.print("<td>"+lista.get(i).getNombre()+"</td>");
        	 out.print("<td>"+lista.get(i).getApellidos()+"</td>");
        	 out.print("<td>"+lista.get(i).getSexo()+"</td>");
        	 out.print("<td>"+lista.get(i).getEmail()+"</td>");
        	 out.print("<td>"+lista.get(i).getDNI()+"</td>");
        	 out.print("<td><a href='frmEmpleado.jsp?IdEmpleado="+ lista.get(i).getIdEmpleado()+"'>Editar</a></td>");
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