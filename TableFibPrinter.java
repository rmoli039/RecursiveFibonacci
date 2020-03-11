/*=======================================================================
|   Source code:  TableFibPrinter.java
|
|         Class:  TableFibPrinter 
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
| 		javac TableFibPrinter.java
| 
|        Purpose:  This class provides methods to receive Fibonacci numbers
|				   from FibDemo's algorithm execution, printing each set to
|				   a square-formatted table and filling in arithmetic overflow 
|				   values with placeholder asterisks.
|
|  Inherits From:  N/A
|
|     Interfaces:  N/A
|
|  +-----------------------------------------------------------------------
|
|      Constants:  DEFAULT_COLUMNS is initialized to 1, the default number of
|				   columns for a table. This number is used to determine the
|				   dimensions of a larger table.
|
|				   MAX_COLUMNS is initialized to 6. This is the maximum number
|				   of columns of Fibonacci numbers that will be printed in the 
|				   table, after which only additional rows are added.
|
|				   OVERFLOW_CHECK is initialized to 0. This is used to check
|				   for arithmetic overflow, because an integer calculated
|			  	   beyond the max integer value will turn negative (< 0).
|
| +-----------------------------------------------------------------------
|
|     Constructors:  TableFibPrinter
|                     - Constructs a TableFibPrinter object
|					  - Takes input for the output file to write to, as
|						well as the length of the Fibonacci sequence
|					  - Calls the setColumns() method to calculate the proper
|						number of columns for a square-formatted table.
|
|    Class Methods:  setColumns() 
|					  - Calculates and sets the proper number of columns for
|						a square-formatted table.
|
| Instance Methods:  printToTable() 
|					  - Checks for arithmetic overflow, throwing an
|						ArithmeticOverflowException if so
|					  - Prints the input Fibonacci number to the next spot in the
|						table, tracking column placement and resetting it if
|						needed
|					 printStarsToTable()
|					  - Calculates the number of digits in an integer overflow value
|					  - Prints that many asterisks to the next spot in the
|						table, tracking column placement and resetting it if
|						needed
|					 resetTable()
|					  - Resets the column counter for a new table to print from
|						scratch
|
|  *===========================================================================*/

import java.io.PrintWriter;		//Allows the program to print to an external file
import java.lang.Math;			//Allows the use of log10, abs, sqrt, & round functions

public class TableFibPrinter 
{
	private int sequenceLength;
	private int columnCounter;
	final static private int DEFAULT_COLUMNS = 1;
	final static private int MAX_COLUMNS = 6;
	final static private int OVERFLOW_CHECK = 0;
	static int columns = DEFAULT_COLUMNS;
	
	PrintWriter outputFile;
	
	/*---------------------------- TableFibPrinter ----------------------------
    |  Constructor TableFibPrinter (output, length)
    |
    |  Purpose:  To construct a TableFibPrinter object. Takes input for the 
    |			 output file to write to, as well as the length of the Fibonacci 
    |			 sequence. Also calls the setColumns() method to calculate the 
    |			 proper number of columns for a square-formatted table.
    |
    |  @param	 output the output file to print to
    |			 length the requested length of the Fibonacci sequence
    *-------------------------------------------------------------------*/
	public TableFibPrinter(PrintWriter output, int length)
	{
		outputFile = output;
		sequenceLength = length;
		setColumns();
	}
	
	/*---------------------------- printToTable ----------------------------
    |  Method printToTable (nextFibNumber)
    |
    |  Purpose:  To print the input Fibonacci number to the next spot in the
	|			 table, tracking column placement and resetting it if needed.
	|			 Also checks for arithmetic overflow, throwing an 
	|			 ArithmeticOverflowException if so, passing the integer
	|			 overflow value.
    |
    |  @param	 nextFibNumber the input Fibonacci number
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public void printToTable(int nextFibNumber) throws ArithmeticOverflowException 
	{		
		if(nextFibNumber < OVERFLOW_CHECK)
		{
			throw new ArithmeticOverflowException(nextFibNumber);
		}
		
		outputFile.printf("%11d ", nextFibNumber);
		columnCounter++;
			
		if (columnCounter == columns)
		{
			columnCounter = 0;
			outputFile.println("");
		}	
	}
	
	/*---------------------------- printStarsToTable ----------------------------
    |  Method printStarsToTable (nextFibNumber)
    |
    |  Purpose:  To calculate the number of digits in an integer overflow value. 
    |			 Prints that many asterisks to the next spot in the table, tracking 
    |			 column placement and resetting it if needed. The formula to
    |			 determine the number of digits in an integer is to take the absolute
    |			 value of it, find the log10 of that number, and then add 1.
    |
    |			 Source: baeldung.com/java-number-of-digits-in-int
    |
    |  @param	 nextFibNumber the input Fibonacci number/integer overflow
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public void printStarsToTable(int nextFibNumber) 
	{		
		int numberLength = (int)(Math.log10(Math.abs(nextFibNumber)) + 1);
		
		String stars = "";
		
		for (int counter = 0; counter < numberLength; counter++)
		{
			stars = (stars + "*");
		}
		outputFile.printf("%11s ", stars);
		columnCounter++;
			
		if (columnCounter == columns)
		{
			columnCounter = 0;
			outputFile.println("");
		}
	}
	
	/*---------------------------- setColumns ----------------------------
    |  Method setColumns ()
    |
    |  Purpose:  To calculate and set the proper number of columns for
	|			 a square-formatted table. The width of the table
    |			 is calculated by the number of columns, which is a rounded
    |			 value of the square root of the number of Fibonacci numbers 
    |			 in the sequence. The maximum number of columns is 6, wherein 
    |			 only the number of rows will continue to grow afterward.
    |
    |  @param	 
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	private void setColumns()
	{
		if (sequenceLength >= (MAX_COLUMNS * MAX_COLUMNS))
		{
			columns = MAX_COLUMNS;
		}
		else if (sequenceLength > DEFAULT_COLUMNS)
		{
			columns = (int)Math.round(Math.sqrt(sequenceLength));
		}
	}
	
	/*---------------------------- resetTable ----------------------------
    |  Method resetTable ()
    |
    |  Purpose:  To reset the column counter for a new table to print from
	|			 scratch.
    |
    |  @param	 
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public void resetTable()
	{
		columnCounter = 0;
	}
}