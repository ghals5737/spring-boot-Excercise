package com.web.service.freeboard;

import com.web.domain.*;
import com.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class FreeboardInfoService {
    @Autowired
    private FreeboardRepository freeboardRepository;
    @Autowired
    private HttpSession session;

    public String getFreeboardPost(String stringFreeId){
        Long freeId = Long.parseLong(stringFreeId);
        Freeboard freeboard = freeboardRepository.findById(freeId).get();
        if (freeboard == null){
            return "freeboard";
        }

        session.setAttribute("freeboard",freeboard);

        return "freeBoardInfo";
    }
}