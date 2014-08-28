package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMathTest.FunctionTests;

public class TestRNDB
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
	public final void rndb()
	{
		for(int i=0;i<FunctionTests.randoms;i++)
		{
			calc.stringEvalExpression("rndb()");
			assertEquals(calc.getErrorString(),"No Error");
		}
	}
}
