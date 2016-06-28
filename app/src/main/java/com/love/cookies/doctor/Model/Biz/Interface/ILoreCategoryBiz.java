package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.LoreCategoryBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识条目逻辑接口
 */
public interface ILoreCategoryBiz {
    public void getLoreCategoryDate(int page, int id, CallBack<LoreCategoryBean> callBack);
}
