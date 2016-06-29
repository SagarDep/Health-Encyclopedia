package com.love.cookies.health_encyclopedia.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识条目实体类
 */
public class LoreCategoryBean {

    /**
     * success : true
     * total : 5125
     * yi18 : [{"title":"食品安\u2026\u2026","loreclass":10,"className":"社会热点","img":"img/news/940.jpg","count":1,"author":"yi18.net","time":"Jan 11, 2014 10:21:40 AM","id":5127}]
     */

    private boolean success;
    private int total;
    /**
     * title : 食品安……
     * loreclass : 10
     * className : 社会热点
     * img : img/news/940.jpg
     * count : 1
     * author : yi18.net
     * time : Jan 11, 2014 10:21:40 AM
     * id : 5127
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
        private int loreclass;
        private String className;
        private String img;
        private int count;
        private String author;
        private String time;
        private int id;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLoreclass(int loreclass) {
            this.loreclass = loreclass;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setAuthor(String author) {
            this.author = author;
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

        public int getLoreclass() {
            return loreclass;
        }

        public String getClassName() {
            return className;
        }

        public String getImg() {
            return "http://www.yi18.net/" + img;
        }

        public int getCount() {
            return count;
        }

        public String getAuthor() {
            return author;
        }

        public String getTime() {
            return time;
        }

        public int getId() {
            return id;
        }
    }
}
