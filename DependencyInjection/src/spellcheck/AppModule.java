package spellcheck;

import com.google.inject.AbstractModule;
import spellcheck.Interface.DictionaryInterface;
import spellcheck.Interface.ExtractorInterface;
import spellcheck.Interface.FetcherInterface;
import spellcheck.Objects.Dictionary;
import spellcheck.Objects.URLFetcher;
import spellcheck.Objects.WordExtractor;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DictionaryInterface.class).to(Dictionary.class);
        bind(ExtractorInterface.class).to(WordExtractor.class);
        bind(FetcherInterface.class).to(URLFetcher.class);
    }
}
