package com.aws.generation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")


public class aluno {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;
	    private int idade;
	    private float notaPrimeiroSemestre;
	    private float notaSegundoSemestre;
	    private String nomeProfessor;
	    private int numeroSala;
		public Object getNotaPrimeiroSemestre() {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getNome() {
			// TODO Auto-generated method stub
			return null;
		}
		public void setNome(Object nome2) {
			// TODO Auto-generated method stub
			
		}
		public void setNotaPrimeiroSemestre(Object notaPrimeiroSemestre2) {
			// TODO Auto-generated method stub
			
		}
		public Object getNomeProfessor() {
			// TODO Auto-generated method stub
			return null;
		}
		public void setNomeProfessor(Object nomeProfessor2) {
			// TODO Auto-generated method stub
			
		}
		public Object getNumeroSala() {
			// TODO Auto-generated method stub
			return null;
		}
		public void setNumeroSala(Object numeroSala2) {
			// TODO Auto-generated method stub
			
		
		}
		

}
