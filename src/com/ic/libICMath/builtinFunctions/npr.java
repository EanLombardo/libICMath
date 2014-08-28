package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class npr extends ICBuiltinFunction
{
	public npr(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=1;
	public String name="npr";
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER && position.prev.prev!=null && position.prev.prev.data.type==ICMathToken.Types.NUMBER)
		{
			position.prev.prev.data.number=ICMath.npr(position.prev.prev.data.number,position.prev.data.number);
			output.remove(position);
			output.remove(position.prev);
			return true;
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
