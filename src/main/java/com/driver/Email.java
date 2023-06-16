package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character


        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:

        if(oldPassword.equals(this.password)){

            // 1. It contains at least 8 characters
            if(newPassword.length()>=8){
                boolean Upper_letter=false;
                boolean Lower_letter=false;
                boolean Digits=false;
                boolean special_charater=false;
                for(int i=0;i<newPassword.length();i++){
                    char ch=newPassword.charAt(i);
                    if(ch>=65||ch<=90){             // 2. It contains at least one uppercase letter
                        Upper_letter=true;
                        continue;
                    }else if(ch>=97||ch<=122){      // 3. It contains at least one lowercase letter
                        Lower_letter=true;
                        continue;
                    }else if(ch>=48||ch<=57){       // 4. It contains at least one digit
                        Digits=true;
                        continue;
                    }else
                        special_charater=true;      // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
                }
                if(Upper_letter&&Lower_letter&&Digits&&special_charater){
                    this.password=newPassword;
                }
            }
        }
    }
}
