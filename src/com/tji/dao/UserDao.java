package com.tji.dao;
import com.tji.bean.User;

public interface UserDao {
    //��¼�����-1����ʧ�ܣ�1�������Ա�ɹ���2����ѧ���ɹ�
    int login(User user);

    //����ѧ���ķ���
    //user ����Ҫ��ӵĶ�����˺�����
    boolean insert(User user);

    //ɾ��ѧ���ķ���
    //
    boolean delete(String uname );
    //�޸���Ϣ
    boolean update(User user);

    //��ѯѧ����Ϣ�ķ���
    User select(String uname);
}
