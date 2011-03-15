
public class Chord {
	
	boolean isMajor;
	Note root, third, fifth;
	
	public Chord() //Basic constructor sets chord to C major
	{
		root = new Note("c");
		third = new Note("e");
		fifth = new Note("g");
		isMajor = true;
	}
	
	public Chord (String root, String third, String fifth, boolean isMajor) //Constructor lets user set notes and tonal quality
	{
		this.root = new Note(root);
		this.third = new Note(third);
		this.fifth = new Note(fifth);
		this.isMajor = isMajor;
	}

	public void parallelShift() //Executes a Riemannian parallel shift on the chord
	{
		if(isMajor)
			third.lower(1); //Lower the third to make the chord minor
		else
			third.raise(1); //Raise the third to make the chord major
		
		isMajor = (isMajor ? false : true);
	}
	
	public void relativeShift() //Executes a Riemannian relative shift on the chord
	{
		if(isMajor)
		{
			fifth.raise(2); //Raise the fifth, making it the new root of a minor chord
			Note temp = fifth;
			fifth = third;
			third = root;
			root = temp;
		}
		else
		{
			root.lower(2); //Lower the root, making it the fifth of a major chord whose root is the old third
			Note temp = root;
			root = third;
			third = fifth;
			fifth = temp;
		}
		
		isMajor = (isMajor ? false : true);
	}

	public void leadingToneShift() //Executes a Riemannian parallel shift on the chord
	{
		if(isMajor) //Lower the root making it the fifth of a minor chord whose root was the previous third
		{
			root.lower(1);
			Note temp = root;
			root = third;
			third = fifth;
			fifth = temp;
		}
		else
		{
			fifth.raise(1); //Raise the fifth making it the root of a major chord 
			Note temp = fifth;
			fifth = third;
			third = root;
			root = temp;
		}
		
		isMajor = (isMajor ? false : true);
	}

	public void resetChord(String root, String third, String fifth, boolean isMajor) // Reset the note values and quality
	{
		this.root.setValue(root);
		this.third.setValue(third);
		this.fifth.setValue(fifth);
		
		this.isMajor = isMajor;
	}
	
	public String getChord() // Prints out the chord values
	{
		return root.getValue() + "  " + third.getValue() + "  " + fifth.getValue();
	}
}