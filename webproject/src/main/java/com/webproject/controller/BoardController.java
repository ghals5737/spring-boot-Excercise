package com.webproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.webproject.domain.Board;
import com.webproject.domain.BoardCategory;
import com.webproject.domain.PageMaker;
import com.webproject.domain.Reply;
import com.webproject.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/board")
public class BoardController{
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);
    private String uploadPath="D:"+File.separator+"spring-project"+File.separator+"webproject"
    +File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static";
    @Autowired
    private BoardService service;

    @GetMapping("list")
    public void getList(Model model,@RequestParam("n")int num)throws Exception{
       logger.info("get list!!!");
       // 게시물 총 갯수
       int count = service.getCnt();
    
       // 한 페이지에 출력할 게시물 갯수
       int postNum = 5;
    
       // 게시물 총 갯수 / 한 페이지에 출력할 게시물 갯수 = 하단 페이징
     //  int pageCnt = (int)Math.ceil((double)count/(double)5);

       int startNum=(num-1)*postNum;
    
       List<Board> board=null;
       board=service.listPage(startNum, postNum);
       PageMaker pageMaker=new PageMaker();

       pageMaker.setTotalCount(count); // 전체 게시글 수를 지정한다.
       pageMaker.setPageNum(num); // 현재 페이지를 페이지 객체에 지정한다. -1을 해야 쿼리에서 사용 할 수 있다.
       pageMaker.setContentNum(5);// 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
       pageMaker.setCurrentBlock(num);// 현재 페이지 블록이 몇 번인지 현재 페이지 번호를 통해서 지정한다.
       pageMaker.setLastblock(pageMaker.getTotalCount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
       pageMaker.prevNext(num); // 현재 페이지 번호로 화살표를 나타낼지 정한다.
       pageMaker.setStartPage(pageMaker.getCurrentBlock()); // 시작 페이지를 페이지 블록 번호로 정한다.
       pageMaker.setEndPage(pageMaker.getLastblock(), pageMaker.getCurrentBlock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.
       
       model.addAttribute("board", board);
       model.addAttribute("pageMaker", pageMaker);       

    }
    @GetMapping("write")
    public void getWrite(Model model)throws Exception{
        logger.info("get Write!!!");

        List<BoardCategory> category=null;
        category=service.cateList();      
        
        model.addAttribute("category", category);
    }

    @PostMapping("write")
    public String postWrite(Board board)throws Exception{
        logger.info("post Write!!!");

        service.insertBoard(board);

        return "redirect:/board/list?n=1";
    }
    @PostMapping("/board/ckUpload")
    public void postCKEditorImgUpload(HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam MultipartFile upload) throws Exception {
            logger.info("post CKEditor img upload");
    
            // 랜덤 문자 생성
            UUID uid = UUID.randomUUID();
            
            OutputStream out = null;
            PrintWriter printWriter = null;
            
            // 인코딩
            res.setCharacterEncoding("utf-8");
            res.setContentType("text/html;charset=utf-8");
            
            try {
            
            String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
            byte[] bytes = upload.getBytes();
            
            // 업로드 경로
            String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
            
            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush();  // out에 저장된 데이터를 전송하고 초기화
            
            String callback = req.getParameter("CKEditorFuncNum");
            printWriter = res.getWriter();
            String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
        
            // 업로드시 메시지 출력
            printWriter.println("{\"filename\" : \""+callback+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");

            printWriter.flush();
            
            
            
            } catch (IOException e) { e.printStackTrace();
            } finally {
            try {
                if(out != null) { out.close(); }
                if(printWriter != null) { printWriter.close(); }
            } catch(IOException e) { e.printStackTrace(); }
            }
            
            return; 
    }
    @GetMapping("/read")
    public void getRead(Model model,@RequestParam("bno")int bno)throws Exception{
        logger.info("get Read !!!!");

        Board board=service.readPage(bno);
        board.setBno(bno);

        model.addAttribute("board", board);
    }
    @GetMapping("/modify")
    public void getModify(Model model,@RequestParam("bno")int bno)throws Exception{
        logger.info("get Modeify!!!");

        List<BoardCategory> category=null;
        category=service.cateList();      
        Board board=service.readPage(bno);
        board.setBno(bno);
        model.addAttribute("category", category); 
        model.addAttribute("board", board);
    }

    @PostMapping("/modify")
    public String postModify(Board board) throws Exception{
        logger.info("post modify!!!");

        service.boardModify(board);

        return "redirect:/board/list?n=1";
    }

    @PostMapping("delete")
    public String postDelete(@RequestParam("bno")int bno)throws Exception{
        logger.info("post delete!!!!");

        service.boardDelete(bno);
        return "redirect:/board/list?n=1";
    }
    @ResponseBody
    @PostMapping("/rpRegist")
    public void registReply(Reply reply)throws Exception{
         
           logger.info("regist reply");           
          
           //reply.setPdNum(pdNum);
 
           service.rpRegist(reply);       
    }
    @ResponseBody
    @GetMapping("/replyList")
    public List<Reply> getReplyList(@RequestParam("n") int bno)throws Exception{
 
         logger.info("get reply list");
         
         List<Reply> reply=service.replyList(bno);
         
         return reply;
    }
    @ResponseBody
    @PostMapping("/modifyReply")
    public void postModifyRegist(Reply reply)throws Exception {
       logger.info("post modify reply");
              
       service.modifyReply(reply);
    }
    @ResponseBody
    @PostMapping("/deleteReply")
    public void postDeleteRegist(int rno)throws Exception {
       logger.info("post delete reply ");
              
       service.deleteReply(rno);
    }
    
}