/**
libICMath aims to be a powerful numerical calculation library, for more info see http://code.google.com/p/libicmath/
Copyright (C) IamMecone.com Development group

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For more info check out the code available freely at http://code.google.com/p/libicmath/
Or check out our website at IamMeCone.com
 */

package com.ic.libICMath;
/**
 * This portion of libICMath contains the java implementation that actually does the math. All internal function implementations will call on this library so changes are easy.
 * 
 * @author Ean Lombardo
 *
 */
public final class ICMath
{
	/**An array of all of the functions that are built in to the calculator via the ICFunction class*/
	public static final String builtInFunctions[] =
	{ "sum", "product", "clearAll", "delete", "isPrime", "abs", "derive", "integrate", "seed", "rnd", "rndn", "rndi", "rndb", "ln", "npr", "ncr", "log", "round", "ipart", "fpart", "int", "floor", "ciel", "sign", "cos", "sin", "tan", "acos", "asin", "atan", "csc", "sec", "cot", "acsc", "asec", "acot", "cosh", "sinh", "tanh" };
	
	/**
	 * A interface that contains the constants representing each function currently supported by the library 
	 *
	 *@since 1.0
	 */
	public static interface BuiltInFunctions
	{
		/** @since 1.0 */
		public static final int FUNCTION_SUM = 1; /** @since 1.0 */
		public static final int FUNCTION_PRODUCT = 2; /** @since 1.0 */
		public static final int FUNCTION_CLEARALL = 3; /** @since 1.0 */
		public static final int FUNCTION_DELETE = 4; /** @since 1.0 */
		public static final int FUNCTION_ISPRIME = 5; /** @since 1.0 */
		public static final int FUNCTION_ABS = 6; /** @since 1.0 */
		public static final int FUNCTION_DERIVE = 7; /** @since 1.0 */
		public static final int FUNCTION_INTEGRATE = 8; /** @since 1.0 */
		public static final int FUNCTION_SEED = 9; /** @since 1.0 */
		public static final int FUNCTION_RND = 10; /** @since 1.0 */
		public static final int FUNCTION_RNDN = 11; /** @since 1.0 */
		public static final int FUNCTION_RNDI = 12; /** @since 1.0 */
		public static final int FUNCTION_RNDB = 13; /** @since 1.0 */
		public static final int FUNCTION_LN = 14; /** @since 1.0 */
		public static final int FUNCTION_NPR = 15; /** @since 1.0 */
		public static final int FUNCTION_NCR = 16; /** @since 1.0 */
		public static final int FUNCTION_LOG = 17; /** @since 1.0 */
		public static final int FUNCTION_ROUND = 18; /** @since 1.0 */
		public static final int FUNCTION_IPART = 19; /** @since 1.0 */
		public static final int FUNCTION_FPART = 20; /** @since 1.0 */
		public static final int FUNCTION_INT = 21; /** @since 1.0 */
		public static final int FUNCTION_FLOOR = 22; /** @since 1.0 */
		public static final int FUNCTION_CIEL = 23; /** @since 1.0 */
		public static final int FUNCTION_SIGN = 24; /** @since 1.0 */
		public static final int FUNCTION_COS = 25; /** @since 1.0 */
		public static final int FUNCTION_SIN = 26; /** @since 1.0 */
		public static final int FUNCTION_TAN = 27; /** @since 1.0 */
		public static final int FUNCTION_ACOS = 28; /** @since 1.0 */
		public static final int FUNCTION_ASIN = 29; /** @since 1.0 */
		public static final int FUNCTION_ATAN = 30; /** @since 1.0 */
		public static final int FUNCTION_CSC = 31; /** @since 1.0 */
		public static final int FUNCTION_SEC = 32; /** @since 1.0 */
		public static final int FUNCTION_COT = 33; /** @since 1.0 */
		public static final int FUNCTION_ACSC = 34; /** @since 1.0 */
		public static final int FUNCTION_ASEC = 35; /** @since 1.0 */
		public static final int FUNCTION_ACOT = 36; /** @since 1.0 */
		public static final int FUNCTION_COSH = 37; /** @since 1.0 */
		public static final int FUNCTION_SINH = 38; /** @since 1.0 */
		public static final int FUNCTION_TANH = 39; /** @since 1.0 */
	}
	
