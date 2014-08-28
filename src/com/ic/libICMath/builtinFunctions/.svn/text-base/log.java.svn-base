package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class log extends ICBuiltinFunction
{
	

	public log(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=-1;
	public String name="log";
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		if(position.data.params==1) //we want log base a
		{
			if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER && position.prev.prev!=null && position.prev.prev.data.type==ICMathToken.Types.NUMBER) //there must two previous token and they must be numbers
			{
				position.prev.prev.data.number=ICMath.log(position.prev.prev.data.number,position.prev.data.number);
				output.remove(position);
				output.remove(position.prev);
				return true;
			}
		}
		else if(position.data.params==0) //we want log base 10
		{
			if(position.prev!=null && position.prev.data.type==ICMathToken.Types.NUMBER ) //there must a previous token and it must be a number
			{
				position.prev.data.number=ICMath.log(10.0D,position.prev.data.number);
				output.remove(position);
				return true;
			}
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
