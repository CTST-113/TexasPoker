package TexasPoker;

public class Poker {
    private int num;
    private char suit;

    public Poker(int num, char suit){
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public char getSuit() {
        return suit;
    }
}
