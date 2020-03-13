package com.tji.view;
import com.tji.bean.User;

import java.util.Scanner;

public class View {
    private static Scanner input = new Scanner(System.in);

    //��ҳ��ͼ
    public static User indexView(){
        System.out.println("**************************************************");
        System.out.println("**************\t\tѧ����Ϣ����ϵͳ\t\t*************");
        System.out.println("**************\t\t�������ʾ������Ϣ\t\t*************");
        System.out.println("**************\t\t�������˺ţ�\t\t*************");
        String uname = input.nextLine();
        System.out.println("**************\t\t���������룺\t\t*************");
        String upass = input.nextLine();
        System.out.println("**************************************************");
        return new User(uname, upass);
    }

    //����Ա��ͼ
    public static int managerMenuView(){
        System.out.println("**************************************************");
        System.out.println("**************\t\t��ӭ����Ա�ؼ�\t\t*************");
        System.out.println("**************\t\t�������ʾ������Ϣ\t\t*************");
        System.out.println("**************\t\t0���˳�\t\t*************");
        System.out.println("**************\t\t1������ѧ����Ϣ\t\t*************");
        System.out.println("**************\t\t2��ɾ��ѧ����Ϣ\t\t*************");
        System.out.println("**************\t\t3���޸�ѧ����Ϣ\t\t*************");
        System.out.println("**************\t\t4����ѯѧ����Ϣ\t\t*************");
        System.out.println("**************************************************");
        int choice = input.nextInt();
        if(choice < 0 || choice > 4){
            System.out.println("�����������������");
            return managerMenuView();//�ص�
        }
        return choice;
    }

    public static User addMenuView(){
        System.out.println("**************\t\t�������ʾ������Ϣ\t\t*************");
        System.out.println("**************\t\t�������˺ţ�\t\t*************");
        String uname = input.nextLine();
        System.out.println("**************\t\t���������룺\t\t*************");
        String upass = input.nextLine();
        System.out.println("**************************************************");
        return new User(uname, upass);
    }
}
