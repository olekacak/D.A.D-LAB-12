package rain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class dailyRainfallAverage{

	private int totalRainfall=0;
	private int dailyRainfalAverage = 0;
	private int totalDay = 6;
	private String filename;
	
	/*
	 * Class constructor
	 */
	
	public dailyRainfallAverage(String filename){
		this.filename = filename;
	}
	
	/*
	 * Method to calculate average of rainfall data at Simpang Ampat
	 * 
	 */
	public void calculateAvg(){
		
		/*
		 * Read data from file dailyRainfall.txt
		 * Calculate total of the data
		 * calculate average of the data
		 * 
		 */
		
		try (
				
			DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))){
			System.out.println("Rainfall Data:");
			
			// Read values of array from the stream
			for (int i = 0; i < 6; i++) {
				int rain = inputStream.readInt();
				
				// calculate total of the daily rainfall data
				totalRainfall += rain;
			
			}
			
			// Close stream
			inputStream.close();
			
			// Calculate average of rainfall data 
			dailyRainfalAverage = totalRainfall / totalDay;
			
			// display the calculated average
			System.out.println("The average of daily rainfall for " + totalDay + " days from Simpang Ampat station is : " + dailyRainfalAverage + "%");
			System.out.println();
			
		} catch (IOException e){
			
			// If there an error, this message will be displayed.
			System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
		}
		
			
	}


}
