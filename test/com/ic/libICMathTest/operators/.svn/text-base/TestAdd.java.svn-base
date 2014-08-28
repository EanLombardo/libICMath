package com.ic.libICMathTest.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICMath;
import com.ic.libICMathTest.OperatorTests;

public class TestAdd
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
		assertTrue(calc.stringEvalExpression("0+0").equals(nts(0.0D)));
	}
	@Test
	public final void oneZero()
	{
		assertTrue(calc.stringEvalExpression("0+4.293781632").equals(nts(4.293781632D)));
	}
	@Test
	public final void noZero()
	{
		assertTrue(calc.stringEvalExpression("239193.193948719782+4.293781632").equals(nts(239193.193948719782D+4.293781632D)));
	}
	@Test
	public final void atonOfRandoms()
	{
		double one;
		double two;
		for(int i=0;i<OperatorTests.randoms;i++)
		{
			one=ICMath.rnd(calc)*i;
			two=ICMath.rnd(calc)*i;
			assertEquals(calc.stringEvalExpression(nts(one)+"+"+nts(two)),nts(new Double(nts(one))+new Double(nts(two))));
		}
	}

}
