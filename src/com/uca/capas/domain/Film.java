package com.uca.capas.domain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "table_film")
public class Film {
	@Id
	@GeneratedValue(generator="film_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "film_seq", sequenceName = "public.film_seq",allocationSize=1)
	@Column(name = "id_film")
	private Integer idfilm;
	
	@Column(name = "film_name")
	private String filmname;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "url_poster")
	private String urlposter;

	public Integer getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}

	public String getFilm_name() {
		return filmname;
	}

	public void setFilm_name(String film_name) {
		this.filmname = film_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getUrl_poster() {
		return urlposter;
	}

	public void setUrl_poster(String url_poster) {
		this.urlposter = url_poster;
	}

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(Integer idfilm, String film_name, String description, String duration, String url_poster) {
		super();
		this.idfilm = idfilm;
		this.film_name = film_name;
		this.description = description;
		this.duration = duration;
		this.url_poster = url_poster;
	}

	
}
