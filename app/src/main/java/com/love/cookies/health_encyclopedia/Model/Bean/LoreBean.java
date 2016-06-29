package com.love.cookies.health_encyclopedia.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识实体类
 */
public class LoreBean {

    /**
     * success : true
     * yi18 : [{"name":"减肥瘦身","id":11}]
     */

    private boolean success;
    /**
     * name : 减肥瘦身
     * id : 11
     */

    private List<Yi18Entity> yi18;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setYi18(List<Yi18Entity> yi18) {
        this.yi18 = yi18;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Yi18Entity> getYi18() {
        return yi18;
    }

    public static class Yi18Entity {
        private String name;
        private int id;

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }
}
