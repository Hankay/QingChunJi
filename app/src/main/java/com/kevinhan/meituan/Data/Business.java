package com.kevinhan.meituan.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Han on 2015/5/12.
 */
public class Business implements Serializable {
    private String status;
    private int total_count;
    private int count;
    private List<Businesses> businesses = new ArrayList<Businesses>();

    public Business(){}

    public Business(String status,int total_count,int count,List<Businesses> businesses){
        this.status = status;
        this.total_count = total_count;
        this.count = count;
        this.businesses = businesses;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Businesses> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Businesses> businesses) {
        this.businesses = businesses;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
