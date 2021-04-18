package com.test.task.basepage;

import com.test.task.infrastructure.driver.Setup;
import com.test.task.infrastructure.driver.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    protected BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
