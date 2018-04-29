package com.example.demo.repositories;

import com.example.demo.entities.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:28 PM.
 */
@Repository
public interface VacataireRepo extends JpaRepository<Vacataire, Long> {
}
