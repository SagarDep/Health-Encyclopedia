package com.love.cookies.health_encyclopedia.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问条目实体类
 */
public class AskCategoryBean {

    /**
     * success : true
     * total : 6895
     * yi18 : [{"title":"人生气表情为啥一个样？","askclass":18,"classname":"生活常识","count":57,"scount":0,"id":7019}]
     */

    private boolean success;
    private int total;
    /**
     * title : 人生气表情为啥一个样？
     * askclass : 18
     * classname : 生活常识
     * count : 57
     * scount : 0
     * id : 7019
     */

    private List<Yi18Entity> yi18;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setYi18(List<Yi18Entity> yi18) {
        this.yi18 = yi18;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTotal() {
        return total;
    }

    public List<Yi18Entity> getYi18() {
        return yi18;
    }

    public static class Yi18Entity {
        private String title;
        private int askclass;
        private String classname;
        private int count;
        private int scount;
        private int id;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAskclass(int askclass) {
            this.askclass = askclass;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setScount(int scount) {
            this.scount = scount;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public int getAskclass() {
            return askclass;
        }

        public String getClassname() {
            return classname;
        }

        public int getCount() {
            return count;
        }

        public int getScount() {
            return scount;
        }

        public int getId() {
            return id;
        }
    }
}
