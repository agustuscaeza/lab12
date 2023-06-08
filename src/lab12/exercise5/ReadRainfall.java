package lab12.exercise5;


	import java.io.DataInputStream;
	import java.io.FileInputStream;

	/**
	 * it is using DataInputStream.
	 * 
	 * 
	 * The program calculates the average bed utilization and display it on the console.
	 * 
	 * @author muhammadizzat
	 *
	 */
	public class ReadRainfall {

		public static void main(String[] args) {

			// 1. Declare output file 
			String sourceFile = "dailyrainfall.dat";
			System.out.println("Reading data from " + sourceFile + "\n");

			try {

				// 2. Create stream to read data
				DataInputStream disobject = new DataInputStream(new FileInputStream(sourceFile));

				// Variables for processing byte-based data
				int dailyrainfall = 0;
				int totaldailyrainfall = 0;
				int n = 0;
				String date = "";
				
				// 3. Process data until end-of-file
				while(disobject.available() > 0) {
					
					// Read data
					date = disobject.readUTF();
					dailyrainfall = disobject.readInt();
					System.out.println( date + "\t" + dailyrainfall);
					
					// Calculate total utilization
					totaldailyrainfall += dailyrainfall;
					n ++;
				}
				
				// 4. Close stream
				disobject.close();
				
				// Calculate average dailyrainfall
				int averagerainfall = totaldailyrainfall / n;
				System.out.print("\nAverage Daily rainfall for " + n
						+ " days in Simpang Ampat Station : " + averagerainfall + "%");
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}

			// Indicate end of program - Could be successful
			System.out.println("\nEnd of program.");
			

		}


}
