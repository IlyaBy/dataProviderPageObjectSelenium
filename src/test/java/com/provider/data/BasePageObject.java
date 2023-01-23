package com.provider.data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BasePageObject extends CommonDriverData{
    private By firstNameInput = By.xpath("//input[@id='firstName']");
    private By lastNameInput = By.xpath("//input[@id='lastName']");
    private By eMailInput = By.xpath("//input[@id='userEmail']");
    private By mobilePhoneInput = By.xpath("//input[@id='userNumber']");
    private By dateOfBirth = By.xpath("//input[@id='dateOfBirthInput']");
    private By subjectInput = By.xpath("//input[@id='subjectsInput']");
    private By submitConfirmation = By.xpath("//div[text()='Thanks for submitting the form']");
    private By addressInput = By.xpath("//textarea[@id='currentAddress']");
    private By submitButton = By.id("submit");
    private By StudentNameAfterSubmission = By.xpath("//td[text()='Lu- Kang']");



    public void firstNameInput(String firstNameText){
        driver.findElement(firstNameInput).sendKeys(firstNameText);
    }

    public void lastNameInput(String lastNameText){
        driver.findElement(lastNameInput).sendKeys(lastNameText);
    }

    public void eMailInput(String emailText){
        driver.findElement(eMailInput).sendKeys(emailText);
    }

    public void mobilePhoneInput(String phoneNumber){ driver.findElement(mobilePhoneInput).sendKeys(phoneNumber);}

    public void subjectInput(String subjectName){
        driver.findElement(subjectInput).sendKeys(subjectName,Keys.ARROW_DOWN);
        driver.findElement(subjectInput).sendKeys(Keys.ENTER);
    }

    public void setAddressInput(String address){
        driver.findElement(addressInput).sendKeys(address);
    }

    public void genderSelect(String genderSelector){
        WebElement genderInput = driver.findElement(By.id(genderSelector)); //input[@id='gender-radio-1']
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();
    }
    public void hobbySelect(String hobby){
        WebElement hobbiesInput = driver.findElement(By.id(hobby));//input[@id='hobbies-checkbox-1']
        Actions hobbiesAction = new Actions(driver);
        hobbiesAction.moveToElement(hobbiesInput).click().perform();
    }

    public void submitClick(){
        driver.findElement(submitButton).submit();
    }

    public void assertSubmission(){
        try{
        Assert.assertEquals("Thanks for submitting the form",driver.findElement(submitConfirmation).getText());
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
        public void assertFalseSubmissionCheck() {
            try{
        Assert.assertFalse(driver.findElement(submitConfirmation).isDisplayed());
            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
    }
}
