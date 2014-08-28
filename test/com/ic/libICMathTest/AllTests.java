package com.ic.libICMathTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{ FunctionTests.class, OperatorTests.class })
public class AllTests
{
	public static int randoms=10001;
}
