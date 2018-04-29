package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by salah3x on 4/29/18 3:02 PM.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_PERSONNE")
@Getter
@Setter
public class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;

	@OneToOne(cascade=CascadeType.ALL)
	private Adresse adresse;
}
