package javaSubject;

import java.util.*;
class Card
{
    private String color;//颜色（红桃，黑桃，梅花，方块）
    private String point;//点数（A,2,3,4,5,6,7,8,9,10,J,Q,K）
    public Card(String color,String point)//构造函数给颜色点数赋值
    {
        this.color=color;
        this.point=point;
    }
    public String getPoker()//返回当前对象的牌
    {
        return this.color+this.point;
    }
}
class DeckOfCards
{
    private String[] newPoker=new String[52];                                                                           //洗牌后的扑克牌
    public String[] colors= {"红桃","方块","梅花","黑桃"};
    public String[] points= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public String[] first_person=new String[newPoker.length/4];
    public String[] second_person=new String[newPoker.length/4];
    public String[] third_person=new String[newPoker.length/4];
    public String[] fourth_person=new String[newPoker.length/4];
    Card card[]=new Card[52];
    public void setPoker()                                                                                              //创建52张扑克牌(未加大小王)
    {
        int len=0;
        for(int i=0;i<colors.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                card[len++]=new Card(colors[i],points[j]);
            }
        }
    }
    public void printInitPoker()
    {
        System.out.println("创建的52张牌为:");
        for(int i=0;i<card.length;i++)
        {
            System.out.print(card[i].getPoker()+" ");
            if((i+1)%13==0)
                System.out.println();
        }
    }
    public void Shuffle_deck()//洗牌
    {
        Random r=new Random();
        int[] hash=new int[card.length];//哈希数组用来判断当前牌是否已经产生
        for(int i=0;i<hash.length;i++)
            hash[i]=0;
        int sub=0;
        while(sub<card.length)
        {
            int x=r.nextInt(card.length);
            if(hash[x]==0)//如果当前牌没有产生
            {
                newPoker[sub++]=card[x].getPoker();
                hash[x]=1;
            }
        }
    }
    public void deal()//发牌
    {
        int temp=0;
        for(int i=0;i<newPoker.length;)
        {
            first_person[i%4+temp]=newPoker[i++];
            second_person[i%4-1+temp]=newPoker[i++];
            third_person[i%4-2+temp]=newPoker[i++];
            fourth_person[i%4-3+temp]=newPoker[i++];
            temp++;
        }
    }
    public void print_result()//输出每个人手中的牌
    {
        System.out.println("第一个人手中的牌为:");
        for(int i=0;i<first_person.length;i++)
        {
            System.out.print(first_person[i]+" ");
        }
        System.out.println();
        System.out.println("第二个人手中的牌为:");
        for(int i=0;i<second_person.length;i++)
        {
            System.out.print(second_person[i]+" ");
        }
        System.out.println();
        System.out.println("第三个人手中的牌为:");
        for(int i=0;i<third_person.length;i++)
        {
            System.out.print(third_person[i]+" ");
        }
        System.out.println();
        System.out.println("第四个人手中的牌为:");
        for(int i=0;i<fourth_person.length;i++)
        {
            System.out.print(fourth_person[i]+" ");
        }
        System.out.println();
    }

}

public class PokeGame
{
    public static void main(String args[])
    {
        DeckOfCards test=new DeckOfCards();
        test.setPoker();
        test.printInitPoker();
        test.Shuffle_deck();
        test.deal();
        test.print_result();
    }
}
