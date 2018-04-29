package com.example.demo.repositories;

import com.example.demo.entities.Permanant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:26 PM.
 */
@Repository
public interface PermanantRepo extends JpaRepository<Permanant, Long> {
}
