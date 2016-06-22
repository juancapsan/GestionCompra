package com.el.ventas;

public class AgregadoEnt {
	
	private int IdAgregado;
	private String Nombre=""; 
	private String Descripcion="";
	private Double Precio=0.0;
	private Boolean Anulado;
	private int Cantidad=0;
	private Double PrecioOferta=0.0;
	public Double getPrecioOferta() {
		return PrecioOferta;
	}
	public void setPrecioOferta(Double precioOferta) {
		PrecioOferta = precioOferta;
	}
	public int getIdAgregado() {
		return IdAgregado;
	}
	public void setIdAgregado(int idAgregado) {
		IdAgregado = idAgregado;
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
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
	
}
