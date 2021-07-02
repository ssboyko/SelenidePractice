import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class softAssertionsGithubtest {
    static Logger logger = LoggerFactory.getLogger(softAssertionsGithubtest.class);

    @BeforeAll
    static void config() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

//  Откройте страницу Selenide в Github
//  Перейдите в раздел Wiki проекта
//  Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//  Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    @Test
    void selenideAutomationPracticeFormTest() {
        logger.info("Start test");
        open("https://github.com/selenide/selenide");
        $(".UnderlineNav-body").find(byText("Wiki")).click();
        $(".wiki-more-pages-link").find(withText("Show 1 more pages")).click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        $(".gollum-markdown-content").shouldHave(text("JUnit5"));
    }

//  Откройте https://the-internet.herokuapp.com/drag_and_drop
//  Перенесите прямоугольник А на место В
//  Проверьте, что прямоугольники действительно поменяли
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        //Этот вариант не работает
        //$("#column-a").hover();
        //actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }


}
