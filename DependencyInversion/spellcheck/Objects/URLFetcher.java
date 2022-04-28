package spellcheck.Objects;

import spellcheck.Interface.FetcherInterface;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLFetcher implements FetcherInterface {

    @Override
	public String fetch(URL url) throws IOException {

		URLConnection connection = url.openConnection();

		StringBuilder contentBuffer = new StringBuilder();

        try (InputStream input = connection.getInputStream()) {
            int c;
            while ((c = input.read()) >= 0) {
                contentBuffer.append((char) c);
            }
        }

		return contentBuffer.toString();
	}
}

