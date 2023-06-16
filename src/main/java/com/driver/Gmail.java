package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    Map<String,Mails>Inbox=new LinkedHashMap<>();

    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    Map<String,Mails>Trash=new LinkedHashMap<>();

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mails newMail=new Mails(date, sender, message);
        if(Inbox.size()>=inboxCapacity){
          String old_msg=findOldestMessage();
          Trash.put(old_msg,Inbox.get(old_msg));
          Inbox.remove(old_msg);
        }
        Inbox.put(message,newMail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

            if(Inbox.containsKey(message)){
                Trash.put(message,Inbox.get(message));
                Inbox.remove(message);
            }


    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.isEmpty())return null;
        String LatestMessage="";
        for(String msg:Inbox.keySet()){
          LatestMessage=msg;
        }
        return LatestMessage;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(Inbox.isEmpty())return null;
        String OldestMessage="";
        for(String msg: Inbox.keySet()){
            OldestMessage=msg;
            break;
        }
       return OldestMessage;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        for(String msg: Inbox.keySet()) {
          Mails mail=Inbox.get(msg);
          if(mail.date.equals(start)||mail.date.equals(end)||(mail.date.after(start)&&mail.date.before(end)))
              count++;
        }
         return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
         return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
