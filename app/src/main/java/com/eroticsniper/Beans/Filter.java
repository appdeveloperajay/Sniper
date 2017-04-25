package com.eroticsniper.Beans;

import java.util.List;

/**
 * Created by joshi on 4/20/2017.
 */

public class Filter
{
    public String getAdv_service_id() {
        return Adv_service_id;
    }

    public void setAdv_service_id(String adv_service_id) {
        Adv_service_id = adv_service_id;
    }

    public List<com.eroticsniper.Beans.Adv_service_options> getAdv_service_options() {
        return Adv_service_options;
    }

    public void setAdv_service_options(List<com.eroticsniper.Beans.Adv_service_options> adv_service_options) {
        Adv_service_options = adv_service_options;
    }

    public String getAdv_service_name() {
        return Adv_service_name;
    }

    public void setAdv_service_name(String adv_service_name) {
        Adv_service_name = adv_service_name;
    }

    private String Adv_service_id;

    private List<Adv_service_options> Adv_service_options;

    private String Adv_service_name;



    @Override
    public String toString()
    {
        return "ClassPojo [Adv_service_id = "+Adv_service_id+", Adv_service_options = "+Adv_service_options+", Adv_service_name = "+Adv_service_name+"]";
    }
}


