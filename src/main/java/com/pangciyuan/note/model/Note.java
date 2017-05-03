package com.pangciyuan.note.model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Integer noteId;

    private Integer userId;

    private String noteTitle;

    private Integer noteBookId;

    private String noteBookTag;

    private Integer noteState;

    private Date createTime;

    private String noteBookText;

    private static final long serialVersionUID = 1L;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    public Integer getNoteBookId() {
        return noteBookId;
    }

    public void setNoteBookId(Integer noteBookId) {
        this.noteBookId = noteBookId;
    }

    public String getNoteBookTag() {
        return noteBookTag;
    }

    public void setNoteBookTag(String noteBookTag) {
        this.noteBookTag = noteBookTag == null ? null : noteBookTag.trim();
    }

    public Integer getNoteState() {
        return noteState;
    }

    public void setNoteState(Integer noteState) {
        this.noteState = noteState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNoteBookText() {
        return noteBookText;
    }

    public void setNoteBookText(String noteBookText) {
        this.noteBookText = noteBookText == null ? null : noteBookText.trim();
    }
}