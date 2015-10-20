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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IPhoneTask)) return false;

        IPhoneTask that = (IPhoneTask) o;

        if (getKeyword() != null ? !getKeyword().equals(that.getKeyword()) : that.getKeyword() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getiPhone() != null ? !getiPhone().equals(that.getiPhone()) : that.getiPhone() != null) return false;
        return !(getBuyingUrl() != null ? !getBuyingUrl().equals(that.getBuyingUrl()) : that.getBuyingUrl() != null);

    }

    @Override
    public int hashCode() {
        int result = getKeyword() != null ? getKeyword().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getiPhone() != null ? getiPhone().hashCode() : 0);
        result = 31 * result + (getBuyingUrl() != null ? getBuyingUrl().hashCode() : 0);
        return result;
    }
}
