package com.ic.libICMath.builtinOperators;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICBuiltinOperator;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;
import com.ic.libICMath.ICLinkedList.Node;

public class factorial extends ICBuiltinOperator
{
	public int paremeterCount=0;
	public factorial(ICCalculatorBase calc)
	{
		super(calc);
		operatorSymbol ='!';
	}

	@Override
	public boolean eval(ICLinkedList output, Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER) //if the last token exists, and is a number
		{
		position.prev.data.number=ICMath.factorial(position.prev.data.number); //change the number of the first token in the operation
		output.remove(position);
		}
		return false;
	}

}
