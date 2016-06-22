package com.el.ventas;

public class PizzaEnt {

	private int IdPizza;
	private String Nombre=""; 
	private String Descripcion="";
	private Double Precio=0.0;
	private Boolean Anulado;
	private String Masa="";
	private String Tipo="";
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getIdPizza() {
		return IdPizza;
	}
	public void setIdPizza(int idPizza) {
		IdPizza = idPizza;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Double getPrecio() {
		return Precio;
	}
	public void setPrecio(Double precio) {
		Precio = precio;
	}
	public Boolean getAnulado() {
		return Anulado;
	}
	public void setAnulado(Boolean anulado) {
		Anulado = anulado;
	}
	public String getMasa() {
		return Masa;
	}
	public void setMasa(String masa) {
		Masa = masa;
	}
	

}
