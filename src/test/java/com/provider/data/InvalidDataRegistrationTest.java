package com.provider.data;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class InvalidDataRegistrationTest extends BasePageObject{

    @DataProvider(name="invalidDataSet")
    public static Object[][] invalidStudentsDataProvider() {

        return new Object[][]{

                {"1%!:()<>&", "1%!:()<>&", "@name</.","123456789","?","gender-radio-1"},
                {"1%!:()<>&", "1%!:()<>&", "name@example.com", "1234567890",
                 "3 Store, 311-318 High Holborn, London, WC1V 7BN","gender-radio-1"}

        };

    }

    @Test (dataProvider="invalidDataSet")
    public void invalidValuesFilledInFieldsInRegistrationFormTest(String firstNameText, String lastNameText,
                String eMailText,String phoneNumber, String address, String genderSelector) {

        BasePageObject base = new BasePageObject();
        base.firstNameInput(firstNameText);
        base.lastNameInput(lastNameText);
        base.eMailInput(eMailText);
        base.mobilePhoneInput(phoneNumber);
        base.setAddressInput(address);
        base.genderSelect(genderSelector);
        base.submitClick();
        base.assertFalseSubmissionCheck();

    }

    @Ignore //The test below is ignored as a duplication of the test from @DataProvider
    public void invalidNamesValuesFilledInRegistrationFormTest() {

        BasePageObject base = new BasePageObject();

        base.firstNameInput("1%!:()<>&");
        base.lastNameInput("1%!:()<>&");
        base.eMailInput("name@example.com");
        base.mobilePhoneInput("1234567890");
        base.setAddressInput("3 Store, 311-318 High Holborn, London, WC1V 7BN");
        base.genderSelect("gender-radio-1");
        base.submitClick();
        base.assertFalseSubmissionCheck();

    }
}
