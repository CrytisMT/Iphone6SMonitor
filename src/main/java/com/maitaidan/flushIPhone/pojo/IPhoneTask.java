package com.maitaidan.flushIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public class IPhoneTask {
    private String color;
    private Integer size;
    private String type;
    // 想去哪个店的关键词
    private String keyword;
    private String email;

    public IPhoneTask(String color, Integer size, String type, String keyword, String email) {
        this.color = color;
        this.size = size;
        this.type = type;
        this.keyword = keyword;
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
