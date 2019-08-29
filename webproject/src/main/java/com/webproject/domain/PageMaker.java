package com.webproject.domain;

public class PageMaker {
    private int totalCount;// 전체 게시물 개수
    private int pageNum;// 현재 페이지 번호
    private int contentNum = 5;// 한 페이지에 몇 개 표시할지
    private int startPage = 1;// 현재 페이지 블록의 시작페이지
    private int endPage = 5;// 현재 페이지 블록의 마지막 페이지
    private int prev = 0;// 이전 페이지로 가는 화살표
    private int next;// 다음 페이지로 가는 화살표
    private int currentBlock;// 현재 페이지 블록
    private int lastblock;// 마지막 페이지 블록

    public void prevNext(int pageNum) {
        if (pageNum > 0 && pageNum < 6) {
            setPrev(0);
            setNext(1);
        }
        else if (getLastblock() == getCurrentBlock()) {
            setPrev(1);
            setNext(0);
        }
        else {
            setPrev(1);
            setNext(1);
        }
    }

    public int calcpage(int totalCount , int contentNum) {
        int totalPage = totalCount / contentNum;
        if (totalCount % contentNum > 0) {
            totalPage++;
        }
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int currentBlock) {
        this.startPage = (currentBlock * 5) - 4;
        //1 2 3 4 5
        //6 7 8 9 10
        //11 12 13
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int getLastBlock, int getCurrentBlock) {
        if (getLastBlock == getCurrentBlock) { // 현재 페이지 블록이 마지막 블록이면
            this.endPage = calcpage(getTotalCount(), getContentNum()); // 페이지 개수를 끝페이지로 지정
        }
        else {
            this.endPage = getStartPage() + 4; // 시작 페이지 + 4를 끝페이지로 지정
        }
    }
    public int getPrev() {
        return prev;
    }
    public void setPrev(int prev) {
        this.prev = prev;
    }
    public int getNext() {
        return next;
    }
    public void setNext(int next) {
        this.next = next;
    }
    public int getCurrentBlock() {
        return currentBlock;
    }
    public void setCurrentBlock(int pageNum) { // 페이지 번호 5 들어옴
        //페이지 번호를 통해서 구한다.
        //페이지 번호 / 페이지 그룹 안의 개수
        //1p 1 / 5 => 0.2
        //5p 5 / 5 = > 1 -> 나머지는 0
        this.currentBlock = pageNum / 5;
        if (pageNum % 5 > 0) {
            this.currentBlock++;
        }
    }
    public int getLastblock() {
        return lastblock;
    }
    public void setLastblock(int totalCount) {

        this.lastblock = totalCount / (5 * this.contentNum);
        if (totalCount % (5 * this.contentNum) > 0) {
            this.lastblock++;
        }
    }
}