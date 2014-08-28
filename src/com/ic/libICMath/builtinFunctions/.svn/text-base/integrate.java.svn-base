package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICFunction;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMagicParser;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class integrate extends ICBuiltinFunction
{

	public integrate(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=true;
	public int parameterCount=0;
	public String name="integrate";
	private ICMagicParser magicParse;
	
	@Override
	public boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn)
	{
		if(position.prev!=null && position.prev.data.type==ICMathToken.Types.MAGIC) //there must be a previous token and it must be magic
		{
			
			position.prev.data.type=ICMathToken.Types.NUMBER;
			magicParse=new ICMagicParser(calc,position.prev.data.magic);
			ICFunction tempFunc=magicParse.getFunction();
			int from=(int)magicParse.getNumber(basis, parentIn);
			int to=(int)magicParse.getNumber(basis, parentIn);
			if(magicParse.atEnd())
			{
				position.prev.data.number=ICMath.integrate(tempFunc, from, to);
				output.remove(position);
			}
			else
			{
				calc.evalError=ICCalculatorBase.Errors.PARAMETER_MISMATCH;
				return false;
			}
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
