package com.pangciyuan.note.model;

import java.io.Serializable;
import java.util.Date;

public class NoteShare implements Serializable {
    private Integer noteShareId;

    private Integer noteId;

    private Integer noteShareType;

    private String noteShareUri;

    private Integer noteShareStart;

    private Date createTime;

    private String sharePin;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getNoteShareId() {
        return noteShareId;
    }

    public void setNoteShareId(Integer noteShareId) {
        this.noteShareId = noteShareId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNoteShareType() {
        return noteShareType;
    }

    public void setNoteShareType(Integer noteShareType) {
        this.noteShareType = noteShareType;
    }

    public String getNoteShareUri() {
        return noteShareUri;
    }

    public void setNoteShareUri(String noteShareUri) {
        this.noteShareUri = noteShareUri == null ? null : noteShareUri.trim();
    }

    public Integer getNoteShareStart() {
        return noteShareStart;
    }

    public void setNoteShareStart(Integer noteShareStart) {
        this.noteShareStart = noteShareStart;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSharePin() {
        return sharePin;
    }

    public void setSharePin(String sharePin) {
        this.sharePin = sharePin == null ? null : sharePin.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}