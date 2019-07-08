package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity //Para crear una tabla con Hibernate
public class User {
	
		@Id // Para indicar que el elemento es un PK
		@GeneratedValue(strategy=GenerationType.AUTO) //define el tipo de generacion para el autoincrement
		private Integer id;
		
		private String name;
		
		private String email;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
		

}