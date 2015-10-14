package com.maitaidan.flushIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/11.
 */
public enum hkIPhoneEnum {


    Silver16("MKQK2ZP/A", "IPhone6S-银色-16GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity16),
    Silver64("MKQP2ZP/A", "IPhone6S-银色-64GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity64),
    Silver128("MKQU2ZP/A", "IPhone6S-银色-128GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity128),
    Silver16Plus("MKU22ZP/A", "IPhone6S Plus-银色-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity16),
    Silver64Plus("MKU72ZP/A", "IPhone6S Plus-银色-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity64),
    Silver128Plus("MKUE2ZP/A", "IPhone6S Plus-银色-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity128),
    Gold16("MKQL2ZP/A", "IPhone6S-土豪金-16GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity16),
    Gold64("MKQQ2ZP/A", "IPhone6S-土豪金-64GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity64),
    Gold128("MKQV2ZP/A", "IPhone6S-土豪金-128GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity128),
    Gold16Plus("MKU32ZP/A", "IPhone6S Plus-土豪金-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity16),
    Gold64Plus("MKU82ZP/A", "IPhone6S Plus-土豪金-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity64),
    Gold128Plus("MKUF2ZP/A", "IPhone6S Plus-土豪金-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity128),
    Gray16("MKQJ2ZP/A", "IPhone6S-深空灰-16GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity16),
    Gray64("MKQN2ZP/A", "IPhone6S-深空灰-64GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity64),
    Gray128("MKQT2ZP/A", "IPhone6S-深空灰-128GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity128),
    Gray16Plus("MKU12ZP/A", "IPhone6S Plus-深空灰-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity16),
    Gray64Plus("MKU62ZP/A", "IPhone6S Plus-深空灰-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity64),
    Gray128Plus("MKUD2ZP/A", "IPhone6S Plus-深空灰-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity128),
    RoseGold16("MKQM2ZP/A", "IPhone6S-玫瑰金-16GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity16),
    RoseGold64("MKQR2ZP/A", "IPhone6S-玫瑰金-64GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity64),
    RoseGold128("MKQW2ZP/A", "IPhone6S-玫瑰金-128GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity128),
    RoseGold16Plus("MKU52ZP/A", "IPhone6S Plus-玫瑰金-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity16),
    RoseGold64Plus("MKU92ZP/A", "IPhone6S Plus-玫瑰金-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity64),
    RoseGold128Plus("MKUG2ZP/A", "IPhone6S Plus-玫瑰金-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity128);

    private String partNumber;
    private String name;
    private String screenSize;
    private String color;
    private String capacity;

    hkIPhoneEnum(String partNumber, String name, String screenSize, String color, String capacity) {
        this.partNumber = partNumber;
        this.name = name;
        this.screenSize = screenSize;
        this.color = color;
        this.capacity = capacity;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getNameByPartName(String partNumber) {
        hkIPhoneEnum[] values = hkIPhoneEnum.values();
        for (hkIPhoneEnum value : values) {
            if (value.partNumber.equals(partNumber)) {
                return value.name;
            }
        }

        return "找不到此型号！";
    }
}
