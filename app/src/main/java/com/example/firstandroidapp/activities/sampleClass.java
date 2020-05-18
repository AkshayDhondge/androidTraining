package com.example.firstandroidapp.activities;



public class sampleClass {
     boolean isValidEmailInJava(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}

