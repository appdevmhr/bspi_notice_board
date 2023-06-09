package com.appdevmhr.bangladeshswedenpolytechnic.model;

public class ProbidanModel {
    String name,title,desc,url;

    public ProbidanModel(String name, String title, String desc) {
        this.name = name;
        this.title = title;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProbidanModel(String name, String title, String desc, String url) {
        this.name = name;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public ProbidanModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
