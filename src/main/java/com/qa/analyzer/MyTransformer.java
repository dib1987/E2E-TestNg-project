package com.qa.analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


// This interface is being implemented to run your failed test cases again // 
public class MyTransformer implements IAnnotationTransformer  {
	
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}