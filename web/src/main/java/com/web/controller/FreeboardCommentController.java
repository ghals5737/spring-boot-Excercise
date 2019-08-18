package com.web.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.domain.Freeboard;
import com.web.domain.FreeboardComment;
import com.web.repository.FreeboardCommentRepository;
import com.web.service.freeboardComment.FreeboardCommentListService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.MediaTypes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FreeboardCommentController {

    @Autowired
    private FreeboardCommentListService freeboardCommentListService;
    @Autowired
    private FreeboardCommentRepository freeboardCommentRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(value = "/freeboardCommentList", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
    public @ResponseBody String freeboardCommentList() {
        Freeboard freeboard = (Freeboard) session.getAttribute("freeboard");
        List<FreeboardComment> commentList = freeboardCommentListService.getList(freeboard.getFreeId());
        String value = null;
        try{
            value = objectMapper.writeValueAsString(commentList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
    @PostMapping("/freeboardCommentWrite")
    public @ResponseBody String freeboardCommentWrite(@RequestBody FreeboardComment freeboardComment){
        freeboardComment.setWrite_date(LocalDateTime.now());
        freeboardCommentRepository.save(freeboardComment);
        return "freeboardComment inserted";
    }
}
