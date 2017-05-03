package com.pangciyuan.note.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pangciyuan.note.common.util.UUIDUtil;
import com.pangciyuan.note.mapper.NoteShareMapper;
import com.pangciyuan.note.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.pangciyuan.note.common.enums.ReslutEnum;
import com.pangciyuan.note.common.model.PageParameter;
import com.pangciyuan.note.common.util.StringUtil;
import com.pangciyuan.note.mapper.NoteBookMapper;
import com.pangciyuan.note.mapper.NoteMapper;
import com.pangciyuan.note.service.NoteService;
import com.pangciyuan.note.vertx.Reslut;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteBookMapper noteBookMapper;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private NoteShareMapper shareMapper;

    @Override
    public Reslut getNoteBook(Integer userId) {
//        userId = 12;
        if (userId == null) return new Reslut(false);
        NoteBookExample bookExample = new NoteBookExample();
        bookExample.or().andUserIdEqualTo(userId);
        List<NoteBook> selectByExample = noteBookMapper.selectByExample(bookExample);
        return new Reslut(selectByExample);
    }

    @Override
    public Reslut getNoteList(Integer userId, Integer noteBookId, int pageNum) {
//        userId = 12;
        NoteExample noteExample = new NoteExample();
        noteExample.or().andUserIdEqualTo(userId).andNoteBookIdEqualTo(noteBookId).andNoteStateEqualTo(0);
        noteExample.setOrderByClause("create_time desc");
//		PageHelper.startPage(pageNum, 25);
        List<Note> selectByExample = noteMapper.selectByExampleWithBLOBs(noteExample);
        PageInfo<Note> pageInfo = new PageInfo<>(selectByExample);
        Map<String, Object> map = new HashMap<>();
        map.put("page", new PageParameter(pageInfo));
        map.put("list", pageInfo.getList());
        return new Reslut(map);
    }

    @Override
    public Reslut addNoteBook(NoteBook noteBook) {
//        noteBook.setUserId(12);
        noteBook.setCreateTime(new Date());
        noteBookMapper.insertSelective(noteBook);
        NoteBookExample bookExample = new NoteBookExample();
        bookExample.or().andNoteBookNameEqualTo(noteBook.getNoteBookName()).andUserIdEqualTo(noteBook.getUserId());
        bookExample.setOrderByClause("create_time desc");
        return new Reslut(noteBookMapper.selectByExample(bookExample).get(0));
    }

    @Override
    public Reslut addNote(Note note) {
//        note.setUserId(12);
        note.setCreateTime(new Date());
        note.setNoteState(0);
        noteMapper.insert(note);
        NoteExample noteExample = new NoteExample();
        noteExample.or().andNoteTitleEqualTo(note.getNoteTitle()).andUserIdEqualTo(note.getUserId());
        noteExample.setOrderByClause("create_time desc");
        return new Reslut(noteMapper.selectByExampleWithBLOBs(noteExample).get(0));
    }

    @Override
    public Reslut updateNote(Note note) {
        return new Reslut(noteMapper.updateByPrimaryKeySelective(note) == 1);
    }

    @Override
    public Reslut updateNoteBook(NoteBook noteBook) {
        return new Reslut(noteBookMapper.updateByPrimaryKeySelective(noteBook) == 1);
    }

    @Override
    public Reslut deleteNoteBook(String bookId) {
        if (!StringUtil.isInt(bookId)) {
            return new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON);
        }
        NoteBookExample bookExample = new NoteBookExample();
        bookExample.or().andNoteBookIdEqualTo(Integer.parseInt(bookId)).andNoteBookTypeEqualTo(0);
        int re = noteBookMapper.deleteByExample(bookExample);
        if (re == 1) {
            // 移动笔记
            bookExample = new NoteBookExample();
            bookExample.or().andNoteBookTypeEqualTo(1);
            NoteBook book = noteBookMapper.selectByExample(bookExample).get(0);
            NoteExample noteExample = new NoteExample();
            noteExample.or().andNoteBookIdEqualTo(Integer.parseInt(bookId));
            Note note = new Note();
            note.setNoteBookId(book.getNoteBookId());
            noteMapper.updateByExampleSelective(note, noteExample);
        }
        return new Reslut(re == 1);
    }

    @Override
    public Reslut deleteNote(String noteId) {
        if (!StringUtil.isInt(noteId)) {
            return new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON);
        }
        NoteExample noteExample = new NoteExample();
        noteExample.or().andNoteIdEqualTo(Integer.parseInt(noteId));
        Note note = new Note();
        note.setNoteState(1);
        int re = noteMapper.updateByExampleSelective(note, noteExample);
        return new Reslut(re == 1);
    }

    @Override
    public Reslut shareNote(String noteId, JSONObject data) {
        if (!StringUtil.isInt(noteId)) {
            return new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON);
        }
        Note note = noteMapper.selectByPrimaryKey(Integer.parseInt(noteId));
        if (note == null) {
            return new Reslut(ReslutEnum.NOT_FOUND);
        }

        NoteShare noteShare = new NoteShare();
        noteShare.setCreateTime(new Date());
        noteShare.setNoteId(note.getNoteId());
        noteShare.setNoteShareStart(0);
        noteShare.setNoteShareType(data.getInteger("type"));
        noteShare.setNoteShareUri(UUIDUtil.generateShortUuid());
        noteShare.setUserId(note.getUserId());
//        noteShare.set
        String pin = "";
        if (noteShare.getNoteShareType() == 1) {//私密分享
            pin = data.getString("pin");
            if (StringUtil.isEmpty(pin))
                pin = UUIDUtil.generateShortUuid().substring(3, 7);
        }
        noteShare.setSharePin(pin);
        shareMapper.insert(noteShare);
        JSONObject jo = new JSONObject();
        jo.put("uri", "http://note.pangciyuan.cn/s/" + noteShare.getNoteShareUri());
        jo.put("pin", pin);
        return new Reslut(jo);
    }

    @Override
    public Reslut getShareNote(String uri) {
        NoteShareExample shareExample = new NoteShareExample();
        shareExample.or().andNoteShareUriEqualTo(uri);
        List<NoteShare> list = shareMapper.selectByExample(shareExample);
        if (list.size() == 1) {
            return new Reslut(list.get(0));
        } else
            return new Reslut(false);
    }

    @Override
    public Reslut getShareNote(String uri, String pin) {
        NoteShareExample shareExample = new NoteShareExample();
        shareExample.or().andNoteShareUriEqualTo(uri);
        List<NoteShare> list = shareMapper.selectByExample(shareExample);
        if (list.size() == 1) {
            NoteShare noteShare =  list.get(0);
            if(noteShare.getNoteShareType()==1){
                if(!pin.equals(noteShare.getSharePin())){
                    return new Reslut(ReslutEnum.PIN_ERROR);
                }
            }
            Note note = noteMapper.selectByPrimaryKey(noteShare.getNoteId());
            if(note==null||note.getNoteState()==0){
                return new Reslut(ReslutEnum.NOT_FOUND,"该笔记已删除或取消分享");
            }
            JSONObject jo = new JSONObject();
            jo.put("title",note.getNoteTitle());
            jo.put("txt",note.getNoteBookText());
            return new Reslut(jo);
        } else
            return new Reslut(ReslutEnum.NOT_FOUND,"该笔记已删除或取消分享");

    }

}
