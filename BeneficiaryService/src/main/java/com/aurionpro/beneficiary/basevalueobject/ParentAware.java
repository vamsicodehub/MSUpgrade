package com.aurionpro.beneficiary.basevalueobject;

import java.io.Serializable;

public interface ParentAware extends Serializable{
	void setParent(MakerCheckerBO parent);
}
