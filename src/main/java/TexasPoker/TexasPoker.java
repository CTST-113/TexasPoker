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
}
