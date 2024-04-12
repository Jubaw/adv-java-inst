package threads_gün3_multithreading_gün4;

import java.security.PublicKey;

public class Multithreading01 {
    public static void main(String[] args) {


        //TASK: 1'den 10'a 2 defa saydıralım.

        //Tek tek sayıyor.Single threading
//        long start = System.currentTimeMillis();
//        Counter counter1 = new Counter("Hakan");
//        Counter counter2 = new Counter("Ahmet");
//
//
//        counter1.count();
//        counter2.count();
//        long finish = System.currentTimeMillis();
//        System.out.println("Main ile geçen süre: " + (finish - start));

        //Aynı anda sayıyor.Multi-threading


        System.out.println("-------------------------------Multi Threading-------------------------------");

        long start = System.currentTimeMillis();
        Thread thread1 = new CounterThread("Ahmet");
        Thread thread2 = new CounterThread("Selim");
        thread1.start();
        thread2.start();

        //main thread, thread1 ve thread2 işini bitirene kadar beklemeli.


        try {
            thread1.join();//thread1 işini bitirene kadar main threadi(hangi threadin run metodunda çağrılmışsa onu) bekletir
            thread2.join();//thread2 işini bitirene kadar main threadi bekletir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long finish = System.currentTimeMillis();
        System.out.println("Multi ile geçen süre: " + (finish - start));


    }


}

class Counter { //Single Thread


    public String name;

    public Counter(String name) {
        this.name = name;
    }
    //1'den 10'a kadar saydıralım

    public void count() {

        for (int i = 0; i < 11; i++) {


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " " + this.name);
        }
    }


}

class CounterThread extends Thread { //Multi - Thread

    public String name;

    public CounterThread(String name) {
        this.name = name;

    }

    public void count() {
        Thread thread = new Thread();

        for (int i = 0; i < 11; i++) {


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " " + this.name);
        }
    }

    @Override
    public void run() {
        count();
    }


}
