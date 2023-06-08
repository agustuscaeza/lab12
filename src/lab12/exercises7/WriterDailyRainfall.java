 package lab12.exercises7;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class WriterDailyRainfall {

	public static void main(String[] args) {
		// 1. Declare output file 
				String outFile = "dailyrainfall7.dat";
				
				// Data declaration
				String date[] = {"31/05/2023", "01/06/2023", "02/06/2023", "03/06/2023", "04/06/2023", "05/06/2023"};
				int dailyrainfalldata[] = {5, 0, 0, 4, 1, 0};
				String station = "Station Name  : Simpang Ampat";
				String district = "District Name : Alor Gajah";
				String space = "\t\t\t\t";
				String Date = "\tDate\t\t\tRainfall";
				String id = "Station ID \t  : 2421003";
				int avgRainfall = 0;
				int TotalRainfall = 0;
				int n = 0;
				
				
				try {
					
					// 2. Create stream to read data
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
					
					out.println(id);
					out.println(station);
					out.println(district);
					out.println(Date);
					
					
					// Process data
					for (int index = 0; index < date.length; index++) {
						
						// 3. Write data into data stream
						out.print(date[index]);
						out.print(space);						
						out.println(dailyrainfalldata[index]);
						
						
						// 4. Flush for each writing
						out.flush();
					}
					
					
					//calculate average rainfall
					for (int i=0; i<dailyrainfalldata.length; i++) {
						TotalRainfall = TotalRainfall + dailyrainfalldata[i];
						n++;
						
						}
						avgRainfall = ( TotalRainfall / n);
						out.println("The average of daily rainfall for " + n + " days in Simpang Ampat station : " + avgRainfall + "%");
						
					
					// 5. Close stream
					out.close();
					
					
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
				// Indicate end of program - Could be successful
				System.out.println("End of program. Check out " + outFile); 
	}
}
