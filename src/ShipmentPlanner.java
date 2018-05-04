import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * Main class to handle the command line instructions.
 * Calling the essential function, act as a main controller
 * of this programme. 
 * @author tecty
 *
 */
public class ShipmentPlanner {
	static private Graph graph ;
	static SearchGraph sg ;
	static State result;
	
	public static void main(String[] args) {
		// initial a graph to store the info
		graph = new Graph();
		// make sure those class variable is null
		sg  = null;
		result = null;
		
		
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
			// a valid command must have two words in command
			if (command.length < 2) continue;
			// if the line is comment, discard this 
			if( command[0].charAt(0)=='#') continue;
			// read the command to call correspond function
			switch (command[0]) {
			
					/*
					 * I don't want to construct a bootstrap class
					 * since this calling abstraction is simple enough.
					 * Also I don't need to use sperate function to 
					 * call these functions.
					 * 
					 */
					case "Refuelling":
						// create a vertex in map 
						graph.addVertex(command[2], 
								Integer.parseInt(command[1]));
						break;
					case "Time":
						graph.addEdgeByName(command[2],
								command[3], Integer.parseInt(command[1]));
						break;
					case "Shipment":
						if (sg ==null) {
							// first time add shipment 
							sg = new SearchGraph(graph,
									new RemainShipStrategy(),
									graph.getVertexByName("Sydney"));
//							Search perform by zero stratey.
//							sg = new SearchGraph(graph,
//									new ZeroStrategy(),
//									graph.getVertexByName("Sydney"));
						}
						sg.addRequireShipment(command[1], command[2]);
						break;
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
		
		// end of input, do the search
		State s = sg.doSearch();
		
		System.out.println(sg.getCounter()+" nodes expanded");
		new StatePrinter().printState(s);
		
		
	}
}
