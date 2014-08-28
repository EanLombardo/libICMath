package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;

public class TestClearAll
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
	public final void x()
	{
		assertTrue(calc.stringEvalExpression("x:=293712.231").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("x").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("clearAll()").equals(nts(1.0D)));
		assertTrue(calc.stringEvalExpression("x").equals(nts(0.0D)));
	}
	@Test
	public final void dude()
	{
		assertTrue(calc.stringEvalExpression("dude:=293712.231").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("dude").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("clearAll()").equals(nts(1.0D)));
		assertTrue(calc.stringEvalExpression("dude").equals(nts(0.0D)));
	}
	@Test
	public final void several()
	{
		assertTrue(calc.stringEvalExpression("x:=293712.231").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("x").equals(nts(293712.231D)));
		assertTrue(calc.stringEvalExpression("dude:=3813247.12313").equals(nts(3813247.12313D)));
		assertTrue(calc.stringEvalExpression("dude").equals(nts(3813247.12313D)));
		assertTrue(calc.stringEvalExpression("g:=9.8").equals(nts(9.8D)));
		assertTrue(calc.stringEvalExpression("g").equals(nts(9.8D)));
		assertTrue(calc.stringEvalExpression("clearAll()").equals(nts(1.0D)));
		assertTrue(calc.stringEvalExpression("x").equals(nts(0.0D)));
		assertTrue(calc.stringEvalExpression("dude").equals(nts(0.0D)));
		assertTrue(calc.stringEvalExpression("g").equals(nts(0.0D)));	
	}
}
