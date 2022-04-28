
package spellcheck.Objects;

import com.google.inject.Inject;
import spellcheck.Interface.DictionaryInterface;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary implements DictionaryInterface {
	private Set<String> words;

    @Inject
	public Dictionary(String fileName) throws IOException {
        //System.out.println(fileName);
        fileName = "dict.txt";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            words = new TreeSet<>();
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }
        }
	}

    @Override
	public boolean isValidWord(String word) {
		return words.contains(word);
	}
}

