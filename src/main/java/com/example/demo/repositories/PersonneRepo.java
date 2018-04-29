package com.example.demo.repositories;

import com.example.demo.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:38 PM.
 */
@Repository
public interface PersonneRepo extends JpaRepository<Personne, Long> {
}
