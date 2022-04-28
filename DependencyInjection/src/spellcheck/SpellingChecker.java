package spellcheck;

import spellcheck.Interface.DictionaryInterface;
import spellcheck.Interface.ExtractorInterface;
import spellcheck.Interface.FetcherInterface;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SpellingChecker {

	public SortedMap<String, Integer> check(URL url, FetcherInterface fetcher, DictionaryInterface dictionary,
                                            ExtractorInterface extractor) throws IOException {

		String content = fetcher.fetch(url);
		List<String> words = extractor.extract(content);
		SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionary.isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

