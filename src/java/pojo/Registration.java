/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Clay
 */
public class Registration {

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
 public String getName() {
        return name;
    }

    public long getContact() {
        return contact;
    }

    String userid,name,password;
    long contact;
    
}
