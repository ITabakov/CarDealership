package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    private static final int CONTENT_LEN_MIN = 3;
    private static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);
    private static final String COMMENT_HEADER = "----------";
    private static final String COMMENT_FOOTER = "----------";
    private static final String CONTENT_MESSAGE = "%s";
    private static final String USER_MESSAGE = "User: %s";
    private String content;
    private String author;

    public CommentImpl(String content, String author) {
        setContent(content);
        setAuthor(author);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public String toString() {
        return String.format(COMMENT_HEADER + System.lineSeparator() +
                        CONTENT_MESSAGE + System.lineSeparator() +
                        USER_MESSAGE + System.lineSeparator() +
                        COMMENT_FOOTER + System.lineSeparator(),
                getContent(), getAuthor());
    }

    private void setContent(String content) {
        ValidationHelpers.validateStringLength(content, CONTENT_LEN_MIN, CONTENT_LEN_MAX, CONTENT_LEN_ERR);
        this.content = content;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

}