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

import com.ic.libICMath.ICLinkedList.Node;

public class ICFunction
{
	/**
	 * The current position the parser is at in the expression input
	 */
	private int charIndex = 0;
	
	/**
	 * Used for the first step of evaluation
	 */
	private boolean first=true;
	
	/**
	 * The string that represents the expression for the formula
	 */
	public String formulaString;
	
	/**
	 * The error (if there was any) that the function came across
	 */
	int error = 0;
	
	/**
	 * The stack, used to store tokens during parsing that allows more than simple expressions
	 */
	ArrayList<ICMathToken> stack = new ArrayList<ICMathToken>();
	
	/**
	 * The output stack contains the expression in reverse polish notation after parsing so the function can be evaluated
	 */
	ICLinkedList output = new ICLinkedList();
	
	/**
	 * Stores the depths of the different sections of the expression being parsed the depth increases by one every time it enters a new set of parenthesis
	 */
	ArrayList<Integer> startDepth = new ArrayList<Integer>();
	
	/**
	 * Same thing as the start depth but for each parameter that is being processed for functions
	 */
	ArrayList<Integer> paramDepth = new ArrayList<Integer>();

	/**
	 * The current depth of the expression during parsing
	 */
	int depth = 0;
	
	/**
	 * Used for looping through output
	 */
	Node tempNode;
	
	/**
	 * the name of the function as it is stored in the ICCalculatorBase, everything will refer to this name as a unique id
	 */
	public String name;
	
	/**
	 * The variable name that this function is a basis of, such as {@code f(x):=x^2} x is the basis of this function because the output is defendant on it
	 */
	public String basis;
	
	/**
	 * The last token while parsing, used to do checks for special cases
	 */
	ICMathToken lastToken = new ICMathToken();
	
	/**
	 * Used for checking more special cases
	 */
	boolean pass = false;
	
	/**
	 * The ICCalculatorBase this function will be stored in, as well as get its variables and other functions from
	 */
	public ICCalculatorBase mainBase;
	
	/**
	 * Used for when an expression is actually a declaration, that way we parse for temporary function instead of this one, and add it to the ICCalculatorBase
	 */
	ICFunction tempForm;
	
	/**
	 * Used to store the ICMagicParser being used
	 */
	ICMagicParser magicParse;

	/**
	 * Pulls the beginning of the input when it is actually a declaration and creates the temporary function with the name and the basis from the declaration
	 * @param dec The string that is the declaration header of the expression
	 */
	public void parseDeclaration(String dec)
	{

		int index;
		int declarationLength=dec.length();
		for (index = 0; index < declarationLength; index++)
		{
			if (dec.charAt(index) == '(')
			{
				name = dec.substring(0, index);
				break;
			}
		}
		basis = dec.substring(index + 1, dec.length() - 1);
		tempForm = new ICFunction(mainBase);
		tempForm.name = name;
		tempForm.basis = basis;

	}

