/*=======================================================================
|   Source code:  EmptyFileException.java
|
|         Class:  EmptyFileException 
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
| 		javac EmptyFileException.java
| 
|        Purpose:  This class serves as a custom exception class to indicate
|				   that an input file has no input inside.
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
|     Constructors:  EmptyFileException
|                     - Constructs a EmptyFileException object
|					 EmptyFileException(String message)
|                     - Constructs a EmptyFileException object
|					  - Calls the superclass to pass a programmer-provided error 
|						message to store as an exception object
|					 
|    Class Methods:  N/A
|
| Instance Methods:  N/A
|
|  *===========================================================================*/

public class EmptyFileException extends Exception 
{
	/*------------------------- EmptyFileException -------------------------
    |  Constructor EmptyFileException ()
    |
    |  Purpose:  To construct a EmptyFileException object.
    |
    |  @param	 
    *-------------------------------------------------------------------*/
	public EmptyFileException() {}
	
	/*------------------------- EmptyFileException -------------------------
    |  Constructor EmptyFileException (message)
    |
    |  Purpose:  To construct a EmptyFileException object. Calls the superclass 
    |			 to pass a programmer-provided error message to store as an exception 
    |			 object.
    |
    |  @param	 message the programmer-defined error message
    *-------------------------------------------------------------------*/
	public EmptyFileException(String message)
	{
		super(message);
	}
}