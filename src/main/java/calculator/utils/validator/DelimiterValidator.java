package calculator.utils.validator;

import static calculator.utils.Constants.COLON;
import static calculator.utils.Constants.COMMA;
import static calculator.utils.Constants.EXCEPTION_MESSAGE;

public class DelimiterValidator {

    public void validateDelimiterUsage(String userInput, String delimiter) {
        if (userInput.matches(".*([" + delimiter + "]{2,}).*")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
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
