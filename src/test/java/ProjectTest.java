import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Log4j
public class ProjectTest  extends BaseTest{

    @Test
    public void createNewProject() {
        open("/login");
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
        $("#createButton").click();
        $("#inputTitle").sendKeys("Leading sTOBLE");
        $(byText("Create project")).click();
        $(withText("Leading sTOBLE")).shouldBe(Condition.visible);

    }
}

