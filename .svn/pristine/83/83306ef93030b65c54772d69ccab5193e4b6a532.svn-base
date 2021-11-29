package com.aurionpro.generic.basevalueobject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

public abstract class AbstractParentChildrenProvider {

	public AbstractParentChildrenProvider() {
		super();
	}
	
	protected void addGetterMethodForField(Field field, List<Method> methods, List<Method> resultGetterMethodsList) {
		final String getterMethodName = "get" + field.getName();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(getterMethodName))
				resultGetterMethodsList.add(method);
		}
	}
	
	protected void invokeGetterMethods(List<MakerCheckerBO> transactionBOs, List<Method> getterMethods, Object targetObject) {
		for (Method getterMethod : getterMethods) {
			Object result = null;
			try {
				result = getterMethod.invoke(targetObject);
				if(null!=result)
				addResultToList(transactionBOs, result);
			} catch (Exception e) {
			}
		}
	}

	protected void addResultToList(List<MakerCheckerBO> transactionBOs, Object result) {
		if (result instanceof Collection) {
			Collection<MakerCheckerBO> resultCollection = (Collection<MakerCheckerBO>) result;
			for (MakerCheckerBO transactionBO : resultCollection) {
				transactionBOs.add(transactionBO);
			}
		} else {
			MakerCheckerBO transactionBO = (MakerCheckerBO) result;
			transactionBOs.add(transactionBO);
		}
	}
}
