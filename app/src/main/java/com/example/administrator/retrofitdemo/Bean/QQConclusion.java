package com.example.administrator.retrofitdemo.Bean;

/**
 * 类描述：QQ号测试
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 15:02
 * 版本：
 */
public class QQConclusion {

    /**
     * error_code : 0
     * reason : success
     * result : {"data":{"conclusion":"[吉带凶]有得有失，华而不实，须防劫财，始保平安","analysis":"金钱上有损失，切忌花枝招展，外表的华丽可能为您带来小人的攻击。"}}
     */

    private int error_code;
    private String reason;
    /**
     * data : {"conclusion":"[吉带凶]有得有失，华而不实，须防劫财，始保平安","analysis":"金钱上有损失，切忌花枝招展，外表的华丽可能为您带来小人的攻击。"}
     */

    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * conclusion : [吉带凶]有得有失，华而不实，须防劫财，始保平安
         * analysis : 金钱上有损失，切忌花枝招展，外表的华丽可能为您带来小人的攻击。
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            private String conclusion;
            private String analysis;

            public String getConclusion() {
                return conclusion;
            }

            public void setConclusion(String conclusion) {
                this.conclusion = conclusion;
            }

            public String getAnalysis() {
                return analysis;
            }

            public void setAnalysis(String analysis) {
                this.analysis = analysis;
            }
        }
    }
}
