package com.oujinjin.service;
import com.oujinjin.entity.Num;
import com.oujinjin.entity.Goods;
import com.oujinjin.entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductClient {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Num i = new Num();

        //进阶没做完.跳到51行
        //创建文件
        File file = new File("D:\\Goods.txt");
        File file2 = new File("D:\\User.txt");
        boolean b = file.createNewFile();
        boolean b2 = file2.createNewFile();
         if(b){
             System.out.println("a");
         }
         else {
            System.out.println("b");
        }

        if(b2){
            System.out.println("a");
        }
        else {
            System.out.println("b");
        }
//------------------//
        CommodityManager c = new CommodityManager();
        ArrayList<Goods> listPro = new ArrayList<>();
        ArrayList<User> list = new ArrayList<>();
        Rl rl = new Rl();
        Crud crud = new Crud();
        Purchase purchase = new Purchase();
        boolean back = false;//是否返回上一级

        //获取本地数据

        c.getSystemUsers(list);
        c.getGoods(listPro);



 //唉第二个功能报废了...
//--------------------------------------------------------------//
        while(!back) {
            if (rl.rl(list)) {
                //System.out.println(list.get(0).getName());
                System.out.println("管理员登陆成功!");
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.txt"));
/*
                list.get(0).setName("admin");
                list.get(0).setPassword("admin");
                //把内容中的用户信息写入本地
                c.writeSystemUsers(list);
                oos.writeObject(list);
*/
                crud.zsgc(listPro);
                continue;
            }
            else {
                System.out.println("用户登陆成功!");
                purchase.purchase(listPro);
                continue;
            }
        }


    }

}
