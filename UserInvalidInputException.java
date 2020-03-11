/*=======================================================================
|   Source code:  UserInvalidInputException.java
|
|         Class:  UserInvalidInputException 
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
| 		javac UserInvalidInputException.java
| 
|        Purpose:  This class serves as a custom exception class to indicate any number
|				   of rule violations made by the user when providing input.
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
|     Constructors:  UserInvalidInputException
|                     - Constructs a UserInvalidInputException object
|					 UserInvalidInputException(String message)
|                     - Constructs a UserInvalidInputException object
|					  - Calls the superclass to pass a programmer-provided error 
|						message to store as an exception object
|					 
|    Class Methods:  N/A
|
| Instance Methods:  N/A
|
|  *===========================================================================*/

public class UserInvalidInputException extends Exception 
{
	/*------------------------- UserInvalidInputException -------------------------
    |  Constructor UserInvalidInputException ()
    |
    |  Purpose:  To construct a UserInvalidInputException object.
    |
    |  @param	 
    *-------------------------------------------------------------------*/
	public UserInvalidInputException() {}
	
	/*------------------------- UserInvalidInputException -------------------------
    |  Constructor UserInvalidInputException (message)
    |
    |  Purpose:  To construct a UserInvalidInputException object. Calls the superclass 
    |			 to pass a programmer-provided error message to store as an exception 
    |			 object.
    |
    |  @param	 message the programmer-defined error message
    *-------------------------------------------------------------------*/
	public UserInvalidInputException(String message)
	{
		super(message);
	}
}