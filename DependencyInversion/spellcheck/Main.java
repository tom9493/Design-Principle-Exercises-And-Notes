package spellcheck;

import spellcheck.Objects.Dictionary;
import spellcheck.Objects.URLFetcher;
import spellcheck.Objects.WordExtractor;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;

public class Main {

	public static void main(String[] args) {
	
		try {
			URL url = new URL(args[0]);
			SpellingChecker checker = new SpellingChecker();
			SortedMap<String, Integer> mistakes = checker.check(url, new URLFetcher(), new Dictionary("dict.txt"),
					new WordExtractor());
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

