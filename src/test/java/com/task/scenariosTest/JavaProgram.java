package com.task.scenariosTest;


public class JavaProgram {
	// O/p: i=1st dot, it should print o
			// 2nd dot , it should print n

	public static void main(String[] args) {

		int i=4;
		String s= "s.o.n.a.lion.i";
		//String[] split = s.split(".");
	
		if((i*2)%2==0) {
	 String s1= s.substring((i*2), (i*2)+1);
	 System.out.println(s1);
		}
		else {
			System.out.println("not printed anything");
		}
		
		
}
}