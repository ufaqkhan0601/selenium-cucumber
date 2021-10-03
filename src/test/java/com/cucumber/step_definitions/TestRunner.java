package com.cucumber.step_definitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
				tags = {"@test"},
		plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner{
	
}