package spellcheck.Interface;

import java.util.List;

public interface ExtractorInterface {
    public abstract List<String> extract(String content);
}
