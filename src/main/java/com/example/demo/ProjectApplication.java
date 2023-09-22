package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.service.Imembreservice;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class ProjectApplication implements CommandLineRunner{

	MemberRepository memberRepository;
	Imembreservice imembreservice;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		byte[] tab;
		// TODO Auto-generated method stub
		Etudiant etd1=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd1@gmail.com")
				.password("pass1")
				.encadrant(null)
				.photo(tab=new byte[10])
				.cv("cv1")
				.nom("abid")
				.prenom("youssef")
				.sujet("blockhain")
				.build();
		
		Etudiant etd2=Etudiant.builder()
				.cin("12344456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("inge")
				.email("etd2@gmail.com")
				.password("pass2")
				.encadrant(null)
				.photo(tab=new byte[10])
				.cv("cv2")
				.nom("kouba")
				.prenom("med")
				.sujet(".net")
				.build();
		EnseignantChercheur ens1=EnseignantChercheur.builder()
				.cin("1234445006")
				.dateNaissance(new Date())
				.email("ens1@gmail.com")
				.password("pass3")
				.photo(tab=new byte[10])
				.grade("chercheur")
				.etablissement("enis")
				.cv("cv3")
				.nom("aaa")
				.prenom("ahmed")
				.build();
		/*memberRepository.save(etd1);
		memberRepository.save(etd2);
		memberRepository.save(ens1);*/
		imembreservice.addMember(etd1);
		imembreservice.addMember(ens1);
		imembreservice.affecter_etudiantToens(etd1.getId(), ens1.getId());
	}

}
