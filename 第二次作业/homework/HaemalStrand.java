package homework;

import monster_property.Monster;
import javax.swing.*;
import java.awt.*;
import java.util.List;

//游戏血条界面设计
public class HaemalStrand extends JFrame {
    String name;
    public int hp, yuan;
    JFrame jf = new JFrame("Heroic War");
    //战斗胜利时调用
    public void xue(int hp, int yuan, String name,int n,List<Monster> mo) {
        this.name = name;
        this.hp = hp;
        this.yuan = yuan;
        JLabel label = new JLabel() {
            public void paint(Graphics g) {
                super.paint(g);
                int HP = (hp * 100) / yuan;
                g.setColor(Color.RED);//主角的血条
                g.drawRect(100, 20 , 100, 10);
                g.fillRect(100, 20, HP, 10);
                for (int i = 0; i < n; i++) {//怪物们的血条
                    int y=20+25*i;
                    g.setColor(Color.RED);
                    g.drawRect(800, y, 100, 10);
                    int x=y+20;
                    String mname=mo.get(i).getName();
                    g.setColor(Color.BLACK);
                    g.drawString(mname,800,x);
                }
                g.setColor(Color.BLACK);
                g.drawString(name,100,50);
                g.setFont(new Font("Series", Font.BOLD, 50));
                g.setColor(Color.YELLOW);
                g.drawString(name+"战斗胜利",330,120);
            }
        };
        jf.add(label);
        jf.setSize(1000, 300);
        jf.setLocation(300,300);
        jf.setVisible(true);
    }

    //战斗失败时调用
    public void wue(List<Integer> last, List<Monster> mo,String name) {
        JLabel label = new JLabel() {
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.RED);//主角的血条
                g.drawRect(100, 20 , 100, 10);
                for (int i = 0; i <mo.size(); i++) {//怪物们的血条
                    int hp1=mo.get(i).getHp();
                    if(hp1<0||hp1==0){
                        hp1=0;//防止出现负数
                    }
                    int yuan1=last.get(i);
                    int HP = (hp1 * 100)/yuan1;
                    int y=20+25*i;
                    g.setColor(Color.RED);
                    g.drawRect(800, y, 100, 10);
                    g.fillRect(800, y, HP, 10);
                    int x=y+20;
                    String mname=mo.get(i).getName();
                    g.setColor(Color.BLACK);
                    g.drawString(mname,800,x);
                }
                g.setColor(Color.BLACK);
                g.drawString(name,100,50);
                g.setFont(new Font("Series", Font.BOLD, 50));
                g.setColor(Color.YELLOW);
                g.drawString(name+"战斗失败",330,120);}
        };
        jf.add(label);
        jf.setSize(1000, 300);
        jf.setLocation(300,300);
        jf.setVisible(true);
    }
}

