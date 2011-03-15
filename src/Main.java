import java.util.*;

public class Main
{
    public static void main (String[] args)
    {
    	Chord main = new Chord("c","e","g",true); //Chord to be transformed
    	Chord target = new Chord("g#","b","d#",false); //Target chord
    	ArrayList<Integer> temp = new ArrayList<Integer>(); //Lists to store the sequences of moves in order to find the quickest
    	ArrayList<Integer> best = new ArrayList<Integer>();
    	int lowestMoves = 10000;
    	
    	for(int k=0;k<10000;k++) //Iterate 10000 times to account for randomness.
    	{
    		while(!(main.getChord().equals(target.getChord()))) //Shift base chord randomly until it equals target
        	{
        		Random generator = new Random();
        		int rand = generator.nextInt(3); //Generate random int between 0-2 exclusive
        		
        		if(rand == 0) // If rand is 0 do a parallel shift
        			main.parallelShift();
        		else if(rand == 1) // If rand is 1 do a relative shift
        			main.relativeShift();
        		else //If rand is 2 do a leading tone shift
        			main.leadingToneShift();
        		
        		temp.add(rand);
        	}
    	
    		if(temp.size()<lowestMoves) //If a sequence was completed which was the quickest yet, record it in best
    		{
    			lowestMoves = temp.size(); //Set the new record for lowest moves
    			best.clear(); //Clear the best ArrayList and set it to the temp
    			for(int j=0;j<temp.size();j++)
    				best.add(new Integer(temp.get(j).intValue()));
    		}
    	
    		main.resetChord("c", "e", "g", true); //Reset the start chord every iteration
    		temp.clear(); //Clear out the temp ArrayList every iteration
    	}
    	
    	printTransformation(main, target, best); //Print out the best transformation
    }
    
    /*Print out the sequence given a list of transformations and a start chord*/
    public static void printTransformation(Chord start, Chord end, ArrayList<Integer> moves) 
    {
    	System.out.println("The quickest method to get from " + start.getChord() + " to " + end.getChord() + ": ");
    	System.out.println("0:    " + start.getChord() + "     Base Chord");
    	for(int k=0;k<moves.size();k++)
    	{
    		if(moves.get(k).intValue()==0)
    		{
    			start.parallelShift();
    			System.out.println((k+1) + ":    " + start.getChord() + "     Parallel Shift");
    		}
    		else if(moves.get(k).intValue()==1)
    		{
    			start.relativeShift();
    			System.out.println((k+1) + ":    " + start.getChord() + "     Relative Shift");
    		}
    		else
    		{
    			start.leadingToneShift();
    			System.out.println((k+1) + ":    " + start.getChord() + "     Leading Tone Exchange");
    		}
    	}
    }
}