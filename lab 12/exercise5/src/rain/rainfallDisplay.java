package rain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class rainfallDisplay{

	private String fileName;

	public rainfallDisplay(String fileName){
		this.fileName = fileName;
	}

	public void displayRainfallData(){
		
	
		try (
			
			// 1. declaration of input stream object
			// Get the data from the input source
			DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))){
			System.out.println("\nDaily Rainfall Data:");
			
			// 2. Read values in the array from the stream
			for (int i = 0; i < 6; i++) {
				int rainfall = inputStream.readInt();
				System.out.println("Day " + (i + 1) + ": " + rainfall ++ );
				
			}
			
			// Close stream
			inputStream.close();
			System.out.println();
			
		} catch (IOException e){
			
			// If there an error, it will display this message.
			System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
		}
	}
}
