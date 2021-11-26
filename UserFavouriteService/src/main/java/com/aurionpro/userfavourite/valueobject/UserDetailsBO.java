package com.aurionpro.userfavourite.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class UserDetailsBO.
 *
 * @author Pravin.Devade
 */

@Entity
@Table(name="AUCORPORATEUSER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsBO implements Serializable{
	
	private static final long serialVersionUID = 4613807538075985849L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="qid_seq")
    @SequenceGenerator(name = "qid_seq", sequenceName="SQ_AMFAVOURITEDETAILS",allocationSize=1)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "loginid")
	private String loginid;

}
