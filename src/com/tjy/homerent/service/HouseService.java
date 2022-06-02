package com.tjy.homerent.service;

import com.tjy.homerent.domain.House;

/**
 * HouseService.java<=>类 [业务层]
 * //定义House[] ,保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */

public class HouseService {
    private House[] houses;
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"jack","112", "海淀区", 2000, "未出租");
    }

    public House findById(int findId) {

        //遍历数组
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;
    }

        //del方法，删除一个房屋信息
    public boolean del(int delId) {

        //应当先找到要删除的房屋信息对应的下标
        //老韩强调，一定要搞清楚 下标和房屋的编号不是一回事
        int index = -1;
        for(int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()) {//要删除的房屋(id),是数组下标为i的元素
                index = i;//就使用index记录i
            }
        }

        if(index == -1) {//说明delId在数组中不存在(有点绕..)
            return false;
        }
        //如果找到, 这里需要小伙伴动脑筋,有点难.
        //老师思路分析:
        for(int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        //把当有存在的房屋信息的最后一个 设置null
        houses[--houseNums] = null;
        return true;

    }
    public boolean add(House newHouse){
        if(houses.length == houseNums){
            System.out.println("数组已满，不能再添加");
            return false;
        }
        houses[houseNums++] =newHouse;
        newHouse.setId(++idCounter);
        return true;

    }

    public House[] list(){
        return houses;
    }
}
