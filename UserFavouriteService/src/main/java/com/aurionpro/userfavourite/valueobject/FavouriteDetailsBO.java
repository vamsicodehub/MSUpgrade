/**
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class FavouriteDetailsBO.
 *
 * @author Pravin.Devade
 */

@Entity
@Table(name="AMFAVOURITEDETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDetailsBO implements Serializable  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4021606821492580446L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="qid_seq")
    @SequenceGenerator(name = "qid_seq", sequenceName="SQ_AMFAVOURITEDETAILS",allocationSize=1)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "version")
	private Integer version = 1;
	
	/** The module name. */
	 @Column(name = "MODULENAME")
	private String moduleName;
	
	/** The type. */
	@Column(name = "FAVOURITETYPE")
	private String favouriteType;
	
	/** The cash pro product id. */
	@Column(name = "CASHPROPRODUCTID")
	private Long cashProProductId;
	
	/** The favourite detail. */
	@Column(name = "FAVOURITEDETAIL")
	private String favouriteDetail;
	
	/** Fav Name **/
	@Column(name = "FAVOURITENAME")
	private String favouriteName;
	
	/** The user id. */
	@Column(name = "USERID")
	private Long userId;
	
	/** The modified by. */
	@Column(name = "MODIFIEDBY")
	private String modifiedBy;
	
	/** The modified on. */
	@Column(name = "MODIFIEDON")
	private Date modifiedOn;


}
