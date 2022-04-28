package spellcheck.Interface;

import java.io.IOException;
import java.net.URL;

public interface FetcherInterface {
    public String fetch(URL url) throws IOException;
}
