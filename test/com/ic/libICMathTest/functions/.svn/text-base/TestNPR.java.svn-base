package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;

public class TestNPR
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
	public final void npr()
	{
		assertEquals(calc.stringEvalExpression("npr(12,0)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("npr(12,1)"),nts(12.0D));
		assertEquals(calc.stringEvalExpression("npr(12,2)"),nts(132.0D));
		assertEquals(calc.stringEvalExpression("npr(12,3)"),nts(1320.0D));
		assertEquals(calc.stringEvalExpression("npr(12,4)"),nts(11880.0D));
		assertEquals(calc.stringEvalExpression("npr(12,5)"),nts(95040.0D));
		assertEquals(calc.stringEvalExpression("npr(12,6)"),nts(665280.0D));
		assertEquals(calc.stringEvalExpression("npr(12,7)"),nts(3991680.0D));
		assertEquals(calc.stringEvalExpression("npr(12,8)"),nts(19958400.0D));
		assertEquals(calc.stringEvalExpression("npr(12,9)"),nts(79833600.0D));
		assertEquals(calc.stringEvalExpression("npr(12,10)"),nts(239500800.0D));
		assertEquals(calc.stringEvalExpression("npr(12,11)"),nts(479001600.0D));
		assertEquals(calc.stringEvalExpression("npr(12,12)"),nts(479001600.0D));
		assertEquals(calc.stringEvalExpression("npr(12,13)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("npr(12,14)"),nts(0.0D));
		assertEquals(calc.stringEvalExpression("npr(12,15)"),nts(0.0D));
	}
}