	/**
	 * Handles the actual parsing of the input
	 * @param form the expression that will represent the formula
	 * @return (true,false) Whether or not the parse was successful
	 */
	public boolean parse(String form)
	{
		mainBase.parseError = 0;
		boolean isFunction = false;
		boolean hadParen = false;
		String declare = "";
		int index = 0;
		char tempChar;
		name = "";
		int open = 0;
		int close = 0;
		int inputLength=form.length();
		for (index = 0; index < inputLength; index++) //Loop through every character to see if it is a declaration
		{
			tempChar = form.charAt(index);
			if (!isValidChar(tempChar))
			{
				mainBase.parseError = 1;
				return false;
			}
			if (tempChar == '(')
			{
				hadParen = true;
				open++;
			}
			if (tempChar == ')')
			{
				close++;
			}
			if (tempChar == ':') 
			{
				tempChar = form.charAt(++index);
				if (tempChar == '=' && hadParen) //This should be a declaration unless the input is invalid
				{
					isFunction = true;
					formulaString = form.substring(index + 1);
					declare = form.substring(0, index - 1);
					parseDeclaration(declare);  //Make this the function being declared and parse this as that function
				}
			}
		}
		if (!isFunction) //It is a function, so only parse the expression
		{
			formulaString = new String(form);
		}
		if (open != close) // There was already an error 
		{
			mainBase.parseError = 5;
			return false;
		}
		//set everything to what it should be for a new parse through
		charIndex = 0;
		error = 0;
		stack.clear();
		output.clear();
		startDepth.clear();
		paramDepth.clear();
		depth = 0;
		ICMathToken lastToken = new ICMathToken();
		boolean pass = false;

		boolean res = false;
		boolean continueParsing = true;
		ICMathToken tempToken = new ICMathToken();
		lastToken.done = true;
		while (continueParsing) //keep parsing till we should stop
		{
			tempToken = getToken(); //get a new token from the input string
			if (tempToken.done) //if this is the last token
			{
				continueParsing = false; //do not make another parsing pass
				res = true;

				int stackIndex = stack.size() - 1;
				for (stackIndex = stack.size() - 1; stackIndex >= 0; stackIndex--)
				{
					if (stack.get(stackIndex).operator != 5 && stack.get(stackIndex).operator != 6 && stack.get(stackIndex).operator != 7)
					{
						if (startDepth.size() != 0)
						{
							int i;
							for (i = 0; i < startDepth.size(); i++)
							{
								if (startDepth.get(i) == depth) //special case for a negative not meaning subtraction before a parenthesis
								{
									ICMathToken tempTokenE = new ICMathToken();
									tempTokenE.type = ICMathToken.Types.NUMBER;
									tempTokenE.number = -1;
									output.add(tempTokenE);
									tempTokenE = new ICMathToken();
									tempTokenE.type = ICMathToken.Types.OPERATOR;
									tempTokenE.operator = ICMathToken.Operators.MULTIPLY;
									output.add(tempTokenE);
									startDepth.remove(i);
								}
							}
						}
					}
					output.add(stack.get(stackIndex));
					stack.remove(stackIndex);
				}

				if (startDepth.size() != 0) //another special case for handling negatives not being subtraction before parethesis
				{
					ICMathToken tempTokenE = new ICMathToken();
					tempTokenE.type = ICMathToken.Types.NUMBER;
					tempTokenE.number = -1;
					output.add(tempTokenE);
					tempTokenE = new ICMathToken();
					tempTokenE.type = ICMathToken.Types.OPERATOR;
					tempTokenE.operator = ICMathToken.Operators.MULTIPLY;
					output.add(tempTokenE);
					startDepth.clear();
				}
				if (isFunction) //we are a function and we are done so we have to add this function to the ICCalculatorBase
				{
					int i;
					for (i = 0; i < output.size; i++)
					{
						tempForm.output.add(output.get(i));
					}
					for (i = 0; i < mainBase.functions.size(); i++)
					{
						if (mainBase.functions.get(i).name.equals(tempForm.name))
						{
							mainBase.functions.remove(i);
						}
					}
					tempForm.formulaString = new String(formulaString);
					tempForm.basis = new String(basis);
					mainBase.functions.add(tempForm);
				}
				break;
			}
			if (tempToken.error != 0) //If there was an error getting the token, stop
			{
				continueParsing = false;
				res = false;
				break;
			}

			if (tempToken.operator == ICMathToken.Operators.MINUS) 
			{
				//the last token was an operator or it is the LAST token, it is not a ) or ^, so move in one depth 
				if (((lastToken.type == ICMathToken.Types.OPERATOR || lastToken.done) && lastToken.operator != ICMathToken.Operators.PARENTHESES_CLOSE) && lastToken.operator != ICMathToken.Operators.POWER)
				{
					startDepth.add(depth);
				}
				else if (lastToken.operator == ICMathToken.Operators.POWER) //The last token was a ^ so we have to do fancy stuff to ensure that the negative happens after the math
				{
					ICMathToken temp = new ICMathToken();
					temp.type = ICMathToken.Types.NUMBER;
					temp.number = -1;
					output.add(temp);
					temp = new ICMathToken();
					temp.type = ICMathToken.Types.OPERATOR;
					temp.operator = ICMathToken.Operators.MULTIPLY;
					stack.add(stack.size(), temp);
				}
				else
				{
					pass = true;
				}
			}
			
			if (tempToken.type == ICMathToken.Types.FUNCTION || tempToken.type == ICMathToken.Types.BUILTIN_FUNCTION)
			{
				if (lastToken.type == ICMathToken.Types.NUMBER || lastToken.type == ICMathToken.Types.VARIABLE) //The last token was a number or variable, so it's an implicit multiply such as 2cos(pi) so put the multiply operator in there fore us
				{
					ICMathToken temp = new ICMathToken();
					temp.type = ICMathToken.Types.OPERATOR;
					temp.operator = ICMathToken.Operators.MULTIPLY;
					stack.add(temp);
				}
				stack.add(tempToken);

			}
			if (tempToken.type == ICMathToken.Types.MAGIC) //Its a magic token, so just put it straight to output as well as the token on the stack 
			{
				output.add(tempToken);
				output.add(stack.get(stack.size() - 1));
				stack.remove(stack.size() - 1);
			}
			if (tempToken.type == ICMathToken.Types.COMMA) //Its a comma, do some fancy stuff 
			{
				int i;

				while (paramDepth.size() < depth + 1)
				{
					paramDepth.add(0); //create depths for each parameter
				}

				paramDepth.set(depth, paramDepth.get(depth) + 1); //set the current depth for that paremeter
				for (i = 0; i < stack.size(); i++)
				{
					if (stack.get(stack.size() - 1).operator == ICMathToken.Operators.PARENTHESES_OPEN) //if it's an open parenthesis then stop
					{
						break;
					}
					else //its not so pop stuff off of the stack onto the output
					{
						output.add(stack.get(stack.size() - 1));
						stack.remove(stack.size() - 1);
					}
				}
			}
			if (tempToken.type == ICMathToken.Types.NUMBER || tempToken.type == ICMathToken.Types.VARIABLE) //its a number or a variable
			{
				if (lastToken.operator == ICMathToken.Operators.PARENTHESES_CLOSE) //the last token was the end of a parenthesis, we have a backwards implied multiply such as cos(pi)2 
				{
					ICMathToken temp = new ICMathToken();
					temp.type = ICMathToken.Types.OPERATOR;
					temp.operator = ICMathToken.Operators.MULTIPLY;
					stack.add(temp);
				}
				if (tempToken.type == ICMathToken.Types.VARIABLE) //Its a variable 
				{
					if (lastToken.type == ICMathToken.Types.NUMBER || lastToken.type == ICMathToken.Types.VARIABLE) //The last token was a number or a variable, we have another implied multiply such as 2x
					{
						ICMathToken temp = new ICMathToken();
						temp.type = ICMathToken.Types.OPERATOR;
						temp.operator = ICMathToken.Operators.MULTIPLY;
						stack.add(temp);
					}
				}
				output.add(tempToken);
				if (stack.size() != 0) //If the stack isnt empty
				{
					if (stack.get(stack.size() - 1).type == ICMathToken.Types.FUNCTION || stack.get(stack.size() - 1).type == ICMathToken.Types.BUILTIN_FUNCTION) //the token on the stack is a function, set the amount of params the function had and move it to the output
					{
						output.add(stack.get(stack.size() - 1));
						output.get(stack.size() - 1).params = paramDepth.get(depth + 1);
						stack.remove(stack.get(stack.size() - 1));
					}
				}
			}
			//it is an operator but not a parenthesis a negative or an assignment or special stuff is going on with negatives
			if ((tempToken.type == ICMathToken.Types.OPERATOR && tempToken.operator != ICMathToken.Operators.PARENTHESES_OPEN && tempToken.operator != ICMathToken.Operators.PARENTHESES_CLOSE) && ((tempToken.operator != ICMathToken.Operators.MINUS && tempToken.operator != ICMathToken.Operators.ASSIGN) || pass))
			{

				int stackIndex = stack.size() - 1;

				for (stackIndex = stack.size() - 1; stackIndex >= 0; stackIndex--) //go through everything in the stack adding it in a specific order 
				{
					if ((tempToken.prec() >= stack.get(stackIndex).prec() && stack.get(stackIndex).operator != ICMathToken.Operators.PARENTHESES_OPEN && !isRightAssoc(stack.get(stackIndex))) || (isRightAssoc(stack.get(stackIndex))) && stack.get(stackIndex).prec() < tempToken.prec())
					{
						output.add(stack.get(stackIndex));
						stack.remove(stackIndex);
					}
					else
					{
						break;
					}

				}
				stack.add(tempToken);
				//the operator is not a power, a perenthesis or an assign
				if (tempToken.operator != ICMathToken.Operators.POWER && tempToken.operator != ICMathToken.Operators.PARENTHESES_OPEN && tempToken.operator != ICMathToken.Operators.PARENTHESES_CLOSE && tempToken.operator != ICMathToken.Operators.ASSIGN)
				{
					if (startDepth.size() != 0) //there are depths
					{
						int i;
						for (i = 0; i < startDepth.size(); i++) //go through every depth and find the current one
						{
							if (startDepth.get(i) == depth) //at the current depths we have an implied multiply so handle that
							{
								ICMathToken tempTokenE = new ICMathToken();
								tempTokenE.type = ICMathToken.Types.NUMBER;
								tempTokenE.number = -1;
								output.add(tempTokenE);
								tempTokenE = new ICMathToken();
								tempTokenE.type = ICMathToken.Types.OPERATOR;
								tempTokenE.operator = ICMathToken.Operators.MULTIPLY;
								output.add(tempTokenE);
								startDepth.remove(i);
							}
						}
					}
				}

			}

			if (tempToken.operator == ICMathToken.Operators.ASSIGN) //we are assigning a variable so handle the assignment
			{
				stack.add(0, tempToken);
				ICMathToken temp = new ICMathToken();
				temp.type = ICMathToken.Types.OPERATOR;
				temp.operator =  ICMathToken.Operators.PARENTHESES_OPEN;
				stack.add(temp);
				depth++;
				while (paramDepth.size() < depth + 1)
				{
					paramDepth.add(0);
				}
				formulaString = formulaString + ")";
			}

			if (tempToken.type == ICMathToken.Types.OPERATOR && tempToken.operator == ICMathToken.Operators.PARENTHESES_OPEN) //its an open parenthesis
			{
				if (lastToken.type == ICMathToken.Types.NUMBER || lastToken.type == ICMathToken.Types.VARIABLE || lastToken.operator == ICMathToken.Operators.PARENTHESES_CLOSE) //the last token was a number a variable or an end parenthesis so we have an implied multiply like (x^2)(x^3) or (x^2)x
				{
					ICMathToken temp = new ICMathToken();
					temp.type = ICMathToken.Types.OPERATOR;
					temp.operator = ICMathToken.Operators.MULTIPLY;
					stack.add(temp);
				}
				stack.add(tempToken);
				depth++;
				while (paramDepth.size() < depth + 1) //handle parameters
				{
					paramDepth.add(0);
				}
			}
			if (tempToken.type == ICMathToken.Types.OPERATOR && tempToken.operator == ICMathToken.Operators.PARENTHESES_CLOSE) //its a close parenthesis
			{
				int i;
				if (lastToken.type == ICMathToken.Types.OPERATOR && lastToken.operator == ICMathToken.Operators.PARENTHESES_OPEN) //the last token was an open parenthesis, handle depths
				{
					paramDepth.set(depth, paramDepth.get(depth) - 1);
				}
				for (i = 0; i < startDepth.size(); i++) //go through every depth to find the current one
				{
					if (startDepth.get(i) == depth) //we have another implied multiply on our hands
					{
						ICMathToken temp = new ICMathToken();
						temp.type = ICMathToken.Types.NUMBER;
						temp.number = -1;
						output.add(temp);
						temp = new ICMathToken();
						temp.type = ICMathToken.Types.OPERATOR;
						temp.operator = ICMathToken.Operators.MULTIPLY;
						output.add(temp);
						startDepth.remove(i);
					}
				}

				depth--;
				int stackIndex = stack.size() - 1;
				for (stackIndex = stack.size() - 1; stackIndex >= 0; stackIndex--) //move everything from the stack to the output until you hit a parenthesis
				{
					if (stack.get(stackIndex).operator != ICMathToken.Operators.PARENTHESES_OPEN)
					{
						output.add(stack.get(stackIndex));
						stack.remove(stackIndex);

					}
					else //remove the parenthesis
					{
						stack.remove(stackIndex);
						break;
					}
				}
				if (stack.size() != 0) //if there is anything left on the stack
				{
					if (stack.get(stack.size() - 1).type == ICMathToken.Types.FUNCTION ||  stack.get(stack.size() - 1).type == ICMathToken.Types.BUILTIN_FUNCTION) //if the top of the stack is a function it is what was going on in the parenthesis
					{
						output.add(stack.get(stack.size() - 1));
						output.get(output.size - 1).params = paramDepth.get(depth + 1);
						stack.remove(stack.size() - 1);
					}
				}
			}
			lastToken = tempToken; //save the last token for checks

		}
		return res; //return whether or not the parse was a success
	}

