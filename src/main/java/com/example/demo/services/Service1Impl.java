package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by salah3x on 4/29/18 3:22 PM.
 */
@Service
@Transactional
public class Service1Impl implements Service1 {

	private final PersonneRepo personneRepo;
	private final AdresseRepo adresseRepo;
	private final VacataireRepo vacataireRepo;
	private final PermanantRepo permanantRepo;
	private final EtudiantRepo etudiantRepo;
	private final CoursRepo coursRepo;

	public Service1Impl(PersonneRepo personneRepo, AdresseRepo adresseRepo, VacataireRepo vacataireRepo,
                        PermanantRepo permanantRepo, EtudiantRepo etudiantRepo, CoursRepo coursRepo) {
		this.personneRepo = personneRepo;
		this.adresseRepo = adresseRepo;
		this.vacataireRepo = vacataireRepo;
		this.permanantRepo = permanantRepo;
		this.etudiantRepo = etudiantRepo;
		this.coursRepo = coursRepo;
	}

	@Override
	public Personne ajouterPersonneAvecAdresse(Personne personne, Adresse adresse) {
		personne.setAdresse(adresse);
		return personneRepo.save(personne);
	}

	@Override
	public Optional<?> ajouterEnseignant(Enseignant enseignant, boolean isVacataire, String attribute) {
		if (isVacataire){
			Vacataire vacataire = new Vacataire();
			vacataire.setNom(enseignant.getNom());
			vacataire.setPrenom(enseignant.getPrenom());
			if (enseignant.getAdresse() != null)
				vacataire.setAdresse(adresseRepo.getOne(enseignant.getAdresse().getId()));
			vacataire.setService(enseignant.getService());
			vacataire.setCours(enseignant.getCours());
			vacataire.setEmployeur(attribute);
			return Optional.of(vacataireRepo.save(vacataire));
		}else {
			Permanant permanant = new Permanant();
			permanant.setNom(enseignant.getNom());
			permanant.setPrenom(enseignant.getPrenom());
			if (enseignant.getAdresse() != null)
				permanant.setAdresse(adresseRepo.getOne(enseignant.getAdresse().getId()));
			permanant.setService(enseignant.getService());
			permanant.setCours(enseignant.getCours());
			permanant.setGrade(attribute);
			return Optional.of(permanantRepo.save(permanant));
		}
	}

	@Override
	public Etudiant ajouterEtudiant(Etudiant etudiant) {
		return etudiantRepo.save(etudiant);
	}

	@Override
	public Cours ajouterCours(Cours cours) {
		return coursRepo.save(cours);
	}
}
