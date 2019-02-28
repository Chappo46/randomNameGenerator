package randomNameGenerator;

public class NameTester {

	public static void main(String[] args)
	{
		NameGenerator ng = new NameGenerator();
		
		for(int i = 0;i<10;i++)
		{
			System.out.print(ng.generate(8));
			System.out.printf("\t\t\t");
			System.out.print(ng.generate(8));
			System.out.printf("\t\t\t");
			System.out.println(ng.generate(8));
		}

	}

}
