package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class floor extends ICBuiltinFunction
{
	public floor(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=0;
	public String name="floor";
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER)
		{
			position.prev.data.number=ICMath.floor(position.prev.data.number);
			output.remove(position);
			return true;
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
