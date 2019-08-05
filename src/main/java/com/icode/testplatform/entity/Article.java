package com.icode.testplatform.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
    private long id;
    private String create_time;
    private Timestamp update_time;
    private String title;
    private String content;
    private long userid;
    private long mainid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
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
}
