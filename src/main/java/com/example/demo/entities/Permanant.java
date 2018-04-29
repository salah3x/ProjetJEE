package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by salah3x on 4/29/18 3:17 PM.
 */
@Entity
@DiscriminatorValue(value="PERMANENT")
@Getter
@Setter
public class Permanant extends Enseignant {

	private String grade;
}
