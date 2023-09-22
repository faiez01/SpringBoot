package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {

	
	private String grade;
	
	private String etablissement;

	@Builder
	public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom,
			@NonNull Date dateNaissance, @NonNull byte[] photo, @NonNull String cv, @NonNull String email,
			@NonNull String password, @NonNull String grade, @NonNull String etablissement) {
		super(cin, nom, prenom, dateNaissance, photo, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}

}
