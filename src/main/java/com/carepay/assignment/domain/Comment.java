package com.carepay.assignment.domain;

import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PostDetails post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostDetails getPostDetails() {
        return post;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.post = postDetails;
    }

}
