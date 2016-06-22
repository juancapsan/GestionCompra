package com.el.ventas;

import java.sql.Date;

public class CustomerEnt {
	
	private int idCustomer;
	private String Codigo="";
	private String RazSocial="";
	private String Direccion="";
	private String Telefono="";
	private String mail="";
	private String Tipocte="";
	private Boolean Activo;
	private Date FechaRegistro;
	private String UsuarioRegistro;
	private  Date FechaModificacion;
	private String UsuarioModificacion;
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getRazSocial() {
		return RazSocial;
	}
	public void setRazSocial(String razSocial) {
		RazSocial = razSocial;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTipocte() {
		return Tipocte;
	}
	public void setTipocte(String tipocte) {
		Tipocte = tipocte;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public String getUsuarioRegistro() {
		return UsuarioRegistro;
	}
	public void setUsuarioRegistro(String usuarioRegistro) {
		UsuarioRegistro = usuarioRegistro;
	}
	public Date getFechaModificacion() {
		return FechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		FechaModificacion = fechaModificacion;
	}
	public String getUsuarioModificacion() {
		return UsuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		UsuarioModificacion = usuarioModificacion;
	}
	
	


}
