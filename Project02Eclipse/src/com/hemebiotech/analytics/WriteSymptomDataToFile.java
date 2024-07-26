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
			
			symptoms.forEach((key, value) -> {
				try {
					writer.write(key + " : " + value +"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			

			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}