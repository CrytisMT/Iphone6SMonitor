package com.maitaidan.IPhoneMonitor.pojo;

/**
 * Created by Crytis on 2015/10/15.
 */
public interface IPhoneEnum {

    String getScreenSize();

    String getColor();

    String getCapacity();

    String getPartNumber();

    IPhoneEnum getEnumByPartName(String partNumber);

    String getName();

    IPhoneEnum getEnumByParam(String IPhoneColor, String IPhoneCapacity, String IPhoneScreenSize);
}
