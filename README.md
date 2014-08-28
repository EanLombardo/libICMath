<p>libICMath is the mathematical computation&nbsp;library used by <a href="https://github.com/EanLombardo/Mathulator">Mathulator</a>, an android calculator project.</p>

<p><strong>NOTE:&nbsp;</strong>This project is no longer under development. This and the Mathulator project have both been put on hold as the plans for a redesign require more developers than are willing to work on this project.</p>

<p>Features</p>

<ul>
	<li>
	<p>Standard mathematical expression evaluation</p>
	</li>
	<li>
	<p>Standard set of mathematical functions (sin, cos, abs, ln ect..)</p>
	</li>
	<li>
	<p>Numerical derivative evaluation</p>
	</li>
	<li>
	<p>Numerical integral evaluation</p>
	</li>
	<li>
	<p>Interactive multi function graphing</p>
	</li>
</ul>

<p>Usage<br />
libICMath is easy to use. Just instantiate an&nbsp;<strong>ICCalculatorBase</strong>, and start evaluating expressions with&nbsp;<strong>ICCalculatorBase.stringEvalExpression(string)</strong></p>

<p>The code under console sets up a basic calculator that can be used in the command line. The code there will show basic usage of libICMath. There is also Javadoc fo the whole library.<strong>&nbsp;</strong></p>

<p>Design<br />
libICMath is designed to be very extendable. Custom builtin functions and operators can be added by extending <strong>ICBuiltinFunction</strong> and <strong>ICBuiltinOperator</strong> respectivly. The point of that design was to allow for a possible plug in system in the future. So people could make their own Jars that libICMath could import to add more functionality.</p>
