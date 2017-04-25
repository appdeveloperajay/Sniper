package com.eroticsniper.Beans;

import java.util.List;

/**
 * Created by Ajay2.Sharma on 13-04-2017.
 */

public class Retroresponse {

    public List<Services> getServices() {
        return Services;
    }

    public void setServices(List<Services> services) {
        this.Services = services;
    }

    private List<Services> Services;



    @Override
    public String toString()
    {
        return "ClassPojo [Services = "+Services+"]";
    }


}
