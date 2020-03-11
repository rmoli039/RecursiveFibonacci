/*=============================================================================  
|   Source code:  FibDemo.java
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
| 		javac FibDemo.java FibSequence.java LoopFibSequence.java FastFibSequence.java 
|			  TableFibPrinter.java UserInvalidInputException.java FileOverwriteException.java
|			  EmptyFileException.java ArithmeticOverflowException.java Sequence.java
|		java FibDemo inputFile outputFile
|
|		Both the input file and the Sequence interface must be in the same directory as 
|		the source code.
|
|		The FibDemo program takes command line input to function. Specifically,
|		two strings following the run command, separated by a delimiter. The first string 
|		(inputFile) is the name of the file that input will be taken from. The second 
|		string (outputFile) is the name of the file that output will be printed to.
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  This program tests the implementation of the Sequence interface in three 
|				 different Fibonacci classes by comparing their three different algorithms,
|				 regular recursion, iterative, and fast recursion. User input is taken from 
|				 the command-line, verified, and then used to pull input values from a 
|				 designated input file. The input values are also validated, and they 
|			     determine the starting base for the Fibonacci sequences and how many 
|				 Fibonacci numbers it should find. The program tests the Fibonacci 
|				 sequencing and searching by displaying the desired Fibonacci numbers in 
|				 three consecutive square-formatted tables. The program also compares the 
|				 efficiency of each algorithm by displaying the execution time for each one 
|				 in both nanoseconds and seconds, allowing for an easy comparison. All 
|				 output is formatted and printed to a designated output file, named in the 
|				 command line.
|
|				 In addition, the program includes custom exception handling for a number of 
|				 possibilities, including: FileNotFound, FileOverwrite, EmptyFile, 
|				 UserInvalidInput, ArithmeticOverflow, and the general Exception. All 
|				 exception handling displays informative messages to the console and 
|				 terminates the program. The exception to this is the 
|				 ArithmeticOverflowException, which does not terminate the program, but 
|				 rather continues sequencing beyond the maximum integer value 
|				 with filler text made of asterisks.
|  
|        Input:  The FibDemo program takes command line input to function. Specifically,
|				 two strings following the run command, separated by a delimiter. The first
|				 string is the name of the file that input will be taken from. The second 
|				 string is the name of the file that output will be printed to. The input file
|				 provides two integer values; the first value is 1-13 and determines the 
|				 starting base for the Fibonacci sequences, while the second value is 1-35
|				 and determines how many Fibonacci numbers the sequences should find.
|  
|       Output:  The program outputs the Fibonacci sequence for each algorithm in a 
|				 square-formatted table. After each table the program also outputs the 
|				 execution time for that specific algorithm in both nanoseconds and seconds. 
|				 All output is printed to the output file.
|  
|      Process:  The program's steps are as follows:  
|  
|                1.  The program validates the command line input, the file input and output,
|					 and the input values, terminating if needed.
|                2.  The program constructs FibSequence, LoopFibSequence, and FastFibSequence 
|					 objects, as well as a TableFibPrinter object for printing.
|                3.  System time is recorded, and a for loop runs, calling the next() 
|				     Fibonacci numbers from the FibSequence class and sending them to the 
|					 TableFibPrinter class to be printed.
|                4.  The loop ends, system time is recorded again, and the recordTimes() 
|					 method is called, calculating and printing the execution time in 
|					 nanoseconds and seconds and resetting the TableFibPrinter to be reused.
|                5.  The same process in steps 3-4 is repeated for the LoopFibSequence class 
|					 and the FastFibSequence class.
|  
|   Required Features Not Included:  All required features are included.  
|  
|   Known Bugs:  None; the program operates correctly. 
|
|   Extra Credit:  Completed. The program considers additional exception handling, 
|				   specifically FileOverwriteException. If the user's output file
|				   already exists, the console asks the user whether or not they
|				   would like to overwrite that file. The user may confirm, which
|				   allows execution to continue normally, or the user may decline,
|				   which throws an exception.
|
|  *===========================================================================*/

import java.io.File;					//Allows the construction of file objects
import java.io.FileNotFoundException;	//Needed to catch a FileNotFoundException
import java.io.PrintWriter;				//Allows the program to print to an external file
import java.util.Scanner;				//Allows the program to read input from a file/console

public class FibDemo 
{

