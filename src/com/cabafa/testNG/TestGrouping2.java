package com.cabafa.testNG;

import org.testng.annotations.Test;

public class TestGrouping2 {
  
	@Test (groups = {"A"})
	public void m1() {
	}
	
	@Test (groups = {"B"})
	public void m2() {
	}
	
	@Test (groups = {"C"})
	public void m3() {
	}
	
	@Test (groups = {"C"})
	public void m4() {
	}
}
