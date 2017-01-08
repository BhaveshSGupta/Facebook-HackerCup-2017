import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
public class Test 
{
	public static void main(String[] args)
	{
		try
		{
			InputStream fis = new FileInputStream("progress_pie_input.txt");
			System.out.println("Line 1 : ");
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			int nCounter = 0;
			int nMax = 0;
			String line = br.readLine();
			System.out.println("Line 1 : " + line);
			if(nCounter == 0)
			{
				nMax = Integer.parseInt(line);
			}
			while (nCounter < nMax) {
				line = br.readLine();
				System.out.println(line);
				String[] sInput = line.split(" ");
				int nPer = Integer.parseInt(sInput[0]);
				int nLocX = Integer.parseInt(sInput[1]);
				int nLocY = Integer.parseInt(sInput[2]);
				boolean bResult = getCalc(nPer, nLocX, nLocY);
				if(bResult)
				{
					System.out.println("Case #" + (nCounter+1) + ": black");
				}
				else
				{
					System.out.println("Case #" + (nCounter+1) + ": white");
				}
				nCounter++;
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			
		}
		
		/*
		for(int nIdx =0; nIdx < nNumber; nIdx++)
		{
			String sLine = sc.nextLine();
			
			String[] sInput = sLine.split(" ");
			int nPer = Integer.parseInt(sInput[0]);
			int nLocX = Integer.parseInt(sInput[1]);
			int nLocY = Integer.parseInt(sInput[2]);
			
			
		}*/
	}
	public static float getAngle(int nLocX, int nLocY) {
		return (float) Math.toDegrees(Math.atan2(nLocX - 50, nLocY - 50));
	}
	public static float getDist(int nLocX, int nLocY) {
		float dist = (float) Math.sqrt(
            Math.pow(nLocX - 50, 2) +
            Math.pow(nLocY - 50, 2) );
		return dist;
	}
	public static boolean getCalc(int nPer, int nLocX, int nLocY)
	{
		float dist = getDist(nLocX, nLocY);
		System.out.println("Dist : " + dist);
		if(dist > 50)
			return false;
		float angle = getAngle(nLocX, nLocY);
		System.out.println("Angle : " + angle);
		System.out.println("PerCentage : " + (nPer*3.6));
		if(angle < 0)
			angle = 360 + angle;
		if(angle > (nPer*3.6))
			return false;
		return true;
	}
}
