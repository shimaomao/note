package com.pangciyuan.note.mapper;

import com.pangciyuan.note.model.NoteBook;
import com.pangciyuan.note.model.NoteBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteBookMapper {
    long countByExample(NoteBookExample example);

    int deleteByExample(NoteBookExample example);

    int deleteByPrimaryKey(Integer noteBookId);

    int insert(NoteBook record);

    int insertSelective(NoteBook record);

    List<NoteBook> selectByExample(NoteBookExample example);

    NoteBook selectByPrimaryKey(Integer noteBookId);

    int updateByExampleSelective(@Param("record") NoteBook record, @Param("example") NoteBookExample example);

    int updateByExample(@Param("record") NoteBook record, @Param("example") NoteBookExample example);

    int updateByPrimaryKeySelective(NoteBook record);

    int updateByPrimaryKey(NoteBook record);
}