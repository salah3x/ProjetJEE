package com.example.demo.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by salah3x on 4/29/18 3:19 PM.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "etudiants")
public class Cours {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_idEnseignant")
	private Enseignant enseignant;

	@ManyToMany(mappedBy="cours", cascade=CascadeType.ALL)
    private Set<Etudiant> etudiants = new HashSet<>();

	public void addEtudiant(Etudiant etudiant){
		this.getEtudiants().add(etudiant) ;
		etudiant.getCours().add(this) ;
	}

	public void removeEtudiant(Etudiant etudiant){
		this.getEtudiants().remove(etudiant);
		etudiant.getCours().remove(this);
	}
}
