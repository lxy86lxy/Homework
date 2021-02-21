package homework;

import monster_property.Monster;
import personproperty.Person;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Sc extends JFrame {
    public static int z[] = new int[100];//储存怪物原来血量
    HaemalStrand haemalStrand = new HaemalStrand();//实例化界面对象
    public static int yuan;//表示主角原始血量
    Scanner put = new Scanner(System.in);

    public void fun() {
        //输入主角属性
        Person person = new Person();
        System.out.println("请输入主角名字");
        person.setName(put.next());
        System.out.println("请输入主角生命值");
        person.setHp(put.nextInt());
        System.out.println("请输入主角攻击力");
        person.setAtk(put.nextInt());
        System.out.println("请输入主角防御力");
        person.setDef(put.nextInt());
        System.out.println("请输入想要设置的怪物数量:");
        int n = put.nextInt();
        yuan = person.getHp();
        List<Monster> mo = new ArrayList<Monster>(fen(n));//对怪物对象集合
        menu(person, mo, n);//选择调用的战斗过程
        fin(n,person,mo);//展示最后血量的文字结果和界面结果
    }

    public void menu(Person person, List<Monster> mo, int n) {
        System.out.println("请选择战斗方式\n1.一回合主角随机攻击一个怪物\t\t2.一回合攻击所有怪物一次\t\t3.一回合攻击指定怪物\t\t0.退出战斗");
        int a = put.nextInt();
        switch (a) {

            case 1:
                did(person, mo, n);
                break;
            case 2:
                does(person, mo, n);
                break;
            case 3:
                done(person, mo, n);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    //对怪物属性操作
    public List<Monster> fen(int n) {
        //对Monster实例化
        Monster[] monster = new Monster[100];
        List<Monster> mo = new ArrayList<Monster>();
        //循环输入怪物的属性
        int i;
        for (i = 0; i < n; i++) {
            System.out.println("请输入怪物名字");
            String name = put.next();
            System.out.println("请输入怪物生命值");
            int hp = put.nextInt();
            System.out.println("请输入怪物攻击力");
            int atk = put.nextInt();
            System.out.println("请输入怪物防御力");
            int def = put.nextInt();
            Monster add = new Monster(name, hp, atk, def);
            monster[i] = add;
            z[i] = add.getHp();
            mo.add(monster[i]);//存入怪物对象
        }
        return mo;//返回一个怪物对象集合
    }

    //判断是否所有的怪物血量都清空
    public boolean get(List<Monster> mo, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (mo.get(i).getHp() > 0) {
                count++;
            }
            if (count > 0) {
                return true;
            }
            count = 0;
        }
        return false;
    }

    //一回合主角随机攻击一个怪物
    public void did(Person person, List<Monster> mo, int n) {
        for (int i = 0; person.getHp() > 0 && get(mo, n); i++) {
            Random random = new Random();
            int j = random.nextInt(n);//随机称取不超过n的数字，n为开始设置的怪物数
            if (mo.get(j).getHp() > 0) {//防止对已死亡的怪物二次攻击
                if (i % 2 == 0) {
                    int x = person.ATK(mo.get(j));
                    System.out.println(person.getName() + "对" + mo.get(j).getName() + "造成" + x + "点伤害");
                } else {//每个怪物对主角攻击
                    int k;
                    for (k = 0; k < n; k++) {//防止已死亡的怪物再次攻击主角
                        if (mo.get(k).getHp() > 0) {
                            int x = mo.get(k).ATK(person);
                            System.out.println(mo.get(k).getName() + "对" + person.getName() + "造成" + x + "点伤害");
                        }
                    }
                }
            } else {
                i--;//在使用时奇偶发生变化，通过-1保持i值不变
                continue;
            }
        }
    }

    //一回合攻击所有怪物一次
    public void does(Person person, List<Monster> mo, int n) {
        for (int i = 0; person.getHp() > 0 && get(mo, n); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (mo.get(j).getHp() > 0) {//防止对已死亡的怪物二次攻击
                        int x = person.ATK(mo.get(j));
                        System.out.println(person.getName() + "对" + mo.get(j).getName() + "造成" + x + "点伤害");
                    }else {
                    continue;
                   }
                }
            } else {//每个怪物对主角攻击
                int k;
                for (k = 0; k < n; k++) {//防止已死亡的怪物再次攻击主角
                    if (mo.get(k).getHp() > 0) {
                        int x = mo.get(k).ATK(person);
                        System.out.println(mo.get(k).getName() + "对" + person.getName() + "造成" + x + "点伤害");
                    }
                }
            }
        }
    }

    //一回合攻击指定怪物
    public void done(Person person, List<Monster> mo, int n) {
        for (int i = 0; person.getHp() > 0 && get(mo, n); i++) {
                if (i % 2 == 0) {
                    System.out.println("请输入你想攻击的怪物的序号");
                    int na = put.nextInt()-1;
                    if (mo.get(na).getHp() > 0) {//防止对已死亡的怪物二次攻击
                    int x = person.ATK(mo.get(na));
                    System.out.println(person.getName() + "对" + mo.get(na).getName() + "造成" + x + "点伤害");
                }else {
                        i--;//在使用时奇偶发生变化，通过-1保持i值不变
                        continue;
                    }
                } else {//每个怪物对主角攻击
                    int k;
                    for (k = 0; k < n; k++) {//防止已死亡的怪物再次攻击主角
                        if (mo.get(k).getHp() > 0) {
                            int x = mo.get(k).ATK(person);
                            System.out.println(mo.get(k).getName() + "对" + person.getName() + "造成" + x + "点伤害");
                        }
                    }
                }
            }
        }

        //输出最后所有角色的HP
        public void fin(int n,Person person,List<Monster> mo){
        if (person.getHp() > 0) {
            System.out.println(person.getName() + "最终HP:" + person.getHp());//输出主角的最终血量
            haemalStrand.xue(person.getHp(), yuan, person.getName(), n, mo);//显示最后血条界面
            for (int i = 0; i < n; i++) {
                System.out.println(mo.get(i).getName() + "最终HP:0");//输出没有怪物的最终血量
            }
        } else {
            System.out.println(person.getName() + "最终HP:0");
            List<Integer> last = new ArrayList<>();//怪物原始血量集合
            for (int i = 0; i < n; i++) {
                if (mo.get(i).getHp() > 0) {//输出怪物最后血量
                    System.out.println(mo.get(i).getName() + "最终HP:" + mo.get(i).getHp());
                } else {
                    System.out.println(mo.get(i).getName() + "最终HP:0");
                }
                last.add(z[i]);
            }
            haemalStrand.wue(last, mo, person.getName());
        }
        //判断主角是否胜利
        if (person.getHp() > 0) {
            System.out.println(person.getName() + "战斗胜利");
        } else {
            System.out.println(person.getName() + "战斗失败");
        }
    }
}