	/**
	 * Finds the sum across the series from start to stop
	 * 
	 * @param expression The series expression
	 * @param variableName the name of the variable that the series expression uses
	 * @param start Where to start taking the sum from
	 * @param stop Where to stop taking the sum at
	 * @return The sum of the series from start to stop
	 * @since 1.0
	 */
	public static final double sum(String expression, String variableName, int start, int stop)
	{
		//TODO Implement sum function, requires ICFunction Done
		return 0;
	}

	/**
	 * Finds the product across the series from start to stop
	 * 
	 * @param expression The series expression
	 * @param variableName the name of the variable that the series expression uses
	 * @param start Where to start taking the product from
	 * @param stop Where to stop taking the product at
	 * @return The sum of the series from start to stop
	 * @since 1.0
	 */
	public static final double product(String expression, String variableName, int start, int stop)
	{
		//TODO Implement product function, requires ICFunction Done
		return 0;
	}

	/**
	 * Deletes all variables from the {@link ICCalculatorBase} you are working with
	 * 
	 * @param calc The {@link ICCalculatorBase} your are doing math with
	 * @return true
	 * @since 1.0
	 */
	public static final double clearAll(ICCalculatorBase calc)
	{
		calc.variables.clear();
		calc.setConstants();
		return 1;
	}

	/**
	 * Deletes a specific variable from the {@link ICCalculatorBase} you are working with
	 * 
	 * @param variableName the name of the variable you want to delete
	 * @param calc The {@link ICCalculatorBase} your are doing math with
	 * @return (1.0,0.0) Whether or not the variable was deleted
	 * @since 1.0
	 */
	public static final double delete(String variableName, ICCalculatorBase calc)
	{
		if(calc.variables.containsKey(variableName))
		{
			calc.variables.remove(variableName);
			return 1.0D;
		}
		return 0.0D;
	}
	
