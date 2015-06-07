package com.kevinhan.meituan.Data;

import java.io.Serializable;

/**
 * Created by Kevin Han on 2015/5/27.
 */
public class Login implements Serializable {
    private String password;
    private String name;

    public Login(){

    }

    public Login(String password, String name){
        this.password = password;
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
