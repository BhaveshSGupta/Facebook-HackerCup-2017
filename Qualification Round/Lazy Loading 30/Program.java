import java.util.*;

import java.io.*;
import java.nio.charset.Charset;
public class Program 
{
	public static void main(String[] args)
	{
		try {
			InputStream in = new FileInputStream(args[0]);
			InputStreamReader inr = new InputStreamReader(in, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(inr);
			File fout = new File(args[1]);
			FileOutputStream out = new FileOutputStream(fout);
 			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(out));
			int count = 0,N,temp;
			String line = br.readLine();
			int T = Integer.parseInt(line);
			int[] W=new int[100];
			while (count < T) {
				line = br.readLine();
				N=Integer.parseInt(line);
				int iCount=0;
				while(iCount!=N){
					line = br.readLine();
					W[iCount]=Integer.parseInt(line);
					iCount++;
				}
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++)
					{
						if(W[i]>W[j]){
							temp = W[j];
							W[j]=W[i];
							W[i]=temp;
						}
					}
				}

				
				iCount=0;
				while(iCount!=N){
					//line = br.readLine();
					//bufw.write(W[iCount]+" ");
					iCount++;
				}
				int totalPending=N;
				int trips=0;
				int topItem=0;
				while(totalPending>0){
					

					float weight=(float)50/(float)W[topItem];
		//System.out.println("Weight "+weight+" topItem "+W[topItem]+" floor "+Math.floor(weight)+" ceil "+(int)Math.ceil(weight));
		int usedInThisTrip=(int)Math.ceil(weight);
		//((int)Math.ceil(weight)>1){
		if(totalPending>=usedInThisTrip){
		totalPending-=usedInThisTrip;
		topItem++;	
		//totalPending--;		
		trips++;	
		}
		else{
			totalPending=0;
		}



				}
				//System.out.println(" trips "+trips);
				bufw.write("Case #" + (count+1)+": "+trips);
				bufw.newLine();		
				bufw.flush();
				
				count++;
			}					
		} catch (Exception e) {
		System.out.println("Exception: "+e);
			//TODO: handle exception
		}
	
	}
}