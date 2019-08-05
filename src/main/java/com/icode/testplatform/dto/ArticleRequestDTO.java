package com.icode.testplatform.dto;

public class ArticleRequestDTO {
    private long userid;//用户id
    private String title;//标题
    private String content;//内容
    private long mainid;//主贴id

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMainid() {
        return mainid;
    }

    public void setMainid(long mainid) {
        this.mainid = mainid;
    }
}
