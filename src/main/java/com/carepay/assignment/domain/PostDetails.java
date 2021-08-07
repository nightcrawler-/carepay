package com.carepay.assignment.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "post")
public class PostDetails extends PostInfo {

    private String content;

    @OneToMany(mappedBy = "post", cascade = { CascadeType.ALL })
    private List<Comment> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
