package com.carepay.assignment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends PostInfo {
    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // private Long id;
    // private String title;
    private String content;

    public Post(String title, String content) {
        super(title);
        this.content = content;
    }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getTitle() {
    //     return title;
    // }

    // public void setTitle(String title) {
    //     this.title = title;
    // }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
