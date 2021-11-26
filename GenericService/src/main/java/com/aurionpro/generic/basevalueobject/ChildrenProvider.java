package com.aurionpro.generic.basevalueobject;

import java.io.Serializable;
import java.util.List;

public interface ChildrenProvider extends Serializable{
	/**
	 * added by sachin 
	 * 26 Dec 2013
	 */
	static final long serialVersionUID = -500281968934161366L;
	List<? extends MakerCheckerBO> getChildrenBOs();
}
