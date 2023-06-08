package lab12.exercises7;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReaderDailyRainfall {
	
		
	public static void main(String[] args) {
		   
        try {
        	
        	String sourceFile = "dailyrainfall7.dat";
        	String data;
        	
            FileReader fileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }

            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}


