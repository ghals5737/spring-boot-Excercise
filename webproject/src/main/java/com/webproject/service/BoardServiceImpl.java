package com.webproject.service;

import java.util.List;

import com.webproject.domain.Board;
import com.webproject.domain.BoardCategory;
import com.webproject.domain.Reply;
import com.webproject.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

	@Override
	public List<BoardCategory> cateList() throws Exception {
		return mapper.cateList();
    }

    @Override
    public void insertBoard(Board board) throws Exception {
       mapper.insertBoard(board);
	}

    @Override
    public List<Board> boardList() throws Exception {
        return mapper.boardList();
    }

    @Override
    public int getCnt() throws Exception {
        return mapper.getCnt();
    }

    @Override
    public List<Board> listPage(int startNum, int cnt) throws Exception {
        return mapper.listPage(startNum, cnt);
    }

    @Override
    public Board readPage(int bno) throws Exception {
        return mapper.readPage(bno);
    }

    @Override
    public void boardModify(Board board) throws Exception {
        mapper.boardModify(board);
    }

    @Override
    public void boardDelete(int bno) throws Exception {
        mapper.boardDelete(bno);
    }

    @Override
    public void rpRegist(Reply reply) throws Exception {
        mapper.rpRegist(reply);
	}

    @Override
    public List<Reply> replyList(int bno) throws Exception {
        return mapper.replyList(bno);
    }

    @Override
    public void modifyReply(Reply reply) throws Exception {
        mapper.modifyReply(reply);
    }

    @Override
    public void deleteReply(int rno) throws Exception {
        mapper.deleteReply(rno);
    }

    @Override
    public int getRpCnt(int bno) throws Exception {
        return mapper.getRpCnt(bno);
    }

}