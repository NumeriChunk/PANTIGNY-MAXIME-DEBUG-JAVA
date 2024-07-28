package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public ISymptomReader reader;
	public ISymptomWriter writer;
	
	/**
	 * Constructor of the AnalyticsCounter
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Get all symptoms from file
	 * @return Array List of all symptoms.
	 */
	public List<String> getSymptoms () {
		return reader.getSymptoms();
	}
	
	/**
	 * Take all the symptoms from List.
	 * Convert to Map collection that will name the key by symptoms and occurrence as value.
	 * @param Raw List of symptoms.
	 * @return Collection with occurrence of symptoms.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		for(int i =0 ; i<symptoms.size() ; i++) {
			if (result.containsKey(symptoms.get(i))) {
				result.put(symptoms.get(i), result.get(symptoms.get(i))+1);
				continue;
			}else {
				result.put(symptoms.get(i), 1);
			}
		}
		
		return result;
			
	}
	
	/**
	 * Sort alphabetical the collection of symptoms.
	 * @param Take Map of unsorted data.
	 * @return Map of sorted data.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(symptoms);
		
		return sortedMap;
		
	}
	
	/**
	 * Write all of the collection into new file named "result.out"
	 * @param Map of symptoms to write in new file.
	 */
	public void writeSymptoms(Map<String, Integer>symptoms) {
		writer.writeSymptoms(symptoms);
	}
}	
	
