package com.hly.os;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author :hly
 * @date :2018/6/5
 */
public class GroupsLinking {
    //���ô��̿�
    static int[][] groupsLinking = {{3, 1, 2, 3}, {3, 4, 5, 6,}, {0, 0, 0, 0}, {0, 0, 0, 0}, {2, 0, 7, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    //��ǰ���п�
    static List<Integer> freeList = new ArrayList<Integer>() {{
        for (int i = 1; i <= 7; i++) {
            add(i);
        }
    }};

    static Scanner scanner = new Scanner(System.in);

    //������п�
    public static void allocate() {
        //���п���,������̿��
        int freeNum, allocativeNum;
        //��ǰ���̿����1��
        if (groupsLinking[0][0] > 1) {
            freeNum = groupsLinking[0][0];
            allocativeNum = groupsLinking[0][freeNum];
            groupsLinking[0][0]--;
            freeList.remove((Integer) allocativeNum);
            System.out.println("����Ŀ��Ϊ��" + allocativeNum);
        }

        else if (groupsLinking[0][0] == 1) {

            if (groupsLinking[0][1] != 0) {
                allocativeNum = groupsLinking[0][1];
                for (int j = 0; j < groupsLinking[allocativeNum].length; j++)
                    //��ǰ���Ѿ������꣬��һ�鿽������ǰ��
                    groupsLinking[0][j] = groupsLinking[allocativeNum][j];
                //groupsLinking[0][0]--;
                freeList.remove((Integer) allocativeNum);
                System.out.println("����Ŀ��Ϊ��" + allocativeNum);

            } else {
                System.out.println("�Ѿ�û�п��п���");
                return;
            }
        }
        else {
            System.out.println("��ǰ���Ѿ���������");
        }
        display();
    }

    //���տ��п�
    public static void recycling() {
        int freeNum;
        System.out.println("������������յĿ����̿���̿��:");
        int recyclingNum = scanner.nextInt();
        for (int i = 0; i < freeList.size(); i++) {
            if (freeList.get(i) == recyclingNum) {
                System.out.println("�ÿ��п��Ѿ�����");
                return;
            }
        }
        //��ǰ�鲻��3��
        if (groupsLinking[0][0] < 3) {
            freeNum = groupsLinking[0][0];
            groupsLinking[0][++freeNum] = recyclingNum;
            freeList.add(recyclingNum);
            groupsLinking[0][0]++;
        } else {
            for (int j = 0; j <= 3; j++)
                groupsLinking[recyclingNum][j] = groupsLinking[0][j];
            groupsLinking[0][0] = 1;
            groupsLinking[0][1] = recyclingNum;
            freeList.add(recyclingNum);
        }
        display();
    }

    public static void display() {
        int freeNum, temp, groupNum = 1;
        //�����̿����û�н�β,���滹�кܶ���
        if (groupsLinking[0][1] != 0) {
            freeNum = groupsLinking[0][0];
            System.out.println("��һ���̿�:");
            //�����һ������̿�
            for (int j = 1; j <= freeNum; j++) {
                System.out.print(groupsLinking[0][j] + " ");
            }
            System.out.println();
            //��һ���̿�
            temp = groupsLinking[0][1];
            groupNum++;
            while (groupsLinking[temp][1] != 0) {
                System.out.println("��" + groupNum + "���̿�:");
                freeNum = groupsLinking[temp][0];
                for (int j = 1; j <= freeNum; j++) {
                    System.out.print(groupsLinking[temp][j] + " ");
                }
                System.out.println();
                groupNum++;
                temp = groupsLinking[temp][1];
            }

            System.out.println("��" + groupNum + "���̿飬Ҳ�����һ��:");
            freeNum = groupsLinking[temp][0];

            for (int j = 2; j <= freeNum; j++) {
                System.out.print(groupsLinking[temp][j] + " ");
            }
            System.out.println();

        }

        else {
            freeNum = groupsLinking[0][0];
            //1��ʾֻ��0
            if (freeNum == 1) {
                System.out.println("�����̿��Ѿ�ȫ��������:");
            } else {
                System.out.println("��һ���̿�Ϊ:");
                for (int j = 2; j <= freeNum; j++) {
                    System.out.print(groupsLinking[0][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void menu() {
        int i = scanner.nextInt();
        if (i == 1) {
            allocate();
            menu();
        } else if (i == 2) {
            recycling();
            menu();
        } else if (i == 3) {
            System.out.println("���˳�");
        }
    }

    public static void main(String[] args) {
        display();
        System.out.println("�����������1:���䣬2:����,3:�˳�");
        menu();

    }

}
