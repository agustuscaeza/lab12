package lab12.exercises6;


	
	import java.io.DataOutputStream;
	import java.io.FileOutputStream;
	//import java.io.IOException;

	/**
	 * This program demonstrate writing data as byte using FileOutputStream.
	 * 
	 * 
	 * @author muhammadizzat
	 *
	 */

	public class DataInputRainfall {
		
		public static void main(String[] args) {
			
			
			// 1. Declare output file 
			String sourceFile = "dailyrainfall2.dat";
			
			// Data declaration
			String[][] Data = { {"2421003", "Simpang Ampat", "Alor Gajah", "0", "0", "4", "1", "0", "6"},
	                			{"2322006", "Melaka Pindah", "Alor Gajah", "0", "0", "0", "0", "0", "2"},
	                			{"2225044", "Chohong", "Jasin", "6", "0", "0", "21", "0", "39"},
	                			{"2125002", "Telok Rimba", "Jasin", "13", "0", "0", "1", "1", "69"},
	                			{"2223023", "Sg. Duyong", "Melaka Tengah", "37", "0", "0", "3", "0", "43"},
	                			{"2222006", "Cheng (Taman Merdeka)", "Melaka Tengah", "20", "0", "0", "3", "0", "42"}};
			
			
			
			try {
				
				// 2. Create stream to read data
				DataOutputStream dosobject = new DataOutputStream(new FileOutputStream(sourceFile));
				
				// Process data
				for (String[] data : Data) {
					
					 String stationId = data[0];
		                String stationName = data[1];
		                String districtName = data[2];
		                String[] rainfalls = {data[3], data[4], data[5],data[6], data[7], data[8]};
				
		                dosobject.writeUTF(stationId);
		                dosobject.writeUTF(stationName);
		                dosobject.writeUTF(districtName);
		                
		             // 3. Write daily rainfall data
			            for (String rainfall : rainfalls) {
			            	dosobject.writeInt(Integer.parseInt(rainfall));
			            }
					}
					
					// 4. Flush for each writing
					dosobject.flush();
				
				
				// 5. Close stream
				dosobject.close();
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			
			// Indicate end of program - Could be successful
			System.out.println("End of program. Check out " + sourceFile); 
		}

}
