package com.maitaidan.IPhoneMonitor.pojo;

import java.util.HashSet;

/**
 * Created by Crytis on 2015/10/12.
 * 是否可以购买的状态
 */
public class IPhoneStatus {
    private String partNumer;
    private String iphoneName;
    private boolean isOnline;
    private boolean isInStore;
    private String buyingUrl;
    private HashSet<String> availableStore;

    public IPhoneStatus() {
        super();
    }

    public IPhoneStatus(String partNumer, String iphoneName, boolean isOnline, boolean isInStore, String buyingUrl, HashSet<String> availableStore) {
        this.partNumer = partNumer;
        this.iphoneName = iphoneName;
        this.isOnline = isOnline;
        this.isInStore = isInStore;
        this.buyingUrl = buyingUrl;
        this.availableStore = availableStore;
    }

    public IPhoneStatus(String partNumer, String iphoneName, boolean isOnline, String buyingUrl) {
        this.partNumer = partNumer;
        this.iphoneName = iphoneName;
        this.isOnline = isOnline;
        this.buyingUrl = buyingUrl;
    }

    public String getIphoneName() {
        return iphoneName;
    }

    public void setIphoneName(String iphoneName) {
        this.iphoneName = iphoneName;
    }

    public String getPartNumer() {
        return partNumer;
    }

    public void setPartNumer(String partNumer) {
        this.partNumer = partNumer;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setIsInStore(boolean isInStore) {
        this.isInStore = isInStore;
    }

    public String getBuyingUrl() {
        return buyingUrl;
    }

    public void setBuyingUrl(String buyingUrl) {
        this.buyingUrl = buyingUrl;
    }

    public HashSet<String> getAvailableStore() {
        return availableStore;
    }

    public void setAvailableStore(HashSet<String> availableStore) {
        this.availableStore = availableStore;
    }
}
