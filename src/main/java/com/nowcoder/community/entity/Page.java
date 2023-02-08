package com.nowcoder.community.entity;

public class Page {
    private int current=1;
    private int limit=5;
    //数据总数（用于计算总页数）
    private int rows=100;
    //查询路径（用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1&&limit<100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //获取当前页的起始行
    public int getOffset(){
        return limit*(current-1);
    }
    //获取总的页数
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }
        else {
            return rows/limit+1;
        }
    }
    //获取起始页码
    public int getFrom(){
        int from=current-2;
        return from<1 ? 1:from;
    }
    //获取终止页码
    public int getTo(){
        int end=current+2;
        int total=getTotal();
        return end>total ? total:end;
    }
}
