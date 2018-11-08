package com.tendcloud.adt.testcases.non_keywords.unit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import framework.base.exception.StopRunningException;

public class TestException {
	
	public static void main(String[] args){
		Test t = new Test();
		Method[] m = Test.class.getMethods();
			for(Method mm : m){
				try {
					mm.invoke(t, null);
				} catch (Exception e) {
					if(e instanceof StopRunningException){
						System.out.println("hellohello");
						
						return;
					}
				}
				
			}
			System.out.println("-----------");
			System.out.println("xxxxx");
	}
	
}

class Test{
	public void get() throws StopRunningException{
		int i=1;
		try {
			int j = i/0;
		} catch (Exception e) {
			throw new StopRunningException(e);
		}
	}
}