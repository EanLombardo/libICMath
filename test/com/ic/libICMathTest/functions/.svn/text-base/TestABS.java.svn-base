package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;

public class TestABS
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
		assertEquals(calc.stringEvalExpression("abs(2341245.53452435)"),nts(2341245.53452435D));
		assertEquals(calc.stringEvalExpression("abs(0.4324134)"),nts(0.4324134D));
		assertEquals(calc.stringEvalExpression("abs(124124)"),nts(124124D));
		assertEquals(calc.stringEvalExpression("abs(3.14159)"),nts(3.14159D));
		assertEquals(calc.stringEvalExpression("abs(1)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("abs(1/0)"),nts(Double.POSITIVE_INFINITY));
	}
	@Test
	public final void negative()
	{
		assertEquals(calc.stringEvalExpression("abs(-2341245.53452435)"),nts(2341245.53452435D));
		assertEquals(calc.stringEvalExpression("abs(-0.4324134)"),nts(0.4324134D));
		assertEquals(calc.stringEvalExpression("abs(-124124)"),nts(124124D));
		assertEquals(calc.stringEvalExpression("abs(-3.14159)"),nts(3.14159D));
		assertEquals(calc.stringEvalExpression("abs(-1)"),nts(1.0D));
		assertEquals(calc.stringEvalExpression("abs(-1/0)"),nts(Double.POSITIVE_INFINITY));
	}
	@Test
	public final void zero()
	{
		assertEquals(calc.stringEvalExpression("abs(0)"),nts(0.0D));
	}
	@Test
	public final void nan()
	{
		assertEquals(calc.stringEvalExpression("abs(0^0)"),nts(Double.NaN));
	}
}
