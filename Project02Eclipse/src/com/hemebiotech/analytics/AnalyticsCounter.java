package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	//
	public ISymptomReader reader;
	public ISymptomWriter writer;
	
	//Point d'entré
	public static void main(String args[]) throws Exception {
		
		//Lecture du fichier symtoms.txt
		ReadSymptomDataFromFile symptomsReader = new ReadSymptomDataFromFile("symptoms.txt");
		symptomsReader.getSymptoms();
		
		WriteSymptomDataToFile symptomsWriter = new WriteSymptomDataToFile();
		symptomsWriter.writeSymptoms(sortSymptoms(countSymptoms(symptomsReader.getSymptoms())));
		/*
		//Ecriture du résultat.
		WriteSymptomDataToFile writeTheSymtoms = new WriteSymptomDataToFile();
		writeTheSymtoms.WriteSymptoms(countSymptoms(readTheSymptoms.GetSymptoms()));
		*/

	}
	
	//Constructeur classe Main
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	//Récupérer la liste 
	public List<String> getSymptoms () {
		return reader.getSymptoms();
	}
	
	//Compter les occurences
	public static Map<String, Integer> countSymptoms(List<String> symptoms){
		
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
	
	//Trier les symptômes et les occurences.
	public static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		
		//Déclaration d'une treemap permettant de trier les éléments.
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(symptoms);
		
		return sortedMap;
		
	}
	
	//Ecrire le résultat
	public void writeSymptoms(Map<String, Integer>symptoms) {
		ISymptomWriter objet = new WriteSymptomDataToFile();
		objet.writeSymptoms(symptoms);
	}
}	
	
