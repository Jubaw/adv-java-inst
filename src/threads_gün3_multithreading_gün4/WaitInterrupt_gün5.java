package threads_gün3_multithreading_gün4;

/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//multi threading uygulamalarda bir threadin işini sürdürebilmesi için
//diğer bir threadin çalışması gerekiyorsa wait/notify veya wait/interrupt ile
//iletişim sağlanabilir

public class WaitInterrupt_gün5 {
    public static int balance = 0;

    //PARA YATIRMA
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " para yatırmak istiyor.");
        this.balance += amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye: " + this.balance);
        notify(); //wait ile bekleyen threade bildirim gönderir.
        notifyAll();//wait ile bekleyen tüm threadleri harekete geçirir.
    }

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " para çekmek istiyor.");
        //BAKİYE YETERLİ Mİ ?
        if (balance == 0 || balance < amount) {
            System.out.println("Bakiye yetersiz.Mevcut bakiye: " + this.balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor");
            try {
                wait();//monitör edilen objeyi geçici olarak serbest bırakır.
            } catch (InterruptedException e) {
                System.out.println("Bakiye güncellendi.İşleme devam ediliyor.");
            }
        }

        //BAKİYE YETERLİYSE↴
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println("Para çekme işlemi başarılı.Mevcut bakiye: " + this.balance);
        }else{
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye: " + this.balance);
            System.out.println("Umudunu kaybetme sonra gel");
        }


    }


    public static void main(String[] args) {
        WaitInterrupt_gün5 obj = new WaitInterrupt_gün5();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);

            }
        });
        thread1.setName("Tüketici");
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt();//thread1'in bekleme işlemini zorla durdurmuş oluyoruz.

            }
        });
        thread2.setName("Üretici");
        thread2.start();


    }
}
