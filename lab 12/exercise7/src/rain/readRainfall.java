package rain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readRainfall{

	   public static void main(String[] args) {
		   
	        try{
	        	
	        	String sourceFile = "dailyRainfall.txt";
	        	String line;
	        	
	            FileReader fileReader = new FileReader(sourceFile);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while ((line = bufferedReader.readLine()) != null){
	                System.out.println(line);
	            }

	            bufferedReader.close();
	            
	        } catch (IOException e){
	            e.printStackTrace();
	        }
	    }
}