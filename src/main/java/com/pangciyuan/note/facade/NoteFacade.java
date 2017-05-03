package com.pangciyuan.note.facade;

import com.pangciyuan.note.model.NoteShare;
import io.vertx.ext.web.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pangciyuan.note.common.enums.ReslutEnum;
import com.pangciyuan.note.common.util.StringUtil;
import com.pangciyuan.note.model.Note;
import com.pangciyuan.note.model.NoteBook;
import com.pangciyuan.note.service.NoteService;
import com.pangciyuan.note.vertx.Reslut;
import com.pangciyuan.note.vertx.Send;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;

@Service
public class NoteFacade {
    @Autowired
    private NoteService noteService;

    // 获取已经登录用户的笔记本
    public void getNoteBook(RoutingContext context) {
        // 获取登录用户
        Session session = context.session();
        Send.send(context, noteService.getNoteBook(session.get("userId")));
    }

    public void addNoteBook(RoutingContext context) {
        Session session = context.session();
        String body = context.getBodyAsString();
        if (StringUtil.isEmpty(body)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
            return;
        }
        try {
            NoteBook noteBook = JSON.parseObject(body, NoteBook.class);
            noteBook.setUserId(session.get("userId"));
            Send.send(context, noteService.addNoteBook(noteBook));
        } catch (Exception e) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
        }

    }

    public void deleteNoteBook(RoutingContext context) {
        HttpServerRequest request = context.request();
        String bookId = request.getParam("bookId");
        Send.send(context, noteService.deleteNoteBook(bookId));

    }

    public void deleteNote(RoutingContext context) {
        HttpServerRequest request = context.request();
        String noteId = request.getParam("noteId");
        Send.send(context, noteService.deleteNote(noteId));
    }

    public void shareNote(RoutingContext context) {
        HttpServerRequest request = context.request();
        String noteId = request.getParam("noteId");
        Send.send(context, noteService.shareNote(noteId, JSON.parseObject(context.getBodyAsString())));
    }

    // 获取登录用户的指定的笔记
    public void getNoteList(RoutingContext context) {
        Session session = context.session();
        HttpServerRequest request = context.request();
        String pageNum = request.getParam("pageNum");
        String bookId = request.getParam("bookId");
        if (!StringUtil.isInt(bookId)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON, "bookId must be int"));
            return;
        }
        if (StringUtil.isEmpty(pageNum))
            pageNum = "1";
        if (!StringUtil.isInt(pageNum)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON, "userId pageNum be int"));
            return;
        }
        Send.send(context,
                noteService.getNoteList(session.get("userId"), Integer.parseInt(bookId), Integer.parseInt(pageNum)));
    }

    public void addNote(RoutingContext context) {
        Session session = context.session();
        String body = context.getBodyAsString();
        if (StringUtil.isEmpty(body)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
            return;
        }
        try {
            Note note = JSON.parseObject(body, Note.class);
            note.setUserId(session.get("userId"));
            Send.send(context, noteService.addNote(note));
        } catch (Exception e) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
        }
    }

    public void updateNote(RoutingContext context) {
        String body = context.getBodyAsString();
        if (StringUtil.isEmpty(body)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
            return;
        }
        try {
            Note note = JSON.parseObject(body, Note.class);
            // note.setUserId(session.get("userId"));
            Send.send(context, noteService.updateNote(note));
        } catch (Exception e) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
        }
    }

    public void updateNoteBook(RoutingContext context) {
        String body = context.getBodyAsString();
        if (StringUtil.isEmpty(body)) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
            return;
        }
        try {
            NoteBook note = JSON.parseObject(body, NoteBook.class);
            // note.setUserId(session.get("userId"));
            Send.send(context, noteService.updateNoteBook(note));
        } catch (Exception e) {
            Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
        }
    }

    public void getShare(RoutingContext context) {
        String uri = context.request().getParam("uri");
        context.addCookie(Cookie.cookie("share-uri", ""));
        context.addCookie(Cookie.cookie("share-type", ""));
        context.removeCookie("type");
        Reslut reslut = noteService.getShareNote(uri);
        if(!reslut.getData().equals(false)){
            context.addCookie(Cookie.cookie("share-uri", uri));
            NoteShare noteShare = JSON.parseObject(JSON.toJSONString(reslut.getData()),NoteShare.class);
            context.addCookie(Cookie.cookie("share-type", String.valueOf(noteShare.getNoteShareType())));
        }
        context.response().sendFile("webRoot/s.html");
    }
    public void getShareNote(RoutingContext context) {
        String uri = context.request().getParam("uri");
        String pin = JSON.parseObject(context.getBodyAsString()).getString("pin");
        Send.send(context, noteService.getShareNote(uri,pin));
    }
}
