package com.oujinjin.service;

import com.oujinjin.entity.Goods;
import com.oujinjin.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommodityManager extends IOException  {
    public User user;
    public Scanner scanner;
    public CommodityManager(ArrayList<User> list,ArrayList<Goods> listPro) {
        //获取用户信息
        getSystemUsers(list);
        //获取保存的商品信息
        getGoods(listPro);
    }

    public  CommodityManager(){

    }
    public void writeGoods(ArrayList<Goods> list){
       /*
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Goods.txt"));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
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
        /*
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User.txt"));
            try {
                Object o = ois.readObject();
                list = (ArrayList<User>) o;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        File file = new File("D:\\User.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if(obj instanceof User){
                this.user = (User) obj;

                list.get(0).setName(((User) obj).getName());
                list.get(0).setPassword(((User) obj).getPassword());
                list.get(0).setFlag(((User) obj).isFlag());

            }
        }catch(EOFException e){
          //  读取失败，第一次创建，所以需要创建一个默认账户

            this.user = new User();
            user.setName("admin");
            user.setPassword("admin");

/*
            list.get(0).setName("admin");
            list.get(0).setPassword("admin");
            list.get(0).setFlag(true);
*/

            //把内容中的用户信息写入本地
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
        /*
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Goods.txt"));
            try {
                Object o = ois.readObject();
                list = (ArrayList<Goods>) o;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
        File file = new File("D:\\Goods.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                list = (ArrayList<Goods>) obj;
            }
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
        /*
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.txt"));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\User.txt");
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
}




