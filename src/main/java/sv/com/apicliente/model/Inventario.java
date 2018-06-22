package sv.com.apicliente.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventario {
	
	@JsonProperty("id")
	public Long id;
	@JsonProperty("producto")
	public Long producto;
	@JsonProperty("existencias")
	public Integer existencias;
	@JsonProperty("fecha")
	public Date fecha;
	
	public Inventario() {

	}
	

	public Inventario(Long id, Long producto, Integer existencias, Date fecha) {
		super();
		this.id = id;
		this.producto = producto;
		this.existencias = existencias;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
