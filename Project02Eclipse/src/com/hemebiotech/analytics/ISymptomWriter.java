package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Will write all of the content of an Map collection.
 * 
 */

public interface ISymptomWriter {

	/**
	 * It will write the content of the Map on file names "result.out".
	 * @param symptoms that have to be treated.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
	
}

