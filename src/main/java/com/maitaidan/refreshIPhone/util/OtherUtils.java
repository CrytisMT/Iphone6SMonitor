package com.maitaidan.refreshIPhone.util;

import com.maitaidan.refreshIPhone.pojo.IPhoneEnum;
import com.maitaidan.refreshIPhone.pojo.Parameters;
import com.maitaidan.refreshIPhone.pojo.cnIPhoneEnum;

/**
 * Created by Crytis on 2015/10/20.
 */
public class OtherUtils {

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
