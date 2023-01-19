package com.monocept.test;

import com.monocept.model.Player;
import java.lang.Class;
import java.lang.reflect.*;

import com.monocept.model.Player;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		
		String str = "java.lang."+args[0];
		Class obj = Class.forName(str);
		Method[] m = obj.getDeclaredMethods();
		for (int i = 0; i < m.length; ++i) {
			System.out.println("Method Name: " + m[i].getName());

			int modifier = m[i].getModifiers();
			System.out.println("Access Modifier: " + Modifier.toString(modifier));

			System.out.println("Return Types: " + m[i].getReturnType());
			System.out.println(" ");

		}
		System.out.println(".....................................");
		Field[] field = obj.getDeclaredFields();
		for(Field f : field) {
			f.setAccessible(true);
		    System.out.println("FieldName: " +f);
		}
		System.out.println("..................................");
		Constructor[] constructors = obj.getDeclaredConstructors();
		for (Constructor c : constructors) {

			System.out.println("Constructor Name: " + c.getName());

			int modifier = c.getModifiers();
			String mod = Modifier.toString(modifier);
			System.out.println("Modifier: " + mod);

			System.out.println("Parameters: " + c.getGenericParameterTypes());
			System.out.println("");

		}
	}

}