	/**
	 * Checks to see if a number is prime
	 * 
	 * @param in Input
	 * @return (1.0,0.0) Whether or not the input is prime
	 * @since 1.0
	 */
	public static final boolean isPrime(double in)
	{
		long r = (long) Math.abs(in);
		int i;
		for (i = 2; i < r - 1; i++)
		{
			if (r % i == 0 && r != 2)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Gets the absolute value
	 * 
	 * @param in Input
	 * @return Absolute value of the input
	 * @since 1.0
	 */
	public static final double abs(double in)
	{
		return Math.abs(in);
	}
	
	/**
	 * Gets the modulus of a number with another number
	 * 
	 * @param a The number to be modulated
	 * @param b The number to modulate with
	 * @return The modulus of the numbers
	 */
	public static final double mod(double a, double b)
	{
		if((int)b==0)
		{
			return Double.NaN;
		}
		return (double)(((int)a)%((int)b));
	}
	
	/**
	 * Gets a number to the power of a number such as 2^3
	 * @param a The number that you are taking the power to such as a^b
	 * @param b The number that you are taking the power with such as a^p
	 */
	public static final double pow(double a, double b)
	{
		if((int)a==0 && (int)b==0)
		{
			return Double.NaN;
		}
		return Math.pow(a, b);
	}
	/**
	 * Numerically estimates the derivative of a function at a point
	 * 
	 * @param function The function you are estimating the derivative at
	 * @param x The x value you are estimating the derivative at
	 * @return The numerically estimated value of the function at the value x
	 * @since 1.0 
	 */
	public static final double derive(ICFunction function, double x)
	{
		double h = Math.pow(1E-1, 1.0 / 3.0) * x;
		double err = 0;
		int i, j;
		double errt, fac, hh, ans = 0;
		double a[][] = new double[10][10];

		hh = h;
		a[1][1] = (function.eval(x + hh) - function.eval(x - hh)) / (2.0 * hh);
		err = 1E30;
		for (i = 2; i < 10; i++)
		{
			hh /= 1.4;
			a[1][i] = (function.eval(x + hh) - function.eval(x - hh)) / (2.0 * hh);
			fac = 1.4 * 1.4;
			for (j = 2; j < i; j++)
			{
				a[j][i] = (a[j - 1][i] * fac - a[j - 1][i - 1]) / (fac - 1.0);
				fac = 1.4 * 1.4 * fac;
				errt = Math.max(Math.abs(a[j][i] - a[j - 1][i]), Math.abs(a[j][i] - a[j - 1][i - 1]));

				if (errt <= err)
				{
					err = errt;
					ans = a[j][i];
				}
			}
			if (Math.abs(a[i][i] - a[i - 1][i - 1]) >= 2.0 * (err))
			{
				break;
			}
		}
		return ans;
	}
	
	/**
	 * 
	 * Numerically estimates the integral of a function from one point to another
	 * 
	 * @param function The function your are estimating the integral of
	 * @param start The x position that the integral estimation starts from
	 * @param stop the x position that the integral estimation ends at
	 * @return The numerically estimated integral of a function from start to stop
	 * @since 1.0
	 */
	public static final double integrate(ICFunction function, double start, double stop)
	{

		double c = (start + stop) / 2;
		double h = stop - start;
		double fa = function.eval(start);
		double fb = function.eval(stop);
		double fc = function.eval(c);
		double S = (h / 6) * (fa + 4 * fc + fb);
		return integrateTwo(function, start, stop, 1E-15, S, fa, fb, fc, 10);
	}
	
	/**
	 * Continuously numerically estimates integral until it is accurate enough
	 * 
	 * @return The numerically estimated integral of a function from start to stop
	 * @since 1.0
	 */
	private static double integrateTwo(ICFunction f, double a, double b, double epsilon, double S, double fa, double fb, double fc, int bottom)
	{
		double c = (a + b) / 2;
		double h = b - a;
		double d = (a + c) / 2;
		double e = (c + b) / 2;
		double fd = f.eval(d);
		double fe = f.eval(e);
		double Sleft = (h / 12) * (fa + 4 * fd + fc);
		double Sright = (h / 12) * (fc + 4 * fe + fb);
		double S2 = Sleft + Sright;
		if (bottom <= 0 || Math.abs(S2 - S) <= 15 * epsilon)
		{
			return S2 + (S2 - S) / 15;
		}
		else
		{
			return integrateTwo(f, a, c, epsilon / 2, Sleft, fa, fc, fd, bottom - 1) + integrateTwo(f, c, b, epsilon / 2, Sright, fc, fb, fe, bottom - 1);
		}
	}
	
	/**
	 * Sets the seed for the random number generator being used by the {@link ICCalculatorBase} that all future 
	 * 
	 * @param calc The {@link ICCalculatorBase} that your are setting the seed for
	 * @param in Input
	 * @return 1.0
	 * @since 1.0
	 */
	public static final double seed(ICCalculatorBase calc, double in)
	{
		calc.randGen.setSeed((long)in);
		return 1;
	}
	
	/**
	 * Gets a pseudo-random decimal number in the range [0.0,1)
	 * 
	 * @param calc The {@link ICCalculatorBase} you are getting the pseudo-random number from
	 * @return A pseudo-random decimal number in the range [0.0,1)
	 * @since 1.0
	 */
	public static final double rnd(ICCalculatorBase calc)
	{
		return calc.randGen.nextDouble();
	}
	
	/**
	 * Gets a pseudo-random normally distributed decimal number
	 * 
	 * @param calc The {@link ICCalculatorBase} you are getting the pseudo-random number from
	 * @return A pseudo-random normally distributed decimal number
	 * @since 1.0
	 */
	public static final double rndn(ICCalculatorBase calc)
	{
		return calc.randGen.nextGaussian();
	}
	
	/**
	 * Gets a pseudo-random integer
	 * 
	 * @param calc The {@link ICCalculatorBase} you are getting the pseudo-random integer from
	 * @return A pseudo-random integer
	 * @since 1.0
	 */
	public static final double rndi(ICCalculatorBase calc)
	{
		return calc.randGen.nextLong();
	}

	/**
	 * Gets a pseudo-random true or false value (boolean)
	 * 
	 * @param calc The {@link ICCalculatorBase} you are getting the pseudo-random boolean from
	 * @return (1.0,0.0)
	 * @since 1.0
	 */
	public static final double rndb(ICCalculatorBase calc)
	{
		if(calc.randGen.nextBoolean())
		{
			return 1.0D;
		}
		else
		{
			return 0.0D;
		}
	}

	/**
	 * Gets the natural logarithm of a number
	 * 
	 * @param in Input
	 * @return The natural logarithm of a number
	 * @since 1.0
	 */
	public static final double ln(double in)
	{
		return Math.log(in);
	}

	/**
	 * Gets the combinations of a population and sample
	 * 
	 * @param n The population
	 * @param r The sample size
	 * @return The combinations of a population and sample
	 * @since 1.0
	 */
	public static final double ncr(double n, double r)
	{
		if(r>n)
		{
			return 0;
		}
		return (factorial(n) / (factorial((n - r))*factorial(r)));
	}

	/**
	 * Gets the permutations of a population and sample
	 * 
	 * @param n The population
	 * @param r The sample size
	 * @return The permutations of a population and sample
	 * @since 1.0
	 */
	public static final double npr(double n, double r)
	{
		if(r>n)
		{
			return 0;
		}
		return factorial(n)/factorial(n-r);
	}
	
	/**
	 * Gets the factorial of an integer
	 * 
	 * @param in Input
	 * @return the factorial an integer
	 * @since 1.0
	 */
	public static final double factorial(double in)
	{
		int r = Math.abs((int)in);
		if (r == 0)
		{
			return 1;
		}
		else if (r == 1)
		{
			return 1;
		}
		else
		{
			int i;
			double m = 1;
			for (i = 2; i < r + 1; i++)
			{
				m *= i;
			}
			return m * sign(in);
		}

	}
	
	/**
	 * Gets the logarithm of a number at a specific base
	 * 
	 * @param base the base
	 * @param in the number
	 * @return The logarithm of a number at a specific base
	 * @since 1.0
	 */
	public static final double log(double base, double in)
	{
		return Math.log(in)/Math.log(base);
	}

	/**
	 * Rounds a number to an integer according to standard rounding rules
	 * 
	 * @param in Input
	 * @return A integer from the rounded input
	 * @since 1.0
	 */
	public static final double round(double in)
	{
		return Math.round(in);
	}

	/**
	 * Gets the integer part of a decimal number
	 * 
	 * @param in Input
	 * @return The integer part of a decimal number
	 * @since 1.0
	 */
	public static final double ipart(double in)
	{
		return (double)(int)in;
	}

	/**
	 * Gets the fractional part of a decimal number
	 * 
	 * @param in Input
	 * @return The fractional part of a decimal number
	 * @since 1.0
	 */
	public static final double fpart(double in)
	{
		double r = Math.abs(ipart(in));
		return sign(in) * (Math.abs(in) - r);
	}

	/**
	 * Gets the integer of a decimal number
	 * 
	 * @param in Input
	 * @return The integer of a decimal number
	 * @since 1.0
	 */
	public static final double INT(double in)
	{
		return (double)(int)in;
	}

	/**
	 * Gets the integer of a decimal number rounded towards 0
	 * 
	 * @param in Input
	 * @return The integer of a decimal number rounded towards 0
	 * @since 1.0
	 */
	public static final double floor(double in)
	{
		double r = Math.abs(Math.round(in));
		if (r > Math.abs(in))
		{
			if (sign(in) == 1)
			{
				return sign(in) * (r - 1);
			}
			else
			{
				return sign(in) * r;
			}
		}
		else if (r < Math.abs(in))
		{
			if (sign(in) == 1)
			{
				return sign(in) * r;
			}
			else
			{
				return sign(in) * (r + 1);
			}
		}
		else
		{
			return in;
		}
	}

	/**
	 * Gets the integer of a decimal number rounded away from 0
	 * 
	 * @param in Input
	 * @return The integer of a decimal number rounded away from 0
	 * @since 1.0
	 */
	public static final double ciel(double in)
	{
		double r = Math.abs(Math.round(in));
		if (r > Math.abs(in))
		{
			if (sign(in) == 1)
			{
				return sign(in) * (r);
			}
			else
			{
				return sign(in) * (r - 1);
			}
		}
		else if (r < Math.abs(in))
		{
			if (sign(in) == 1)
			{
				return sign(in) * (r + 1);
			}
			else
			{
				return sign(in) * r;
			}
		}
		else
		{
			return in;
		}
	}

	/**
	 * Gets the integer of a decimal number rounded away from 0
	 * 
	 * @param in Input
	 * @return The integer of a decimal number rounded away from 0
	 * @since 1.0
	 */
	public static final double sign(double in)
	{
		if (in > 0)
		{
			return 1.0;
		}
		else if (in < 0)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Gets the cosine of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The cosine of the input
	 * @since 1.0
	 */
	public static final double cos(double in, ICCalculatorBase calc)
	{
		return Math.cos(toRadian(in, calc));
	}

	/**
	 * Gets the sine of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The sine of the input
	 * @since 1.0
	 */
	public static final double sin(double in, ICCalculatorBase calc)
	{
		return Math.sin(toRadian(in, calc));
	}

	/**
	 * Gets the tangent of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The tangent of the input
	 * @since 1.0
	 */
	public static final double tan(double in, ICCalculatorBase calc)
	{
		return Math.tan(toRadian(in, calc));
	}

	/**
	 * Gets the arc cosine (inverse cosine) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc cosine of the input
	 * @since 1.0
	 */
	public static final double acos(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.acos(in),calc);
	}

	/**
	 * Gets the arc sine (inverse sine) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc sine of the input
	 * @since 1.0
	 */
	public static final double asin(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.asin(in),calc);
	}

	/**
	 * Gets the arc tangent (inverse tangent) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc tangent of the input
	 * @since 1.0
	 */
	public static final double atan(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.atan(in),calc);
	}

