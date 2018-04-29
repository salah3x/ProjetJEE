package com.example.demo.services;

import com.example.demo.entities.*;

import java.util.Optional;

/**
 * Created by salah3x on 4/29/18 2:57 PM.
 */
public interface Service1 {

	Personne ajouterPersonneAvecAdresse(Personne personne, Adresse adresse);

	/**
	 *
	 * @param enseignant l'ensignat à ajouter
	 * @param isVacataire true si c'est un vacataire, sinon false
	 * @param attribute employeur si c'est un vacataire, grade s'il s'agit d'un permanant
	 * @return un objet contient Vacataire ou Permanant (depend à isVacataire)
	 */
	Optional<?> ajouterEnseignant(Enseignant enseignant, boolean isVacataire, String attribute);

	Etudiant ajouterEtudiant(Etudiant etudiant);

	Cours ajouterCours(Cours cours);
}
