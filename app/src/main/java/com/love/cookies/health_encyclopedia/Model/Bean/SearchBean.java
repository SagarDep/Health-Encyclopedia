package com.love.cookies.health_encyclopedia.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索实体类
 */
public class SearchBean {

    /**
     * success : true
     * total : 2227
     * yi18 : [{"id":1392,"title":"豆腐","img":"img/food/00001392.jpg","keywords":"","description":"","content":"）消化系统疾病 哪些体质的人适宜吃豆腐?（测一测你的体质）<font color=\"red\">健康<\/font>体质平和质，气郁体质，湿热体质，痰湿体质，特禀体质，瘀血体质 哪些疾病的患者不适宜食用豆腐?痛风，内分泌系统疾病 哪些体质的人不适宜食用豆腐?（测","type":"food"}]
     */

    private boolean success;
    private int total;
    /**
     * id : 1392
     * title : 豆腐
     * img : img/food/00001392.jpg
     * keywords :
     * description :
     * content : ）消化系统疾病 哪些体质的人适宜吃豆腐?（测一测你的体质）<font color="red">健康</font>体质平和质，气郁体质，湿热体质，痰湿体质，特禀体质，瘀血体质 哪些疾病的患者不适宜食用豆腐?痛风，内分泌系统疾病 哪些体质的人不适宜食用豆腐?（测
     * type : food
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
        private int id;
        private String title;
        private String img;
        private String keywords;
        private String description;
        private String content;
        private String type;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImg() {
            return "http://www.yi18.net/" + img;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getDescription() {
            return description;
        }

        public String getContent() {
            return content;
        }

        public String getType() {
            return type;
        }
    }
}
