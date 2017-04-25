package com.eroticsniper.Beans;

import java.util.List;

/**
 * Created by joshi on 4/11/2017.
 */

public class CategoryResp {

    public List<com.eroticsniper.Beans.Category> getCategory() {
        return Category;
    }

    public void setCategory(List<com.eroticsniper.Beans.Category> category) {
        Category = category;
    }

    private List<Category> Category;


    @Override
    public String toString()
    {
        return "ClassPojo [Category = "+Category+"]";
    }
}
