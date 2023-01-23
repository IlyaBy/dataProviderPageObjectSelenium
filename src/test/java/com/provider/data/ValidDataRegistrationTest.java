package com.provider.data;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


    public class ValidDataRegistrationTest extends BasePageObject{

        @Test
        public void TestValidValuesFilledInCompulsoryFieldsRegistrationForm() {

            BasePageObject base = new BasePageObject();

            base.firstNameInput("Lu-");
            base.lastNameInput("Kang");
            base.eMailInput("name@example.com");
            base.mobilePhoneInput("1234567890");
            base.setAddressInput("3 Store, 311-318 High Holborn, London, WC1V 7BN");
            base.subjectInput("Math");
            base.genderSelect("gender-radio-1");
            base.submitClick();
            base.assertSubmission();

        }

        @DataProvider (name="validDataSet")
        public static Object[][] differentStudentsDataProvider() {

            return new Object[][]{

                    {"Sonya-", "Blade", "name@example.com","1234567890","Economics","gender-radio-2","hobbies-checkbox-2"},
                    {"Conchita-", "Wurst", "name@example.com", "1234567890", "Computer Science","gender-radio-3","hobbies-checkbox-3"},
                    {"Lu-", "Kang", "name@example.com","1234567890","Maths","gender-radio-1","hobbies-checkbox-1"}
            };

        }

        @Test (dataProvider="validDataSet")
        public void differentValidStudentsDataFilledInRegistrationFormTest(String firstNameText, String lastNameText, String eMailText,String phoneNumber,
                                         String subjectName,String genderSelector, String hobby) {
            BasePageObject basePro = new BasePageObject();
            basePro.firstNameInput(firstNameText);
            basePro.lastNameInput(lastNameText);
            basePro.eMailInput(eMailText);
            basePro.mobilePhoneInput(phoneNumber);
            basePro.subjectInput(subjectName);
            basePro.genderSelect(genderSelector);
            basePro.hobbySelect(hobby);
            basePro.submitClick();
            basePro.assertSubmission();

        }
        }



