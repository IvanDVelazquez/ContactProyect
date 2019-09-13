package com.example.solsticeprogrammingchallenge;

public class Info {
    private String tag;
    private String infoTag;
    private String type;

    public Info(String tag, String infoTag, String type) {
        this.tag = tag;
        this.infoTag = infoTag;
        this.type = type;
    }



    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getInfoTag() {
        return infoTag;
    }

    public void setInfoTag(String infoTag) {
        this.infoTag = infoTag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
