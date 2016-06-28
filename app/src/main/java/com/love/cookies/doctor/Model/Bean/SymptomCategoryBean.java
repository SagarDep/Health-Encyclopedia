package com.love.cookies.doctor.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目实体类
 */
public class SymptomCategoryBean {

    /**
     * success : true
     * total : 706
     * yi18 : [{"name":"药物性胸腔积液","img":"img/symptom/20150131091822_615.jpg","place":"乳房","count":3568,"rcount":0,"fcount":0,"id":3513}]
     */

    private boolean success;
    private int total;
    /**
     * name : 药物性胸腔积液
     * img : img/symptom/20150131091822_615.jpg
     * place : 乳房
     * count : 3568
     * rcount : 0
     * fcount : 0
     * id : 3513
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
        private String place;
        private int count;
        private int rcount;
        private int fcount;
        private int id;

        public void setName(String name) {
            this.name = name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
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

        public String getPlace() {
            return place;
        }

        public int getCount() {
            return count;
        }

        public int getRcount() {
            return rcount;
        }

        public int getFcount() {
            return fcount;
        }

        public int getId() {
            return id;
        }
    }
}
