package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;

public class TestNCR
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
	public final void ncr()
	{
		assertEquals(calc.stringEvalExpression("ncr(12,0)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,1)"),nts(12.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,2)"),nts(66.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,3)"),nts(220.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,4)"),nts(495.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,5)"),nts(792.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,6)"),nts(924.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,7)"),nts(792.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,8)"),nts(495.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,9)"),nts(220.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,10)"),nts(66.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,11)"),nts(12.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,12)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,13)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,14)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("ncr(12,15)"),nts(0.0D));
	}
}
