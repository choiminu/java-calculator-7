package calculator.utils.extractor;
import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractor {
    private final BasicDelimiterExtractor basicExtractor = new BasicDelimiterExtractor();
    private final CustomDelimiterExtractor customExtractor = new CustomDelimiterExtractor();

    public List<String> determineDelimiter(String userInput) {
        List<String> delimiters = new ArrayList<>();
        basicExtractor.extractBasicDelimiters(userInput, delimiters);
        customExtractor.extractCustomDelimiters(userInput, delimiters);
        return delimiters;
    }
}
