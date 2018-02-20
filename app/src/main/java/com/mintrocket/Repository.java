package com.mintrocket;


import com.google.gson.annotations.SerializedName;

public class Repository {

    private long id;
    private String name;
    private Owner owner;
    private String description;
    @SerializedName("html_url")
    private String htmlUrl;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getHtmlUrl() {
        return htmlUrl;
    }
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
