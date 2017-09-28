package com.cabafa.testNG;

import org.testng.annotations.Test;

public class testAttributes {
	
  @Test (priority = 5)
  public void f() {
  }
  
  @Test (priority = 0)
  public void m() {
  }
  
  @Test (priority = 15)
  public void l() {
  }
  
  @Test (priority = 9)
  public void w() {
  }
  
  @Test (priority = 0)
  public void t() {
  }
  
  @Test (enabled = false) 
  public void h() {
  }
}
