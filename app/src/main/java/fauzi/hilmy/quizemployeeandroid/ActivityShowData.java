package fauzi.hilmy.quizemployeeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityShowData extends AppCompatActivity {

    TextView lblUser, lblFull, lblEmail, lblSex, lblPhone, lblAddress, lblPendidikan, lblTingkat, lblIpk, lblJurusan, lblIbu, lblAyah, lblIstri, lblJumlahAnak, lblGaji, lblpokok, lblTunjang;
    String Uuser, Ffull, Eemail, Pphone, Addrssfd, Genfds, Pndiikfds, Ipkfds, tingkafd, jrusanfds, ibufds, bpkfds, istrifds, jmlahanakfds, kluargfd;
    int gajia, jumlahaaaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent aqwer = getIntent();
        Uuser = aqwer.getStringExtra("user");
        Ffull = aqwer.getStringExtra("full");
        Eemail = aqwer.getStringExtra("email");
        Pphone = aqwer.getStringExtra("phone");
        Addrssfd = aqwer.getStringExtra("address");
        Genfds = aqwer.getStringExtra("sex");
        Pndiikfds = aqwer.getStringExtra("pendidikan");
        Ipkfds = aqwer.getStringExtra("ipk");
        tingkafd = aqwer.getStringExtra("tingkat");
        jrusanfds = aqwer.getStringExtra("jurusan");
        ibufds = aqwer.getStringExtra("ibu");
        bpkfds = aqwer.getStringExtra("bapak");
        istrifds = aqwer.getStringExtra("istri");
        jmlahanakfds = aqwer.getStringExtra("anak");
        kluargfd = aqwer.getStringExtra("keluargaa");

        lblUser = (TextView)findViewById(R.id.lblUsername);
        lblFull = (TextView)findViewById(R.id.lblFull);
        lblEmail = (TextView)findViewById(R.id.lblEmail);
        lblSex = (TextView)findViewById(R.id.lblGender);
        lblPhone = (TextView)findViewById(R.id.lblPhone);
        lblAddress = (TextView)findViewById(R.id.lblAddress);
        lblPendidikan = (TextView)findViewById(R.id.lblPendidikan);
        lblTingkat = (TextView)findViewById(R.id.lblTingkatPendidikan);
        lblIpk = (TextView)findViewById(R.id.lblIpk);
        lblJurusan = (TextView)findViewById(R.id.lblJurusan);
        lblIbu = (TextView)findViewById(R.id.lblIbu);
        lblAyah = (TextView)findViewById(R.id.lblAyah);
        lblIstri = (TextView)findViewById(R.id.lblIstri);
        lblJumlahAnak = (TextView)findViewById(R.id.lblJumlahAnak);
        lblGaji = (TextView)findViewById(R.id.lblGaji);
        lblpokok = (TextView)findViewById(R.id.lbltotalGaji);
        lblTunjang = (TextView)findViewById(R.id.lblGajitunjang);


        if (tingkafd.equalsIgnoreCase("SD"))  {
            gajia = 1000000;
        } else if (tingkafd.equalsIgnoreCase("SMP")) {
            gajia = 2000000;
        } else if(tingkafd.equalsIgnoreCase("SMK")) {
            gajia = 2500000;
        }else if(tingkafd.equalsIgnoreCase("D3")) {
            gajia = 2700000;
        }else if(tingkafd.equalsIgnoreCase("S1")) {
            gajia = 3000000;
        }else if(tingkafd.equalsIgnoreCase("S2")) {
            gajia = 5000000;
        }

        if (kluargfd.equalsIgnoreCase("Sudah") && (jmlahanakfds.equalsIgnoreCase("0"))) {
            jumlahaaaa = 700000;
        } else if (kluargfd.equalsIgnoreCase("Sudah") && (jmlahanakfds.equalsIgnoreCase("1"))) {
            jumlahaaaa = 1000000;
        } else if (kluargfd.equalsIgnoreCase("Sudah") && (jmlahanakfds.equalsIgnoreCase("2"))) {
            jumlahaaaa = 2000000;
        }else if (kluargfd.equalsIgnoreCase("Sudah") && (jmlahanakfds.equalsIgnoreCase("3"))) {
            jumlahaaaa = 3000000;
        }

        int jumlaah = gajia + jumlahaaaa;

        lblUser.setText("Username : " + Uuser);
        lblFull.setText("FullName : " + Ffull);
        lblEmail.setText("Email : " + Eemail);
        lblSex.setText("Phone Number : " + Pphone);
        lblPhone.setText("Address : " + Addrssfd);
        lblAddress.setText("Gender : " + Genfds);
        lblPendidikan.setText("Pendidikan Terakhir : " + Pndiikfds);
        lblTingkat.setText("Tingkat Pendidikan : " + tingkafd);
        lblIpk.setText("IPK : " + Ipkfds);
        lblJurusan.setText("Major : " + jrusanfds);
        lblIbu.setText("Nama Ibu : " + ibufds);
        lblAyah.setText("Nama Ayah : " + bpkfds);
        lblIstri.setText("Nama Istri : " + istrifds);
        lblJumlahAnak.setText("Jumlah Anak : " + jmlahanakfds);

        lblpokok.setText("Gaji Pokok Anda : Rp." + gajia);
        lblTunjang.setText("Gaji Tunjangan Anda : Rp." + jumlahaaaa);
        lblGaji.setText("Total Gaji = Rp." + jumlaah);
    }
}
