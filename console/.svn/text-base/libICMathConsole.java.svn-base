import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ic.libICMath.ICCalculatorBase;


public class libICMathConsole
{
	public static void main(String[] args)
	{
		System.out.println("Initializing...");
		ICCalculatorBase calcbase= new ICCalculatorBase(null);
		boolean cont=true;
		String in="";
		BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Done");
		while(cont)
		{
			try
			{
				in=inputBuffer.readLine();
				if(in.equals("exit"))
				{
					cont=false;
				}
				else
				{
					System.out.println("  "+calcbase.stringEvalExpression(in));
				}
			}
			catch (IOException e)
			{}
			
		}
		
	}
}
