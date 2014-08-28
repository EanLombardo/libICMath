package com.ic.libICMath;

public abstract class ICBuiltinFunction
{
	public boolean isMagic;
	public int parameterCount;
	public String name;
	public static ICCalculatorBase calc;
	
	public abstract boolean eval(ICLinkedList output, ICLinkedList.Node position, String basis, double parentIn);
	public ICBuiltinFunction(ICCalculatorBase calc)
	{
		calc=this.calc;
	}
}
