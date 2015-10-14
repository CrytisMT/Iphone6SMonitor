package com.maitaidan.flushIPhone.pojo;

/**
 * Created by Crytis on 2015/10/15.
 */
public interface IPhoneEnum {
    String getScreenSize();

    String getColor();

    String getCapacity();

    String getPartNumber();

    public IPhoneEnum getEnumByPartName(String partNumber);
}