	/**
	 * the constructor for the ICFunction class, sets the ICCalculatorBase
	 * @param base The ICCalculatorBase this ICFunction should get variables from and save functions and variables too
	 */
	public ICFunction(ICCalculatorBase base)
	{
		mainBase = base;
	}

	/**
	 * Evaluates the parsed function using an input to replace the basis
	 * 
	 * @param in The number that will replace the basis variable during evaluation
	 * @return The double result of the the evaluated function
	 */
	public double eval(double in)
	{
		ICLinkedList savedOutput= new ICLinkedList(output);
		first=true;
		mainBase.evalError = 0;
		if (mainBase.calcError())
		{
			return 0;
		}
		if (savedOutput.size == 0)
		{
			mainBase.evalError = 1;
			return 0;
		}
		tempNode=savedOutput.headNode;
		
		if((tempNode.data.type!=ICMathToken.Types.NUMBER && tempNode.data.type!=ICMathToken.Types.VARIABLE) && !(tempNode.data.type==ICMathToken.Types.BUILTIN_FUNCTION && mainBase.builtInFunctionParameterCounts[tempNode.data.builtIn-1]==-1) && tempNode.data.type!=ICMathToken.Types.MAGIC ) //by definition, the very first token HAS to be a number or variable, or magic
		{
			mainBase.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
			return 0;
		}
		while(tempNode!=null) //keep going till we reach the end of the nodes
		{
			if(!first)
			{
			tempNode=tempNode.next; //go to the next node
			}
			first=false;
				if(tempNode==null) //if we are at the end leave the loop
				{
					break;
				}
				if(tempNode.data.type==ICMathToken.Types.VARIABLE) // its a variable, we are evaluating so numberize it
				{
					tempNode.data.type=ICMathToken.Types.NUMBER;
					if(tempNode.data.variable.equals(basis))
					{
						tempNode.data.number=in;
					}
					else
					{
						tempNode.data.number=mainBase.getVariable(tempNode.data.variable);
					}
					continue;
				}
				if(tempNode.data.type==ICMathToken.Types.FUNCTION) //its a user created function
				{
					if(tempNode.prev!=null && tempNode.prev.data.type==ICMathToken.Types.NUMBER)// if the last last token exists, and is a number, do the operation 
					{
						for(int i=0;i<mainBase.functions.size();i++) 
						{
							if(mainBase.functions.get(i).name.equals(tempNode.data.function)) //find which function it is
							{
								tempNode.prev.data.number=mainBase.functions.get(i).eval(tempNode.prev.data.number); //evaluate it
								savedOutput.remove(tempNode);
								continue;
							}
						}
					}
					else
					{
						mainBase.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
						return 0;
					}
				}
				if(tempNode.data.type==ICMathToken.Types.NUMBER)
				{
					continue;
				}
				if(tempNode.data.type== ICMathToken.Types.OPERATOR) //if its an operator
				{
				    mainBase.builtInOperators.get(tempNode.data.operator-1).eval(savedOutput, tempNode, basis, in);
				}
				if(tempNode.data.type==ICMathToken.Types.BUILTIN_FUNCTION) //its a built in function
				{
					mainBase.builtInFunctions.get(tempNode.data.builtIn-1).eval(savedOutput, tempNode, basis, in);
				}
		}
		if(savedOutput.size>1) //somehow we hit the end but there is stuff left, there is too much of something
		{
			mainBase.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
			return 0;
		}
		return savedOutput.headNode.data.number;
	}
	
