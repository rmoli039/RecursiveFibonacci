/*=======================================================================
|   Source code:  FibSequence.java
|
|         Class:  FibSequence 
|
|        Author:  Richard Molina
|    Student ID:  6140544
|    Assignment:  Program #6 - Recursive Fibonacci
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U08
|        Instructor:  William Feild  
|          Due Date:  29 November 2018, at the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:   
| 		javac FibSequence.java Sequence.java
| 
|        Purpose:  This class serves to implement the Sequence interface to
|				   allow for the construction of FibSequence objects. The class
|				   provides methods to construct a new FibSequence, call the next
|				   value in the sequence, and calculate the next Fibonacci number
|				   based on the previous/starting base.
|
|  Inherits From:  N/A
|
|     Interfaces:  Sequence.java
|
|  +-----------------------------------------------------------------------
|
|      Constants:  N/A
|
| +-----------------------------------------------------------------------
|
|     Constructors:  FibSequence
|                     - Constructs a FibSequence object
|					  - Takes input for the starting number of the sequence,
|						storing it as one less than the input value, because
|						the next() method begins by incrementing the current
|						base
|
|    Class Methods:  fibonacci() 
|					  - Calculates the Fibonacci number for an input base
|					  - Utilizes a simple (slow) recursive formula
|					  - Returns the calculated Fibonacci number
|
| Instance Methods:  next() 
|					  - Iterates the current base
|					  - Returns the next Fibonacci number in the sequence (based
|						on that new current base)
|
|  *===========================================================================*/

public class FibSequence implements Sequence
{
	private int currentBase;
	
	/*---------------------------- FibSequence ----------------------------
    |  Constructor FibSequence (startingNumber)
    |
    |  Purpose:  To construct a FibSequence object. Takes input for the 
    |			 starting number of the sequence, storing it as one less 
    |			 than the input value, because the next() method begins by 
    |			 incrementing the current base.
    |
    |  @param	 startingNumber the first base of the sequence
    *-------------------------------------------------------------------*/
	public FibSequence(int startingNumber)
	{
		currentBase = startingNumber - 1;
	}

	/*---------------------------- next ----------------------------
    |  Method next ()
    |
    |  Purpose:  To iterate the current base of the Fibonacci sequence.
	|
    |			 Implements the next() method from the Sequence interface.
    |
    |  @param	 
    |
    |  @return   the next Fibonacci number in the sequence (based on that 
    |			 new current base)
    *-------------------------------------------------------------------*/
	public int next() 
	{
		currentBase++;
		return fibonacci(currentBase);
	}
	
	/*---------------------------- fibonacci ----------------------------
    |  Method fibonacci (base)
    |
    |  Purpose:  To calculate the Fibonacci number for an input base.
    |			 A Fibonacci number is calculated by summing the previous 
    |			 two Fibonacci numbers in the sequence, where the first two
    |			 numbers in the sequence are 1 and 1. The base number describes 
    |			 the position of the desired Fibonacci number in the sequence.
    |			 Utilizes a simple (slow) recursive formula, calling on itself
    |			 to add the previous two numbers in the sequence. Inefficient
    |			 due to many repeated calls. 
	|
	|     		 Source:  Horstmann, Cay S. Big Java: Early Objects, 5th Edition. 
	|							Wiley, 01/2013, pp.599. [Yuzu].
    |
    |  @param	 base the input base number
    |
    |  @return   the calculated Fibonacci number
    *-------------------------------------------------------------------*/
	private int fibonacci(int base)
	{
		final int BASE_CASE = 2;
		final int BASE_VALUE = 1;
		final int FIRST_NTH_BASE = base - 1;
		final int SECOND_NTH_BASE = base - 2;
		
		if (base <= BASE_CASE) 
		{ 
			return BASE_VALUE; 
		} 
		else 
		{ 
			return fibonacci(FIRST_NTH_BASE) + fibonacci(SECOND_NTH_BASE);
		}
	}
}