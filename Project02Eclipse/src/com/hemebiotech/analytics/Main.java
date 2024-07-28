package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	/**
	 * This program will take raw data to sorted data with occurrence.
	 * @author Maxime P
	 */
	public static void main(String[] args) {
		
		String fileToAnalyse = "symptoms.txt";
		Map<String, Integer> mapResult = new HashMap<String, Integer>();
		List<String> listResult = new ArrayList<String>();
		
		ISymptomReader symptomsReader = new ReadSymptomDataFromFile(fileToAnalyse);
		ISymptomWriter symptomsWriter = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomsReader, symptomsWriter);
		
		listResult = analyticsCounter.getSymptoms();
		
		mapResult = analyticsCounter.countSymptoms(listResult);
		
		mapResult = analyticsCounter.sortSymptoms(mapResult);
		
		analyticsCounter.writeSymptoms(mapResult);
		
	}
	
}


