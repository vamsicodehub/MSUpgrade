package com.aurionpro.generic.basevalueobject;

import java.util.List;


public abstract class ParentMasterBO extends MasterBO implements ChildrenProvider{

	protected ChildrenProvider childrenProvider = new SimpleChildrenProvider(this);
	
	public ParentMasterBO() {
		super();
	}


	public final List<? extends MakerCheckerBO> getChildrenBOs() {
		return childrenProvider.getChildrenBOs();
	}
}
