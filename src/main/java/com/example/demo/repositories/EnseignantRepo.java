package com.example.demo.repositories;

import com.example.demo.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:57 PM.
 */
@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
}
