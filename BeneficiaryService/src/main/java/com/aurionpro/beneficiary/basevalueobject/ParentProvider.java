package com.aurionpro.beneficiary.basevalueobject;

import java.io.Serializable;
import java.util.List;
/**
 * added by sachin 
 * 26 Dec 2013
 */
public interface ParentProvider extends Serializable{
	List<? extends MakerCheckerBO> getParentBOs();
}
