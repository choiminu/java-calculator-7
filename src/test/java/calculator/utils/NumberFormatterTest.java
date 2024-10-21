package calculator.utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberFormatterTest {
    @Test
    public void 숫자_포맷팅() {
        //given
        NumberFormatter numberFormatter = new NumberFormatter();

        //when
        String result = numberFormatter.format(123456789012345.9);

        //then
        Assertions.assertThat(result).isEqualTo("123456789012345.9");
    }
}