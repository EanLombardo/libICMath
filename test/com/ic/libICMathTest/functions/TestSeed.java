package com.ic.libICMathTest.functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ic.libICMath.ICCalculatorBase;
import com.ic.libICMath.ICMath;
import com.ic.libICMathTest.FunctionTests;

public class TestSeed
{
	ICCalculatorBase calc;
	double array[]= new double[FunctionTests.randoms];
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
	public final void seed()
	{
		double s=ICMath.rnd(calc);
		ICMath.seed(calc, s);
		for(int i=0;i<FunctionTests.randoms;i++)
		{
			array[i]=ICMath.rnd(calc);
		}
		ICMath.seed(calc, s);
		for(int i=0;i<FunctionTests.randoms;i++)
		{
			assertEquals(array[i],ICMath.rnd(calc),0);
		}
	}
}
