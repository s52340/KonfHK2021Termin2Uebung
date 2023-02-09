package org.campus02;

//Hashcode: git log = d68d3ee0de1eaff750ba79baf23462025be88032
public class PasswordValidation {

    private String password;


    public PasswordValidation(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean validateLength(){
        int passwordLength = password.length();
        if (passwordLength >= 8){
            return true;
        }
        else {
            return false;
        }
    }

    public int countUpperCaseLetters(){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char b = password.charAt(i);
            if (Character.isUpperCase(b)){
                count = count + 1;
            }
        }
        return count;
    }

    public int countLowerCaseLetters(){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char b = password.charAt(i);
            if (Character.isLowerCase(b)){
                count = count + 1;
            }
        }
        return count;
    }

    public int countSpecialSign(){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(Character.isLetter(c)){
                count = count;
            } else if (Character.isDigit(c)) {
                count = count;
            } else {
                count = count + 1;
            }
        }
        return count;
    }
    
    public int countNumbers(){
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char d = password.charAt(i);
            if (Character.isDigit(d)){
                count = count + 1;
            }
        }
        return count;
    }
    
    public byte validatePasswordStrength(){
        int passwordLength = password.length();
        int countUpperCase = countUpperCaseLetters();
        int countLowerCase = countUpperCaseLetters();
        int countNumb = countNumbers();
        int countSpecials = countSpecialSign();
        if (passwordLength <= 8){
            return 0;
        }
        else if (passwordLength > 8 && countUpperCase == 0 || passwordLength > 8 && countNumb == 0) {
            return 1;
        }
        else if (passwordLength > 8 && countUpperCase > 0 && countLowerCase >0 && countNumb >0
        || passwordLength > 8 && countUpperCase > 0 && countLowerCase >0 && countSpecials >0){
        return 2;
        } else if (passwordLength > 8 && countUpperCase > 0 &&
                countLowerCase > 0 && countNumb > 0 && countSpecials > 0) {
            return 3;
        }
        else {
            return 123;
        }
    }


}

