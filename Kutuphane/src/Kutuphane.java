import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;



public class Kutuphane extends Islem{ // Islem sınıfını kütüphaneye extend ettik kalıttık

    int secenek= 0;


    public Kutuphane(String kitapAdi)// Kitap adını sorgulama ekranı
    {
        this.kitapAdi = kitapAdi; // kitap adını burdaki kitapadi değişkenine atma
        conection();                // islem sınıfındaki bağlantı açama metodunu çağırma
        kitapAra();
    }




}
