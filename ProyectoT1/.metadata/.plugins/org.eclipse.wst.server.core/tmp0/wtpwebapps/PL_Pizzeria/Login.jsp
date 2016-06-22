<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bl.seguridad.*"%>
<%@page import="com.el.seguridad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <br/>
	    <h3 align="center">Iniciar sesion </h3>
     <br/>
     <%
	   try{
		   
	   if(request.getParameter("btnIngresar")!=null)
	   {
	   String _user =request.getParameter("txtUsuario");
	   String _passw = request.getParameter("txtPassword");
	   UsuarioEnt x = UsuarioBL.Instancia().VerificarAcceso(_user, _passw);
	   
	   HttpSession s = request.getSession();
	   s.setAttribute("usuario", x);
	    response.sendRedirect("frmMenu.jsp");
	    }
	   }catch(Exception e)
	    {
		   out.print(e.getMessage());
	    }
	%>
     <form>
		<table align="center" border="1">
		     <tr>
		         <td>Usuario:</td>
		         <td><input type="text" name="txtUsuario"></td>
		     </tr>
		     
		     <tr>
		         <td>Password:</td>
		         <td><input type="text" name="txtPassword"></td>
		     </tr>
		     
		     <tr>
		         <td colspan="2">
		             <input type="submit" name="btnIngresar" value="Ingresar">
		             <input type="reset" value="Limpiar">
		         </td>
		     </tr>
		</table>
	</form>
</body>
</html>