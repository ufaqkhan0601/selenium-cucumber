package com.cucumber.step_definitions;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.cucumber.actions.ActionsLib;
import com.cucumber.helpers.ObjectRepository;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
public class StepDefinitions {
    public WebDriver driver;
    public Properties OR;
    
    public StepDefinitions() throws IOException {
    	driver = Hooks.driver;
    	OR = ObjectRepository.ObjectRepo(System.getProperty("user.dir")+"//src//test//resources//OR.properties");
    }
    @Given("^I open Flipkart Website$")
    public void open_Website()
    {
    	driver.get(Hooks.config.getProperty("url"));
    }
    
    @And("^Click on X Button$")
    public void click_On_X_Button() throws Throwable {
    	ActionsLib.clickOnXButton(driver, OR);
    }
   
    
    @Then("^Click and Search in Top Search Box$")
    public void click_And_Search_In_Top_Search_Box(DataTable columns) throws Throwable {
    	List<DataTableRow> rows = columns.getGherkinRows();
    	for (DataTableRow row : rows) {
        ActionsLib.clickAndSearchInTopSearchBox(driver, OR,row.getCells().get(0));
    	}
    }
    
    @When("^Click Item from the Searched Result$")
    public void click_Item_From_The_Searched_Result(DataTable columns) throws Throwable {
    	List<DataTableRow> rows = columns.getGherkinRows();
    	for (DataTableRow row : rows) {
        ActionsLib.clickItemFromTheSearchedResult(driver, OR,row.getCells().get(0));
    	}
    }   
    @And("^Click Add to Cart Button$")
    public void click_Add_To_Cart_Button() throws Throwable {
    	ActionsLib.clickAddToCartButton(driver, OR);
    }
    
    @And("^Switch Another Window$")
    public void switch_Another_Window() throws Throwable {
    	ActionsLib.switchAnotherWindow(driver, OR);
    }
    @Then("^Validate Item added in Cart Succesfully$")
    public void validate_Item_Added_In_Cart_Succesfully() throws Throwable {
    	ActionsLib.validateItemAddedInCartSuccesfully(driver, OR);
    }
    
   
}