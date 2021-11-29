package com.aurionpro.beneficiary.basevalueobject;

import java.util.List;


public abstract class ParentChildMakerCheckerBO extends MakerCheckerBO implements
		ParentProvider, ParentAware, ChildrenProvider {

	protected ParentProvider parentProvider;
	protected ParentAware parentAware;
	protected ChildrenProvider childrenProvider;

	public ParentChildMakerCheckerBO() {
		super();
		SimpleParentProvider simpleParentProvider = new SimpleParentProvider(this);
		parentProvider = simpleParentProvider; 
		parentAware = simpleParentProvider;
		childrenProvider = new SimpleChildrenProvider(this);
	}
	
	public ParentChildMakerCheckerBO(String runTimeObject) {
		super();
		System.out.println("======================================== ParentChildMakerCheckerBO..");
	}

	

	public final List<? extends MakerCheckerBO> getChildrenBOs() {
		return childrenProvider.getChildrenBOs();
	}

	public final List<? extends MakerCheckerBO> getParentBOs() {
		return parentProvider.getParentBOs();
	}
	
	public final void setParent(MakerCheckerBO parentBO) {
		parentAware.setParent(parentBO);
	}
}
