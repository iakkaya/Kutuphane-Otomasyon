import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Islem {

    String adSoyad;
    String telNo;
    String kitapAdi;
    String kitapYazar;
    String yayinEvi;
    String alimTarihi;
    String kitapBasimTarihi;
    String kira;
    String kitapYayinEvi;
    int kitapTarih;
    String kitapDurum = "iade edilmedi";
    Connection conn;
    Statement state;
    boolean dongu = false;


    Scanner tara = new Scanner(System.in);


    public Islem(String kullanici, int islem) throws SQLException {

        try {

            conection();
        } catch (Exception error) {
            System.out.println("Veri tabanı bagalantisinda hata olustu" + error.toString());
        }


        if (islem == 1) {
            kitapKira();

        }


    }

    public Islem()
    {


    }


    public void conection() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3325/teknik_servis?user=root&password=123456");
            state = conn.createStatement();


        } catch (SQLException err) {
            System.out.println("Veri tabanı bağlantı hatası olustu.\n" + err.toString());
        }


    }

    public void kitapAra() {

        try {

            String islem = "SELECT * FROM kitap"; // tablodaki bütün sütunları seç

            ResultSet rs = state.executeQuery(islem);

            while (rs.next()) {


                if (rs.getString("kitap_adi").equalsIgnoreCase(kitapAdi)) // tablodaki kitap adı değişken olan kitap adina eşit olursa if çalışır// whileı durdur
                {

                    dongu = true;

                    break;

                }





            }

            if(dongu == true)
            {
                System.out.println("Kitap sistemde mevcuttur.");
            }

            else
            {
                System.out.println("Kitap sistemde mevcut değildir.");

            }

            state.close();
            conn.close();

        }
        catch (Exception err)

        {
            err.printStackTrace();
        }


    }


    public void kitapKiraListele() throws SQLException
    {

        conection();

        ResultSet rs = state.executeQuery("SELECT * FROM kitap_kira");


        while (rs.next()) {
            System.out.println("Ad Soyad: "+rs.getString("ad_soyad")+" - "+" Telefon Numarasi: "+rs.getString("tel_no")+" Kitap Adi: "+ rs.getString("kitap_adi")+" - "+" Alınma Tarihi: "+rs.getString("tarih")+"\n");

        }

        state.close();
        conn.close();

    }


    public void kitapKira() throws SQLException {

        conection(); // baglantı açma


        System.out.print("Lutfen ad soyad giriniz: ");
            adSoyad = tara.nextLine();

            System.out.print("Lutfen telefon numarasi giriniz: ");
            telNo = tara.nextLine();


            System.out.print("Lutfen kitap adi giriniz:");


            kitapAdi = tara.nextLine();




            Date tarihOku = new Date(); // Tarih bilgisini alma

            String strDateFormat = "hh:mm:ss a dd-MMM-yyyy"; // tarih bilgisini istediğimiz formatta alma
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            alimTarihi =  sdf.format(tarihOku); // kiralama tarihini alimTarihi değişkenine ata

            String query = "INSERT INTO ksitap_kira (ad_soyad,tel_no,kitap_adi,tarih) VALUES('" + adSoyad + "','" + telNo + "','" + kitapAdi + "','" + alimTarihi + "')";

            state.executeUpdate(query);// query emrini çalıştırma işlemi için

        System.out.println("Kitap kira kayit basarili.");


            state.close();
            conn.close();// bağlantıların kapatılması işlemi










    }

    public void kitapListele() throws SQLException {

        conection();

        ResultSet rs = state.executeQuery("SELECT * FROM kitap");


        while (rs.next()) {
            System.out.println("Kitap adi: "+rs.getString("kitap_adi")+" - "+" Kitap yazari: "+rs.getString("kitap_yazar")+" Kitap yayinevi: "+ rs.getString("kitap_yayinevi")+" - "+" Kitap tarih: "+rs.getString("kitap_tarih")+"\n");

        }
        state.close();
        conn.close();



    }

    public void kitapEkle()
    {

        try {
            conection();

            System.out.println("Kitap kayit ekranına hoşgeldiniz");

            System.out.print("Lutfen kitap adi giriniz: ");
            kitapAdi = tara.nextLine();

            System.out.print("Lutfen kitap yazar giriniz: ");
            kitapYazar = tara.nextLine();

            System.out.print("Lutfen kitap yayin evi giriniz: ");
            kitapYayinEvi = tara.nextLine();

            System.out.print("Lutfen kitap basım tarihi giriniz(orn: 2001):");

            kitapBasimTarihi = tara.nextLine();

            String query = "INSERT INTO kitap (kitap_adi,kitap_yazar,kitap_yayinevi,kitap_tarih) VALUES('" + kitapAdi + "','" + kitapYazar + "','" + kitapYayinEvi + "','" + kitapBasimTarihi + "')";

            state.executeUpdate(query);

            System.out.println("Kayit islemi basarili.");

            state.close();
            conn.close();




        }
        catch (SQLException error)
        {
            System.out.println("SQL baglanti sirasinda hata olustu"+error.toString());
        }


    }


    public void kitapİade() {


        try {


            conection();

            System.out.println("Kitap iade ekranina hoşgeldiniz ");

            System.out.println();
            System.out.print("Lutfen iade edilecek kitabin adini giriniz: ");
            kitapAdi = tara.nextLine();

            String query = "INSERT INTO kitap (kitap_adi,kitap_yazar,kitap_yayinevi,kitap_tarih) VALUES('" + kitapAdi + "','" + kitapYazar + "','" + kitapYayinEvi + "','" + kitapBasimTarihi + "')";

            state.executeUpdate(query);
            System.out.println("Kayit islemi basarili.");
        }
        catch (SQLException error)
        {
            System.out.println("Sql baglantisinda hata olustu."+error.toString());
        }








    }


    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }
}

