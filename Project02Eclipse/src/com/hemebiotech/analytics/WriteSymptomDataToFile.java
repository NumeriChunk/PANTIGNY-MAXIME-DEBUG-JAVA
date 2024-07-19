package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			
			FileWriter fileWriter = new FileWriter("result.out");
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write("headache: " + AnalyticsCounter.headacheCount + "\n");
			writer.write("rash: " + AnalyticsCounter.rashCount + "\n");
			writer.write("dialated pupils: " + AnalyticsCounter.pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}