package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;


public class SizeValidator extends AbstractFieldValidator {

	int  min = 0,max=0;
	public SizeValidator(String additionalData) {
		min =Integer.parseInt(additionalData.split(",")[0].split(":")[1]);
		max =Integer.parseInt(additionalData.split(",")[1].split(":")[1]);
	}
	@Override
	public List<String> validate(Object obj) {
		String temp = obj.toString();
		List<String> errorList = new LinkedList<String>();
		if(temp!=null&&(min>temp.length()||max<temp.length()))
		{
			errorList.add(String.format("Size should be between %s to %s",min,max ));
		}
		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}
		return errorList;
	}

}
