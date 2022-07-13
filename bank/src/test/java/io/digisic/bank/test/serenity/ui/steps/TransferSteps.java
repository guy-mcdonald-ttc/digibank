package io.digisic.bank.test.serenity.ui.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import io.digisic.bank.test.serenity.ui.pom.TransferPage;

import static org.junit.Assert.assertTrue;


public class TransferSteps extends ScenarioSteps{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9217777745579627128L;
	
	TransferPage transferPage;

	@Step ("Select From Account Number '{0}'")
	public void selectFromAccount(String index) {
		transferPage.selectFromAccount(Integer.valueOf(index));
	}

	@Step ("Select To Account Number '{0}'")
	public void selectToAccount(String index) {
		transferPage.selectToAccount(Integer.valueOf(index));
	}
	
	@Step ("Enter Amount '{0}'")
	public void enterAmount(String amount) {
		transferPage.enterAmount(amount);
	}

	@Step ("Click the Submit button")
	public void clickSubmit() {
		transferPage.clickSubmit();
	}
	
	@Step ("Validate transfer between same account alert appears")
	public void validateTransferBetweenSameAccountAlertPresent() {
		assertTrue(transferPage.expectedTransferBetweenSameAccountErrorDisplayed());
	}

}
