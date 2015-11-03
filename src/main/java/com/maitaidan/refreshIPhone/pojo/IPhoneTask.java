package com.maitaidan.refreshIPhone.pojo;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public class IPhoneTask {

    private String email;
    private IPhoneEnum iPhone;
    private String buyingUrl;


    public IPhoneTask(String email, IPhoneEnum iPhone) {
        this.email = email;
        this.iPhone = iPhone;
        this.buyingUrl = generateBuyingUrl(iPhone);
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
        this.buyingUrl = generateBuyingUrl(iPhone);
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
        if (!(o instanceof IPhoneTask)) return false;

        IPhoneTask that = (IPhoneTask) o;

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
        return "IPhoneTask{" +
                "email='" + email + '\'' +
                ", iPhone=" + iPhone +
                '}';
    }

    /**
     * 生成购买链接
     *
     * @param iPhone
     * @return
     */
    public static String generateBuyingUrl(IPhoneEnum iPhone) {
        StringBuffer sb = new StringBuffer("http://www.apple.com/");
        if (cnIPhoneEnum.Gold128.getEnumByPartName(iPhone.getPartNumber()) != null) {
            sb.append("cn").append("/shop/buy-iphone/iphone6s/");
            if (iPhone.getScreenSize().contains("4")) {
                sb.append("4.7-英寸屏幕-");
            } else {
                sb.append("5.5-英寸屏幕-");
            }

            if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity16)) {
                sb.append("16gb-");
            } else if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity64)) {
                sb.append("64gb-");
            } else if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity128)) {
                sb.append("128gb-");
            }

            if (iPhone.getColor().equalsIgnoreCase(Parameters.SilverColor)) {
                sb.append("银色");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.GoldColor)) {
                sb.append("金色");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.GrayColor)) {
                sb.append("深空灰色");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.RoseGoldColor)) {
                sb.append("玫瑰金色");
            }
        } else {
            sb.append("hk-zh").append("/shop/buy-iphone/iphone6s/");
            if (iPhone.getScreenSize().contains("4")) {
                sb.append("4.7-吋螢幕-");
            } else {
                sb.append("5.5-吋螢幕-");
            }

            if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity16)) {
                sb.append("16gb-");
            } else if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity64)) {
                sb.append("64gb-");
            } else if (iPhone.getCapacity().equalsIgnoreCase(Parameters.Capacity128)) {
                sb.append("128gb-");
            }

            if (iPhone.getColor().equalsIgnoreCase(Parameters.SilverColor)) {
                sb.append("銀色");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.GoldColor)) {
                sb.append("金色");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.GrayColor)) {
                sb.append("太空灰");
            } else if (iPhone.getColor().equalsIgnoreCase(Parameters.RoseGoldColor)) {
                sb.append("玫瑰金色");
            }
        }
        return sb.toString();
    }
}
