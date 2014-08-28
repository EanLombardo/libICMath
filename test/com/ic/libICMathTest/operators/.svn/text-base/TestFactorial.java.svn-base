package com.ic.libICMathTest.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICMath;
import com.ic.libICMathTest.OperatorTests;

public class TestFactorial
{
	ICCalculatorBase calc;
	@Before
	public void setUp() throws Exception
	{
		calc= new ICCalculatorBase(new ICCalculatorBase.Settings());
	}
	public String nts(double in)
	{
		return String.format("%.12G", in);
	}
	@Test
	public final void zeros()
	{
		assertEquals(calc.stringEvalExpression("0!"),nts(1.0D));
	}
	@Test
	public final void noZero()
	{
		assertEquals(calc.stringEvalExpression("239193.193948719782!"),nts(ICMath.factorial(239193.193948719782)));
	}
	@Test
	public final void atonOfRandoms()
	{
		double one;
		for(int i=0;i<OperatorTests.randoms;i++)
		{
			one=ICMath.rnd(calc)*i;
			assertEquals(calc.stringEvalExpression(nts(one)+"!"),nts(ICMath.factorial(new Double(nts(one)))));
		}
	}

}
