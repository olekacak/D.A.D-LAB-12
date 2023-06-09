package rain;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class rainfall{

	public static void main(String[] args){

		//1. declaration of file name.
		String fileName = "dailyRainfall.txt";
		
		//2. list the data in array
		int[] rainfallData = {4, 1, 0, 6, 19, 1};

		try (
			
			//3. create an output stream between this program and the target file
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
			
			//4. insert the data into the file
			for (int rainfall : rainfallData){
				outputStream.writeInt(rainfall);
			}
			
			//5. Clear the stream
			outputStream.flush();
			
			//6. close the stream
			outputStream.close();
			
			// indicate end of the program - if success
			System.out.println("Rainfall data has been written to the file: " + fileName);

		} catch (IOException e){
			
			// if there an error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + e.getMessage());
		}
		
		/*
		 * Use displayRainfallData method in RainFallDisplay class to display the data.
		 */
		rainfallDisplay display = new rainfallDisplay("dailyRainfall.txt");
		display.displayRainfallData();
		
		/*
		 * Use calculateAvg method in dailyRainfallAverage class to calculate the average of the data.
		 */
		dailyRainfallAverage avg = new dailyRainfallAverage("dailyRainfall.txt");
		avg.calculateAvg();
	}

}
