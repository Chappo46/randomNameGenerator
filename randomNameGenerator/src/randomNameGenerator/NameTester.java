package randomNameGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameTester {

	public static void main(String[] args)
	{
		NameGenerator ng = new NameGenerator();
		List<String> nameList = new ArrayList<String>();
		for(int i = 0;i<10000;i++)
		{
//			System.out.println(ng.generate(3));
			
//			System.out.print(ng.generate(9)+ " "+ng.generate(9));
//			System.out.println();
//			
			
//			System.out.print(ng.generate(8));
//			System.out.printf("\t\t\t");
//			System.out.print(ng.generate(8));
//			System.out.printf("\t\t\t");
//			System.out.println(ng.generate(8));
			nameList.add(ng.generate(10));
		}
		Collections.sort(nameList);
		
		for(String el: nameList)
		{
			System.out.println(el);
		}
	}

}