	/**
	 * Returns a string of all of the functions tokens separated by spaces
	 * 
	 * @return A string containing a space separated output of all of the token from the function
	 */
	public String toTokenStrings()
	{
		String temp = "";
		int i;
		for (i = 0; i < output.size; i++)
		{
			temp += " " + output.get(i).toString();
		}
		return temp;
	}
	
	/**
	 * Gets the next token from the expression string
	 * 
	 * @return The next token from the expression string
	 */
	public ICMathToken getToken()
	{
		ICMathToken tempToken = new ICMathToken();
		char tempChar;

		if (charIndex >= formulaString.length())
		{
			tempToken.done = true;
			return tempToken;
		}

		tempChar = formulaString.charAt(charIndex);

		while (Character.isWhitespace(tempChar)) 
		{
			charIndex++;
			tempChar = formulaString.charAt(charIndex);
		}
		if (stack.size() > 0)
		{
			if ((stack.get(stack.size() - 1).type == ICMathToken.Types.BUILTIN_FUNCTION) && isMagicFunction(stack.get(stack.size() - 1).builtIn))
			{
				int tempDepth = 0;
				if (tempChar == '(')
				{
					charIndex++;
					tempDepth++;
					int i;
					for (i = charIndex; i < formulaString.length(); i++)
					{
						if (formulaString.charAt(i) == '(')
						{
							tempDepth++;
						}
						if (formulaString.charAt(i) == ')')
						{
							tempDepth--;
							if (tempDepth == 0)
							{
								tempToken.magic = formulaString.substring(charIndex, i);
								tempToken.type = 6;
								charIndex = i + 1;
								return tempToken;
							}
						}
					}
				}
			}
		}
		if (tempChar == ':')
		{
			charIndex++;
			tempChar = formulaString.charAt(charIndex);
			if (tempChar == '=')
			{
				tempToken.type = 2;
				tempToken.operator = ICMathToken.Operators.ASSIGN;
				charIndex++;
				return tempToken;
			}
		}
		if (isNumber(tempChar))
		{
			String theENumber = "";
			String theWholeNumber = "";
			while (isNumber(tempChar))
			{
				theWholeNumber = theWholeNumber + String.valueOf(tempChar);
				if ((charIndex + 1 >= formulaString.length()) == false)
				{
					charIndex++;
					tempChar = formulaString.charAt(charIndex);
				}
				else
				{

					tempChar = ' ';
					charIndex++;
					break;
				}
			}

			if (tempChar == 'E')
			{
				charIndex++;

				tempChar = formulaString.charAt(charIndex);
				while (tempChar == '0' || tempChar == '1' || tempChar == '2' || tempChar == '3' || tempChar == '4' || tempChar == '5' || tempChar == '6' || tempChar == '7' || tempChar == '8' || tempChar == '9' || tempChar == '−' || tempChar == '-' || tempChar == '+')
				{
					if (tempChar == '+')
					{
						charIndex++;
						tempChar = formulaString.charAt(charIndex);
						continue;
					}
					theENumber += tempChar;
					charIndex++;
					if (charIndex >= formulaString.length())
					{
						break;
					}
					tempChar = formulaString.charAt(charIndex);

				}
			}
			tempChar = ' ';
			tempToken.type = 1;
			if (theENumber == "")
			{
				tempToken.number = Double.valueOf(theWholeNumber);
			}
			else
			{
				tempToken.number = Double.valueOf(theWholeNumber) * Math.pow(10, Double.valueOf(theENumber));
			}
		}
		else if ((tempChar == '−' || tempChar == '-') && !(isNumber(formulaString.charAt(charIndex))))
		{
			tempToken.type = 2;
			tempToken.operator = 2;
			charIndex++;
		}
		else if ((tempChar == '−' || tempChar == '-') && (isNumber(formulaString.charAt(charIndex))))
		{
			String theWholeNumber = "";
			while (isNumber(tempChar))
			{
				theWholeNumber = theWholeNumber + String.valueOf(tempChar);
				if ((charIndex + 1 >= formulaString.length()) == false)
				{
					charIndex++;
					tempChar = formulaString.charAt(charIndex);
				}
				else
				{
					charIndex++;
					tempChar = ' ';
					break;
				}
			}
			tempToken.type = 1;
			tempToken.number = Double.valueOf(theWholeNumber);

		}
		else if(tempChar=='(')
		{
			tempToken.type = 2;
			tempToken.operator=ICMathToken.Operators.PARENTHESES_OPEN;
			charIndex++;
		}
		else if(tempChar==')')
		{
			tempToken.type = 2;
			tempToken.operator=ICMathToken.Operators.PARENTHESES_CLOSE;
			charIndex++;
		}
		else if(mainBase.isOperator(tempChar))
		{
			tempToken.type = 2;
			tempToken.operator=mainBase.getOperator(tempChar);
			charIndex++;
		}
		else if (isLetter(tempChar))
		{

			String var = "";
			while (isLetter(tempChar))
			{
				var = var + String.valueOf(tempChar);
				if ((charIndex + 1 >= formulaString.length()) == false)
				{
					charIndex++;
					tempChar = formulaString.charAt(charIndex);
				}
				else
				{
					charIndex++;
					tempChar = ' ';
					break;
				}
			}
			if (mainBase.isBuiltinFunction(String.valueOf(var))) 
			{
				tempToken.type=ICMathToken.Types.BUILTIN_FUNCTION;
				for(int i=0;i<ICMath.builtInFunctions.length;i++)
				{
					if(ICMath.builtInFunctions[i].equals(var))
					{
						tempToken.builtIn=i+1;
						break;
					}
				}
			}
			else if(mainBase.isFunction(String.valueOf(var)))
			{
				tempToken.type=ICMathToken.Types.FUNCTION;
				for(int i=0;i<mainBase.functions.size();i++)
				{
					if(mainBase.functions.get(i).name.equals(var))
					{
						tempToken.function=var;
					}
				}
			}
			else
			{
				tempToken.type = 4;
				tempToken.variable = var;
			}

		}

		if (tempChar == ',')
		{
			tempToken.type = 5;
			charIndex++;
		}

		if (!(charIndex < formulaString.length()))
		{
			tempToken.function = "EOS";
		}

		if (charIndex == -1)
		{
			tempToken.error = -1;
		}
		return tempToken;
	}

