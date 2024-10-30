package com.karla.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotBlank
	@Size(min = 5, message = "Debe tener al menos 5 caracteres.")
	private String titulo;
	@Column
	@NotBlank
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String artista;
	@Column
	@NotBlank
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String album;
	@Column
	@NotBlank
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String genero;
	@Column
	@NotBlank
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String idioma;
	@Column
	private LocalDateTime fechaCreacion;
	@Column
	private LocalDateTime fechaActualizacion;

	public Cancion() {
		this.id = 0l;
		this.titulo = "";
		this.artista = "";
		this.album = "";
		this.genero = "";
		this.idioma = "";
		this.fechaCreacion = LocalDateTime.now();
		this.fechaActualizacion = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@PrePersist
	protected void onCreate( ) {
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate( ) {
		fechaActualizacion = LocalDateTime.now();
	}
}
