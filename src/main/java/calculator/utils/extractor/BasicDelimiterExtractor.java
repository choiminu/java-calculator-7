package calculator.utils.extractor;
import static calculator.utils.Constants.COLON;
import static calculator.utils.Constants.COMMA;
import java.util.List;

public class BasicDelimiterExtractor {

    public void extractBasicDelimiters(String userInput, List<String> delimiters) {
        if (hasBasicDelimiter(userInput, COMMA)) {
            delimiters.add(String.valueOf(COMMA));
        }

        if (hasBasicDelimiter(userInput, COLON)) {
            delimiters.add(String.valueOf(COLON));
        }
    }

    private boolean hasBasicDelimiter(String userInput, char delimiter) {
        return userInput.contains(String.valueOf(delimiter));
    }

}
