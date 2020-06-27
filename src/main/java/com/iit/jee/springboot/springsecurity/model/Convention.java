package com.iit.jee.springboot.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Convention {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date signature;
    private String[] participants=new String[4];
    private Date dateEdition;
    private Date declenche;
    private Date dateExpiration;
    private String objet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getSignature() {
		return signature;
	}
	public void setSignature(Date signature) {
		this.signature = signature;
	}
	public String[] getParticipants() {
		return participants;
	}
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	public Date getDateEdition() {
		return dateEdition;
	}
	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}
	public Date getDeclenche() {
		return declenche;
	}
	public void setDeclenche(Date declenche) {
		this.declenche = declenche;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public Convention(Long id, String type, Date signature, String[] participants, Date dateEdition, Date declenche,
			Date dateExpiration, String objet) {
		super();
		this.id = id;
		this.type = type;
		this.signature = signature;
		this.participants = participants;
		this.dateEdition = dateEdition;
		this.declenche = declenche;
		this.dateExpiration = dateExpiration;
		this.objet = objet;
	}
	public Convention() {
		super();
	}
    
	



}
