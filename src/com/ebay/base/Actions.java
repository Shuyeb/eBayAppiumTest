package com.ebay.base;

import static com.ebay.base.ConstantRepository.SearchBox;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


// This class file has the common actions/functions that will be called into the main script

public class Actions {
	TouchAction touchAction;
	public Actions(AndroidDriver<AndroidElement> driver) {
		loadProperties();
		touchAction = new TouchAction(driver);
	}
	Properties prop;
	public Properties loadProperties() {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\Config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	public String readProperty(String property) {
		return prop.getProperty(property);
	}
	public void scroll(WebElement Name, WebElement SearchBox ) {
		touchAction.longPress(element(Name)).moveTo(element(SearchBox)).release().perform();
	}
	public void tap(WebElement tapElementName) {
		touchAction.tap(tapOptions().withElement(element(tapElementName))).perform();
	}
}
