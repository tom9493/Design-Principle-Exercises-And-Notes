import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import spellcheck.AppModule;
import spellcheck.Interface.DictionaryInterface;
import spellcheck.Interface.ExtractorInterface;
import spellcheck.Interface.FetcherInterface;
import spellcheck.Objects.URLFetcher;
import spellcheck.SpellingChecker;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;

public class DependencyInjectionTest {
    Injector injector;
    FetcherInterface fetcher;
    DictionaryInterface dictionary;
    ExtractorInterface extractor;

    @Before
    public void setup() throws IOException {
        injector = Guice.createInjector(new AppModule());
        fetcher = Mockito.mock(URLFetcher.class);
        Mockito.when(fetcher.fetch(new URL("https://pastebin.com/raw/t6AZ5kx3"))).
                thenReturn("You may think that this function is obsolete, and doesn't seem to do anything. " +
                        "And you would be correct. But when we remove this funtion for some reason the whole program " +
                        "crashes and we can't figure out why, so here it will stay.");
    }

    @Test
    public void testSpellChecker() throws IOException {
        dictionary = injector.getInstance(DictionaryInterface.class);
        extractor = injector.getInstance(ExtractorInterface.class);
        SortedMap<String, Integer> mistakes;

        try {
            URL url = new URL("https://pastebin.com/raw/t6AZ5kx3");
            SpellingChecker checker = new SpellingChecker();

            mistakes = checker.check(url, fetcher, dictionary, extractor);

            int be = mistakes.get("be");
            int doesn = mistakes.get("doesn");
            int funtion = mistakes.get("funtion");
            int t = mistakes.get("t");

            Assert.assertEquals(be, 1);
            Assert.assertEquals(doesn, 1);
            Assert.assertEquals(funtion, 1);
            Assert.assertEquals(t, 2);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Mockito.verify(fetcher).fetch(new URL("https://pastebin.com/raw/t6AZ5kx3"));
    }
}
