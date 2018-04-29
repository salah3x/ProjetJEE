package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.services.Service1;
import com.example.demo.services.Service2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Service1 service1 = ctx.getBean(Service1.class);
		Service2 service2 = ctx.getBean(Service2.class);

		Personne personne = new Personne();
		personne.setNom("Personne 1");
		personne.setPrenom("Prenom 1");

		Adresse adresse = new Adresse();
		adresse.setRue("Rue 1");
		adresse.setVille("Ville 1");

		service1.ajouterPersonneAvecAdresse(personne, adresse);
		System.out.println("Test 1 terminé : Ajouter personne avec adresse");

		Enseignant enseignant = new Enseignant();
		enseignant.setNom("Ens 1");
		enseignant.setPrenom("Prénom 2");
		enseignant.setService("Service 1");

		Vacataire vacataire = (Vacataire) service1.ajouterEnseignant(enseignant, true, "Vacataire").get();
		System.out.println("Test 2 terminé : Ajouter enseingnat");

		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Etudiant 1");
		etudiant.setPrenom("prenom etudiant 1");
		etudiant.setSpecialite("Specialité 1");

		etudiant = service1.ajouterEtudiant(etudiant);
		System.out.println("Test 3 terminé : Ajouter étudiant");

		Cours cours = new Cours();
		cours.setNom("Cours 1");

		cours = service1.ajouterCours(cours);
		System.out.println("Test 4 terminé : Ajouter cours");

		service2.affecterCoursEnseignant(cours.getId(), vacataire.getId());
		System.out.println("Test 5 terminé : Affecter Cours à un enseignant");

		service2.affecterCoursEtudiant(cours.getId(), etudiant.getId());
		System.out.println("Test 6 terminé : Affecter Cours à un etudiant");

		service2.afficherCoursAvecEtudiant(cours.getId());
		System.out.println("Test 7 terminé : Afficher un cours avec les étudiants (id, nom, spécialité) qui le suivent. ");
		service2.afficherEnseignantAvecCours(vacataire.getId());
		System.out.println("Test 8 terminé : Afficher un enseignant avec ses cours");
		System.in.read();
	}
}
