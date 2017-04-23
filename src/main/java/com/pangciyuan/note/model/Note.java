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

    public Note setNoteId(Integer noteId) {
        this.noteId = noteId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Note setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public Note setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
        return this;
    }

    public Integer getNoteBookId() {
        return noteBookId;
    }

    public Note setNoteBookId(Integer noteBookId) {
        this.noteBookId = noteBookId;
        return this;
    }

    public String getNoteBookTag() {
        return noteBookTag;
    }

    public Note setNoteBookTag(String noteBookTag) {
        this.noteBookTag = noteBookTag == null ? null : noteBookTag.trim();
        return this;
    }

    public Integer getNoteState() {
        return noteState;
    }

    public Note setNoteState(Integer noteState) {
        this.noteState = noteState;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Note setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getNoteBookText() {
        return noteBookText;
    }

    public Note setNoteBookText(String noteBookText) {
        this.noteBookText = noteBookText == null ? null : noteBookText.trim();
        return this;
    }
}