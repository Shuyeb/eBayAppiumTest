package com.ebay.search.main;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebay.base.Actions;
import com.ebay.base.ConstantRepository;
import com.ebay.base.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BuyProduct extends com.ebay.base.Base   {
	
	    @Test
		public static void Testing() throws InterruptedException, FileNotFoundException, IOException {
			//This is the main script
			AndroidDriver<AndroidElement> driver = Capabilities();
			Actions act = new Actions(driver);
			Utilities utilities = new Utilities();
			ConstantRepository constants = new ConstantRepository();
			//Implicit wait assignment
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			System.out.println("Ebay application is accessed");
			WebElement MoreLink = driver.findElementByAndroidUIAutomator(constants.MoreLink);
			WebElement SearchBox = driver.findElementByAndroidUIAutomator(constants.SearchBox);
			Assert.assertEquals(MoreLink.isDisplayed(), true);
			System.out.println("Homepage is shown");
			//Scroll method to scroll the UI	
			act.scroll(MoreLink, SearchBox);
			System.out.println("Screen is Scrolled successfully");
			WebElement HomeIcon = driver.findElementByXPath(constants.HomeIcon);
			HomeIcon.click();
			HomeIcon.click();
			WebElement EmailID1 = driver.findElementByAndroidUIAutomator(constants.EmailIDfield);
			EmailID1.sendKeys(act.readProperty("Email"));
			WebElement Password = driver.findElementByAndroidUIAutomator(constants.Password);
			Password.sendKeys(Utilities.Password());
			driver.findElementByAndroidUIAutomator(constants.SignIn).click();
			System.out.println("SignIn button is clicked for logging in");
			driver.findElementByAndroidUIAutomator(constants.NoThanksButton).click();
			System.out.println("User logged in successfully");
			WebElement SearchIcon = driver.findElementByXPath(constants.SearchIcon);
			SearchIcon.click();
			driver.findElementByAndroidUIAutomator(constants.SearchBox).sendKeys(act.readProperty("Product"));
			driver.findElementByXPath(constants.AutoSuggestion).click();
			System.out.println("User search for the product");
			driver.findElementByAndroidUIAutomator(constants.ProductResult).click();
			System.out.println("Search results are shown");
			boolean addElement=true;
			WebElement AddToCart= null;
			WebElement ViewCart = null;
			WebElement Watch = null;
			//Adding a Try catch block to handle the scenario where the product is already added to the cart
			try
			{
			AddToCart = driver.findElementByAndroidUIAutomator(constants.AddToCart);
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Add to Cart button is not found, hence viewing the cart");
				addElement = false;
			}
			if(!addElement)
			{	
				ViewCart = driver.findElementByAndroidUIAutomator(constants.ViewInCart);
				Watch = driver.findElementByAndroidUIAutomator(constants.WatchButton);	
				act.scroll(Watch, ViewCart);
				//Script taps the View Cart link
				act.tap(ViewCart);
			}
			else
			{
				Thread.sleep(5000);
				//Script taps the Add to Cart lin
				act.tap(AddToCart);
				System.out.println("Clicked AddtoCart");
				ViewCart = driver.findElementByAndroidUIAutomator(constants.ViewInCart);
				Watch = driver.findElementByAndroidUIAutomator(constants.WatchButton);	
				//Scroll method to scroll the UI
				act.scroll(Watch, ViewCart);
				System.out.println("Screen is Scrolled to show Watch button");
				act.tap(ViewCart);
			}
			//Script now clicks on Checkout button
			System.out.println("View Cart is clicked to see the items");
			WebElement CheckOut = driver.findElementByAndroidUIAutomator(constants.CheckOutButton);
			System.out.println("Tapping on Checkout");
			act.tap(CheckOut);			
			System.out.println("Checkout successful");
		}

	}

