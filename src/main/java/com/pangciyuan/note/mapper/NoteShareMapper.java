package com.pangciyuan.note.mapper;

import com.pangciyuan.note.model.NoteShare;
import com.pangciyuan.note.model.NoteShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteShareMapper {
    long countByExample(NoteShareExample example);

    int deleteByExample(NoteShareExample example);

    int deleteByPrimaryKey(Integer noteShareId);

    int insert(NoteShare record);

    int insertSelective(NoteShare record);

    List<NoteShare> selectByExample(NoteShareExample example);

    NoteShare selectByPrimaryKey(Integer noteShareId);

    int updateByExampleSelective(@Param("record") NoteShare record, @Param("example") NoteShareExample example);

    int updateByExample(@Param("record") NoteShare record, @Param("example") NoteShareExample example);

    int updateByPrimaryKeySelective(NoteShare record);

    int updateByPrimaryKey(NoteShare record);
}