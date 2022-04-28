
package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;
import spellcheck.Interface.DictionaryInterface;
import spellcheck.Interface.ExtractorInterface;
import spellcheck.Interface.FetcherInterface;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppModule());

		FetcherInterface fetcher = injector.getInstance(FetcherInterface.class);
		DictionaryInterface dictionary = injector.getInstance(DictionaryInterface.class);
		ExtractorInterface extractor = injector.getInstance(ExtractorInterface.class);

		try {
			URL url = new URL(args[0]);
			SpellingChecker checker = new SpellingChecker();

			SortedMap<String, Integer> mistakes = checker.check(url, fetcher, dictionary, extractor);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

