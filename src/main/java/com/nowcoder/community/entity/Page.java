package com.nowcoder.community.entity;

/*
*  封装分页相关的信息
* */

// SpringMVC会自动将请求中的参数映射到Controller方法参数上，默认按照同名规则映射，无论是基本类型与之同名，还是对象中的成员与之同名。
public class Page {
    //当前页码
    private int current = 1;
    //显示的上限
    private int limit = 10;
    //数据的总数，用于计算总的页数
    private int rows;
    //查询路径（用于复用页面链接）
    private String path;

    /*
    前面两个是页面传进来的，后两个是传给页面的
     */
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
       if (limit >= 1 && limit <= 100) this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
       if (rows >= 0) this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*
    * 获取当前页的起始行（左闭右开区间）
    * */
    public int getoffset() {
        return (current - 1) * limit;
    }

    /*
    * 获取总页数
    * */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /*
    * 获取起始页码:离当前页最近的前面几页
    * */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /*
    * 获取结束页码
    * */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }

}
