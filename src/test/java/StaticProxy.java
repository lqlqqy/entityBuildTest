public class StaticProxy {
    // 静态代理

    public static void main(String[] args) {
        //new WeddingProxy(new People()).marry();
        //wp.marry();
        new Thread(()->{
            System.out.println("我是线程呀");
        }).start();


    }
}

interface IMarry {
    void marry();
}

class People implements IMarry{

    @Override
    public void marry() {
        System.out.println("我要结婚了 新郎就是我");
    }
}

class WeddingProxy implements IMarry{
    private People people;

    public WeddingProxy(People people) {
        this.people = people;
    }

    @Override
    public void marry() {
        System.out.println("结婚前做事");
        people.marry();
        System.out.println("结婚首尾");
    }
}
