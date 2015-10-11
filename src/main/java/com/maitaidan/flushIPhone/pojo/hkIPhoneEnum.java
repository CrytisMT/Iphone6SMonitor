package com.maitaidan.flushIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/11.
 */
public enum hkIPhoneEnum {


    Sliver16("ML7E2CH/A", "IPhone6S-银色-16GB"),
    Sliver64("ML7E2CH/A", "IPhone6S-银色-64GB"),
    Sliver128("ML7E2CH/A", "IPhone6S-银色-128GB"),
    Sliver16Plus("ML7E2CH/A", "IPhone6S Plus-银色-16GB"),
    Sliver64Plus("ML7E2CH/A", "IPhone6S Plus-银色-64GB"),
    Sliver128Plus("ML7E2CH/A", "IPhone6S Plus-银色-128GB"),
    Gold16("ML7E2CH/A", "IPhone6S-土豪金-16GB"),
    Gold64("ML7E2CH/A", "IPhone6S-土豪金-64GB"),
    Gold128("ML7E2CH/A", "IPhone6S-土豪金-128GB"),
    Gold16Plus("ML7E2CH/A", "IPhone6S Plus-土豪金-16GB"),
    Gold64Plus("ML7E2CH/A", "IPhone6S Plus-土豪金-64GB"),
    Gold128Plus("ML7E2CH/A", "IPhone6S Plus-土豪金-128GB"),
    Gray16("ML7E2CH/A", "IPhone6S-深空灰-16GB"),
    Gray64("ML7E2CH/A", "IPhone6S-深空灰-64GB"),
    Gray128("ML7E2CH/A", "IPhone6S-深空灰-128GB"),
    Gray16Plus("ML7E2CH/A", "IPhone6S Plus-深空灰-16GB"),
    Gray64Plus("ML7E2CH/A", "IPhone6S Plus-深空灰-64GB"),
    Gray128Plus("ML7E2CH/A", "IPhone6S Plus-深空灰-128GB"),
    RoseGold16("ML7E2CH/A", "IPhone6S-玫瑰金-16GB"),
    RoseGold64("ML7E2CH/A", "IPhone6S-玫瑰金-64GB"),
    RoseGold128("ML7E2CH/A", "IPhone6S-玫瑰金-128GB"),
    RoseGold16Plus("ML7E2CH/A", "IPhone6S Plus-玫瑰金-16GB"),
    RoseGold64Plus("ML7E2CH/A", "IPhone6S Plus-玫瑰金-64GB"),
    RoseGold128Plus("ML7E2CH/A", "IPhone6S Plus-玫瑰金-128GB");

    private String partNumber;
    private String name;

    hkIPhoneEnum(String partNumber, String name) {
        this.partNumber=partNumber;
        this.name = name;
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
