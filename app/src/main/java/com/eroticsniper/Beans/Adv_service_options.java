package com.eroticsniper.Beans;

/**
 * Created by joshi on 4/20/2017.
 */

public class Adv_service_options
{
    private String option_Name;

    private String option_id;

    public String getOption_Name ()
    {
        return option_Name;
    }

    public void setOption_Name (String option_Name)
    {
        this.option_Name = option_Name;
    }

    public String getOption_id ()
    {
        return option_id;
    }

    public void setOption_id (String option_id)
    {
        this.option_id = option_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [option_Name = "+option_Name+", option_id = "+option_id+"]";
    }
}

