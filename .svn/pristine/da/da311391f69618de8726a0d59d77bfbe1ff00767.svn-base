package com.aurionpro.userfavourite.valueobject;

import java.io.Serializable;

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


@Entity
@Table(name="ASPARAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterBO implements Serializable{

 static final long serialVersionUID = 7157059627040232082L;
 
 
 @Id
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="qid_seq")
 @SequenceGenerator(name = "qid_seq", sequenceName="SQ_ASPARAM",allocationSize=1)
 @Column(name = "id")
 private Long id;
 
 @Column(name = "PARAMVAL")
 private String paramVal;
 
 @Column(name = "PARAMKEY")
 private String paramKey;

}
