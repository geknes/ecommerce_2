package com.hackmonkey.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="talla")
public class Talla {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_segmento")
	private Long idSegmento;
	
	
	
}
