package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {

    //Private member variables accessible only through getters and setters
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    //Default constructor
    public AddressBook() {
        name = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
        email = "";

    }

    //Setters and getters
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setAddress(String a) {
        address = a;
    }
    public String getAddress() {
        return address;
    }
    public void setCity(String c) {
        city = c;
    }
    public String getCity() {
        return city;
    }
    public void setState(String s) {
        state = s;
    }
    public String getState() {
        return state;
    }
    public void setZip(String z) {
        zip = z;
    }
    public String getZip() {
        return zip;
    }
    public boolean setPhone(String p) {
        boolean value = false;
        if(value = isPhoneNumberValid(p)) {
            phone = p;
        }
        return value;
    }
    public String getPhone() {
        return phone;
    }
    public boolean setEmail(String e) {
        boolean value = false;
        if(value = isEmailValid(e)) {
            email = e;
        }
        return value;
    }
    public String getEmail() {
        return email;
    }
    public String displayAddressBook() {
        String s = ""+getName() +"\n" +getAddress() +" " +"\n" +getCity() +", "+getState()
                     +" "+getZip() +"\n" +getPhone() +"\n" +getEmail();
        return s;
    }
    private boolean isEmailValid(String email){
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        boolean isValid = false;

        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
}
