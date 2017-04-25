package com.eroticsniper.Beans;

/**
 * Created by joshi on 4/10/2017.
 */

public class Category {
    private String Have_services;

    private String Cat_name;

    private String Cat_id;

    private String Have_advanceservices;

    private String Cat_type;

    public String getHave_services ()
    {
        return Have_services;
    }

    public void setHave_services (String Have_services)
    {
        this.Have_services = Have_services;
    }

    public String getCat_name ()
    {
        return Cat_name;
    }

    public void setCat_name (String Cat_name)
    {
        this.Cat_name = Cat_name;
    }

    public String getCat_id ()
    {
        return Cat_id;
    }

    public void setCat_id (String Cat_id)
    {
        this.Cat_id = Cat_id;
    }

    public String getHave_advanceservices ()
    {
        return Have_advanceservices;
    }

    public void setHave_advanceservices (String Have_advanceservices)
    {
        this.Have_advanceservices = Have_advanceservices;
    }

    public String getCat_type ()
    {
        return Cat_type;
    }

    public void setCat_type (String Cat_type)
    {
        this.Cat_type = Cat_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Have_services = "+Have_services+", Cat_name = "+Cat_name+", Cat_id = "+Cat_id+", Have_advanceservices = "+Have_advanceservices+", Cat_type = "+Cat_type+"]";
    }

}
