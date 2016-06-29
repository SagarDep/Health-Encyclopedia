package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.AskCategoryBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问条目逻辑接口
 */
public interface IAskCategoryBiz {
    public void getAskCategoryDate(int page, int id, CallBack<AskCategoryBean> callBack);
}
