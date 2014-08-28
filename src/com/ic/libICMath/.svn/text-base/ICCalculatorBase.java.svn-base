/**
libICMath aims to be a powerful numerical calculation library, for more info see http://code.google.com/p/libicmath/
Copyright (C) IamMecone.com Development group

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For more info check out the code available freely at http://code.google.com/p/libicmath/
Or check out our website at IamMeCone.com
 */


package com.ic.libICMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.ic.libICMath.builtinFunctions.*;
import com.ic.libICMath.builtinOperators.*;

/**
* The class that handles all of the variables and evaluations for ICFunctions to allow expression evaluation, variable and sub function storage, as well as statistics for evaluation time
* and even the ability to use a listener to run events when variables and or functions are added or removed.
*@author Ean Lombardo
*                     
*@since 1.0
*@version 1.0           
*
*/

public class ICCalculatorBase
{
	/**Holds the string that are the names of the variables for the calculator to use*/
	public HashMap<String,Double> variables= new HashMap<String,Double>();
	
	/**Holds the user created functions that are declared within this ICCalculator base for the calculator to use*/
	public ArrayList<ICFunction> functions = new ArrayList<ICFunction>(); 
	
	/**Cross references with the functions ArrayList to know what functions are to be graphed*/
	public ArrayList<ICFunction> graphingFunctions = new ArrayList<ICFunction>();
	
