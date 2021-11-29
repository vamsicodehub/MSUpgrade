package com.aurionpro.beneficiary.basevalueobject;

import java.util.List;


public abstract class ChildMakerCheckerBO extends MakerCheckerBO implements ParentProvider, ParentAware {
	
	protected ParentProvider parentProvider;
	protected ParentAware parentAware;

	public ChildMakerCheckerBO() {
		SimpleParentProvider simpleParentProvider = new SimpleParentProvider(this);
		parentProvider = simpleParentProvider; 
		parentAware = simpleParentProvider;
	}
	
	public ChildMakerCheckerBO(String runTimeObject) {
	}

	
	/**
	 * TODO:Pravin
	 */
/*	public ChildMakerCheckerBO(BaseDTO baseDTO) {
		super(baseDTO);
		SimpleParentProvider simpleParentProvider = new SimpleParentProvider(this);
		parentProvider = simpleParentProvider; 
		parentAware = simpleParentProvider;
	}*/

	public final List<? extends MakerCheckerBO> getParentBOs() {
		return parentProvider.getParentBOs();
	}
	
	public final void setParent(MakerCheckerBO parentBO) {
		parentAware.setParent(parentBO);
	}
	
	public String getEntityIdentifier() {
		return null;
	}
}
