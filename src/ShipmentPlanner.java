import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShipmentPlanner {
	public static void main(String[] args) {
		 Scanner sc = null;
	     try
	     {
	         sc = new Scanner(new File(args[0]));    // args[0] is the first command line argument
	         // read the input file by scan all the lines
	         while (sc.hasNextLine()) {
	        	// get the input by line 
				String line = (String) sc.nextLine();
				//Test output
				//System.out.println("ThisLine: "+ line );
				
				// split it as command array
				String[] command = line.split(" ");
				
				// if the line is command, discard this 
				//if(command[0] && command[0].charAt(0)=='#') continue;
				// read the command to call correspond function
				switch (command[0]) {
 				}
	        }
		}
		catch (FileNotFoundException e)
		{
		    System.out.println(e.getMessage());
		}
		finally
		{
		    if (sc != null) sc.close();
		}
	}
}
