package com.maitaidan.IPhoneMonitor.pojo;

import com.maitaidan.IPhoneMonitor.util.OtherUtils;

/**
 * Created by Crytis on 2015/10/9.
 */
public class onlineTask {

    private String email;
    private IPhoneEnum iPhone;
    private String buyingUrl;


    public onlineTask(String email, IPhoneEnum iPhone) {
        this.email = email;
        this.iPhone = iPhone;
        this.buyingUrl = OtherUtils.generateBuyingUrl(iPhone);
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
        this.buyingUrl = OtherUtils.generateBuyingUrl(iPhone);
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
        if (!(o instanceof onlineTask)) return false;

        onlineTask that = (onlineTask) o;

        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getiPhone() != null ? !getiPhone().equals(that.getiPhone()) : that.getiPhone() != null) return false;
        return !(getBuyingUrl() != null ? !getBuyingUrl().equals(that.getBuyingUrl()) : that.getBuyingUrl() != null);

    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getiPhone() != null ? getiPhone().hashCode() : 0);
        result = 31 * result + (getBuyingUrl() != null ? getBuyingUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "onlineTask{" +
                "email='" + email + '\'' +
                ", iPhone=" + iPhone +
                '}';
    }

}
