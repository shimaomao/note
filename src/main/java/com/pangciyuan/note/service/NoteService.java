package com.pangciyuan.note.service;

import com.pangciyuan.note.model.Note;
import com.pangciyuan.note.model.NoteBook;
import com.pangciyuan.note.vertx.Reslut;

public interface NoteService {
	/**
	 * 获取用户的笔记本
	 * 
	 * @param userId
	 * @return
	 */
	Reslut getNoteBook(Integer userId);

	Reslut addNoteBook(NoteBook noteBook);

	Reslut updateNoteBook(NoteBook noteBook);

	Reslut deleteNoteBook(String bookId);

	/**
	 * 获取用户指定笔记本的笔记
	 * 
	 * @param userId
	 * @return
	 */
	Reslut getNoteList(Integer userId, Integer noteBookId, int pageNum);

	Reslut addNote(Note note);

	Reslut updateNote(Note note);

	Reslut deleteNote(String noteId);

}
