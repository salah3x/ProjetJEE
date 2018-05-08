package com.example.demo.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by salah3x on 4/29/18 3:15 PM.
 */
@Entity
@DiscriminatorValue(value="ETUDIANT")
@Getter
@Setter
@EqualsAndHashCode(exclude = "cours")
public class Etudiant extends Personne {

	private String specialite;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Cours> cours = new HashSet<>();

	public void addCours(Cours cours){
		this.getCours().add(cours) ;
		cours.getEtudiants().add(this) ;
	}

	public void removeCours(Cours cours){
		this.getCours().remove(cours) ;
		cours.getEtudiants().remove(this);
	}
}
