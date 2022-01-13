

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoWebShopTest {

    @ValueSource(strings = {"3rd Album", "$50 Physical Gift Card "})
    @DisplayName("Поиск товара {0} на сайте demowebshop")
    @Tag("Medium")
    @ParameterizedTest(name = "Поиск товара {0} на сайте demowebshop")
    void parameterizedSearchDemoWebShopTest(String searchValue) {
        open("http://demowebshop.tricentis.com");
        $(".search-box-text").setValue(searchValue);
        $(".button-1").click();
        $(".product-title").shouldHave(text(searchValue));
    }


    @CsvSource(value = {"Diamond|Black & White Diamond Heart",
            "Gift Card|$100 Physical Gift Card"},

            delimiter = '|')
    @DisplayName("Поиск слова {0} и отображение товара {1} на сайте demowebshop")
    @Tag("Medium")
    @ParameterizedTest(name = "Поиск слова {0} и отображение товара {1} на сайте demowebshop")
    void searchDemoWebShopCsvTest(String searchValue, String expectedResult) {
        open("http://demowebshop.tricentis.com");
        $(".search-box-text").setValue(searchValue);
        $(".button-1").click();
        $(".product-title").shouldHave(text(expectedResult));
    }


    @MethodSource
    @Tag("Medium")
    @ParameterizedTest(name = "Поиск слова {0} и отображение товара {1} на сайте demowebshop")
    void searchDemoWebShopArgumentTest(String searchValue, String expectedResult) {
        open("http://demowebshop.tricentis.com");
        $(".search-box-text").setValue(searchValue);
        $(".button-1").click();
        $(".product-title").shouldHave(text(expectedResult));
    }

    static Stream<Arguments> searchDemoWebShopArgumentTest() {
        return Stream.of(
                Arguments.of("Diamond", "Black & White Diamond Heart"),
                Arguments.of("Gift Card", "$100 Physical Gift Card")
        );
    }

    @EnumSource(TabNames.class)
    @Tag("Medium")
    @ParameterizedTest
    void searchDemoWebShopEnumTest(TabNames tabNames) {
        open("http://demowebshop.tricentis.com");
        $$(".top-menu").findBy(text(tabNames.getName())).click();
        $(".page-title").shouldHave(text(tabNames.getName()));
    }
}
