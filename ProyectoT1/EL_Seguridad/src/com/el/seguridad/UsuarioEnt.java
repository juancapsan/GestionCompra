package com.el.seguridad;

import com.el.comunes.EmpleadoEnt;

public class UsuarioEnt {

	private int IdUsuario;
	private String Usuario;
	private String Password;
	private Boolean Anulado;
	private Boolean Activo;
	private EmpleadoEnt Empleado;
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Boolean getAnulado() {
		return Anulado;
	}
	public void setAnulado(Boolean anulado) {
		Anulado = anulado;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	public EmpleadoEnt getEmpleado() {
		return Empleado;
	}
	public void setEmpleado(EmpleadoEnt empleado) {
		Empleado = empleado;
	}
	
	public boolean isActivo() {
		return Activo;
	}

}
