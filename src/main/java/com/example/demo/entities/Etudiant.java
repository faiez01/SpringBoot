package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
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
@DiscriminatorValue("etd")
public class Etudiant extends Membre {

	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	
	
	
	private String diplome;
	@ManyToOne
	private EnseignantChercheur encadrant;



	private String sujet;
	
	@Builder
	public Etudiant(@NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance,
			 byte[] photo, @NonNull String cv, @NonNull String email, @NonNull String password,
			Date dateInscription, @NonNull String diplome,String sujet, EnseignantChercheur encadrant) {
		super(cin, nom, prenom, dateNaissance, photo, cv, email, password);
		this.dateInscription = dateInscription;
		this.sujet = sujet;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}
	
	
	
}
