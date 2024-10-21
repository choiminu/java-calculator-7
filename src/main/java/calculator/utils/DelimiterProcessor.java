package calculator.utils;

import static calculator.utils.Constants.COLON;
import static calculator.utils.Constants.COMMA;
import static calculator.utils.Constants.CUSTOM_DELIMITER_PREFIX;
import static calculator.utils.Constants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.utils.Constants.DELIMITER_PATTERN_PREFIX;
import static calculator.utils.Constants.DELIMITER_PATTERN_SUFFIX;
import static calculator.utils.Constants.EMPTY;
import calculator.utils.validator.DelimiterValidator;
import java.util.Arrays;


public class DelimiterProcessor {

    private final DelimiterValidator validator = new DelimiterValidator();

    public String[] splitByDelimiter(String userInput, String delimiter) {
        if (delimiter.isEmpty()) {
            return new String[]{userInput};
        }

        validator.validateDelimiterUsage(userInput, delimiter);
        userInput = deleteCustomDelimiter(userInput, delimiter);

        return Arrays.stream(userInput.split(DELIMITER_PATTERN_PREFIX + delimiter + DELIMITER_PATTERN_SUFFIX))
                .filter(s -> !s.trim().isEmpty())
                .toArray(String[]::new);
    }

    public String deleteCustomDelimiter(String userInput, String delimiter) {
        if (hasCustomDelimiter(delimiter)) {
            userInput = userInput.replace(CUSTOM_DELIMITER_PREFIX, EMPTY);
            userInput = userInput.replace(CUSTOM_DELIMITER_SUFFIX, EMPTY);
        }
        return userInput;
    }

    public boolean hasCustomDelimiter(String delimiters) {
        for (char delimiter : delimiters.toCharArray()) {
            if (delimiter != COMMA && delimiter != COLON) {
                return true;
            }
        }
        return false;
    }
}
