package com.maitaidan.refreshIPhone.pojo;

import com.maitaidan.refreshIPhone.util.OtherUtils;

import java.util.Arrays;

/**
 * Created by Crytis on 2015/11/4.
 */
public class storeTask {

    private String email;
    private IPhoneEnum iPhone;
    private String buyingUrl;
    private String[] stores;
    private String region;

    @Override
    public String toString() {
        return "storeTask{" +
                "email='" + email + '\'' +
                ", iPhone=" + iPhone +
                ", buyingUrl='" + buyingUrl + '\'' +
                ", stores=" + Arrays.toString(stores) +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        storeTask storeTask = (storeTask) o;

        if (!email.equals(storeTask.email)) return false;
        if (!iPhone.equals(storeTask.iPhone)) return false;
        if (!buyingUrl.equals(storeTask.buyingUrl)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(stores, storeTask.getStores())) return false;
        return region.equals(storeTask.region);

    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + iPhone.hashCode();
        result = 31 * result + buyingUrl.hashCode();
        result = 31 * result + Arrays.hashCode(stores);
        result = 31 * result + region.hashCode();
        return result;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String[] getStores() {
        return stores;
    }

    public void setStores(String[] stores) {
        this.stores = stores;
    }

    public storeTask(String email, IPhoneEnum iPhone, String[] stores, String region) {

        this.email = email;
        this.iPhone = iPhone;
        this.stores = stores;
        this.region = region;
        this.buyingUrl = OtherUtils.generateBuyingUrl(iPhone);
    }
}
