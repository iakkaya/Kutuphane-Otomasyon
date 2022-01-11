import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException { /// Olusabilecek sql hatalarında pprogramın kapanmasının engellemek için(throws)


        System.out.println("Kutuphane Otomasyonuna hoş geldiniz..");


        boolean islem = true;                    // Döngümüzün sonsuz kere dönmesi için
        int sayici = 3;                 // Kullanıcıdan 3 defa yanlış girilebilmesi için

        String id = null;           //kullanıcı adı
        String pass;                    // şfifre
        Scanner tara = new Scanner(System.in); // tarayıcımız

        while (islem) {                                         //// Sonsuz döngü yapıldı kullanıcı adı ve sifresi yanlıs girildiğinde 3 defa tekrardan dönecek
            System.out.print("Lutfen kullanıcı adi giriniz: ");
            id = tara.next();

            System.out.print("Lutfen kullanıcı sifresini giriniz: ");
            pass = tara.next();

            if (id.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
            {
                islem = false;
                break;                                              /// Kullanıcının id ve pass e doğru girmesi durumunda while bitirir
            }
            else if (sayici > 0)// Değilse else gire
            {

                System.out.println("Bilgiler yanlis girildi");
                sayici--;
                continue;                   // Yanlış girilmesi durumunda sayacı bir azaltıp while tekrar eder
            }
            else
            {
                System.out.println("Cok fazla hatalı deneme yapildi");
                System.exit(0);// Program kapatılır
            }

        }

        System.out.println("Giris basarili..");



        while (true) //Döngü yine sonsuz döner
        {


            System.out.println("Lutfen islem seciniz: ");

            System.out.println("1 - Kitap Sorgula");


            System.out.println("2 - Kitap Listele");


            System.out.println("3 - Kitap kira");


            System.out.println("4 - Kitap Ekle");

            System.out.println("5 - Alinmiş Tüm Kayitlarin Listesi");


            System.out.println("0 - Cıkıs");

            System.out.print("Lutfen islem seciniz: ");


            int secenek = 0;// Menüdeki işlem seçimi sayısal olarak

            try { // Sayı dışında bir harf girilmesi durumunda hata verilececk try catch kullandık

                secenek = tara.nextInt();

            } catch (Exception error)
            {
                System.out.println("Yanlıs bir karakter girildi.." + error.toString());
            }


            Kayit kayit;                               // Kayit sınıfının bir örneği aldındı

            Islem islemNesne = new Islem();          // İslem sınıfının bir örneği aldındı. aldığımız contractorun içi boş

            switch (secenek)// seceneğe göre değerlendirme için
            {
                case 1:


                    kayit = new Kayit();     // Kayit sınıfındaki constracktıra giderek kitap sorgulamsı yapar.

                    break;

                case 2:
                    islemNesne.kitapListele(); //islem sınıfındaki listeleme metodu çağırıldı
                    break;


                case 3:
                    System.out.println("Kitap rezervasyon ekranına gidiliyor..");

                    islemNesne.kitapKira();

                    break;

                case 4:
                    islemNesne.kitapEkle();

                    break;

                case 5:
                    islemNesne.kitapKiraListele();


                    break;



                case 0 :
                    System.out.println("Programdan cikis yapiliyor...");
                    System.exit(0); // Program sonlandırma komutu


            }


        }


    }





    }

