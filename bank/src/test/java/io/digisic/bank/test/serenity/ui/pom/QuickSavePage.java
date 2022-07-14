package io.digisic.bank.test.serenity.ui.pom;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl ("https://localhost:8443/account/xfer-between")
public class QuickSavePage extends PageObject {
	
	@FindBy(id="toAccount")
	private WebElement toAccount;
	
	@FindBy(id="amount")
	private WebElement amountInput;

	@FindBy(id="formSubmitButton")
	private WebElement submitButton;

	public void selectToAccount(int index) {
		new Select(toAccount).selectByIndex(index);
	}
	
	public void enterAmount(String amount) {
		amountInput.sendKeys(amount);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}

}
