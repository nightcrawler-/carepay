package com.carepay.assignment.domain;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CreatePostRequest {

    @NotNull 
    @Size(max = 20) 
    private String title;

    @NotNull 
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
