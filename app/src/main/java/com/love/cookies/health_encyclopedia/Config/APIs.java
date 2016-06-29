package com.love.cookies.health_encyclopedia.Config;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 所有的接口和key
 */
public class APIs {

    public static final int REFRESH = 1;
    public static final int LOADMORE = 2;

    public static final int PAGE_LIMIT = 20;

    //食疗大全 food
    public static final int TAG_FOOD = 1;
    public static final String APIX_FOOD_KEY = "9163c56fa0be47a96e8786cfe3c3436e";//key
    public static final String APIX_FOOD_LIST = "http://a.apix.cn/yi18/food/list";//取得食品列表
    public static final String APIX_FOOD_MENU = "http://a.apix.cn/yi18/food/menu";//取得疗效列表
    public static final String APIX_FOOD_MENU_LIST = "http://a.apix.cn/yi18/food/menulist";//取得疗效分类列表
    public static final String APIX_FOOD_BAR = "http://a.apix.cn/yi18/food/bar";//取得功能列表
    public static final String APIX_FOOD_BAR_LIST = "http://a.apix.cn/yi18/food/barlist";//取得功能分类列表
    public static final String APIX_FOOD_DETAIL = "http://a.apix.cn/yi18/food/show";//取得食品详细
    public static final String APIX_FOOD_SEARCH = "http://a.apix.cn/yi18/food/search";//搜索食品

    //健康知识 lore
    public static final int TAG_LORE = 2;
    public static final String APIX_LORE_KEY = "71da3f14550b4a8352ec907fa50f1131";//key
    public static final String APIX_LORE_DETAIL = "http://a.apix.cn/yi18/lore/show";//知识信息详细
    public static final String APIX_LORE_LIST = "http://a.apix.cn/yi18/lore/list";//知识信息列表
    public static final String APIX_LORE_CLASS = "http://a.apix.cn/yi18/lore/loreclass";//知识分类列表
    public static final String APIX_LORE_SEARCH = "http://a.apix.cn/yi18/lore/search";//搜索健康知识

    //健康一问 ask
    public static final int TAG_ASK = 3;
    public static final String APIX_ASK_KEY = "6038a1696d8846d35db0c975c496e43b";//key
    public static final String APIX_ASK_CLASS = "http://a.apix.cn/yi18/ask/askclass";//知识分类列表
    public static final String APIX_ASK_LIST = "http://a.apix.cn/yi18/ask/list";//知识信息列表
    public static final String APIX_ASK_DETAIL = "http://a.apix.cn/yi18/ask/show";//问题答案信息详情
    public static final String APIX_ASK_SEARCH = "http://a.apix.cn/yi18/ask/search";//搜索问题

    //病状查找 symptom
    public static final int TAG_SYMPTOM = 4;
    public static final String APIX_SYMPTOM_KEY = "2c4d4d8e7ea94ddc6952f5fa05dbbdc4";//key
    public static final String APIX_SYMPTOM_DETAIL = "http://a.apix.cn/yi18/symptom/show";//病状信息详情
    public static final String APIX_SYMPTOM_LIST = "http://a.apix.cn/yi18/symptom/list";//病状信息列表
    public static final String APIX_SYMPTOM_PLACE = "http://a.apix.cn/yi18/symptom/place";//身体部位
    public static final String APIX_SYMPTOM_SEARCH = "http://a.apix.cn/yi18/symptom/search";//病状搜索

}
