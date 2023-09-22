package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Memberservice implements Imembreservice {

	MemberRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;

	@Override
	public Membre addMember(Membre m) {

		memberRepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);

	}

	@Override
	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
	}

	@Override
	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Membre> findAll() {

		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		// TODO Auto-generated method stub
		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		// TODO Auto-generated method stub
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		// TODO Auto-generated method stub
		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		// TODO Auto-generated method stub
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		// TODO Auto-generated method stub
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affecter_etudiantToens(Long idEtudiant, Long idEnseignant) {
		Etudiant etd=etudiantRepository.findById(idEtudiant).get();
		EnseignantChercheur ens=enseignantChercheurRepository.findById(idEnseignant).get();
		etd.setEncadrant(ens);
		memberRepository.save(etd);
		
	}

}
