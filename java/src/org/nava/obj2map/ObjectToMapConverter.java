/**
  This program converts the given object into map while persisting the data type of the object members.
 */
package org.nava.obj2map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ObjectToMapConverter {

	private Object objectToBeConverted;
	private Map<String, Object> mapToBePopulated;

	public Object getObjectToBeConverted() {
		return objectToBeConverted;
	}

	public void setObjectToBeConverted(Object objectToBeConverted) {
		this.objectToBeConverted = objectToBeConverted;
	}

	public Map<String, Object> getMapToBePopulated() {
		return mapToBePopulated;
	}

	public void setMapToBePopulated(Map<String, Object> mapToBePopulated) {
		this.mapToBePopulated = mapToBePopulated;
	}

	public ObjectToMapConverter(Object toBeConverted, Map<String, Object> toBeMapped) {
		this.objectToBeConverted = toBeConverted;
		this.mapToBePopulated = toBeMapped;
	}

	public void convert(){

		Class<? extends Object> clazz = this.objectToBeConverted.getClass();
		Method[] allMethods = clazz.getDeclaredMethods();

		for (Method method : allMethods) {
			if (method.getName().startsWith("get")) {
				String key = getKey(method);
				Object value = getValue(method, key);
				System.out.println("Adding key :" + key + " with value :" + value);
				this.mapToBePopulated.put(key, value);
			}
		}
	}

	private Object getValue(Method method, String key) {
		Object value = null;
		Object[] nullArgs = new Object[0];
		try {
			value = method.invoke(this.objectToBeConverted, nullArgs);
		} catch (IllegalAccessException e) {
			System.err.println("Error accessing a method, value for key "+key+" will be set to null \n"+e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error invoking a method, value for key "+key+" will be set to null \n"+e.getMessage());
		} catch (InvocationTargetException e) {
			System.err.println("Error invoking a method, value for key "+key+" will be set to null \n"+e.getMessage());
		}
		return value;
	}

	private String getKey(Method method) {
		String name = method.getName();
		name = name.substring(3);
		name = name.toLowerCase();
		return name;
	}
}
