package com.eroticsniper.Beans;

/**
 * Created by Ajay2.Sharma on 13-04-2017.
 */

public class Services {
    private String Service_name;

    private String Service_id;

    public String getService_name ()
    {
        return Service_name;
    }

    public void setService_name (String Service_name)
    {
        this.Service_name = Service_name;
    }

    public String getService_id ()
    {
        return Service_id;
    }

    public void setService_id (String Service_id)
    {
        this.Service_id = Service_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Service_name = "+Service_name+", Service_id = "+Service_id+"]";
    }

}
