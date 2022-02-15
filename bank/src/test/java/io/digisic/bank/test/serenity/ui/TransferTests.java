package io.digisic.bank.test.serenity.ui;

import net.thucydides.core.annotations.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.digisic.bank.test.serenity.ui.steps.LoginSteps;
import io.digisic.bank.test.serenity.ui.steps.MenuNavigationSteps;
import io.digisic.bank.test.serenity.ui.steps.TransferSteps;


public class TransferTests {
	
	@Steps
	private LoginSteps login;
	
	@Steps
	private MenuNavigationSteps menu;
	
	@Steps
	private TransferSteps transferSteps;
	

	@And("^they attempt to transfer money$")
	public void openTransferPage() throws Throwable {
		menu.clickTransferMenuOption();
	}

	@When("^(.*) selects account number '(.*)' as the from account$")
	public void selectFromAccount(String perosna, String index) throws Throwable {
		transferSteps.selectFromAccount(index);
	}

	@And("^they select account number '(.*)' as the to account$")
	public void selectToAccount(String index) throws Throwable {
		transferSteps.selectToAccount(index);
	}

	@And("^they enter '(.*)' into the amount field$")
	public void enterAmount(String amount) throws Throwable {
		transferSteps.enterAmount(amount);
	}

	@And("^they submit the form$")
	public void submit() throws Throwable {
		transferSteps.clickSubmit();
	}

	@Then("^(.*) verifies the transfer failed$")
	public void accountNotCreated(String persona) throws Throwable {
		transferSteps.validateTransferBetweenSameAccountAlertPresent();
	}

}
