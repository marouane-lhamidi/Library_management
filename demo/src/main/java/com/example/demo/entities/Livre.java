package com.example.demo.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Livre {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(length = 50, nullable = false,updatable = false, name = "titre")

	private String titre;
	
	@Column(nullable = false,updatable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String maisonEdition;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private Date dateSortie;
	
	@Column(nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String auteur;
	
	@Column(nullable = false)
	private int nombrePages;
	
	@Column(nullable = false, updatable = false, unique=true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int isbn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date dateDerConsult;
	
	@Column(nullable = false)
	private boolean disponible;

}
