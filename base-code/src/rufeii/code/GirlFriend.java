package rufeii.code;

public class GirlFriend {
    protected int age=999;
    private double high;
    private double weight;
    private String boy;
    public GirlFriend() {
        System.out.println("GirlFriend");
    }
    public GirlFriend(int age, double high, double weight, String boy) {
        this.age = age;
        this.high = high;
        this.weight = weight;
        this.boy = boy;
    }
    public void getGirlFriend(){
        System.out.printf("boy：%s，年龄：%d，身高：%.2f，体重：%.2f%n", boy, age, high, weight);
    }
    public void Call(){
        System.out.println("手机正在打电话");
    }
    public void PlayGame(){
        System.out.println("手机正在玩游戏");
    }
    public void Sleeping() {
        System.out.println("正在和男朋友睡觉");
    }
}