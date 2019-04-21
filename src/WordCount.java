import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.io.*;

public class WordCount {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		ArrayList<String> textInput = null;
		
		Map<String, Integer> wordCount = new HashMap<>();
		
		double happaxWords = 0;
		double stopWords = 0;
		double stopFrequency = 0;
		
		System.out.print("Please enter name of txt file: ");
		String fileName = kb.next();
		
		System.out.println("\nOpening file\n.\n.\n.");
		
		File f = new File("/Users/ryan/workspace/249 Assignment 4/" + fileName + ".txt");
		
		if (f.exists()) {
			System.out.println("Successul!\n\nAnalyzing text\n.\n.\n.\nSuccessful!\n");
		}
		else System.out.println("Failed! Please make sure file exists in the correct directory...");
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Add each entry to the ArrayList
		
		try {
			
			Scanner textScanner = new Scanner(new FileInputStream(f));
			
			textInput = new ArrayList<String>();
			
			while(textScanner.hasNext()) {
				textInput.add(textScanner.next().toLowerCase());
			}
			
		//////////////////////////////////////////////////////////////////////////////////////////
		// Remove entries with periods
			
			Iterator<String> it = textInput.iterator();
			
			while (it.hasNext()) {
				if( it.next().contains(".")) {
					it.remove();
				}
			}
			
			Iterator<String> it2 = textInput.iterator();
			
			while (it2.hasNext()) {
				if( it2.next().contains(",")) {
					it2.remove();
				}
			}
	
		//////////////////////////////////////////////////////////////////////////////////////////
		// Add entries to the HashMap <Word, Frequency>
			
			Iterator<String> tokens = textInput.iterator();
			
			while (tokens.hasNext()) {
				
				String word = tokens.next();
				
				Integer counter = wordCount.get(word);
				
				if (counter != null) {
					counter++;
				}
				else counter = 1;
				
				wordCount.put(word, counter);
			}
			textScanner.close();
		} 
		catch (FileNotFoundException e) {
			System.out.print("File not found!");
			e.printStackTrace();
		}
				
		//////////////////////////////////////////////////////////////////////////////////////////
		// Convert map to stream and reorder by frequency(value) of word(key)
		
		Stream<Map.Entry<String,Integer>> sortedWordCount = wordCount.entrySet().stream().sorted(Collections.reverseOrder((Map.Entry.comparingByValue())));
		
		Iterator<Entry<String, Integer>> sorted = sortedWordCount.iterator();
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Print ordered word list
		
		int rank = 1;
		
		System.out.println("-----------------------\n Rank \tWord=Frequency  \n----------------------- ");
		
		while (sorted.hasNext()) {
			System.out.println(" "+rank+"\t"+sorted.next().toString());
			rank++;
		}
		System.out.println("-----------------------\n");
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Display statistics
		
		System.out.println("Word types: " + wordCount.size());
		System.out.println("Word tokens: " + textInput.size());
		
		for (int x : wordCount.values()) {
			if (x == 1) {
				happaxWords++;
			}
		}
		for (int x : wordCount.values()) {
			if (x > 9) {
				stopWords++;
			}
		}
		
		for (int x : wordCount.values()) {
			if (x > 9) {
				stopFrequency += x;
			}
		}
		
		System.out.println("\nHappax legomena: " + (int)happaxWords);
		System.out.println("% of happax: " + String.format("%.2f", (happaxWords / wordCount.size())*100) + "%");
		System.out.println("Happax account for " + String.format("%.2f", (happaxWords / textInput.size())*100) + "% of the text\n");
		
		System.out.println("Stop words: " + (int)stopWords);
		System.out.println("% of stop words: " + String.format("%.2f", (stopWords / wordCount.size())*100) + "%");
		System.out.println("Stops account for " + String.format("%.2f", (stopFrequency / textInput.size())*100) + "% of the text\n");
		
		System.out.print("Thank you for using my Word Counter! Program will now terminate...");
		
		sortedWordCount.close();
		kb.close();
	}

}




