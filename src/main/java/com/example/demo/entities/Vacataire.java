package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by salah3x on 4/29/18 3:18 PM.
 */
@Entity
@DiscriminatorValue(value="VACATAIRE")
@Getter
@Setter
public class Vacataire extends Enseignant {

	private String employeur;
}
