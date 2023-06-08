package lab12.exercises6;


	import java.io.DataInputStream;
	import java.io.FileInputStream;
	import java.io.IOException;
	
	/**
	 * This program demonstrate writing data as byte using FileinputStream.
	 * This program demonstrate writing byte-based data using DatainputStream.
	 * 
	 * @author muhammadizzat
	 *
	 */

	public class DataOutputRainfall {
		 public static void main(String[] args) {
			 
			 try {
				 
				 String outfile =  "dailyrainfall2.dat";
				 DataInputStream disobject = new DataInputStream(new FileInputStream(outfile));

				 int S = 0;
				 int D = 0;

				 // Variables for average rainfall calculation
				 int[] TotalRainfall = new int[6];
				 int[] RainfallCount = new int[6];

				 // Reading data for each station
				 while (disobject.available() > 0) {
					 
					 String stationId = disobject.readUTF();
					 String stationname = disobject.readUTF();
					 String district = disobject.readUTF();

					 System.out.println("Station ID: " + stationId);
					 System.out.println("Station Name : " + stationname);
					 System.out.println("District : " + district);

					 // Reading of daily rainfall data
					 System.out.println("Daily Rainfall data:");
					 
					 int TotalRainfallOfStation = 0;
					 for (int i = 0; i < 6; i++) {
						 
						 int data = disobject.readInt();
						 TotalRainfallOfStation += data;
						 TotalRainfall[i] += data;
						 RainfallCount[i]++;

						 System.out.println("Day " + (i + 1) + ": " + data);
					 }

					 double AvgRainfall = TotalRainfallOfStation / 6.0;
					 String formattedAverage1 = String.format("%.2f", AvgRainfall);
					 System.out.println("Average Rainfall: " + formattedAverage1);
					 System.out.println();
					 S++;
					 D++;
				 }

				 disobject.close();

				 System.out.println("Number of Stations: " + S);
				 System.out.println("Number of Districts: " + D);
				 System.out.println("Average Rainfall for each day :");
				 for (int i = 0; i < 6; i++) {
					 double averageRainfall = TotalRainfall[i] / (double) RainfallCount[i];
					 String formattedAverage2 = String.format("%.2f", averageRainfall);
					 System.out.println("Day " + (i + 1) + ": " + formattedAverage2);
				 }
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 }
	}


