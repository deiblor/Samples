package com.cabafa.testNG;

import org.testng.annotations.*;

public class TestAnnotations {

	@Test
	public void f1() {

		System.out.println("Inside F1");

	}

	@Test
	public void f2() {

		System.out.println("Inside F2");

	}

	@BeforeTest
	public void beforeTests() {

		System.out.println("Before any test");

	}

	@AfterTest
	public void afterTests() {

		System.out.println("After all tests");

	}

	@BeforeMethod
	public void beforeMethods() {

		System.out.println("Before every test method");
		;

	}

	@AfterMethod
	public void afterMethods() {

		System.out.println("After every test method");

	}

	@BeforeClass
	public void beforeClasses() {

		System.out.println("Before class");

	}

	@AfterClass
	public void afterClasses() {

		System.out.println("After class");

	}
}
