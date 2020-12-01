package com.oujinjin.service;

import com.oujinjin.entity.Goods;
import com.oujinjin.entity.Opt;
import com.oujinjin.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserGoodsManager extends IOException  {
    public User user;
    public Scanner scanner;
    public UserGoodsManager(ArrayList<User> list, ArrayList<Goods> listPro) {
        //获取用户信息
        getSystemUsers(list);
        //获取保存的商品信息
        getGoods(listPro);
    }

    public UserGoodsManager(){

    }
    public void writeGoods(ArrayList<Goods> list){

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\Goods.txt");
            oos = new ObjectOutputStream(fos);
            // 把默认账户写入保存用户信息的文件中
            oos.writeObject(list);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {

            e1.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public  void getSystemUsers(ArrayList<User> list){

        File file = new File("D:\\User.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            list.addAll(((ArrayList<User>) obj));

        }catch(EOFException e){

            this.user = new User();
            user.setName("admin");
            user.setPassword("admin");
            user.setFlag(true);
            user.setId(0);
            list.add(user);
            //将内容写入本地
            writeSystemUsers(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(ois!=null){//非空
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getGoods(ArrayList<Goods> list){

        File file = new File("D:\\Goods.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            list.addAll(((ArrayList<Goods>) obj));


        }catch(EOFException e){
            list = new ArrayList<Goods>();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  void  writeSystemUsers(ArrayList<User> list) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\User.txt");
            oos = new ObjectOutputStream(fos);
//将用户写入本地
            oos.writeObject(list);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public  void  writeOpt(ArrayList<Opt> list) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\Opt.txt");
            oos = new ObjectOutputStream(fos);
//将日志写入本地
            oos.writeObject(list);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void getOpt(ArrayList<Opt> list){

        File file = new File("D:\\Opt.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            list.addAll(((ArrayList<Opt>) obj));


        }catch(EOFException e){
            list = new ArrayList<Opt>();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




