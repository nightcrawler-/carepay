package com.carepay.assignment.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
