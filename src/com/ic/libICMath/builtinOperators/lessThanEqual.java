package com.ic.libICMath.builtinOperators;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICBuiltinOperator;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMathToken;
import com.ic.libICMath.ICLinkedList.Node;

public class lessThanEqual extends ICBuiltinOperator
{
	public lessThanEqual(ICCalculatorBase calc)
	{
		super(calc);
		operatorSymbol ='≤';
	}

	@Override
	public boolean eval(ICLinkedList output, Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER) //if the last token exists, and is a number
		{
			if(position.prev.prev!=null && position.prev.prev.data.type==ICMathToken.Types.NUMBER)// if the last last token exists, and is a number, do the operation 
			{
				if(position.prev.prev.data.number <= position.prev.data.number)
				{
					position.prev.prev.data.number=1.0D; //change the number of the first token in the operation
				}
				else
				{
					position.prev.prev.data.number=0.0D; //change the number of the first token in the operation
				}
		
		output.remove(position.prev); //remove the second node of the operation
		output.remove(position);
			}
		}
		return false;
	}

}
