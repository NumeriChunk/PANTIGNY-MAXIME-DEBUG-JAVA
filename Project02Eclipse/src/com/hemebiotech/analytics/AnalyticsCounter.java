package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	private Map<String, Integer> mapSymptoms;
	private List<String> listSymptoms;
	
	/**
	 * Constructor of the AnalyticsCounter
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
		this.mapSymptoms = new HashMap<String, Integer>();
		this.listSymptoms = new ArrayList<String>();
	}

	/**
	 * Get all symptoms from file
	 * @return Array List of all symptoms.
	 */
	public void getSymptoms () {
		setListSymptoms(getReader().getSymptoms());
	}
	
	/**
	 * Take all the symptoms from List.
	 * Convert to Map collection that will name the key by symptoms and occurrence as value.
	 * @param Raw List of symptoms.
	 * @return Collection with occurrence of symptoms.
	 */
	public void countSymptoms(){
		
		for(int i =0 ; i<getListSymptoms().size() ; i++) {
			if (getMapSymptoms().containsKey(getListSymptoms().get(i))) {
				getMapSymptoms().put(getListSymptoms().get(i), getMapSymptoms().get(getListSymptoms().get(i))+1);
				continue;
			}else {
				getMapSymptoms().put(getListSymptoms().get(i), 1);
			}
			
		}	
	}
	
	/**
	 * Sort alphabetical the collection of symptoms.
	 * @param Take Map of unsorted data.
	 * @return Map of sorted data.
	 */
	public void sortSymptoms(){
		
		setMapSymptoms(new TreeMap<String, Integer>(getMapSymptoms()));
		
	}
	
	/**
	 * Write all of the collection into new file named "result.out"
	 * @param Map of symptoms to write in new file.
	 */
	public void writeSymptoms() {
		getWriter().writeSymptoms(this.mapSymptoms);
	}

	public Map<String, Integer> getMapSymptoms() {
		return mapSymptoms;
	}

	public void setMapSymptoms(Map<String, Integer> mapSymptoms) {
		this.mapSymptoms = mapSymptoms;
	}

	public List<String> getListSymptoms() {
		return listSymptoms;
	}

	public void setListSymptoms(List<String> listSymptoms) {
		this.listSymptoms = listSymptoms;
	}

	public ISymptomReader getReader() {
		return reader;
	}

	public ISymptomWriter getWriter() {
		return writer;
	}
}	
	