	public static void main(String[] args)
	{
		final int FIRST_INPUT_INDEX = 0;
		final int SECOND_INPUT_INDEX = 1;
		
		File inputFile = null;
		PrintWriter outputFile = null;
		Scanner input = null;
		int[] inputValues = null;
		
		try
		{
			validateCommandInput(args);
			inputFile = new File(args[FIRST_INPUT_INDEX]);
			input = new Scanner(inputFile);
			inputValues = validateFileInput(input);
			overwriteFileCheck(args[SECOND_INPUT_INDEX]);
			outputFile = new PrintWriter(args[SECOND_INPUT_INDEX]);

		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Input file not found. Ensure the file is in the same "
								+ "directory and the name is spelled correctly.");
			System.exit(1);
		}
		catch (FileOverwriteException exception)
		{
			System.out.println(exception.getMessage());
			System.exit(1);
		}
		catch (EmptyFileException exception)
		{
			System.out.println(exception.getMessage());
			System.exit(1);
		}
		catch (UserInvalidInputException exception) 
		{
			System.out.println(exception.getMessage());
			System.exit(1);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.exit(1);
		}
		
		final int DEFAULT_TIME = 0;
		int startingNumber = inputValues[FIRST_INPUT_INDEX];
		int sequenceLength = inputValues[SECOND_INPUT_INDEX];
		long startTime = DEFAULT_TIME;
		
		FibSequence fib = new FibSequence(startingNumber);
		LoopFibSequence loopFib = new LoopFibSequence(startingNumber);
		FastFibSequence fastFib = new FastFibSequence(startingNumber, sequenceLength);
		TableFibPrinter tablePrinter = new TableFibPrinter(outputFile, sequenceLength);

		System.out.println("Loading values. The process should take no more than a minute.");
		outputFile.printf("Normal Recursive%n");
		startTime = System.nanoTime();
		for(int counter = 0; counter < sequenceLength; counter++)
		{
			try
			{
				tablePrinter.printToTable(fib.next());
			}
			catch (ArithmeticOverflowException exception)
			{
				tablePrinter.printStarsToTable(exception.getOverflowNumber());
				System.out.println("ArithmeticOverflow encountered. Placeholder values "
									+ "printed with asterisks.");
			}
		}
		recordTimes(startTime, outputFile, tablePrinter);
		
		outputFile.printf("Iterative - Expected%n");
		startTime = System.nanoTime();
		for(int counter = 0; counter < sequenceLength; counter++)
		{
			try
			{
				tablePrinter.printToTable(loopFib.next());
			}
			catch (ArithmeticOverflowException exception)
			{
				tablePrinter.printStarsToTable(exception.getOverflowNumber());
				System.out.println("ArithmeticOverflow encountered. Placeholder values "
									+ "printed with asterisks.");
			}
		}
		recordTimes(startTime, outputFile, tablePrinter);
		
		outputFile.printf("Fast Recursive%n");
		startTime = System.nanoTime();
		for(int counter = 0; counter < sequenceLength; counter++)
		{
			try
			{
				tablePrinter.printToTable(fastFib.next());
			}
			catch (ArithmeticOverflowException exception)
			{
				tablePrinter.printStarsToTable(exception.getOverflowNumber());
				System.out.println("ArithmeticOverflow encountered. Placeholder values "
									+ "printed with asterisks.");
			}
		}
		recordTimes(startTime, outputFile, tablePrinter);
		
