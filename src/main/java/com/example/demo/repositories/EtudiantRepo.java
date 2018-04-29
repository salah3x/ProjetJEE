package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:25 PM.
 */
@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
}
