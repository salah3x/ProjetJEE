package com.example.demo.services;

import com.example.demo.entities.Cours;
import com.example.demo.entities.Enseignant;

/**
 * Created by salah3x on 4/29/18 2:59 PM.
 */
public interface Service2 {

	void affecterCoursEnseignant(Long idCours, Long idEns);

	void affecterCoursEtudiant(Long idCours, Long idEtu);

	Cours afficherCoursAvecEtudiant(Long idCours);

	Enseignant afficherEnseignantAvecCours(Long idEns);
}
