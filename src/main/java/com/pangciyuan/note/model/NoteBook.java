package com.pangciyuan.note.model;

import java.io.Serializable;
import java.util.Date;

public class NoteBook implements Serializable {
    private Integer noteBookId;

    private String noteBookName;

    private Integer userId;

    private Date createTime;

    private Integer noteBookType;

    private static final long serialVersionUID = 1L;

    public Integer getNoteBookId() {
        return noteBookId;
    }

    public void setNoteBookId(Integer noteBookId) {
        this.noteBookId = noteBookId;
    }

    public String getNoteBookName() {
        return noteBookName;
    }

    public void setNoteBookName(String noteBookName) {
        this.noteBookName = noteBookName == null ? null : noteBookName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNoteBookType() {
        return noteBookType;
    }

    public void setNoteBookType(Integer noteBookType) {
        this.noteBookType = noteBookType;
    }
}