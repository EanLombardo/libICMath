package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class rnd extends ICBuiltinFunction
{
	public rnd(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=0;
	public String name="rnd";
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		position.data.number=ICMath.rnd(calc);
		return true;
	}

}