		input.close();
		outputFile.close();
	}
	
	/*---------------------------- recordTimes ----------------------------
    |  Method recordTimes (startTime, outputFile, tablePrinter)
    |
    |  Purpose:  To calculate the runtime of each algorithm, done by 
    |			 subtracting the system time before execution from the current 
    |			 system time. The time in nanoseconds is converted to seconds
    |			 by dividing by the conversion factor, 1,000,000,000. The
    |			 time to compute is printed in both nanoseconds and seconds.
    |			 Lastly, the TableFibPrinter is reset for the next algorithm.
    |
    |  @param	startTime the system time recorded before execution	
    |			outputFile the output file to print to
    |			tablePrinter the TableFibPrinter to reset
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public static void recordTimes(long startTime, PrintWriter outputFile, 
								   TableFibPrinter tablePrinter)
	{
		long nanoRunTime = System.nanoTime() - startTime;
		
		final int NANO_CONVERSION = 1000000000;
		
		double secondsRunTime = (double)nanoRunTime / NANO_CONVERSION;
		
		outputFile.printf("%nTime to compute: %,d nanoseconds,%8.4f seconds%n%n", 
						   nanoRunTime, secondsRunTime);
		tablePrinter.resetTable();
	}
	
	/*---------------------------- validateCommandInput ----------------------------
    |  Method validateCommandInput (inputStrings)
    |
    |  Purpose:  To validate command line input. The method ensures that exactly
    |			 two values were input into the command line. If not, a 
    |			 UserInvalidInputException is thrown with an error message explaining why.
    |
    |  @param	inputStrings the array of strings input to the command line
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public static void validateCommandInput(String[] inputStrings) 
											throws UserInvalidInputException
	{
		final int EXPECTED_COMMAND_INPUT = 2;
		
		if (inputStrings.length != EXPECTED_COMMAND_INPUT) {
			throw new UserInvalidInputException("Invalid input. In the command line, provide"
												 + " the name of an input file followed by "
												 + "the name of an output file, separated by"
												 + " a space.");
		}
	}
	
	/*---------------------------- overwriteFileCheck ----------------------------
    |  Method overwriteFileCheck (outputFile)
    |
    |  Purpose:  To check if the user provided output file already exists.
    |			 If the user's output file already exists, the console asks the user 
    |			 whether or not they would like to overwrite that file. The user may 
    |			 confirm, which allows execution to continue normally, or the user 
    |			 may decline, which throws a FileOverwriteException with an error 
    |			 message explaining what to do.
    |
    |  @param	outputFile the output file name input from the command line
    |
    |  @return  void
    *-------------------------------------------------------------------*/
	public static void overwriteFileCheck(String outputFile) throws FileOverwriteException
	{
		boolean overwriteFile = new File(outputFile).exists();
		
		if(overwriteFile)
		{
			System.out.print("Would you like to overwrite the file: '" + outputFile + "'? ");
			
			Scanner input = new Scanner(System.in);
			boolean valid = true;
			
			do
			{
				System.out.print("Type 'y' for yes or 'n' for no: ");
				String inputText = input.next();
				if(inputText.toLowerCase().equals("n"))
				{
					input.close();
					throw new FileOverwriteException("Execution terminated. In the command "
													  + "line, provide a different name for "
													  + "the output file.");
				}
				else if(inputText.toLowerCase().equals("y"))
				{
					valid = false;
				}
			} while (valid);
			
			input.close();
		}
	}
	
	/*---------------------------- validateFileInput ----------------------------
    |  Method validateFileInput (input)
    |
    |  Purpose:  To validate values from the input file. First the method ensures that 
    |			 at least two values are present in the file, throwing an 
    |			 EmptyFileException if nothing is present or a UserInvalidInputException
    |			 if only one value is present. After, the method checks that both
    |			 values are positive integers, that the first value is between 1-13,
    |			 and that the second value is between 1-35, and throws a
    |			 UserInvalidInputException if any one of those tests fails. All 
    |			 exceptions are thrown with an error message explaining the issue.
    |			 If validation is successful, an int[] is constructed with the
    |			 input values and returned.
    |
    |  @param	input the Scanner object reading the input file
    |
    |  @return  an int[] containing the two input values from the input file
    *-------------------------------------------------------------------*/
	public static int[] validateFileInput(Scanner input) throws EmptyFileException, 
																UserInvalidInputException
	{
		final int MIN_INPUT_VALUE = 1;
		final int MAX_FIRST_INPUT_VALUE = 13;
		final int MAX_SECOND_INPUT_VALUE = 35;
		
		if(!input.hasNext())
		{
			throw new EmptyFileException("No input detected in the input file.");
		}
		
		String firstValue = input.next();
		
		if(!input.hasNext())
		{
			throw new UserInvalidInputException("Invalid input values. 2 numbers "
												 + "are expected.");
		}
		
		String secondValue = input.next();
		
		if (!isInteger(firstValue) || !isInteger(secondValue))
		{
			throw new UserInvalidInputException("Invalid input values. Input should be 2 "
												 + "positive integers.");
		}
		
		if (Integer.parseInt(firstValue) < MIN_INPUT_VALUE || 
				Integer.parseInt(firstValue) > MAX_FIRST_INPUT_VALUE)
		{
			throw new UserInvalidInputException("Invalid input value. The first value must be"
												 + " between 1 and 13.");
		}
		
		if (Integer.parseInt(secondValue) < MIN_INPUT_VALUE || 
				Integer.parseInt(secondValue) > MAX_SECOND_INPUT_VALUE)
		{
			throw new UserInvalidInputException("Invalid input value. The second value must "
												 + "be between 1 and 35.");
		}
		
		int[] values = new int[]{Integer.parseInt(firstValue), 
								 Integer.parseInt(secondValue)};
		return values;
	}
	
	/*---------------------------- isInteger ----------------------------
    |  Method isInteger (inputString)
    |
    |  Purpose:  To test an input String to see if it is an integer. A loop
    |			 parses each character of the String and tests it to ensure
    |			 it is a digit (0-9). If any character in the String is not
    |			 a digit, the method returns false. Else, it returns true.
    |
    |			 Source: stackoverflow.com/questions/237159/whats-the-best-
    |			 		 way-to-check-if-a-string-represents-an-integer-in-java
    |
    |
    |  @param	inputString the String to be tested
    |
    |  @return  true/false whether the input String is an integer
    *-------------------------------------------------------------------*/
	public static boolean isInteger(String inputString)
	{
	    int stringLength = inputString.length();
		
	    for (int position = 0; position < stringLength; position++)
	    {
	        char digit = inputString.charAt(position);
	        if (digit < '0' || digit > '9')
	        {
	            return false;
	        }
	    }
	    return true;
	}
}