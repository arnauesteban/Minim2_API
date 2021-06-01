package edu.upc.dsa.models;

public class Badge {

    private String name;
    private String url;

    public Badge(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Badge(){}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getName()
    {
        return this.name;
    }
    public String getUrl()
    {
        return this.url;
    }

}