package com.tji.view;
import com.tji.bean.User;

import java.util.Scanner;

public class View {
    private static Scanner input = new Scanner(System.in);

    //首页视图
    public static User indexView(){
        System.out.println("**************************************************");
        System.out.println("**************\t\t学生信息管理系统\t\t*************");
        System.out.println("**************\t\t请根据提示输入信息\t\t*************");
        System.out.println("**************\t\t请输入账号：\t\t*************");
        String uname = input.nextLine();
        System.out.println("**************\t\t请输入密码：\t\t*************");
        String upass = input.nextLine();
        System.out.println("**************************************************");
        return new User(uname, upass);
    }

    //管理员视图
    public static int managerMenuView(){
        System.out.println("**************************************************");
        System.out.println("**************\t\t欢迎管理员回家\t\t*************");
        System.out.println("**************\t\t请根据提示输入信息\t\t*************");
        System.out.println("**************\t\t0：退出\t\t*************");
        System.out.println("**************\t\t1：增加学生信息\t\t*************");
        System.out.println("**************\t\t2：删除学生信息\t\t*************");
        System.out.println("**************\t\t3：修改学生信息\t\t*************");
        System.out.println("**************\t\t4：查询学生信息\t\t*************");
        System.out.println("**************************************************");
        int choice = input.nextInt();
        if(choice < 0 || choice > 4){
            System.out.println("输入错误，请重新输入");
            return managerMenuView();//回调
        }
        return choice;
    }

    public static User addMenuView(){
        System.out.println("**************\t\t请根据提示输入信息\t\t*************");
        System.out.println("**************\t\t请输入账号：\t\t*************");
        String uname = input.nextLine();
        System.out.println("**************\t\t请输入密码：\t\t*************");
        String upass = input.nextLine();
        System.out.println("**************************************************");
        return new User(uname, upass);
    }
}