	public boolean isNumber(char test)
	{
		String digits = "0123456789.";
		boolean ret = false;
		int i;
		for (i = 0; i < 11; i++)
		{
			if (test == digits.charAt(i))
			{
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Gets whether or not the input token is right associative
	 * 
	 * @return (true,false) Whether or not the input token is right associative
	 */
	public static boolean isRightAssoc(ICMathToken tok)
	{
		if (tok.operator == 5 || tok.operator == 9 || tok.operator == 10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Gets whether or not the input character is a valid letter via ICFunction standards
	 * 
	 * @return (true,false) Whether or not the input character is a valid letter via ICFunction standards
	 */
	public static boolean isLetter(char test)
	{
		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρςστυφχψω";
		boolean ret = false;
		int i;
		for (i = 0; i < letters.length(); i++)
		{
			if (test == letters.charAt(i))
			{
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * Gets whether or not the input function representative is a magic function
	 * 
	 * @return (true,false) Whether or not the input function representative is a magic function
	 */
	public static boolean isMagicFunction(int in)
	{
		if (in==ICMath.BuiltInFunctions.FUNCTION_INTEGRATE || in==ICMath.BuiltInFunctions.FUNCTION_DERIVE || in==ICMath.BuiltInFunctions.FUNCTION_SUM || in==ICMath.BuiltInFunctions.FUNCTION_PRODUCT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Gets whether or not the input character is a valid character for ICFunction standards
	 * 
	 * @return (true,false) Whether or not the input character is a valid character for ICFunction standards
	 */
	public static boolean isValidChar(char in)
	{
		String check = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+=-_ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρςστυφχψω, ./*^%!:()1234567890<>≤≥≠";
		int i;
		for (i = 0; i < check.length(); i++)
		{
			if (check.charAt(i) == in)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets whether or not the input string is a valid name for ICFunction standards
	 * 
	 * @return (true,false) Whether or not the input string is a valid name for ICFunction standards
	 */
	public static boolean isValidName(String in)
	{
		int i;
		for (i = 0; i < in.length(); i++)
		{
			if (!isLetter(in.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
}
