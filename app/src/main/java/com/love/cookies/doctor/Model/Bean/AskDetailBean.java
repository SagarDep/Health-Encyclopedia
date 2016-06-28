package com.love.cookies.doctor.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问详情实体类
 */
public class AskDetailBean {

    /**
     * success : true
     * yi18 : {"title":"频繁照镜子也是一种病吗？","askclass":2,"classname":"心理咨询","count":9742,"scount":0,"id":1,"answer":[{"message":"<div> \n <p>　　<\/p> \n <p>　　爱美的人士喜欢照镜子，这是能够理解的行为，因为仪容对于一个人的外在是非常重要，但是如果你属于那类频繁照镜子而且又无法忍受自己的缺点那么你就需要小心了。 <br /><br />　　专家日前指出，当今社会患有\u201c镜子综合症\u201d的人比想象的更多。这种\u201c疾病\u201d的主要特征之一是整天照镜子，不能容忍自己身上的任何缺点。而且，这些\u201c病人\u201d在挖空心思使自己变得更迷人的过程中，会产生一系列的心理问题。<\/p> \n <p> <\/p> \n <p>　　事实上很多人都患有这一综合症，其症状并不难判断。照镜子审视自己这一简单举动虽然可以帮助我们发现自己体貌上的缺点，却也可以发展成为对心理健康的一种负面影响。这种\u201c镜子综合征\u201d会导致很多现代疾病，如厌食症、贪食症、过度锻炼症、日晒痴迷症或沉迷于整形。 <br /><br />　　尽管极端的后果很少发生，然而很多人会在照镜子时产生一种心理冲突。尽管其外表并不丑陋，但他们觉得自己比别人都难看。而这一问题的根源是，在目前这个社会，丑陋相对来说是一种疾病。 <br /><br />　　一个明显的例子就是很多年轻人会将自己的照片上传至一些网站供人评头论足，有时就会造成被评说者沮丧、焦虑和饮食失调。而且事情还远不止如此，有研究表明，身材高大的男性挣钱更多，就业机会也更好。而那些肥胖女性的收入比苗条女性会低不少。这些现象都会给人的身心健康造成损害，甚至会影响人的经济地位。<\/p> \n <p>　　（更多精彩：无线问问） wap.wenwen.com<\/p> \n<\/div>","topcount":0,"id":1}]}
     */

    private boolean success;
    /**
     * title : 频繁照镜子也是一种病吗？
     * askclass : 2
     * classname : 心理咨询
     * count : 9742
     * scount : 0
     * id : 1
     * answer : [{"message":"<div> \n <p>　　<\/p> \n <p>　　爱美的人士喜欢照镜子，这是能够理解的行为，因为仪容对于一个人的外在是非常重要，但是如果你属于那类频繁照镜子而且又无法忍受自己的缺点那么你就需要小心了。 <br /><br />　　专家日前指出，当今社会患有\u201c镜子综合症\u201d的人比想象的更多。这种\u201c疾病\u201d的主要特征之一是整天照镜子，不能容忍自己身上的任何缺点。而且，这些\u201c病人\u201d在挖空心思使自己变得更迷人的过程中，会产生一系列的心理问题。<\/p> \n <p> <\/p> \n <p>　　事实上很多人都患有这一综合症，其症状并不难判断。照镜子审视自己这一简单举动虽然可以帮助我们发现自己体貌上的缺点，却也可以发展成为对心理健康的一种负面影响。这种\u201c镜子综合征\u201d会导致很多现代疾病，如厌食症、贪食症、过度锻炼症、日晒痴迷症或沉迷于整形。 <br /><br />　　尽管极端的后果很少发生，然而很多人会在照镜子时产生一种心理冲突。尽管其外表并不丑陋，但他们觉得自己比别人都难看。而这一问题的根源是，在目前这个社会，丑陋相对来说是一种疾病。 <br /><br />　　一个明显的例子就是很多年轻人会将自己的照片上传至一些网站供人评头论足，有时就会造成被评说者沮丧、焦虑和饮食失调。而且事情还远不止如此，有研究表明，身材高大的男性挣钱更多，就业机会也更好。而那些肥胖女性的收入比苗条女性会低不少。这些现象都会给人的身心健康造成损害，甚至会影响人的经济地位。<\/p> \n <p>　　（更多精彩：无线问问） wap.wenwen.com<\/p> \n<\/div>","topcount":0,"id":1}]
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
        private int askclass;
        private String classname;
        private int count;
        private int scount;
        private int id;
        /**
         * message : <div>
         <p>　　</p>
         <p>　　爱美的人士喜欢照镜子，这是能够理解的行为，因为仪容对于一个人的外在是非常重要，但是如果你属于那类频繁照镜子而且又无法忍受自己的缺点那么你就需要小心了。 <br /><br />　　专家日前指出，当今社会患有“镜子综合症”的人比想象的更多。这种“疾病”的主要特征之一是整天照镜子，不能容忍自己身上的任何缺点。而且，这些“病人”在挖空心思使自己变得更迷人的过程中，会产生一系列的心理问题。</p>
         <p> </p>
         <p>　　事实上很多人都患有这一综合症，其症状并不难判断。照镜子审视自己这一简单举动虽然可以帮助我们发现自己体貌上的缺点，却也可以发展成为对心理健康的一种负面影响。这种“镜子综合征”会导致很多现代疾病，如厌食症、贪食症、过度锻炼症、日晒痴迷症或沉迷于整形。 <br /><br />　　尽管极端的后果很少发生，然而很多人会在照镜子时产生一种心理冲突。尽管其外表并不丑陋，但他们觉得自己比别人都难看。而这一问题的根源是，在目前这个社会，丑陋相对来说是一种疾病。 <br /><br />　　一个明显的例子就是很多年轻人会将自己的照片上传至一些网站供人评头论足，有时就会造成被评说者沮丧、焦虑和饮食失调。而且事情还远不止如此，有研究表明，身材高大的男性挣钱更多，就业机会也更好。而那些肥胖女性的收入比苗条女性会低不少。这些现象都会给人的身心健康造成损害，甚至会影响人的经济地位。</p>
         <p>　　（更多精彩：无线问问） wap.wenwen.com</p>
         </div>
         * topcount : 0
         * id : 1
         */

        private List<AnswerEntity> answer;

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

        public void setAnswer(List<AnswerEntity> answer) {
            this.answer = answer;
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

        public List<AnswerEntity> getAnswer() {
            return answer;
        }

        public static class AnswerEntity {
            private String message;
            private int topcount;
            private int id;

            public void setMessage(String message) {
                this.message = message;
            }

            public void setTopcount(int topcount) {
                this.topcount = topcount;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMessage() {
                return message;
            }

            public int getTopcount() {
                return topcount;
            }

            public int getId() {
                return id;
            }
        }
    }
}
