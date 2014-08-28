package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class delete extends ICBuiltinFunction
{
	public delete(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=0;
	public String name="delete";
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.variable!=null && !position.prev.data.variable.equals("")) //there was to be a previous token and it must be a variable name
		{
			position.prev.data.type=ICMathToken.Types.NUMBER;
			if(calc.variables.remove(position.prev.data.variable)!=null) //remove the variable, and put true or false into the node
			{
				position.prev.data.number=1.0D;
			}
			else
			{
				position.prev.data.number=0.0D;
			}
			output.remove(position); //delete the function node
			return true;
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
