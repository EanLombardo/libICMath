package com.ic.libICMathTest.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICMath;
import com.ic.libICMathTest.OperatorTests;

public class TestGreaterThan
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
	public double greater(double one, double two)
	{
		if(one>two)
		{
			return 1.0D;
		}
		return 0.0D;
	}
	@Test
	public final void zeros()
	{
		assertEquals(calc.stringEvalExpression("0>0"),nts(0.0D));
	}
	@Test
	public final void oneZero()
	{
		assertEquals(calc.stringEvalExpression("0>4.293781632"),nts(0.0D));
	}
	@Test
	public final void noZero()
	{
		assertEquals(calc.stringEvalExpression("239193.193948719782>4.293781632"),nts(1.0D));
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
			assertEquals(calc.stringEvalExpression(nts(one)+">"+nts(two)),nts(greater(one,two)));
		}
	}

}
