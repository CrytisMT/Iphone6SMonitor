package com.maitaidan.refreshIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/12.
 * hk apple store
 */
public enum HKStoreEnum implements StoreEnum {

    CantonRoad("R499", "香港", "CantonRoad"),
    CausewayBay("R409", "香港", "CausewayBay"),
    FestivalWalk("R485", "香港", "FestivalWalk"),
    ifcmall("R428", "香港", "ifc mall");

    private String storeNo;
    private String city;
    private String address;

    HKStoreEnum(String storeNo, String city, String address) {
        this.storeNo = storeNo;
        this.city = city;
        this.address = address;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