	/**
	 * Gets the cosecant of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The cosecant of the input
	 * @since 1.0
	 */
	public static final double csc(double in, ICCalculatorBase calc)
	{
		return 1/Math.sin(toRadian(in, calc));
	}

	/**
	 * Gets the secant of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The secant of the input
	 * @since 1.0
	 */
	public static final double sec(double in, ICCalculatorBase calc)
	{
		return 1/Math.cos(toRadian(in, calc));
	}

	/**
	 * Gets the cotangent of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The cotqangent of the input
	 * @since 1.0
	 */
	public static final double cot(double in, ICCalculatorBase calc)
	{
		return 1/Math.tan(toRadian(in, calc));
	}

	/**
	 * Gets the arc cosecant (inverse cosecant) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc cosecant of the input
	 * @since 1.0
	 */
	public static final double acsc(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.asin(1/in),calc);
	}

	/**
	 * Gets the arc secant (inverse secant) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc secant of the input
	 * @since 1.0
	 */
	public static final double asec(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.acos(1/in),calc);
	}

	/**
	 * Gets the arc cotangent (inverse cotangent) of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The arc cotangent of the input
	 * @since 1.0
	 */
	public static final double acot(double in, ICCalculatorBase calc)
	{
		return fromRadian(Math.atan(1/in),calc);
	}

	/**
	 * Gets the hyperbolic cosine of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The hyperbolic cosine of the input
	 * @since 1.0
	 */
	public static final double cosh(double in, ICCalculatorBase calc)
	{
		return Math.cosh(toRadian(in, calc));
	}

	/**
	 * Gets the hyperbolic sine of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The hyperbolic sine of the input
	 * @since 1.0
	 */
	public static final double sinh(double in, ICCalculatorBase calc)
	{
		return Math.sinh(toRadian(in, calc));
	}

	/**
	 * Gets the hyperbolic tangent of a number
	 * 
	 * @param in Input
	 * @param calc The ICCalculatorBase you are using
	 * @return The hyperbolic tangent of the input
	 * @since 1.0
	 */
	public static final double tanh(double in, ICCalculatorBase calc)
	{
		return Math.tanh(toRadian(in, calc));
	}
	
	/**
	 * Converts an angle to radians from the angle unit given from the ICCalculatorBase.Settings class
	 * @param in The angle 
	 * @param calc The ICCalculatorBase you are using
	 * @return The angle measure in radians
	 */
	public static final double toRadian(double in, ICCalculatorBase calc)
	{
		int a = calc.settings.getAngleUnit();
		if (a == 0)
		{
			return ((in / 360) * (2 * Math.PI));
		}
		else if (a == 1)
		{
			return in;
		}
		else if (a == 2)
		{
			return (in / 100) * (2 * Math.PI);
		}
		else if (a == 3)
		{
			return in * (2 * Math.PI);
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Converts an angle from radians to the angle unit given from the ICCalculatorBase.Settings class
	 * @param in The angle 
	 * @param calc The ICCalculatorBase you are using
	 * @return The angle measure with the unit from the ICCalculatorBase.Settings class
	 */
	public static final double fromRadian(double in, ICCalculatorBase calc)
	{
		int a = calc.settings.getAngleUnit();
		if (a == 0)
		{
			return ((in * 360) / (2 * Math.PI));
		}
		else if (a == 1)
		{
			return in;
		}
		else if (a == 2)
		{
			return (in * 100) / (2 * Math.PI);
		}
		else if (a == 3)
		{
			return in / (2 * Math.PI);
		}
		else
		{
			return 0;
		}
	}
}
