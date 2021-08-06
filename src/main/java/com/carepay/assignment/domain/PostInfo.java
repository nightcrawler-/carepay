package com.carepay.assignment.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "post")
public class PostInfo {

    @Id
    private Long id;
    private String title;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
