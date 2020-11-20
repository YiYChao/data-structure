package top.chao.thread;

public class MyRunable implements Runnable {
//    private int ticket = 100;
    volatile private int ticket = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket > 0){
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket --;
                }
            }
        }
    }
}
