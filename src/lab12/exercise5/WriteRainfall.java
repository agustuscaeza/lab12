package lab12.exercise5;





import java.io.DataOutputStream; 
import java.io.FileOutputStream;
//import java.io.IOException;

/**
 * This program demonstrate writing data as byte using FileOutputStream.
 * This program demonstrate writing byte-based data using DataOuputStream.
 * 
 * @author muhammadizzat
 *
 */
public class WriteRainfall {

public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String outFile = "dailyrainfall.dat";
		
		// Data declaration
		String date[] = {"31/05/2023", "01/06/2023", "02/06/2023", "03/06/2023", "04/06/2023", "05/06/2023"};
		int dailyrainfalldata[] = {5, 0, 0, 4, 1, 0};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dosobject = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < date.length; index++) {
				
				// 3. Write data into data stream
				dosobject.writeUTF(date[index]);
				dosobject.writeInt(dailyrainfalldata[index]);
				
				// 4. Flush for each writing
				dosobject.flush();
			}
			
			// 5. Close stream
			dosobject.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}

}
