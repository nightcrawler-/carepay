package com.carepay.assignment.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostDetails extends PostInfo {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
