import java.sql.SQLException;
import java.util.*;




public class Kayit extends Islem{




    public Kayit() throws SQLException
    {
        System.out.println("Kitap kayıt ekranına hoşgeldiniz..");

        System.out.println();

        System.out.print("Lutfen istediğiniz kitabin adiniz giriniz:");


        kitapAdi = tara.nextLine();

        Kutuphane kutuphane = new Kutuphane(kitapAdi);// Kitap adının parametre olarak kullanarak kütüphane sınıfını çağırdık




    }




}
