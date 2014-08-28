package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICMath;
import com.ic.libICMathTest.FunctionTests;

public class TestIsPrime
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
	public double btd(boolean in)
	{
		if(in)
		{
			return 1.0D;
		}
		return 0.0D;
	}
	@Test
	public final void arePrime()
	{
		assertEquals(calc.stringEvalExpression("isPrime(3)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(5)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(7)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(13)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(11)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(71)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("isPrime(37)"),nts(1.0D));
	}
	@Test
	public final void notPrime()
	{
		assertEquals(calc.stringEvalExpression("isPrime(9)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(100)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(99)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(6)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(2000)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(50)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("isPrime(212)"),nts(0.0D));
	}
	@Test
	public final void aBunchOfRandoms()
	{
		double one;
		for(int i=0; i<FunctionTests.randoms;i++)
		{
			one=ICMath.rnd(calc)*i;
			assertEquals(calc.stringEvalExpression("isPrime("+nts(one)+")"),nts(btd(ICMath.isPrime(one))));
		}
	}
}
