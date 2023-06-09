package rain;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class rainfallInput {
	
	public static void main(String[] args) {

		//1. declaration of file name.
		String fileName = "dailyRainfall.txt";
		
		//2. list the data in array
		 String[][] rainfallDataArr = {
	                {"2421003", "Simpang Ampat", "Alor Gajah", "4", "1", "0", "6", "19", "1"},
	                {"2321006", "Ladang Lendu ", "Alor Gajah", "2", "0", "0", "3", "4", "0"},
	                {"2222002", "Durian Tunggal", "Alor Gajah", "0", "0", "0", "37", "6", "9"},
	                {"2424031", "Datoh Kramat di Nyalas Melaka", "Jasin", "0", "0", "0", "0", "17", "0"},
	                {"2125002", "Telok Rimba", "Jasin", "0", "1", "1", "69", "53", "4"},
	                {"2223023", "Sg. Duyong", "Melaka Tengah", "0", "3", "0", "43", "26", "26"}
	                };
		
		try (
			
			//3. create an output stream between this program and the target file
			DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(fileName))) {
			
			//4. insert the data into the file
			for (String[] rainfallData : rainfallDataArr) {
				
				 String stationId = rainfallData[0];
	                String stationName = rainfallData[1];
	                String districtName = rainfallData[2];
	                String[] rainfalls = {rainfallData[3], rainfallData[4], rainfallData[5],rainfallData[6], rainfallData[7], rainfallData[8]};
				
	                dataOutput.writeUTF(stationId);
	                dataOutput.writeUTF(stationName);
	                dataOutput.writeUTF(districtName);
			
			
			// Writing rainfall readings
	            for (String rainfall : rainfalls) {
	            	dataOutput.writeInt(Integer.parseInt(rainfall));
	            }
			}
				
			//5. Clear the stream
			dataOutput.flush();
			
			//6. close the stream
			dataOutput.close();
			
			// indicate end of the program - if success
			System.out.println("Rainfall data has been written to the file: " + fileName);

		} catch (IOException e) {
			
			// if there an error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + e.getMessage());
		}

	}
}