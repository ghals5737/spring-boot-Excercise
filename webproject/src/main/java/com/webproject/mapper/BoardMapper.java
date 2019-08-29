package com.webproject.mapper;

import java.util.List;

import com.webproject.domain.Board;
import com.webproject.domain.BoardCategory;
import com.webproject.domain.Reply;

public interface BoardMapper {
    public List<BoardCategory> cateList()throws Exception;
    public void insertBoard(Board board)throws Exception;
    public List<Board> boardList()throws Exception;
    public int getCnt()throws Exception;
    public List<Board> listPage(int startNum,int cnt)throws Exception;
    public Board readPage(int bno)throws Exception;
    public void boardModify(Board board)throws Exception;
    public void boardDelete(int bno)throws Exception;
    public void rpRegist(Reply reply)throws Exception;
    public List<Reply> replyList(int bno)throws Exception;
    public void modifyReply(Reply reply)throws Exception;
    public void deleteReply(int rno)throws Exception;
    public int getRpCnt(int bno)throws Exception;
}