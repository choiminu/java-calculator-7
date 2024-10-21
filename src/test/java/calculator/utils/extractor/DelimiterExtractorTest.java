package calculator.utils.extractor;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    DelimiterExtractor extractor = new DelimiterExtractor();


    @Test
    @DisplayName("기본 구분자 사용")
    void 기본_구분자_사용() {
        //given
        String userInput = "1:2,3";

        //when
        List<String> result = extractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains(",", ":");
    }

    @Test
    @DisplayName("커스텀 구분자 사용")
    void 커스텀_구분자_사용() {
        //given
        String userInput = "//^^\\n1^^2^^3^^4";

        //when
        List<String> result = extractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains("^^");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자 사용")
    void 기본_구분자_커스텀_구분자_사용() {
        //given
        String userInput = "//^^\\n1,2:3^^4";

        //when
        List<String> result = extractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains(",", ":", "^^");
    }


    @Test
    @DisplayName("커스텀 구분자 1개 이상")
    void 기본_구분자와_커스텀_구분자_1개_이상() {
        //given
        String userInput = "//&\\n//^^\\n1&2&3^^4";

        //when
        List<String> result = extractor.determineDelimiter(userInput);

        //then
        assertThat(result).contains("^^", "&");
    }

    @Test
    @DisplayName("유효하지 않은 커스텀 구분자를 사용하면 예외가 발생한다.")
    public void 유효하지_않은_커스텀_구분자_사용() {
        //given
        String userInput = "//^n1,2^3";
        //when then
        Assertions.assertThatThrownBy(() -> extractor.determineDelimiter(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}