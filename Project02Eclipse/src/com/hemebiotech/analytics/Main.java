package com.hemebiotech.analytics;		

public class Main {
	/**
	 * This program will take raw data to sorted data with occurrence.
	 * @author Maxime P
	 */
	public static void main(String[] args) {
		
		String fileToAnalyse = "symptoms.txt";
		
		ISymptomReader symptomsReader = new ReadSymptomDataFromFile(fileToAnalyse);
		ISymptomWriter symptomsWriter = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomsReader, symptomsWriter);
		
		analyticsCounter.getSymptoms();
		analyticsCounter.countSymptoms();
		analyticsCounter.sortSymptoms();
		analyticsCounter.writeSymptoms();
		
	}
	
}


