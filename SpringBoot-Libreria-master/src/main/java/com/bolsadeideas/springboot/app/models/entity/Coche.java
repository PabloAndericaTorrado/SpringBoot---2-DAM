package com.bolsadeideas.springboot.app.models.entity;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="coches")
public class Coche implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Double kilometraje;
    private Double precio;
    private String matricula;
    private String foto;

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

	public Coche() {
		super();
	}

	public Coche(Long id, String marca, String modelo, Integer anioFabricacion, Double kilometraje, Double precio,
			String matricula, @NotNull Date createAt) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.kilometraje = kilometraje;
		this.precio = precio;
		this.matricula = matricula;
		this.createAt = createAt;
	}
	
	

	public Coche(Long id, String marca, String modelo, Integer anioFabricacion, Double kilometraje, Double precio,
			String matricula, String foto, @NotNull Date createAt) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.kilometraje = kilometraje;
		this.precio = precio;
		this.matricula = matricula;
		this.foto = foto;
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public Double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion
				+ ", kilometraje=" + kilometraje + ", precio=" + precio + ", matricula=" + matricula + ", createAt="
				+ createAt + "]";
	}
    
    
    
    
    
}
