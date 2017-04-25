package com.eroticsniper.Beans;

import java.util.List;

/**
 * Created by joshi on 4/20/2017.
 */

public class AdvCategoryResp
{
    public List<com.eroticsniper.Beans.Filter> getFilter() {
        return Filter;
    }

    public void setFilter(List<com.eroticsniper.Beans.Filter> filter) {
        Filter = filter;
    }

    private List<Filter> Filter;


    @Override
    public String toString()
    {
        return "ClassPojo [Filter = "+Filter+"]";
    }
}
