package TexasPoker;

import java.util.Scanner;

public class TexasPoker {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Poker[] Black = new Poker[5];
        Poker[] White = new Poker[5];

        String temp = new String();

        System.out.println("Black:");
        for (int i = 0; i < 5; i++) {
            temp = in.next();
            Black[i] = new Poker(CharToInt(temp.charAt(0)), temp.charAt(1));
        }

        System.out.println("White:");
        for (int i = 0; i < 5; i++) {
            temp = in.next();
            White[i] = new Poker(CharToInt(temp.charAt(0)), temp.charAt(1));
        }

        Poker t = new Poker(0, '0');

        for (int i = 0; i < 4; i++) {

            for (int j = i + 1; j < 5; j++) {
                if(Black[i].getNum() > Black[j].getNum()){
                    t = Black[i];
                    Black[i] = Black[j];
                    Black[j] = t;
                }
                if(White[i].getNum() > White[j].getNum()){
                    t = White[i];
                    White[i] = White[j];
                    White[j] = t;
                }
            }

        }

        int flag_B_1 = 0, flag_W_2 = 0, flag_B_3 = 1;
        int flag_W_1 = 0, flag_B_2 = 0, flag_W_3 = 1;

        //测试对子
        for (int i = 0; i < 4; i++) {
            if(Black[i].getNum() == Black[i + 1].getNum()){
                flag_B_1++;
                i++;
            }
        }
        if (flag_B_1 == 1) {
            flag_B_3 = 2;
        }
        else if (flag_B_1 == 2) {
            flag_B_3 = 3;
        }
        for (int i = 0; i < 4; i++) {
            if(White[i].getNum() == White[i + 1].getNum()){
                flag_W_1++;
                i++;
            }
        }
        if (flag_W_1 == 1) {
            flag_W_3 = 2;
        }
        else if (flag_W_1 == 2) {
            flag_W_3 = 3;
        }

        //测试三条
        flag_B_1 = 0;
        flag_W_1 = 0;
        for (int i = 0; i < 3; i++) {
            if(Black[i].getNum() == Black[i + 1].getNum() && Black[i].getNum() == Black[i + 2].getNum()){
                flag_B_1++;
            }
        }
        if (flag_B_1 == 1) {
            flag_B_3 = 4;
        }
        for (int i = 0; i < 3; i++) {
            if(White[i].getNum() == White[i + 1].getNum() && White[i].getNum() == White[i + 2].getNum()){
                flag_W_1++;
            }
        }
        if (flag_W_1 == 1) {
            flag_W_3 = 4;
        }

        //测试顺子
        flag_B_1 = 0;
        flag_W_1 = 0;
        for (int i = 0; i < 4; i++) {
            if(Black[i].getNum() == Black[i + 1].getNum() - 1){
                flag_B_1++;
            }
            if(White[i].getNum() == White[i + 1].getNum() - 1) {
                flag_W_1++;
            }
        }

        if (flag_B_1 == 4) {
            flag_B_3 = 5;
        }
        if (flag_W_1 == 4) {
            flag_W_3 = 5;
        }

        //测试同花
        for (int i = 0; i < 4; i++) {
            if(Black[i].getSuit() == Black[i + 1].getSuit()){
                flag_B_2++;
            }
        }
        if (flag_B_2 == 4) {
            flag_B_3 = 6;
        }
        for (int i = 0; i < 4; i++) {
            if(White[i].getSuit() == White[i + 1].getSuit()){
                flag_W_2++;
            }
        }
        if (flag_W_2 == 4) {
            flag_W_3 = 6;
        }

        //测试同花顺
        if (flag_B_1 == 4 && flag_B_2 == 4) {
            flag_B_3 = 7;
        }
        if (flag_W_1 == 4 && flag_W_2 == 4) {
            flag_W_3 = 7;
        }

