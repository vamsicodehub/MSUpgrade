package com.aurionpro.beneficiary.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.aurionpro.beneficiary.basevalueobject.ChildMakerCheckerBO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="BMBENEPAYMETDMAPCASH")
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryCashPayoutMapBO extends ChildMakerCheckerBO {


	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cash_seq")
    @SequenceGenerator(name = "cash_seq", sequenceName="SQ_BMBENEPAYMETDMAPCASH",allocationSize=1)
    @Column(name = "id")
	protected Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BENEPAYMETDMAPID")
	private BeneficiaryPaymentMethodMapBO benePayMetdMapId;	
	
	@Column(name = "DOCUMENTTYPE")
	private String documentType;
	
	@Column(name = "DOCUMENTNO")
	private String documentNo;


	public String getDocumentType() {
		return (String)getPropertyObject("documentType");
	}

	public void setDocumentType(String documentType) {
		setProperty("documentType", documentType);
	}

	public String getDocumentNo() {
		return  (String)getPropertyObject("documentNo");
	}

	public void setDocumentNo(String documentNo) {
		setProperty("documentNo", documentNo);
	}

	public BeneficiaryPaymentMethodMapBO getBenePayMetdMapId() {
		return benePayMetdMapId;
	}

	public void setBenePayMetdMapId(BeneficiaryPaymentMethodMapBO benePayMetdMapId) {
		this.benePayMetdMapId = benePayMetdMapId;
	}

	

	
}
