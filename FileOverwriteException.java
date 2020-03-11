/*=======================================================================
|   Source code:  FileOverwriteException.java
|
|         Class:  FileOverwriteException 
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
| 		javac FileOverwriteException.java
| 
|        Purpose:  This class serves as a custom exception class to indicate
|				   that an output file is set to be overwritten.
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
|     Constructors:  FileOverwriteException
|                     - Constructs a FileOverwriteException object
|					 FileOverwriteException(String message)
|                     - Constructs a FileOverwriteException object
|					  - Calls the superclass to pass a programmer-provided error 
|						message to store as an exception object
|					 
|    Class Methods:  N/A
|
| Instance Methods:  N/A
|
|  *===========================================================================*/

public class FileOverwriteException extends Exception 
{
	/*------------------------- FileOverwriteException -------------------------
    |  Constructor FileOverwriteException ()
    |
    |  Purpose:  To construct a FileOverwriteException object.
    |
    |  @param	 
    *-------------------------------------------------------------------*/
	public FileOverwriteException() {}
	
	/*------------------------- FileOverwriteException -------------------------
    |  Constructor FileOverwriteException (message)
    |
    |  Purpose:  To construct a FileOverwriteException object. Calls the superclass 
    |			 to pass a programmer-provided error message to store as an exception 
    |			 object.
    |
    |  @param	 message the programmer-defined error message
    *-------------------------------------------------------------------*/
	public FileOverwriteException(String message)
	{
		super(message);
	}
}