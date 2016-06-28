package com.love.cookies.doctor.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 更新日志实体类
 */
public class ChangeLogBean {

    /**
     * version : V 1.0
     * date : 2015-12-03
     * description : 掌上医生——随时随地，享受掌上健康生活
     */

    private List<ChangeLogEntity> change_log;

    public void setChange_log(List<ChangeLogEntity> change_log) {
        this.change_log = change_log;
    }

    public List<ChangeLogEntity> getChange_log() {
        return change_log;
    }

    public static class ChangeLogEntity {
        private String version;
        private String date;
        private String description;

        public void setVersion(String version) {
            this.version = version;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public String getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }
    }
}
