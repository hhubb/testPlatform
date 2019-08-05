package com.icode.testplatform.dto;

import java.util.Date;
import java.util.List;

public class ArticleDTO {
    private String sender;
    private long id;
    private long userid;
    private long mainid;
    private String title;
    private String content;
    private String create_time;
    private Date update_time;
    private List<ArticleDTO> subArticleList;

    public List<ArticleDTO> getSubArticleList() {
        return subArticleList;
    }

    public void setSubArticleList(List<ArticleDTO> subArticleList) {
        this.subArticleList = subArticleList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getMainid() {
        return mainid;
    }

    public void setMainid(long mainid) {
        this.mainid = mainid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

}
