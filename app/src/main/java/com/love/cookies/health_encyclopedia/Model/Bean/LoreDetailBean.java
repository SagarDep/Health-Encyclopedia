package com.love.cookies.health_encyclopedia.Model.Bean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识知识详情实体类
 */
public class LoreDetailBean {

    /**
     * success : true
     * yi18 : {"title":"告别双下巴和颈部赘肉","message":" \u2026\u2026","count":0,"author":"yi18","loreclass":11,"className":"减肥瘦身","time":"Dec 5, 2013 12:00:00 AM","id":1}
     */

    private boolean success;
    /**
     * title : 告别双下巴和颈部赘肉
     * message :  ……
     * count : 0
     * author : yi18
     * loreclass : 11
     * className : 减肥瘦身
     * time : Dec 5, 2013 12:00:00 AM
     * id : 1
     */

    private Yi18Entity yi18;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setYi18(Yi18Entity yi18) {
        this.yi18 = yi18;
    }

    public boolean isSuccess() {
        return success;
    }

    public Yi18Entity getYi18() {
        return yi18;
    }

    public static class Yi18Entity {
        private String title;
        private String message;
        private int count;
        private String author;
        private int loreclass;
        private String className;
        private String time;
        private int id;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setLoreclass(int loreclass) {
            this.loreclass = loreclass;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getMessage() {
            return message;
        }

        public int getCount() {
            return count;
        }

        public String getAuthor() {
            return author;
        }

        public int getLoreclass() {
            return loreclass;
        }

        public String getClassName() {
            return className;
        }

        public String getTime() {
            return time;
        }

        public int getId() {
            return id;
        }
    }
}
