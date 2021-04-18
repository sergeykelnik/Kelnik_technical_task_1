package com.test.task;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/test/task/UbsDomicileTest.feature"},
        strict = true,
        plugin = {"pretty",
                "json:target/cucumber_json_reports/domicile.json",
                "html:target/domicile-html"},
        glue = {"com.test.task"})
public class UbsDomicileTest {
}