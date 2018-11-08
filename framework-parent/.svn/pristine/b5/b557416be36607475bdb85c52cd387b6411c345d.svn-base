package com.tendcloud.adt.testcases.non_keywords.common;

import static org.testng.Assert.assertFalse;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import framework.base.anotation.TestDoc;
import framework.base.exception.StopRunningException;

public class TestException {

	//第一种情况：调用有异常的方法，捕获异常，之后再抛出给调用端：
	@Test
	public void testException() throws Throwable{
		try {
			m1();
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println("-------------");
			System.out.println(msg);
			System.out.println("-------------");
			e.printStackTrace();
			throw new StopRunningException(e);
		}
	}
	
	//第二种情况，调用有异常的方法，但不处理，在调用端由调用者处理：
	public void testException2(){
		m1();
	}
	
	//第三种情况，抛出Error
	@Test
	public void test3(){
		try {
			m3();
		} catch (Throwable e) {
			String msg = e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void ttt() throws Throwable{
		try {
			testException();
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println("***************");
			System.out.println(msg);
			System.out.println("***************");
			e.printStackTrace();
		}
	}
	
	@Test
	@TestDoc(testObjective="测试捕获一个异常后，再抛出一个自定义异常，看是否可以将自定义异常正常捕获，并得到异常信息")
	public void testSelfException(){
		try {
			m2();
		} catch (Throwable e) {
			String msg = e.getMessage();
			/*String cause = e.getCause();*/
			System.out.println(e instanceof StopRunningException);
			//System.out.println(e.getClass().getSimpleName());
		}
	}
	
	
	
	@Test
	public void testError(){
		try {
			m3();
		} catch (Throwable e) {
			String msg = e.getMessage();
			//String cause = e.getCause().getMessage();
			System.out.println(msg + "------------" );
		}
	}
	
	@Test
	public void testM6(){
		try {
			m6();
		} catch (Throwable e) {
			if(e instanceof StopRunningException){
				//
				System.out.println("xxx");
			}
		}
	}
	public void m1(){//抛出Exception
		int i = 1/0;
	}
	
	public void m2() throws Exception{//捕获异常，重新抛出自定义异常；
		try {
			m1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			throw new StopRunningException("hello, test");
		}
	}
	
	public void m3() throws AssertionError{//抛出Error；
		int i = 2;
		assertFalse(i>0);
	}
	
	public void m4() throws Exception{
		try {
			m3();
		} catch (Throwable t) {
			throw new StopRunningException((StopRunningException)t);
		}
	}
	public void m5(){
		m3();
	}
	public void m6() throws StopRunningException{
		try {
			m5();
		} catch (Throwable e) {
			throw new StopRunningException((StopRunningException)e);
		}
	}
	
	
	@Test
	public void test() throws StopRunningException{
		assertFalse(1>0);
		//throw new StopRunningException("aaaaa");
		//System.out.println(s instanceof StopRunningException);
	}
	
	@Test
	public void t() throws StopRunningException{
		try {
			test();
		} catch (Throwable e) {
			String msg = e.getMessage();
			System.out.println(msg);
			throw new StopRunningException("aaaaa");
		}
	}
	
	@Test
	public void hello(){
		try {
			test();
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
	
	public void testFinally(){
		for(int i=0;i<4; i++){
			try {
			int j = 1/3;
			break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//return ;
				break;
				
			}finally{
				System.out.println("hello");
			}
		}
		
	}
	@Test
	public void tes(){
		testFinally();
	}
}









