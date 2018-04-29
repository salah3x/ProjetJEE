package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by salah3x on 4/29/18 3:13 PM.
 */
@Entity
@DiscriminatorValue(value="ENSEIGNANT")
@Getter
@Setter
public class Enseignant extends Personne{

	private String service;

	@OneToMany(mappedBy="enseignant")
	private List<Cours> cours=new ArrayList<>();

	public void addCours(Cours cours){
		this.getCours().add(cours) ;
		cours.setEnseignant(this) ;
	}

	public void removeCours(Cours cours){
		this.getCours().remove(cours) ;
		cours.setEnseignant(null) ;
	}
}
