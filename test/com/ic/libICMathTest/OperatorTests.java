package com.ic.libICMathTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ic.libICMathTest.operators.*;

@RunWith(Suite.class)
@SuiteClasses(
{ TestAdd.class, TestSubtract.class, TestMultiply.class, TestDivide.class, TestPower.class, TestMod.class, TestFactorial.class, TestEquals.class, TestGreaterThan.class, TestLessThan.class, TestLessThanEquals.class, TestGreaterThanEquals.class,TestNotEqual.class })
public class OperatorTests
{
	public static int randoms=AllTests.randoms;
}
