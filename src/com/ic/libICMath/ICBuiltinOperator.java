package com.ic.libICMath;

public abstract class ICBuiltinOperator
{
	public char operatorSymbol;
	public static ICCalculatorBase calc;
	public int parameterCount=1;
	
	public abstract boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn);
	public ICBuiltinOperator(ICCalculatorBase calc)
	{
		calc=this.calc;
	}
}
