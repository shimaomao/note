package com.pangciyuan.note.model;

import java.io.Serializable;

public class NoteTag implements Serializable {
    private Integer noteTagId;

    private String noteTagName;

    private Integer noteTagState;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getNoteTagId() {
        return noteTagId;
    }

    public void setNoteTagId(Integer noteTagId) {
        this.noteTagId = noteTagId;
    }

    public String getNoteTagName() {
        return noteTagName;
    }

    public void setNoteTagName(String noteTagName) {
        this.noteTagName = noteTagName == null ? null : noteTagName.trim();
    }

    public Integer getNoteTagState() {
        return noteTagState;
    }

    public void setNoteTagState(Integer noteTagState) {
        this.noteTagState = noteTagState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}