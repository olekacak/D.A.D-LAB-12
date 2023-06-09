package rain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writeRainfall{

	public static void main(String[] args){
        
		try{
        	
			String sourceFile = "dailyRainfall.txt";
			
            FileWriter fileWriter = new FileWriter(sourceFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Writing data for Station Simpang Ampat 
            printWriter.println("Station ID: 2421003");
            printWriter.println("Station Name: Simpang Ampat");
            printWriter.println("District: Alor Gajah");
            printWriter.println("Rainfall Data:");

            // 6 days data of rainfall from Simpang Ampat station
            int[] rainfallData = {4, 1, 0, 6, 19, 1};
            
            int totalRainfall = 0;
			int n = 0;
			int dailyRainfallAvg = 0;

            for (int i = 0; i < rainfallData.length; i++){
                
            	printWriter.println("Day " + (i + 1) + ": " + rainfallData[i]);
            
            }
            
          //calculate average of daily rainfall for Simpang Ampat station
			for (int i=0; i<rainfallData.length; i++) {
				totalRainfall = totalRainfall + rainfallData[i];
				n++;
				
				}
			dailyRainfallAvg = ( totalRainfall / n);
			printWriter.println("The average of daily rainfall for " + n + " days from Simpang Ampat station is : " + dailyRainfallAvg + "%");
				
			
			// 5. Close stream
            printWriter.close();
            
            System.out.println("Data creation has ended.");
       
		} catch (IOException e) {
            e.printStackTrace();
        }
    }
}