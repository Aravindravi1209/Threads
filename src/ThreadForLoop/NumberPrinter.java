package ThreadForLoop;

public class NumberPrinter implements Runnable{
    int num;
    public NumberPrinter(int num)
    {
        this.num=num;
    }
    @Override
    public void run() {
        System.out.println("The number is "+num);
    }
}
