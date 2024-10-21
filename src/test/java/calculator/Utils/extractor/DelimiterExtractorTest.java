package calculator.Utils.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    @Test
    @DisplayName("기본 구분자를 사용한 입력에서 구분자를 추출")
    void 기본_구분자_사용() {
        //given
        String userInput = "1:2,3";

        //when
        String result = delimiterExtractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains(",", ":");
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 입력에서 구분자를 추출")
    void 커스텀_구분자_사용() {
        //given
        String userInput = "//^^\\n1^^2^^3^^4";

        //when
        String result = delimiterExtractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains("^^");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자를 사용한 입력에서 구분자를 추출")
    void 기본_구분자_커스텀_구분자_사용() {
        //given
        String userInput = "//^^\\n1,2:3^^4";

        //when
        String result = delimiterExtractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains(",", ":", "^^");
    }


    @Test
    @DisplayName("커스텀 구분자를 여러번 사용한 입력에서 구분자를 추출")
    void 기본_구분자와_커스텀_구분자_여러번_사용() {
        //given
        String userInput = "//&\\n//^^\\n1&2&3^^4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //when
        String result = delimiterExtractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains("^^", "&");
    }


}