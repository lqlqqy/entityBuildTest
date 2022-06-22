import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args) {

        System.out.println("dd");
    }

}

class MyThread implements Callable<Object>{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
