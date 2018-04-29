package com.example.demo.repositories;

import com.example.demo.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by salah3x on 4/29/18 3:24 PM.
 */
@Repository
public interface CoursRepo extends JpaRepository<Cours, Long> {
}
