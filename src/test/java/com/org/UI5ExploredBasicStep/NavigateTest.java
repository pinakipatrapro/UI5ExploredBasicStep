package com.org.UI5ExploredBasicStep;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.org.UI5ExploredBasicStep.util.LoadDrivers;
import com.org.UI5ExploredBasicStep.util.ElementHelper;

public class NavigateTest {

	public ElementHelper search(String searchString,WebDriver wd) {
		//Load Element Helper
		ElementHelper eh = new ElementHelper();
		eh.getElementById("sdk---app--searchControl-openingBtn-img", wd).click();
		eh.getElementById("sdk---app--searchControl-searchField-I", wd).sendKeys(searchString);
		eh.getElementById("sdk---app--searchControl-searchField-search", wd).click();
		return eh;
	}
	@Test
	public void navigateToPage() {
		//Load Drivers
		LoadDrivers drivers = new LoadDrivers();
		WebDriver wd = drivers.openUrl("https://sapui5.hana.ondemand.com");
		ElementHelper eh = this.search("Fragment", wd);

		String Path = "//*[@id='sdk---searchPage--allList-listUl']/descendant::a[contains(.,'Creating Custom Filter')]";
		eh.getElementByXpath(Path,wd).click();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.close();
	}
}
