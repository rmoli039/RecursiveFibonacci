/*=======================================================================
|   Source code:  ArithmeticOverflowException.java
|
|         Class:  ArithmeticOverflowException 
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
| 		javac ArithmeticOverflowException.java
| 
|        Purpose:  This class serves as a custom exception class to indicate
|				   that a value in the Fibonacci sequence is an integer 
|				   overflow value.
|
|  Inherits From:  Exception.java
|
|     Interfaces:  N/A
|
|  +-----------------------------------------------------------------------
|
|      Constants:  N/A
|
| +-----------------------------------------------------------------------
|
|     Constructors:  ArithmeticOverflowException
|                     - Constructs a ArithmeticOverflowException object
|					 ArithmeticOverflowException(String message)
|                     - Constructs a ArithmeticOverflowException object
|					  - Calls the superclass to pass a programmer-provided error 
|						message to store as an exception object
|					 ArithmeticOverflowException(int number)
|                     - Constructs a ArithmeticOverflowException object
|					  - Sets the overflowNumber equal to the input number
|					 
|    Class Methods:  N/A
|
| Instance Methods:  getOverflowNumber() 
|					  - Returns the value of the integer overflow that caused the 
|						exception to be thrown
|
|  *===========================================================================*/

public class ArithmeticOverflowException extends Exception 
{
	private int overflowNumber;
	
	/*------------------------- ArithmeticOverflowException -------------------------
    |  Constructor ArithmeticOverflowException ()
    |
    |  Purpose:  To construct a ArithmeticOverflowException object.
    |
    |  @param	 
    *-------------------------------------------------------------------*/
	public ArithmeticOverflowException() {}
	
	/*------------------------- ArithmeticOverflowException -------------------------
    |  Constructor ArithmeticOverflowException (message)
    |
    |  Purpose:  To construct a ArithmeticOverflowException object. Calls the superclass 
    |			 to pass a programmer-provided error message to store as an exception 
    |			 object. 
    |
    |  @param	 message the programmer-defined error message
    *-------------------------------------------------------------------*/
	public ArithmeticOverflowException(String message)
	{
		super(message);
	}
	
	/*------------------------- ArithmeticOverflowException -------------------------
    |  Constructor ArithmeticOverflowException (number)
    |
    |  Purpose:  To construct a ArithmeticOverflowException object. Sets the overflowNumber 
    |			 equal to the input number.
    |
    |  @param	 number the value of the integer overflow that caused the exception 
    |			 to be thrown
    *-------------------------------------------------------------------*/
	public ArithmeticOverflowException(int number) 
	{
		overflowNumber = number;
	}
	
	/*---------------------------- getOverflowNumber ----------------------------
    |  Method getOverflowNumber ()
    |
    |  Purpose:  To return the value of the integer overflow that caused the 
	|			 exception to be thrown.
    |
    |  @param	 
    |
    |  @return   the value of the integer overflow that caused the 
	|		     exception to be thrown
    *-------------------------------------------------------------------*/
	public int getOverflowNumber()
	{
		return overflowNumber;
	}
}