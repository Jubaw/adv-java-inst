package threads_gün3_multithreading_gün4;

public class ThreadCreationWays {
    public static void main(String[] args) {
//her java programında default olarak 1 tane thread başlatılır:main thread
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());

        //1.YOL
        Thread thread1=new MyThread();
        //thread1.run();--!!!!!!Thread başlatılmaz
        thread1.start();//Threadi başlatır, run metodunu çağırarak
        thread1.setName("threadcik");

        //2.YOL

        Runnable runnable=new MyRunnable();
        Thread thread2=new Thread(runnable);
        thread2.start();

        //2. YOL: anonymous class:isimsiz class
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Çalışan thread: "+Thread.currentThread().getName());
                System.out.println("Anonim thread uyuyacak:)");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Anonim thread uyandı");
                System.out.println("Anonymous class ile tanımlanan thread başladı.");
            }
        });
        thread3.setName("anonim");
        thread3.start();

        System.out.println("-------------------------------------------------------");


        //2. YOL: Runnable(functional) : lambda exp ile
        Thread thread4=new Thread(()->{
            //run metodunun body
            System.out.println("Çalışan thread: "+Thread.currentThread().getName());
            System.out.println("Lambda expression ile oluşturuldu.");
        });
        thread4.start();


        //main threadi bir süre bekletelim
        try {
            Thread.sleep(3000);//hangi thread çağırırsa bu threadi bekletir
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("main metodu burada tamamlandı.");

//her thread işini senkron olarak gerçekleştirir

    }

}
//thread oluşturmanın SADECE 2 tane yolu var
//1. YOL: Thread classını extend ederek
class MyThread extends Thread{

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işlemleri(kodları)
        System.out.println("Çalışan thread : "+Thread.currentThread().getName());
        System.out.println("Mythread threadi çalışıyor. HARİKA:)");
    }
}

//2.YOL: Runnable Interfaceini(functional) implemente ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işlemleri(kodları)
        System.out.println("Çalışan thread: "+Thread.currentThread().getName());
        System.out.println("Runnable ile hazırlanan thread başladı.");

    }
}

