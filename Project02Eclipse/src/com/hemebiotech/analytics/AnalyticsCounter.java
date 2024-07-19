package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	public static int headacheCount = 0;
	public static int rashCount = 0;
	public static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		
		//Initialize reading file.
		try {

			FileReader fileReader = new FileReader("symptoms.txt");
			
			BufferedReader reader = new BufferedReader(fileReader);  
			
			String line = reader.readLine();
			
			while (line != null) {

				if (line.equals("headache")) {
					headacheCount++;
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}
	
				line = reader.readLine();	// get another symptom
			}
			
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		// Initialize writing in new file.
		try {
			
			FileWriter fileWriter = new FileWriter("result.out");
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
