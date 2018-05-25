package org.ysh.java.core.test;

public class AssertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -1;
		assert i>0:"i must bigger than 0";
		if(i%3==0){
			System.out.println("3");
		}else{
			System.out.println("not 3");
		}
		
	}

}
