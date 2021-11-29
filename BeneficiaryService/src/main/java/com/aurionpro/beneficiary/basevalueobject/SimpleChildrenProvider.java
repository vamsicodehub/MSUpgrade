package com.aurionpro.beneficiary.basevalueobject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SimpleChildrenProvider extends AbstractParentChildrenProvider implements ChildrenProvider {
private static Map<String,List<Method>> childrenMethodsMap =new HashMap<String, List<Method>>();
	
	private  transient List<Method> childrenMethods = new ArrayList<Method>();

	private ChildrenProvider childProviderImplInstance;

	public SimpleChildrenProvider(ChildrenProvider childProviderImplInstance) {
			
			this.childProviderImplInstance = childProviderImplInstance;
			String className = childProviderImplInstance.getClass().getName();
			childrenMethods = childrenMethodsMap.get(className);
			
			if(childrenMethods == null || childrenMethods.isEmpty()) {
				childrenMethods = new ArrayList<Method>();
				Method [] methods = childProviderImplInstance.getClass().getDeclaredMethods();

				//SV:Need to get the methods of the class and its base class 

				ArrayList<Method> methds = new ArrayList<Method>();
				for(Method method : methods){
					methds.add(method);
				}

				Method [] methods2 = childProviderImplInstance.getClass().getSuperclass().getDeclaredMethods();
				for(Method method : methods2){
					methds.add(method);
				}
				//SV:END

				Class<Child> annotationClass = Child.class;
				Field [] fields = childProviderImplInstance.getClass().getDeclaredFields();
				//SV:Need to get the fields of the class and its base class
				ArrayList<Field> flds = new ArrayList<Field>();
				for(Field field : fields){
					flds.add(field);
				}

				Field [] fields2 = childProviderImplInstance.getClass().getSuperclass().getDeclaredFields();
				for(Field field : fields2){
					flds.add(field);
				}

//				for (Field field : fields) {
				//SV:END
				for (Field field : flds) {			
					if (field.isAnnotationPresent(annotationClass)) {
//						addGetterMethodForField(field, methods, childrenMethods);
						addGetterMethodForField(field, methds, childrenMethods);
					}
				}
				
				childrenMethodsMap.put(className, childrenMethods);
			}
			else {
			//	System.out.println("GETTING FROM CACHE OBJECT " + childrenMethods + " className = "+ className);
			}
		}

	public List<? extends MakerCheckerBO> getChildrenBOs() {
		List<MakerCheckerBO> childrenBOs = new ArrayList<MakerCheckerBO>();
		invokeGetterMethods(childrenBOs, childrenMethods, childProviderImplInstance);
		return childrenBOs;
	}
}