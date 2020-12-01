package com.oujinjin.service;
import com.oujinjin.entity.Num;
import com.oujinjin.entity.Goods;
import com.oujinjin.entity.Opt;
import com.oujinjin.entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductClient {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Num i = new Num();

        File file = new File("D:\\Goods.txt");
        File file2 = new File("D:\\User.txt");
        File file3 = new File("D:\\Opt.txt");

        file.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        UserGoodsManager c = new UserGoodsManager();
        ArrayList<Goods> listPro = new ArrayList<>();
        ArrayList<User> list = new ArrayList<>();
        ArrayList<Opt> listOpt = new ArrayList<>();
        Rl rl = new Rl();
        Crud crud = new Crud();
        Purchase purchase = new Purchase();
        boolean back = false;//是否返回上一级


        c.getSystemUsers(list);//获取用户信息
        if (file.length()!=0)
        c.getGoods(listPro);//获取商品信息
        if (file3.length()!=0)
        c.getOpt(listOpt);//获取商操作日志


        while(!back) {
            if (rl.rl(list,listOpt)) {

                System.out.println("管理员登陆成功!");
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.txt"));

                crud.zsgc(listPro,listOpt);

            }
            else {
                System.out.println("用户登陆成功!");
                purchase.purchase(listPro);
                continue;
            }
        }


    }

}
