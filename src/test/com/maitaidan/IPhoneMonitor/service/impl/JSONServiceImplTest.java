package com.maitaidan.IPhoneMonitor.service.impl;

import org.junit.Test;

/**
 * Created by xinyu.jiang on 2015/10/15.
 */
public class JSONServiceImplTest {

    @Test
    public void testParseStoreAvailableJson() throws Exception {
        String json = "{\"head\":{\"status\":\"200\",\"data\":{}},\"body\":{\"response\":{\"slotStepsData\":{\"cases\":{\"errors\":{},\"stepSummaryItems\":[],\"state\":\"enabled\",\"configData\":{\"enabledSections\":{\"iphone6ssiliconecase\":true,\"iphone6scase\":true}},\"validatedParameters\":{}},\"dock\":{\"errors\":{},\"stepSummaryItems\":[],\"state\":\"enabled\",\"configData\":{\"enabledSections\":{\"iphone6sdock\":true}},\"validatedParameters\":{}},\"applecare\":{\"errors\":{},\"stepSummaryItems\":[],\"state\":\"enabled\",\"configData\":{\"enabledSections\":{\"service_support\":true}},\"validatedParameters\":{}}},\"summarySection\":{\"pageTitle\":\"iPhone 6s 128GB 玫瑰金色 - Apple (香港)\",\"pageURL\":\"4.7-吋螢幕-128gb-玫瑰金色\",\"canonicalURL\":\"http://www.apple.com/hk-zh/shop/buy-iphone/iphone6s\",\"summary\":{\"isBuyable\":true,\"price\":\"\\n\\n<span class=\\\"as-price-currentprice\\\">\\n    <span itemscope=\\\"itemscope\\\" itemprop=\\\"offers\\\" itemtype=\\\"http://schema.org/Offer\\\">\\n        \\n        <meta itemprop=\\\"priceCurrency\\\" content=\\\"HKD\\\" /> \\n        <span itemprop=\\\"price\\\">\\n            HK$7,188\\n        </span>\\n    </span>\\n\\n\\n</span>\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\",\"carrierFinancing\":{},\"financing\":\"\\n\\n\\n\\n\\n\\n\\n              \\n\\n\\n\\n\\n\\n\\n\",\"promotions\":\"\\n\\n\\n\\n\\n<span class=\\\"gift-card \\\">\\n    \\n</span>\\n\\n\",\"buyNowButton\":\"\\n\\n\\n\\n<form method=\\\"get\\\" action=\\\"#\\\"    data-feature-name=\\\"Step1\\\" data-display-name=\\\"AOS: home/shop_iphone/family/iphone6s\\\" data-eVar20=\\\"AOS: home/shop_iphone/family/iphone6s | MKQW2 | Availability | 199 | 1-2 weeks\\\" data-part-number=\\\"MKQW2ZP/A\\\"  >\\n\\n    \\n\\n        <div class=\\\"as-purchaseinfo-button\\\">\\n\\n<span class=\\\"add-to-cart \\\" >\\n\\n\\n\\n<button \\n    type=\\\"submit\\\" \\n    class=\\\"button as-button-large as-button-block\\\" \\n    name=\\\"add-to-cart\\\" \\n    value=\\\"add-to-cart\\\" \\n    \\n    title=\\\"加入購物袋\\\">\\n        <span class=\\\"label\\\">加入購物袋</span>\\n</button>\\n</span>         </div>\\n\\n        <input name=\\\"product\\\" type=\\\"hidden\\\" disabled=\\\"disabled\\\" value=\\\"\\\" id=\\\"productPartNumber\\\" />\\n\\n\\n\\n\\n        <input type=\\\"hidden\\\" name=\\\"product\\\" value=\\\"MKQW2ZP/A\\\" />\\n        <input type=\\\"hidden\\\" name=\\\"step\\\" value=\\\"select\\\" />\\n</form>\",\"productTitle\":\"iPhone 6s 128GB 玫瑰金色\",\"isOverridePriceWithFinancing\":false},\"ireserve\":{\"enabled\":true,\"category\":\"iphone\",\"link\":{\"url\":\"https://reserve-hk.apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQW2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk-zh%2Fshop%2Fbuy-iphone%2Fiphone6s%2F4.7-%E5%90%8B%E8%9E%A2%E5%B9%95-128gb-%E7%8E%AB%E7%91%B0%E9%87%91%E8%89%B2\",\"text\":\"預約於店內購買\",\"dataVar\":{},\"omnitureData\":{\"featureName\":\"iReserve\",\"linkText\":\"AOS: home/shop_iphone/family/iphone6s\",\"commitCodeId\":0},\"newTab\":false,\"link\":\"https://reserve-hk.apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQW2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk-zh%2Fshop%2Fbuy-iphone%2Fiphone6s%2F4.7-%E5%90%8B%E8%9E%A2%E5%B9%95-128gb-%E7%8E%AB%E7%91%B0%E9%87%91%E8%89%B2\"},\"ireserveFooter\":\"預約服務額滿即止\",\"parentPartNumber\":\"MKQW2\",\"partNumber\":\"MKQW2ZP/A\"}}}}}";
        JSONServiceImpl jsonService = new JSONServiceImpl();
        System.out.println(jsonService.isIPhoneOnlineAvailable(json));

    }

