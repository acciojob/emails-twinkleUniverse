package com.driver;

import java.util.Date;

public class Mails {

    Date date;
    String sender;

//    public String getSender() {
//        return sender;
//    }

    public String getMessage() {
        return message;
    }

//    public Date getDate() {
//        return date;
//    }

    private String message;
    public Mails(Date date, String sender, String message){
        this.date=date;
        this.sender=sender;
        this.message=message;
    }
}
