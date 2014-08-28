package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;

public class TestLN
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
	public final void positive()
	{
		assertEquals(calc.stringEvalExpression("ln(e^3)"),nts(3.0D));
		assertEquals(calc.stringEvalExpression("ln(e^0.4324134)"),nts(0.4324134D));
		assertEquals(calc.stringEvalExpression("ln(e^14)"),nts(14.0D));
		assertEquals(calc.stringEvalExpression("ln(e^3.14159)"),nts(3.14159D));
		assertEquals(calc.stringEvalExpression("ln(e)"),nts(1.0D));
	}
	@Test
	public final void negative()
	{
		assertEquals(calc.stringEvalExpression("ln(-2341245.53452435)"),nts(Double.NaN));
		assertEquals(calc.stringEvalExpression("ln(-0.4324134)"),nts(Double.NaN));
		assertEquals(calc.stringEvalExpression("ln(-124124)"),nts(Double.NaN));
		assertEquals(calc.stringEvalExpression("ln(-3.14159)"),nts(Double.NaN));
		assertEquals(calc.stringEvalExpression("ln(0)"),nts(Double.NEGATIVE_INFINITY));
	}
}
