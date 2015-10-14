package com.maitaidan.flushIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/11.
 */
public enum cnIPhoneEnum implements IPhoneEnum{


    Silver16("ML7D2CH/A", "IPhone6S-银色-16GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity16),
    Silver64("ML7H2CH/A", "IPhone6S-银色-64GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity64),
    Silver128("ML7H2CH/A", "IPhone6S-银色-128GB", Parameters.IPhone6SScreenSize, Parameters.SilverColor, Parameters.Capacity128),
    Silver16Plus("ML6C2CH/A", "IPhone6S Plus-银色-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity16),
    Silver64Plus("ML6G2CH/A", "IPhone6S Plus-银色-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity64),
    Silver128Plus("ML6L2CH/A", "IPhone6S Plus-银色-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.SilverColor, Parameters.Capacity128),
    Gold16("ML7E2CH/A", "IPhone6S-土豪金-16GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity16),
    Gold64("ML7J2CH/A", "IPhone6S-土豪金-64GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity64),
    Gold128("ML7N2CH/A", "IPhone6S-土豪金-128GB", Parameters.IPhone6SScreenSize, Parameters.GoldColor, Parameters.Capacity128),
    Gold16Plus("ML6D2CH/A", "IPhone6S Plus-土豪金-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity16),
    Gold64Plus("ML6H2CH/A", "IPhone6S Plus-土豪金-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity64),
    Gold128Plus("ML6M2CH/A", "IPhone6S Plus-土豪金-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.GoldColor, Parameters.Capacity128),
    Gray16("ML7C2CH/A", "IPhone6S-深空灰-16GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity16),
    Gray64("ML7G2CH/A", "IPhone6S-深空灰-64GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity64),
    Gray128("ML7L2CH/A", "IPhone6S-深空灰-128GB", Parameters.IPhone6SScreenSize, Parameters.GrayColor, Parameters.Capacity128),
    Gray16Plus("ML6A2CH/A", "IPhone6S Plus-深空灰-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity16),
    Gray64Plus("ML6F2CH/A", "IPhone6S Plus-深空灰-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity64),
    Gray128Plus("ML6K2CH/A", "IPhone6S Plus-深空灰-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.GrayColor, Parameters.Capacity128),
    RoseGold16("ML7F2CH/A", "IPhone6S-玫瑰金-16GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity16),
    RoseGold64("ML7K2CH/A", "IPhone6S-玫瑰金-64GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity64),
    RoseGold128("ML7P2CH/A", "IPhone6S-玫瑰金-128GB", Parameters.IPhone6SScreenSize, Parameters.RoseGoldColor, Parameters.Capacity128),
    RoseGold16Plus("ML6E2CH/A", "IPhone6S Plus-玫瑰金-16GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity16),
    RoseGold64Plus("ML6J2CH/A", "IPhone6S Plus-玫瑰金-64GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity64),
    RoseGold128Plus("ML6N2CH/A", "IPhone6S Plus-玫瑰金-128GB", Parameters.IPhone6SPlusScreenSize, Parameters.RoseGoldColor, Parameters.Capacity128);

    private String partNumber;
    private String name;
    private String screenSize;
    private String color;
    private String capacity;

    cnIPhoneEnum(String partNumber, String name, String screenSize, String color, String capacity) {
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
        cnIPhoneEnum[] values = cnIPhoneEnum.values();
        for (cnIPhoneEnum value : values) {
            if (value.partNumber.equals(partNumber)) {
                return value.name;
            }
        }

        return "找不到此型号！";
    }

    public IPhoneEnum getEnumByPartName(String partNumber) {
        cnIPhoneEnum[] values = cnIPhoneEnum.values();
        for (cnIPhoneEnum value : values) {
            if (value.partNumber.equals(partNumber)) {
                return value;
            }
        }
        return null;
    }
}
