package com.epam.training.selenium.ex_4a;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage {
	// You can give the web browser type, what you want to use
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    public void searchFor(String text) {
    	searchBox.sendKeys(text);
    	searchBox.submit();
    }
} 