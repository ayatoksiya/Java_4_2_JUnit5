package JUnit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Execution(ExecutionMode.CONCURRENT)
public class TitleTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    @Tag("regression")
    void shouldValidateCorrectTitleSiiPortal(String url, String expectedTitle) {
        //GIVEN
        driver.get(url);
        driver.manage().window().maximize();
        //WHEN
        String actualTitle = driver.getTitle();
        //THEN
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
