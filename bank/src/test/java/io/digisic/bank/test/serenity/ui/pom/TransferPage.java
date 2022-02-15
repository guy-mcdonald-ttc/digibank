package io.digisic.bank.test.serenity.ui.pom;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl ("https://localhost:8443/account/xfer-between")
public class TransferPage extends PageObject {
	
	@FindBy(id="fromAccount")
	private WebElement fromAccount;
	
	@FindBy(id="toAccount")
	private WebElement toAccount;
	
	@FindBy(id="amount")
	private WebElement amountInput;

	@FindBy(id="formSubmitButton")
	private WebElement submitButton;

	@FindBy(id="error")
	private WebElement errorAlert;

	public void selectFromAccount(int index) {
		new Select(fromAccount).selectByIndex(index);
	}

	public void selectToAccount(int index) {
		new Select(toAccount).selectByIndex(index);
	}
	
	public void enterAmount(String amount) {
		amountInput.sendKeys(amount);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}

	public boolean expectedTransferBetweenSameAccountErrorDisplayed() {
		return errorAlert.getText().equals("Can not trasnsfer from and to the same account.");
	}
	
}
