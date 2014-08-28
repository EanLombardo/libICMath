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
/**
 * The ICMagicParser can read magic strings and get output in whatever order you want almost like a stream. Simplifies and safens magic parsing.
 * 
 * @since 1.0
 * @version 1.0  
 * @author Ean Lombardo
 *
 */
public class ICMagicParser
{
	public String input;
	public String remainingInput;
	private ICCalculatorBase calcBase;
	private boolean go;
	private int index;
	private int parenIndex;
	private String temp;
	private ICFunction tempFunc;
	double tempDouble;
	
	/**
	 * Initiates an ICMaficParser 
	 * 
	 * @param calc The ICCalculatorBase being used with parsing
	 * @param magic The magic string to pe parsed
	 */
	public ICMagicParser(ICCalculatorBase calc, String magic)
	{
		input=magic;
		remainingInput=magic;
		calcBase=calc;
	}
	
	/**
	 * Gets a function from a magic string.
	 * Input is [expression],[basis variable]
	 * 
	 * @return AICFunction from the magic string
	 */
	public ICFunction getFunction()
	{
		tempFunc=new ICFunction(calcBase);
		tempFunc.parse(getString());
		tempFunc.basis=getVariableName();
		return tempFunc;
	}
	
	/**
	 * Gets a variable name from a magic string.
	 * Input is [variable name]
	 * 
	 * @return A variable name from the magic string
	 */
	public String getVariableName()
	{
		temp=getString();
		if(!ICFunction.isValidName(temp))
		{
			calcBase.parseError=ICCalculatorBase.Errors.INVALID_VARIABLE_NAME;
		}
		return temp;
	}
	
	/**
	 * Gets a number from a magic string.
	 * Input is [number]
	 * 
	 * @return A number from the magic string
	 */
	public double getNumber(String inVar, double varValue)
	{
		tempFunc= new ICFunction(calcBase);
		tempFunc.basis=inVar;
		tempFunc.parse(getString());
		return tempFunc.eval(varValue);
	}
	
	/**
	 * Gets an un-validated string from a magic string
	 * Input is [string]
	 * 
	 * @return An un-validated string from a magic string
	 */
	public String getString()
	{
		go=true;
		index=0;
		parenIndex=0;
		temp="";
		while(go)
		{
			
				temp+=remainingInput.charAt(index);
				if(remainingInput.charAt(index)=='(')
				{
					parenIndex++;
				}
				if(remainingInput.charAt(index)==')')
				{
					parenIndex--;
				}
				index++;
				if((index==remainingInput.length() || remainingInput.charAt(index)==',') && parenIndex==0)
				{
					go=false;
				}
		}
		if(index!=remainingInput.length())
		{
			remainingInput=remainingInput.substring(index+1);
		}
		else
		{
			remainingInput="";
		}
		return temp;
	}
	
	/**
	 * Gets whether or not this ICMagicParser is at the end of the magic string
	 * 
	 * @return (true, false) Whether or not this ICMagicParser is at the end of the magic string
	 */
	public boolean atEnd()
	{
		if(remainingInput.equals(""))
		{
			return true;
		}
		return false;
	}
}
