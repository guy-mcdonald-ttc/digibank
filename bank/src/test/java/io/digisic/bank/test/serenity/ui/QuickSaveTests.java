package io.digisic.bank.test.serenity.ui;

import net.thucydides.core.annotations.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.digisic.bank.test.serenity.ui.steps.LoginSteps;
import io.digisic.bank.test.serenity.ui.steps.MenuNavigationSteps;
import io.digisic.bank.test.serenity.ui.steps.QuickSaveSteps;


public class QuickSaveTests {
	
	@Steps
	private LoginSteps login;
	
	@Steps
	private MenuNavigationSteps menu;
	
	@Steps
	private QuickSaveSteps quickSaveSteps;
	

	@And("^they attempt to use QuickSave$")
	public void openQuickSavePage() throws Throwable {
		menu.clickQuickSaveMenuOption();
	}

	@And("^they select account number '(.*)' as the to account$")
	public void selectToAccount(String index) throws Throwable {
		quickSaveSteps.selectToAccount(index);
	}

	@And("^they enter '(.*)' into the amount field$")
	public void enterAmount(String amount) throws Throwable {
		quickSaveSteps.enterAmount(amount);
	}

	@And("^they submit the form$")
	public void submit() throws Throwable {
		quickSaveSteps.clickSubmit();
	}

	@Then("^(.*) verifies the order was placed$")
	public void accountCreated(String personal) throws Throwable {
		quickSaveSteps.redirectedToViewSavingsPage();
	}

}
