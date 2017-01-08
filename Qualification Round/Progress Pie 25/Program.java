import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
public class Test 
{
	public static void main(String[] args)
	{
		try
		{
			InputStream in = new FileInputStream(args[0]);
			InputStreamReader inr = new InputStreamReader(in, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(inr);
			File fout = new File(args[1]);
			FileOutputStream out = new FileOutputStream(fout);
 			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(out));
			int count = 0;
			//int nMax = 0;
			String line = br.readLine();
			int T = Integer.parseInt(line);
			while (count < T) {
				line = br.readLine();
				String[] sInput = line.split(" ");
				int percentageCall = Integer.parseInt(sInput[0]);
				int xCall = Integer.parseInt(sInput[1]);
				int yCall = Integer.parseInt(sInput[2]);
				boolean bResult = pieProgress(percentageCall, xCall, yCall);
				if(bResult)
				{
					bufw.write("Case #" + (count+1) + ": black");
					bufw.newLine();		
					bufw.flush();
				}
				else
				{
					bufw.write("Case #" + (count+1) + ": white");
					bufw.newLine();
					bufw.flush();
				}
				count++;
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			
		}
	}
	public static float pointToAngle(int xCall, int yCall) {
		return (float) Math.toDegrees(Math.atan2(xCall - 50, yCall - 50));
	}
	public static float getDist(int xCall, int yCall) {
		float dist = (float) Math.sqrt(Math.pow(xCall - 50, 2) + Math.pow(yCall - 50, 2) );
		return dist;
	}
	public static boolean pieProgress(int percentageCall, int xCall, int yCall)
	{
        if percentageCall == 0 return false;S
		float dist = getDist(xCall, yCall);
		if(dist > 50) return false;
		float angle = pointToAngle(xCall, yCall);
		if(angle < 0) angle = 360 + angle;
		if(angle > (percentageCall*3.6))
			return false;
		return true;
	}
}
