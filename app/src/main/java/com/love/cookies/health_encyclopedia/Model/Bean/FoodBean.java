package com.love.cookies.health_encyclopedia.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食物实体类
 */
public class FoodBean {
    /**
     * success : true
     * total : 3309
     * yi18 : [{"name":"大乌泡","img":"img/food/20150727110905_821.jpg","menu":"其他功效","bar":"养阴补虚","count":629,"fcount":0,"rcount":0,"id":4701}]
     */

    private boolean success;
    private int total;
    /**
     * name : 大乌泡
     * img : img/food/20150727110905_821.jpg
     * menu : 其他功效
     * bar : 养阴补虚
     * count : 629
     * fcount : 0
     * rcount : 0
     * id : 4701
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
        private String name;
        private String img;
        private String menu;
        private String bar;
        private int count;
        private int fcount;
        private int rcount;
        private int id;

        public void setName(String name) {
            this.name = name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setMenu(String menu) {
            this.menu = menu;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getImg() {
            return "http://www.yi18.net/" + img;
        }

        public String getMenu() {
            return menu;
        }

        public String getBar() {
            return bar;
        }

        public int getCount() {
            return count;
        }

        public int getFcount() {
            return fcount;
        }

        public int getRcount() {
            return rcount;
        }

        public int getId() {
            return id;
        }
    }

}
