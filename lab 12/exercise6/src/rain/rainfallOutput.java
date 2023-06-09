package rain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class rainfallOutput{

	 public static void main(String[] args) {
		 
		 try {
			 
			 String fileName =  "dailyRainfall.txt";
			 DataInputStream dataInput = new DataInputStream(new FileInputStream(fileName));

			 int totalStation = 0;
			 int totalDistrict = 0;

			 // Variables for average rainfall calculation
			 int[] totalRainfall = new int[6];
			 int[] totalRainfallStation = new int[6];

			 // Reading data for each station
			 while (dataInput.available() > 0) {
				 
				 String stationId = dataInput.readUTF();
				 String stationName = dataInput.readUTF();
				 String districtName = dataInput.readUTF();

				 System.out.println("Station ID: " + stationId);
				 System.out.println("Station Name: " + stationName);
				 System.out.println("District Name: " + districtName);

				 // Reading rainfall readings
				 System.out.println("Rainfall Data:");
				 
				 int rainfallStationTotal = 0;
				 for (int i = 0; i < 6; i++) {
					 
					 int data = dataInput.readInt();
					 rainfallStationTotal += data;
					 totalRainfall[i] += data;
					 totalRainfallStation[i]++;

					 System.out.println("Day " + (i + 1) + ": " + data);
				 }

				 double rainfallStationAvg = rainfallStationTotal / 6.0;
				 System.out.println("Daily Rainfall Average: " + rainfallStationAvg + "%");
				 System.out.println();
				 totalStation++;
				 totalDistrict++;
			 }

			 dataInput.close();

			 System.out.println("Total Stations: " + totalStation);
			 System.out.println("Total Districts: " + totalDistrict);
			 System.out.println("Average Rainfall Per Day:");
			 for (int i = 0; i < 6; i++) {
				 double averageRainfall = totalRainfall[i] / (double) totalRainfallStation[i];
				 System.out.println("Day " + (i + 1) + ": " + averageRainfall + "%");
			 }
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
}