	/**
	 * An array that contains how many parameters each functions take 
	 */
	public int builtInFunctionParameterCounts[]=
	{3,3,-1,0,0,0,2,3,0,-1,-1,-1,-1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	/**Standard java pseudo random number generation, used for functions who need to use pseudo random numbers*/
	public Random randGen; 
	
	/**This is a nameless function that is used by the ICCalculatorBase for expression evaluation*/
	public ICFunction evaluationFunction = new ICFunction(this); 
	
	/**This string will contain the reverse polish notation of the last expression evaluated via the ICFuntion and ICMathToken classes*/
	public String RPN;
	
	/**This will contain the error code for any error that happens while the function is parsing after each evaluation*/
	public int parseError = 0;
	
	/**This will contain the error code for any error that happens while evaluating after each evaluation*/
	public int evalError = 0; 
	
	/**This is the standard settings object to be overridden to allow any sort of loading and saving you would want, the class as it is now is default settings*/
	public Settings settings;

	/**This will contain the start time in nanoseconds after each evaluation*/
	public long startTime;
	
	/**This will contain the end time in nanoseconds after each evaluation*/
	public long endTime;
	
	/**This is a listener that can be overridden to allow running events when a variable and or function is added or removed*/
	VariableFunctionChangeListener changeListener = null;
	
	/**
	 * The flag for the ICCalculatorBase using Degrees for angles, 360 degrees is one full rotation
	 */
	int ANGLE_UNIT_DEGREE=0;
	
	/**
	 * The flag for the ICCalculatorBase using Radians for angles, 2pi radians is one full rotation
	 */
	int ANGLE_UNIT_RADIAN=1;
	
	/**
	 * The flag for the ICCalculatorBase using gradians for angles, 100 gradians is one full rotation
	 */
	int ANGLE_UNIT_GRADIAN=2;
	
	/**
	 * The flag for the ICCalculatorBase using revolutions for angles, 1 revolution is one full rotation
	 */
	int ANGLE_UNIT_REVOLUTON=3;

	/**
	 * This string contains every letter that is allowed by this ICCalculatorBase for variable and function names
	 * 
	 */
	String VALID_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρςστυφχψω";
	
	public final ArrayList<ICBuiltinFunction> builtInFunctions= new ArrayList<ICBuiltinFunction> ();
	
	public final ArrayList<ICBuiltinOperator> builtInOperators= new ArrayList<ICBuiltinOperator> ();
	
	/** This is the class listener that will be called when a function and/or variable is add or removed from it's parent ICCalculatorBase
	 * 
	 * @version 1.0
	 * @since 1.0
	 */
	
	public static abstract class VariableFunctionChangeListener
	{
		/** Called whenever a function is added or removed from the ICCalculatorBase
		 * @param functions An ArrayList containing all of the functions in the ICCalculatorBase
		 * */
		abstract public void onFunctionChange(ArrayList<ICFunction> functions);
		
		/** Called whenever a variable is added or removed from the ICCalculatorBase
		 * @param variableNames An ArrayList containing all of the names of the variables in the ICCalculatorBase
		 * @param variableValues An ArrayList containing all of the values of the variables in the ICCalculatorBase
		 * */
		abstract public void onVariablesChange(HashMap<String,Double> variables);
		
		/** Called whenever a function and/or variable is added or removed from the ICCalculatorBase, NOTE: onFunctionChange and or onVariablesChange will still be called as well if the change is known
		 * @param variableNames An ArrayList containing all of the names of the variables in the ICCalculatorBase
		 * @param variableValues An ArrayList containing all of the values of the variables in the ICCalculatorBase
		 * @param functions An ArrayList containing all of the functions in the ICCalculatorBase
		 * */
		abstract public void onChange(HashMap<String,Double> variables, ArrayList<ICFunction> functions);
		
	};
	
	/** A class that handles settings for the ICCalculatorBase, meant to be overloaded so you can save and load settings however you want.
	 * The default un-overloaded class always returns the basic default settings
	 * 
	 * @version 1.0
	 * @since 1.0
	 */
	public static abstract class Settings
	{
		/** Gets a boolean for whether or not the reverse polish notation should be shown to the user.
		 * 
		 * 
	     * 
		 * @return (true,false) Whether or not the reverse polish notation should be shown
		 */
		public boolean getShowRPN()
		{
			return false;
		}

		/** Gets an integer that represents the the angle unit that the calculator should do math with
		 * 
		 * 
	     * 
		 * @return (ANGLE_UNIT_DEGREE,ANGLE_UNIT_RADIAN,ANGLE_UNIT_GRADIAN,ANGLE_UNIT_REVOLUTON) The integer representing what angle unit the calculator is using
		 */
		public int getAngleUnit()
		{
			return 0;
		}

		/** Gets a boolean for whether or not to show the how long a calculation took
		 * 
		 * 
	     * 
		 * @return (true,false) Whether or not to show the how long a calculation took
		 */
		public boolean geShowTime()
		{
			return false;
		}

		/** Gets a boolean for whether or not colors should be inverted in the graph
		 * 
		 * 
	     * 
		 * @return (true,false) Whether or not colors should be inverted in the graph
		 */
		public boolean getGraphingSwithcColors()
		{
			return false;
		}

		/** Gets a boolean for whether or not the grid should be shown in the graph
		 * 
		 * 
	     * 
		 * @return (true,false) Whether or not the grid should be shown in the graph
		 */
		public boolean getGraphingShowGrid()
		{
			return false;
		}
		
		/** Gets a boolean for whether or not graphing should plot points or linearly estimate the graph
		 * 
		 * 
	     * 
		 * @return (true,false) Whether or not graphing should plot points or linearly estimate the graph
		 */
		public boolean getGraphingDotMode()
		{
			return false;
		}

	}
	
	
	/**
	 * The main constructor for the ICCalculatorBase class, sets up the setting system, sets some default variables and initializes the random number generator
	 * 
	 * @param prefs the ICCalculatorBase.Settings class the ICCalculatorBase should use for settings
	 * 
	 */
	public ICCalculatorBase(Settings prefs)
	{
		settings = prefs;
		setConstants();
		randGen = new Random();
		builtInFunctions.add(new sum(this));
		builtInFunctions.add(new product(this));
		builtInFunctions.add(new clearAll(this));
		builtInFunctions.add(new delete(this));
		builtInFunctions.add(new isPrime(this));
		builtInFunctions.add(new abs(this));
		builtInFunctions.add(new derive(this));
		builtInFunctions.add(new integrate(this));
		builtInFunctions.add(new seed(this));
		builtInFunctions.add(new rnd(this));
		builtInFunctions.add(new rndn(this));
		builtInFunctions.add(new rndi(this));
		builtInFunctions.add(new rndb(this));
		builtInFunctions.add(new ln(this));
		builtInFunctions.add(new npr(this));
		builtInFunctions.add(new ncr(this));
		builtInFunctions.add(new log(this));
		builtInFunctions.add(new round(this));
		builtInFunctions.add(new ipart(this));
		builtInFunctions.add(new fpart(this));
		builtInFunctions.add(new INT(this));
		builtInFunctions.add(new floor(this));
		builtInFunctions.add(new ceil(this));
		builtInFunctions.add(new sign(this));
		builtInFunctions.add(new cos(this));
		builtInFunctions.add(new sin(this));
		builtInFunctions.add(new tan(this));
		builtInFunctions.add(new acos(this));
		builtInFunctions.add(new asin(this));
		builtInFunctions.add(new atan(this));
		builtInFunctions.add(new csc(this));
		builtInFunctions.add(new sec(this));
		builtInFunctions.add(new cot(this));
		builtInFunctions.add(new acsc(this));
		builtInFunctions.add(new asec(this));
		builtInFunctions.add(new acot(this));
		builtInFunctions.add(new cosh(this));
		builtInFunctions.add(new sinh(this));
		builtInFunctions.add(new tanh(this));
		
		builtInOperators.add(new plus(this));
		builtInOperators.add(new minus(this));
		builtInOperators.add(new multiply(this));
		builtInOperators.add(new divide(this));
		builtInOperators.add(new power(this));
		builtInOperators.add(new modulus(this));
		builtInOperators.add(new factorial(this));
		builtInOperators.add(new equals(this));
		builtInOperators.add(new greaterThan(this));
		builtInOperators.add(new lessThan(this));
		builtInOperators.add(new lessThanEqual(this));
		builtInOperators.add(new greaterThanEqual(this));
		builtInOperators.add(new notEqual(this));
		builtInOperators.add(new assign(this));
		
		ICBuiltinFunction.calc=this;
		ICBuiltinOperator.calc=this;
	}

	/**
	 * Sets a variable to a value in the ICCalculatorBase, if the variable doesn't exist it will be created
	 * 
	 * @param var The name of the variable
	 * @param val The value of the variable
	 * 
	 */
	public void setVariable(String var, double val)
	{
		variables.put(var, val);
		
		try
		{
			changeListener.onFunctionChange(functions);
			changeListener.onChange(variables, functions);
		}
		catch (Exception e)
		{
		}
	}
	
	public boolean isOperator(char opChar)
	{
		for(int i=0;i<builtInOperators.size();i++)
		{
			if(builtInOperators.get(i).operatorSymbol==opChar)
			{
				return true;
			}
		}
		return false;
	}
	
	public int getOperator(char opChar)
	{
		for(int i=0;i<builtInOperators.size();i++)
		{
			if(builtInOperators.get(i).operatorSymbol==opChar)
			{
				return i+1;
			}
		}
		return -1;
	}

	/**
	 * Gets the value of the variable from the ICCalculatorBase
	 * 
	 * @param var The name of the variable the you want
	 * @return The value of the variable
	 * 
	 */
	public double getVariable(String var)
	{
		if(variables.containsKey(var))
		{
			return variables.get(var);
		}
		return 0;
	}

	/**
	 * Evaluates an expression with the ICCalculatorBase using an ICFunction, any functions or variables created by this expression will be put into this ICCalculatorBase. Afterwards errors will be set in this
	 * ICCalculatorBase as well as start and stop time, and the the variable "Ans" will be set to the value of the expression
	 * 
	 * @param expression The expression that you want evaluated
	 * @return The value of the evaluated expression
	 * 
	 */
	public double evalExpression(String expression)
	{
		startTime = System.nanoTime();
		//try
		//{
			parseError = 0;
			if (expression.equals(""))
			{
				expression = "Ans";
			}
			if (!evaluationFunction.parse(expression))
			{
				if (parseError == 0)
				{
					parseError = -1;
				}
			}
			else
			{
				RPN = evaluationFunction.toTokenStrings();
				double ans = evaluationFunction.eval(1);
				if (evalError == 0)
				{
					setVariable("Ans", ans);
					endTime = System.nanoTime();
					return ans;
				}
			}
		//}
		//catch (Exception e)
		//{
		//	parseError = -2;
		//}
		return 0;
	}
	
	/**
	 * Evaluates an expression with the ICCalculatorBase using an ICFunction returning a string for the answer, this is for convenience as it will give you the string of your double answer or a string about the error it had, any functions or variables created by this expression will be put into this ICCalculatorBase. Afterwards errors will be set in this
	 * ICCalculatorBase as well as start and stop time, and the the variable "Ans" will be set to the value of the expression
	 * 
	 * @param expression The expression that you want evaluated
	 * @return The value of the expression as a string, or an explanation of the error that prevented the expressions evaluation
	 * 
	 * 
	 */
	public String stringEvalExpression(String expression)
	{
		double result=evalExpression(expression);
		if(calcError())
		{
			return getErrorString();
		}
		else
		{
			return String.format("%.12G", result);
		}
	}
	
	/**
	 * Contains constants for every error that can happen in an ICCalculatorBase
	 * 
	 * @since 1.0
	 * @version 1.0
	 */
	public static interface Errors
	{
		/**
		 * There wasn't an error
		 * 
		 */
		public static final int NO_ERROR=0; 
		
		/**
		 * There was an error in syntax, such that the expression was not written correctly to the extent that it could not be run
		 * 
		 */
		public static final int SYNTAX_ERROR=1;
		
		/**
		 * There was a type mismatch, a function need something different than what you gave it such as {@code derive(x^2,2,3)} the 2 should be a variable name, but in that case it is a number
		 * 
		 */
		public static final int TYPE_MISMATCH=2;
		
		/**
		 * The variable name given is invalid, not all characters are allowed in variable and function names see VALID_LETTERS for a string of all allowed characters
		 * 
		 */
		public static final int INVALID_VARIABLE_NAME=3;
		
		/**
		 * There were too many or not enough parameters for this function, such as {@code cos(1,2)} the cos function only takes one parameter
		 * 
		 */
		public static final int PARAMETER_MISMATCH=4;
		
		/**
		 * There weren't enough parenthesis to evaluate the function, such as {@code 1+(2/4)+6)} there should be another ( somewhere
		 * 
		 */
		public static final int PARENTHESIS_MISMATCH=5;
		
		/**
		 * Something happened somewhere that caused an error for some unknown reason
		 * 
		 */
		public static final int UNKOWN_ERROR=-1;
		
		/**
		 * There was an error so bad that an exception was thrown, please email <a href="mailto:ean@iammecone.com">Ean Lombardo</a>
		 * 
		 */
		public static final int EVIL_ERROR=-2;
	}
	
	/**
	 * Gets the string that is detailed info on what error occurred on the last calculation
	 * 
	 * @return Information on the evaluation or parse error 
	 * 
	 * 
	 */
	public String getErrorString()
	{
		int in = 0;
		if (parseError == Errors.NO_ERROR && evalError == Errors.NO_ERROR)
		{
			return "No Error";
		}

		if (evalError != 0)
		{
			in = evalError;
		}
		if (parseError != 0)
		{
			in = parseError;
		}
		if (in == Errors.SYNTAX_ERROR)
		{
			return "Syntax Error";
		}
		if (in == Errors.TYPE_MISMATCH)
		{
			return "Type Mismatch";
		}
		if (in == Errors.TYPE_MISMATCH)
		{
			return "Invalid Variable name";
		}
		if (in == Errors.PARAMETER_MISMATCH)
		{
			return "Incorrect number of parameters for function";
		}
		if (in == Errors.PARENTHESIS_MISMATCH)
		{
			return "Mismatched parentheses";
		}
		if (in == Errors.UNKOWN_ERROR)
		{
			return "An unknown error occured";
		}
		if (in == Errors.EVIL_ERROR)
		{
			return "An evil error occured, please report your input to support@iammecone.com";
		}
		return "An unknown error occured";
	}

	/**
	 * Gets whether or not there was an error in the last evaluation
	 * 
	 * @return (true,false) Whether or not there was an error in the last evaluation
	 * 
	 * 
	 * 
	 */
	public boolean calcError()
	{
		if (parseError == 0 && evalError == 0)
		{
			return false;
		}
		return true;
	}

	/**
	 * Creates a new function in the ICCalculatorBase, to be used by other expressions or possibly for graphing
	 * 
	 * @param name The name of the functions
	 * @param f The expression of the function
	 * @param of The defendant variable of the function, the variable that is replaced by the input
	 * @return (true,false) True, unless there was an error with creating the function
	 * 
	 * 
	 * 
	 */
	public boolean createFunction(String name, String f, String of)
	{
		int i = 0;
		for (i = 0; i < functions.size(); i++)
		{
			if (functions.get(i).name == name)
			{
				functions.get(i).parse(f);
			}
		}
		ICFunction gen = new ICFunction(this);
		gen.parse(f);
		gen.basis = of;
		gen.name = name;
		functions.add(gen);
		if (changeListener != null)
		{
			try
			{
				changeListener.onFunctionChange(functions);
				changeListener.onChange(variables, functions);
			}
			catch (Exception e)
			{
			}
		}
		return calcError();
	}

	/**
	 * Gets the time in nanoseconds that it took for evaluation of the last expression
	 * 
	 * @return The time in nanoseconds that the last evaluation took
	 * 
	 * 
	 * 
	 */
	public int getEvalTime()
	{
		if (!calcError())
		{
			return (int) (endTime - startTime);
		}
		else
		{
			return -1;
		}
	}

	/**
	 * Gets the error code of the parse or evaluation error that happened in the last evaluation
	 * 
	 * @return The error code from the last evaluation
	 * 
	 * 
	 * 
	 */
	public int getError()
	{
		int in = 0;

		if (evalError != 0)
		{
			in = evalError;
		}
		if (parseError != 0)
		{
			in = parseError;
		}
		return in;
	}

	/**
	 * Set's the VariableFunctionChangeListener for this ICCalculatorCase, the member functions of this class will be called as changes happen in this ICCalculatorClass
	 * 
	 * @param listener The listener for this class to use
	 * 
	 * 
	 */
	
	public void setListener(VariableFunctionChangeListener listener)
	{
		changeListener = listener;
	}

	/**
	 * Invalidates the ICCalculator base by calling the the listener about a change and does anything it needs too to reset itself, which is currently nothing.
	 * 
	 * 
	 * 
	 */
	public void invalidate()
	{
		
		try
		{
			changeListener.onChange(variables, functions);
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Gets whether or not a function exists in this ICCalculatorBase
	 * 
	 * @param name the name of the function your looking for
	 * @return (true,false) true if the function does exist in this ICCalculatorBase
	 * 
	 * 
	 * 
	 */
	public boolean functionExists(String name)
	{
		for (int index = 0; index < functions.size(); index++)
		{
			if (functions.get(index).name.equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sets the standard constants in the ICCalculatorBase
	 * 
	 * 
	 * 
	 */
	public void setConstants()
	{
		setVariable("e", Math.E);
		setVariable("π", Math.PI);
		setVariable("pi", Math.PI);
		setVariable("BIG_NUMBER", Double.MAX_VALUE);
		setVariable("SMALL_DECIMAL", Double.MIN_VALUE);
	}
	public boolean isBuiltinFunction(String test)
	{
		for(int i=0;i<ICMath.builtInFunctions.length;i++)
		{
			if(ICMath.builtInFunctions[i].equals(test))
			{
				return true;
			}
		}
		return false;
	}
	public boolean isFunction(String test)
	{
		for(int i=0;i<functions.size();i++)
		{
			if(functions.get(i).name.equals(test))
			{
				return true;
			}
		}
		return false;
	}
}
