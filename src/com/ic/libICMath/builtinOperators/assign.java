package com.ic.libICMath.builtinOperators;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICBuiltinOperator;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;
import com.ic.libICMath.ICLinkedList.Node;

public class assign extends ICBuiltinOperator
{

	public assign(ICCalculatorBase calc)
	{
		super(calc);
		operatorSymbol = '\0';
	}

	@Override
	public boolean eval(ICLinkedList output, Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER ) // the last token must be a number
		{
			if(position.prev.prev!=null && position.prev.prev.data.variable!=null && !position.prev.prev.data.variable.equals("")) //the last last token must be a variable, but isn't necessarily a variable type for eficiency
			{
				calc.setVariable(position.prev.prev.data.variable, position.prev.data.number);
				position.prev.prev.data.number=position.prev.data.number;
				output.remove(position.prev);
				output.remove(position);
				//return position.prev.data.number; //return the variable and cease evaluation, nothing other than an assignment can happen when there is an assignment operator
			}
		}
		return false;
	}

}
