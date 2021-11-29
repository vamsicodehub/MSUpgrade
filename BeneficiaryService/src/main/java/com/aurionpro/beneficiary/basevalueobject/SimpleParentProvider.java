package com.aurionpro.beneficiary.basevalueobject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleParentProvider extends AbstractParentChildrenProvider implements ParentProvider, ParentAware {
	private ParentProvider parentProviderImplInstance;
	private static Map<String,List<Method>> parentMethodsMap =new HashMap<String, List<Method>>();
	private  transient List<Method> parentMethods = new ArrayList<Method>();
	
	private transient List<Method> parentGetterMethods;
	private transient List<Method> parentSetterMethods;
	
	public SimpleParentProvider(ParentProvider parentProviderImplInstance) {
		

		this.parentProviderImplInstance = parentProviderImplInstance;
		String className = parentProviderImplInstance.getClass().getName();
		parentMethods = parentMethodsMap.get(className);
		
		parentGetterMethods = new ArrayList<Method>();
		parentSetterMethods = new ArrayList<Method>();
		
		if(parentMethods == null || parentMethods.isEmpty()) {
			parentMethods = new ArrayList<Method>();
			Method [] methods = parentProviderImplInstance.getClass().getDeclaredMethods();
		
		
		//SV:
		ArrayList<Method> methds = new ArrayList<Method>();
		for(Method method : methods){
			methds.add(method);
		}
		
		Method [] methods2 = parentProviderImplInstance.getClass().getSuperclass().getDeclaredMethods();
		for(Method method : methods2){
			methds.add(method);
		}
		
		Class<Parent> annotationClass = Parent.class;
		Field [] fields = parentProviderImplInstance.getClass().getDeclaredFields();
		//SV:
		ArrayList<Field> flds = new ArrayList<Field>();
		for(Field field : fields){
			flds.add(field);
		}
		
		Field[] fields2 = parentProviderImplInstance.getClass().getSuperclass().getDeclaredFields();
		for(Field field : fields2){
			flds.add(field);
		}
		//SV:END
		
//		for (Field field : fields) {
		for (Field field : flds) {
			if (field.isAnnotationPresent(annotationClass)) {
//				addGetterMethodForField(field, methods, parentGetterMethods);
//				addSetterMethodForField(field, methods, parentSetterMethods);
				addGetterMethodForField(field, methds, parentGetterMethods);
				addSetterMethodForField(field,  methds, parentSetterMethods);

			}
		}
		parentMethodsMap.put(className, parentMethods);
		}
		else {
		//	System.out.println("GETTING FROM CACHE OBJECT " + childrenMethods + " className = "+ className);
		}
	}
	
	
	

	private void addSetterMethodForField(Field field, List<Method> methods, List<Method> resultSetterMethodsList) {
		final String setterMethodName = "set" + field.getName();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(setterMethodName))
				resultSetterMethodsList.add(method);
		}
	}

	public List<? extends MakerCheckerBO> getParentBOs() {
		List<MakerCheckerBO> parentBOs = new ArrayList<MakerCheckerBO>();
		invokeGetterMethods(parentBOs, parentGetterMethods, parentProviderImplInstance);
		return parentBOs;
	}

	public void setParent(MakerCheckerBO parentBO) {
		invokeSetterMethods(parentBO, parentSetterMethods, parentProviderImplInstance);
	}

	private void invokeSetterMethods(MakerCheckerBO parentBO, List<Method> parentSetterMethods, ParentProvider parentProviderImplInstance) {
		for (Method setterMethod : parentSetterMethods) {
			try {
				if (setterMethod.getParameterTypes()[0] == parentBO.getClass() || setterMethod.getParameterTypes()[0] == parentBO.getClass().getSuperclass())
					setterMethod.invoke(parentProviderImplInstance, new Object [] {parentBO});
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
