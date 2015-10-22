package com.maitaidan.refreshIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/12.
 * 大陆apple store
 */
public enum CNStoreEnum implements StoreEnum{

    BeijingXiDan("R320","北京","西单大悦城"),
    BeijingSanLiTun("R388","北京","三里屯"),
    BeijingWangFuJing("R448","北京","王府井"),
    BeijingHuaMao("R479","北京","华贸购物中心"),
    ShangHaiNanJingDongLu("R359","上海","南京东路"),
    ShangHaiPuDong("R389","上海","浦东"),
    ShangHaiHKSquare("R390","上海","香港广场"),
    ShangHaiHuanMao("R401","上海","上海环贸 iapm"),
    NanJingHongYueCity("R643","南京","虹悦城"),
    TianJinDaYueCity("R637","天津","大悦城"),
    ChengDuWanXiangCity("R502","成都","万象城"),
    WuXiHengLongSquare("R574","无锡","恒隆广场"),
    HangZhouXiHu("R471","杭州","西湖"),
    HangZhouWanXiangCity("R532","杭州","万象城"),
    ShenYangDaYueCity("R534","沈阳","中街大悦城"),
    ShenZhenJiaRiSquare("R484","深圳","益田假日广场"),
    ZhengZhouWanXiangCity("R572","郑州","万象城"),
    ChongQingBeiChengTianJie("R476","重庆","北城天街"),
    ChongQingJieFangBei("R480","重庆","解放碑"),
    ChongQingWanXiangCity("R573","重庆","万象城");


    private String storeNo;
    private String city;
    private String address;

    CNStoreEnum(String storeNo, String city, String address) {
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
