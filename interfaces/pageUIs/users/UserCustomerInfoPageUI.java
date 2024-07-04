package pageUIs.users;

import commons.BasePage;

public class UserCustomerInfoPageUI extends BasePage {
    public static final String GENDER_MALE_RADIO = "xpath=//input[@id='gender-male']";
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String DAY_DROPDOWN = "name=DateOfBirthDay";
    public static final String MONTH_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
    public static final String YEAR_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";
    public static final String EMAIL_TEXTBOX = "Css=input[id='Email']";
    public static final String COMPANY_TEXTBOX = "xpath=//input[@id='Company']";

//    public static final String ADDRESS_LINK = "//div[contains(@class, 'block-account-navigation')]//a[text()='Addresses']";
}
