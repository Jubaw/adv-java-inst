package threads_gün3_multithreading_gün4;

public class Volatile01 {

    public static volatile int flag = 0;//değişkenin değerinin main memory'e alınmasını garanti etmek için volatile keyword'ünü kullanırız.
    //Cache'e alınıyor.


    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() { //1.Çekirdekte
            @Override
            public void run() {
                while (flag == 0){
                    System.out.println("Bu sadece bir risk!");
                }

            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() { //2.Çekirdekte
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag = 1;
                System.out.println("Flag 1 oldu, döngü duracak.");
            }
        });
        thread2.start();


















    }





}