    @Test
    public void testParseStoreAvailableJson1() throws Exception {
        JSONServiceImpl jsonService = new JSONServiceImpl();
        String json = "{\n" +
                "  \"R320\" : {\n" +
                "    \"ML7D2CH/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"ML7C2CH/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R388\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"ML7D2CH/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"ML7C2CH/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R658\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R424\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R469\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"18 h 00\",\n" +
                "        \"contractTimeslotTime\" : \"18 h 30\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"NONE\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R315\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R425\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R477\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R367\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"NONE\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"NONE\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"NONE\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R522\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : null,\n" +
                "    \"MKUE2ZD/A\" : \"NONE\",\n" +
                "    \"MKQT2ZD/A\" : \"NONE\",\n" +
                "    \"MKQW2ZD/A\" : \"NONE\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"NONE\",\n" +
                "    \"MKQR2ZD/A\" : \"NONE\",\n" +
                "    \"MKQN2ZD/A\" : \"NONE\",\n" +
                "    \"MKQQ2ZD/A\" : \"NONE\",\n" +
                "    \"MKQK2ZD/A\" : \"NONE\",\n" +
                "    \"MKQJ2ZD/A\" : \"NONE\",\n" +
                "    \"MKQM2ZD/A\" : \"NONE\",\n" +
                "    \"MKUF2ZD/A\" : \"NONE\",\n" +
                "    \"MKQP2ZD/A\" : \"NONE\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"NONE\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"NONE\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"NONE\"\n" +
                "  },\n" +
                "  \"R376\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R277\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R178\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"ALL\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"ALL\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"isToday\" : true,\n" +
                "  \"fr_FR\" : {\n" +
                "    \"launchDate\" : \"vendredi 25 septembre\"\n" +
                "  },\n" +
                "  \"R374\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R276\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"ALL\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R394\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R395\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"ALL\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"ALL\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"ALL\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R373\" : {\n" +
                "    \"MKU62ZD/A\" : \"NONE\",\n" +
                "    \"MKU92ZD/A\" : \"NONE\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"NONE\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"NONE\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"NONE\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"NONE\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"NONE\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"R470\" : {\n" +
                "    \"MKU62ZD/A\" : \"ALL\",\n" +
                "    \"MKU92ZD/A\" : \"ALL\",\n" +
                "    \"MKU32ZD/A\" : \"NONE\",\n" +
                "    \"timeSlot\" : {\n" +
                "      \"fr_FR\" : {\n" +
                "        \"timeslotTime\" : \"17 h 45\",\n" +
                "        \"contractTimeslotTime\" : \"17 h 45\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"MKUE2ZD/A\" : \"NONE\",\n" +
                "    \"MKQT2ZD/A\" : \"ALL\",\n" +
                "    \"MKQW2ZD/A\" : \"ALL\",\n" +
                "    \"MKUG2ZD/A\" : \"NONE\",\n" +
                "    \"MKQU2ZD/A\" : \"ALL\",\n" +
                "    \"MKQR2ZD/A\" : \"ALL\",\n" +
                "    \"MKQN2ZD/A\" : \"ALL\",\n" +
                "    \"MKQQ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQK2ZD/A\" : \"ALL\",\n" +
                "    \"MKQJ2ZD/A\" : \"ALL\",\n" +
                "    \"MKQM2ZD/A\" : \"ALL\",\n" +
                "    \"MKUF2ZD/A\" : \"ALL\",\n" +
                "    \"MKQP2ZD/A\" : \"ALL\",\n" +
                "    \"MKU52ZD/A\" : \"NONE\",\n" +
                "    \"MKU72ZD/A\" : \"ALL\",\n" +
                "    \"MKU22ZD/A\" : \"NONE\",\n" +
                "    \"MKUD2ZD/A\" : \"NONE\",\n" +
                "    \"MKU12ZD/A\" : \"NONE\",\n" +
                "    \"MKQL2ZD/A\" : \"ALL\",\n" +
                "    \"MKU82ZD/A\" : \"ALL\",\n" +
                "    \"MKQV2ZD/A\" : \"ALL\"\n" +
                "  },\n" +
                "  \"updated\" : 1445441886509\n" +
                "}";
        System.out.println(jsonService.parseStoreAvailableJson(json));

    }
}