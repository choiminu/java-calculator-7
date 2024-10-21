package calculator.utils.extractor;
import static calculator.utils.Constants.CUSTOM_DELIMITER_PREFIX;
import static calculator.utils.Constants.CUSTOM_DELIMITER_PREFIX_LENGTH;
import static calculator.utils.Constants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.utils.Constants.CUSTOM_DELIMITER_SUFFIX_LENGTH;
import static calculator.utils.Constants.EXCEPTION_MESSAGE;

import java.util.List;

public class CustomDelimiterExtractor {

    public void extractCustomDelimiters(String userInput, List<String> delimiters) {
        while (hasCustomDelimiter(userInput)) {
            String delimiter = extractNextCustomDelimiter(userInput);
            userInput = updateUserInputAfterDelimiterExtraction(userInput);
            delimiters.add(delimiter);
        }
    }

    private String extractNextCustomDelimiter(String userInput) {
        int startIndex = findStartIndex(userInput);
        int endIndex = findEndIndex(userInput, startIndex);

        if (! isValidDelimiterPosition(startIndex, endIndex)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return userInput.substring(startIndex, endIndex);
    }

    private int findStartIndex(String userInput) {
        return userInput.indexOf(CUSTOM_DELIMITER_PREFIX) + CUSTOM_DELIMITER_PREFIX_LENGTH;
    }

    private int findEndIndex(String userInput, int startIndex) {
        return userInput.indexOf(CUSTOM_DELIMITER_SUFFIX, startIndex);
    }

    private String updateUserInputAfterDelimiterExtraction(String userInput) {
        int endIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return userInput.substring(endIndex + CUSTOM_DELIMITER_SUFFIX_LENGTH);
    }

    private boolean hasCustomDelimiter(String userInput) {
        return userInput.contains(CUSTOM_DELIMITER_PREFIX);
    }

    private boolean isValidDelimiterPosition(int startIndex, int endIndex) {
        return endIndex != -1 && startIndex < endIndex;
    }
}

