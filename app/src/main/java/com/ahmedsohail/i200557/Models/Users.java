package com.ahmedsohail.i200557.Models;


public class Users {

    String profilePic,userName,password,email,contact;
    public Users(){};

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public Users(String profilePic, String userName, String password, String email, String contact) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }
}
