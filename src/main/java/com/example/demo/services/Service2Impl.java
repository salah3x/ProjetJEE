package com.example.demo.services;

import com.example.demo.entities.Cours;
import com.example.demo.entities.Enseignant;
import com.example.demo.repositories.CoursRepo;
import com.example.demo.repositories.EnseignantRepo;
import com.example.demo.repositories.EtudiantRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by salah3x on 4/29/18 3:56 PM.
 */
@Service
@Transactional
public class Service2Impl implements Service2 {

	private final CoursRepo coursRepo;
	private final EnseignantRepo enseignantRepo;
	private final EtudiantRepo etudiantRepo;

	public Service2Impl(CoursRepo coursRepo, EnseignantRepo enseignantRepo, EtudiantRepo etudiantRepo) {
		this.coursRepo = coursRepo;
		this.enseignantRepo = enseignantRepo;
		this.etudiantRepo = etudiantRepo;
	}

	@Override
	public void affecterCoursEnseignant(Long idCours, Long idEns) {
		coursRepo.getOne(idCours).setEnseignant(enseignantRepo.getOne(idEns));
	}

	@Override
	public void affecterCoursEtudiant(Long idCours, Long idEtu) {
		coursRepo.getOne(idCours).addEtudiant(etudiantRepo.getOne(idEtu));
	}

	@Override
	public Cours afficherCoursAvecEtudiant(Long idCours) {
		Cours cours = coursRepo.getOne(idCours);
		System.out.print("Cours : "+cours.getNom()+" - Etudiants : {");
		cours.getEtudiants().forEach(etudiant -> System.out.print("["+etudiant.getNom()+", "+etudiant.getSpecialite()+"]"));
		System.out.println("}");
		return cours;
	}

	@Override
	public Enseignant afficherEnseignantAvecCours(Long idEns) {
		Enseignant enseignant = enseignantRepo.getOne(idEns);
		System.out.print("Enseignant : "+enseignant.getNom()+" - Cours : {");
		enseignant.getCours().forEach(cours -> System.out.print("["+cours.getNom()+"]"));
		System.out.println("}");
		return enseignant;
	}
}
