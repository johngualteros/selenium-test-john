package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQaTests {

    @Test
    public void clickOnAlertsFrameAndWindows() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jumbo170\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com");

        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement stringElement =  driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(stringElement);
        actions.click().perform();

        assertEquals("https://demoqa.com/alertsWindows", driver.getCurrentUrl());
    }

    @Test
    public void clickOnLeftPanelTextAlerts() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jumbo170\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alertsWindows");

        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement listElement =  driver.findElement(By.xpath("//li[@id='item-2']"));

        WebElement spanText = listElement.findElement(By.xpath("//span[text()='Alerts']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(spanText);
        actions.click().perform();

        assertEquals("https://demoqa.com/alerts", driver.getCurrentUrl());
    }

    @Test
    public void validateTheCorrectFunctionalitiesOfButtons() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jumbo170\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");

        WebElement alertButton =  driver.findElement(By.xpath("//button[@id='alertButton']"));

        alertButton.click();

        //Validate if alerts exists
        Alert alert = driver.switchTo().alert();

        assertEquals("You clicked a button", alert.getText());

        alert.accept();

        //second button
        WebElement alertButtonFiveSecondsDelay = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));

        alertButtonFiveSecondsDelay.click();

        Thread.sleep(5000);

        //validate if alert appears after pass five seconds

        Alert alertDelay = driver.switchTo().alert();

        assertEquals("This alert appeared after 5 seconds", alert.getText());

        alertDelay.accept();

        //third button
        WebElement alertConfirmationButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));

        alertConfirmationButton.click();

        Alert confirmationAlert = driver.switchTo().alert();

        confirmationAlert.accept();

        WebElement validateIfTheMessageAppearCorrectlyWhichConfirmAlert =
                driver.findElement(By.xpath("//span[@id='confirmResult']"));

        assertEquals("You selected Ok", validateIfTheMessageAppearCorrectlyWhichConfirmAlert.getText());

        //Fourth button
        WebElement promtButton = driver.findElement(By.xpath("//button[@id='promtButton']"));

        promtButton.click();

        Alert promptAlert = driver.switchTo().alert();

        promptAlert.sendKeys("John Gualteros");

        promptAlert.accept();

        WebElement validateIfTheMessageAppearCorrectlyWhichPromptInput =
                driver.findElement(By.xpath("//span[@id='promptResult']"));

        assertEquals("You entered John Gualteros", validateIfTheMessageAppearCorrectlyWhichPromptInput.getText());

    }
}
