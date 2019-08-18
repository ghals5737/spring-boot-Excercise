package com.web.service.freeboard;

import com.web.domain.*;
import com.web.repository.*;
import com.web.pageMaker.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreeboardListService {
    @Autowired
    private HttpSession session;

    @Autowired
    private PageMakerService pageMakerService;

    @Autowired
    private FreeboardRepository freeboardRepository;

    public String freeboardList(int pageNum) {

        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum,10,freeboardRepository);

        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "freeId");
        Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);

        if (freeboardPage.getSize() == 0) {
            session.setAttribute("boardList",new ArrayList<Freeboard>());
            session.setAttribute("pageMaker",pageMaker);
            return "freeboard";
        }

        List<Freeboard> freeboardList = freeboardPage.getContent();
        session.setAttribute("boardList", freeboardList);
        session.setAttribute("pageMaker",pageMaker);

        return "freeboard";
    }
}
