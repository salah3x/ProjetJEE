package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by salah3x on 4/29/18 3:09 PM.
 */

@Entity
@Getter
@Setter
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String rue;

	private String ville;
}
