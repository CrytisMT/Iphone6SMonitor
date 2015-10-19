package com.maitaidan.refreshIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public class IPhoneTask {
    // 想去哪个店的关键词
    private String keyword;
    private String email;
    private IPhoneEnum iPhone;
    private String buyingUrl;


    public IPhoneTask(String keyword, String email, IPhoneEnum iPhone) {
        this.keyword = keyword;
        this.email = email;
        this.iPhone = iPhone;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IPhoneEnum getiPhone() {
        return iPhone;
    }

    public void setiPhone(IPhoneEnum iPhone) {
        this.iPhone = iPhone;
    }

    public String getBuyingUrl() {
        return buyingUrl;
    }

    public void setBuyingUrl(String buyingUrl) {
        this.buyingUrl = buyingUrl;
    }
}
