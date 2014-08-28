package com.ic.libICMath.builtinFunctions;

import com.ic.libICMath.ICBuiltinFunction;
import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICFunction;
import com.ic.libICMath.ICLinkedList;
import com.ic.libICMath.ICMagicParser;
import com.ic.libICMath.ICMath;
import com.ic.libICMath.ICMathToken;

public class product extends ICBuiltinFunction
{
	public product(ICCalculatorBase calc)
	{
		super(calc);
	}

	public boolean isMagic=false;
	public int parameterCount=0;
	public String name="product";
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
			double product=1;
			for(int i=from;i<(to+1);i++)
			{
				product*=tempFunc.eval(i);
			}
			position.prev.data.number=product;
			output.remove(position);
		}
		calc.evalError=ICCalculatorBase.Errors.SYNTAX_ERROR;
		return false;
	}

}
