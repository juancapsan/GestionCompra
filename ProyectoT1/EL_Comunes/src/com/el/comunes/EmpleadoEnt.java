package com.el.comunes;

public class EmpleadoEnt {

	private int IdEmpleado=0;
	private String Nombre="";
	private String Apellidos="";
	private String Sexo="";
	private String Email="";
	private Boolean Anulado;
	private Boolean Activo;
	private String DNI="";
	public int getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getEmail() {
		return Email;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getAnulado() {
		return Anulado;
	}
	public void setAnulado(Boolean anulado) {
		Anulado = anulado;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	

}
