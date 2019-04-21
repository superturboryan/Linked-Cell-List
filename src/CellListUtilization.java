import java.io.*; 
import java.util.*;


public class CellListUtilization {

	public static void main(String[] args) {

		System.out.println("Welcome to my CellList tester!\n");
		
		String currentFile = "Cell_Info.txt";
		
		System.out.println("Text file currently used for input: " + currentFile + "\n");
		
		CellList cl1 = new CellList();
		CellList cl2 = new CellList();
		
		File cellFile = new File("/Users/ryan/workspace/249 Assignment 4/" + currentFile);
		
		try {
			Scanner input = new Scanner(new FileInputStream(cellFile));
			
			while (input.hasNextLine()) {
				
				long sn = input.nextLong();
				String b = input.next();
				double p = input.nextDouble();
				int y = input.nextInt();
				
				CellPhone toInsert = new CellPhone(sn, b, y, p);
				
				cl1.addToStart(toInsert);
				cl2.addToStart(toInsert);
			}
			input.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("ERROR! Input file not found \nPlease ensure it is in the correct directory and try again. \nProgram terminating...");
			e.printStackTrace();
			System.exit(0);
		}
		
			
//		cl1.deleteFromIndex(25);
//		cl1.deleteFromIndex(24);
//		cl1.deleteFromStart();
		
		System.out.println("Are the two created lists equal? " + cl1.equals(cl2) + "\n");
		
		CellPhone test = new CellPhone(1234567, "Apple", 2017, 849.99);
		
		//cl1.insertAtIndex(test, 0);
		
		cl1.replaceAtIndex(test, 0);
		
		cl1.showContents();
		
		System.out.println("\nAre the two created lists equal? " + cl1.equals(cl2) + "");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("\nPlease enter a serial # to find within the list: ");
		long search = kb.nextLong();
		
		System.out.print("\nWas the serial # found in the list? ");
		if (cl1.contains(search) == true) {
			System.out.println("Yes!");
		}
		else System.out.println("No!");
		
		cl1.find(search);
		
		kb.close();
	}	
}
