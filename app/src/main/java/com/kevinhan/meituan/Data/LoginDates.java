package com.kevinhan.meituan.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin han on 2015/5/27.
 */
public class LoginDates implements Serializable {
    private String status;
    private List<Login> login = new ArrayList<Login>();

    public LoginDates(){
    }

    public LoginDates(String status,List<Login> login){
        this.status = status;
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Login> getLogin() {
        return login;
    }

    public void setLogin(List<Login> login) {
        this.login = login;
    }
}