        //比较大小
        if (flag_B_3 > flag_W_3) {
            ResultOutput('B');
        }
        else if (flag_B_3 < flag_W_3) {
            ResultOutput('W');
        }
        else{
            switch (flag_B_3){
                case 1:{
                    for (int i = 4; i > -1; i--) {
                        if (Black[i].getNum() > White[i].getNum()) {
                            ResultOutput('B');
                        }
                        else if (Black[i].getNum() < White[i].getNum()){
                            ResultOutput('W');
                        }
                        if (i == 1) {
                            ResultOutput('T');
                        }
                    }
                }break;
                case 2:{
                    int B = 0, W = 0;
                    for (int i = 0; i < 4; i++) {
                        if(Black[i].getNum() == Black[i + 1].getNum()){
                            B = Black[i].getNum();
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if(White[i].getNum() == White[i + 1].getNum()){
                            W = White[i].getNum();
                        }
                    }
                    if (B > W) {
                        ResultOutput('B');
                    }
                    else if (B < W){
                        ResultOutput('W');
                    }
                    else if (B == W) {
                        for (int i = 4, j = 4; i > -1 && j > -1; i--, j--) {
                            if (Black[i].getNum() == B) {
                                i--;
                                j++;
                                continue;
                            }
                            if (White[j].getNum() == W){
                                j--;
                                i++;
                                continue;
                            }

                            if (Black[i].getNum() > White[j].getNum()) {
                                ResultOutput('B');
                            }
                            else if (Black[i].getNum() < White[j].getNum()){
                                ResultOutput('W');
                            }
                        }
                        ResultOutput('T');
                    }
                }break;
                case 3:{
                    int B_1 = 0, B_2 = 0, W_1 = 0, W_2 = 0;
                    for (int i = 0; i < 4; i++) {
                        if(Black[i].getNum() == Black[i + 1].getNum()){
                            B_1 = Black[i].getNum();
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if(White[i].getNum() == White[i + 1].getNum()){
                            W_1 = White[i].getNum();
                        }
                    }
                    if (B_1 > W_1) {
                        ResultOutput('B');
                    }
                    else if (B_1 < W_1){
                        ResultOutput('W');
                    }
                    /////
                    for (int i = 0; i < 4; i++) {
                        if(Black[i].getNum() == Black[i + 1].getNum() && Black[i].getNum() == B_1){
                            B_2 = Black[i].getNum();
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if(White[i].getNum() == White[i + 1].getNum() && White[i].getNum() == W_1){
                            W_2 = White[i].getNum();
                        }
                    }
                    if (B_2 > W_2) {
                        ResultOutput('B');
                    }
                    else if (B_2 < W_2){
                        ResultOutput('W');
                    }
                    /////
                    else if (B_1 == W_1 && B_2 == W_2) {
                        for (int i = 4, j = 4; i > -1 && j > -1; i--, j--) {
                            if (Black[i].getNum() == B_1 || Black[i].getNum() == B_2) {
                                i--;
                                j++;
                                continue;
                            }
                            if (White[j].getNum() == W_1 || White[j].getNum() == W_2){
                                j--;
                                i++;
                                continue;
                            }
                            if (Black[i].getNum() > White[j].getNum()) {
                                ResultOutput('B');
                            }
                            else if (Black[i].getNum() < White[j].getNum()){
                                ResultOutput('W');
                            }
                        }
                        ResultOutput('T');
                    }
                }break;
                case 4:{
                    int B = 0, W = 0;
                    for (int i = 0; i < 3; i++) {
                        if(Black[i].getNum() == Black[i + 1].getNum() || Black[i].getNum() == Black[i + 2].getNum()){
                            B = Black[i].getNum();
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        if(White[i].getNum() == White[i + 1].getNum() || White[i].getNum() == White[i + 2].getNum()){
                            W = White[i].getNum();
                        }
                    }
                    if (B > W) {
                        ResultOutput('B');
                    }
                    else if (B < W){
                        ResultOutput('W');
                    }
                    else if (B == W) {
                        ResultOutput('T');
                    }
                }break;
                case 5:{
                    if (Black[4].getNum() > White[4].getNum()) {
                        ResultOutput('B');
                    }
                    else if (Black[4].getNum() < White[4].getNum()){
                        ResultOutput('W');
                    }
                    else if (Black[4].getNum() == White[4].getNum()) {
                        ResultOutput('T');
                    }
                }break;
                case 6:{
                    for (int i = 4; i > -1; i--) {
                        if (Black[i].getNum() > White[i].getNum()) {
                            ResultOutput('B');
                        }
                        else if (Black[i].getNum() < White[i].getNum()){
                            ResultOutput('W');
                        }
                        if (i == 0) {
                            ResultOutput('T');
                        }
                    }
                }break;
                case 7:{
                    if (Black[4].getNum() > White[4].getNum()) {
                        ResultOutput('B');
                    }
                    else if (Black[4].getNum() < White[4].getNum()) {
                        ResultOutput('W');
                    }
                    else if (Black[4].getNum() == White[4].getNum()) {
                        ResultOutput('T');
                    }
                }break;
            }
        }
        return;
    }

    public static int CharToInt(char x){
        switch(x){
            case '2':;
            case '3':;
            case '4':;
            case '5':;
            case '6':;
            case '7':;
            case '8':;
            case '9':return x - '0';
            case 'T':return 10;
            case 'J':return 11;
            case 'Q':return 12;
            case 'K':return 13;
            case 'A':return 14;
            default:; break;
        }
        return 0;
    }

    public static void ResultOutput(char ch){
        if (ch == 'B') {
            System.out.println("Black wins");
        }
        else if (ch == 'W') {
            System.out.println("White wins");
        }
        else if (ch == 'T') {
            System.out.println("Tie");
        }
        return;
    }
}
