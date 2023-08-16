package com.chrisloarryn.springboot.mycoolapp.rest.domain;

public class Dinosaur {
    // link and name
    private String link;
    private String name;

    public Dinosaur() {
    }

    public Dinosaur(String link, String name) {
        this.link = link;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dinosaur{");
        sb.append("link='").append(link).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
