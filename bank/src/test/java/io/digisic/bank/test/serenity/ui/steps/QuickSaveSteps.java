package io.digisic.bank.test.serenity.ui.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import io.digisic.bank.test.serenity.ui.pom.NewSavingsAccountPage;
import io.digisic.bank.test.serenity.ui.pom.QuickSavePage;

import static org.junit.Assert.assertTrue;


public class QuickSaveSteps extends ScenarioSteps{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9217777745479627128L;
	
	QuickSavePage quickSavePage;
	NewSavingsAccountPage newSavingsAccountPage;

	@Step ("Select To Account Number '{0}'")
	public void selectToAccount(String index) {
		quickSavePage.selectToAccount(Integer.valueOf(index));
	}
	
	@Step ("Enter Amount '{0}'")
	public void enterAmount(String amount) {
		quickSavePage.enterAmount(amount);
	}

	@Step ("Click the Submit button")
	public void clickSubmit() {
		quickSavePage.clickSubmit();
	}

	@Step ("User is expected to be redirected to the View Savings Accounts page")
	public void redirectedToViewSavingsPage() {
		assertTrue(newSavingsAccountPage.atViewSavingsPage());
	}
	
}
