import java.util.ArrayList;

public class Note {
	
	String value = "";
	private ArrayList<String> allNotes = new ArrayList<String>(); //A reference list of every note there is, in order
	
	public Note()
	{
		value = "c";
		populateAllNotes();
	}

	public Note(String value)
	{
		this.value = value;
		populateAllNotes();
	}
	
	public void raise(int steps) // Raises the note's value by a given number of half-steps
	{
		int index = allNotes.indexOf(value); //Current note's position in allNotes
		int newIndex = index + steps; //Find the new index
		if(newIndex >11) //If it gets out of bounds, subtract 11 to get it back in
			newIndex -= 12;
		value = allNotes.get(newIndex); //Set the value to the new index's value
	}
	
	public void lower(int steps) // Lowers the note's value by a given number of half-steps
	{
		int index = allNotes.indexOf(value); //Current note's position in allNotes
		int newIndex = index - steps; //Find the new index
		if(newIndex < 0) //If it gets out of bounds, add 11 to get it back in
			newIndex += 12;
		value = allNotes.get(newIndex); //Set the value to the new index's value
	}
	
	private void populateAllNotes() //Populates the allNotes list upon construction
	{ 
		allNotes.add("c");
		allNotes.add("c#");
		allNotes.add("d");
		allNotes.add("d#");
		allNotes.add("e");
		allNotes.add("f");
		allNotes.add("f#");
		allNotes.add("g");
		allNotes.add("g#");
		allNotes.add("a");
		allNotes.add("a#");
		allNotes.add("b");
	}
	
	public void setValue(String value) // Setter for the note's value
	{
		this.value = value;
	}
	
	public String getValue() //Returns the note's value
	{
		return value;
	}
}