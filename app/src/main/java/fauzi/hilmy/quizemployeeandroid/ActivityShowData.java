package fauzi.hilmy.quizemployeeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityShowData extends AppCompatActivity {

    TextView lblUser, lblFull, lblEmail, lblSex, lblPhone, lblAddress, lblPendidikan, lblTingkat, lblIpk, lblJurusan, lblIbu, lblAyah, lblIstri, lblJumlahAnak, lblGaji;
    String gaji, jumlahAnakaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

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

        Intent naa = new Intent(getApplicationContext(), ActivityShowData.class);
        String uuser = naa.getStringExtra("user");
        String ffull = naa.getStringExtra("full");
        String eemail = naa.getStringExtra("email");
        String pphone = naa.getStringExtra("phone");
        String aadress = naa.getStringExtra("address");
        String ggender = naa.getStringExtra("sex");
        String ambilPendidikan = naa.getStringExtra("pendidikan");
        String ambilIpk = naa.getStringExtra("ipk");
        String ambilTingkat = naa.getStringExtra("tingkat");
        String ambilJurusan = naa.getStringExtra("jurusan");
        String nIbu = naa.getStringExtra("ibu");
        String nBapak = naa.getStringExtra("bapak");
        String nIstri = naa.getStringExtra("istri");
        String nJumlahAnak = naa.getStringExtra("anak");
        String keluarga = naa.getStringExtra("keluargaa");

        int gaajii = Integer.parseInt(gaji);

        if (ambilTingkat.equalsIgnoreCase("SD"))  {
            gaajii = 1000000;
        } else if (ambilTingkat.equalsIgnoreCase("SMP")) {
            gaajii = 2000000;
        } else if(ambilTingkat.equalsIgnoreCase("SMK")) {
            gaajii = 2500000;
        }else if(ambilTingkat.equalsIgnoreCase("D3")) {
            gaajii = 2700000;
        }else if(ambilTingkat.equalsIgnoreCase("S1")) {
            gaajii = 3000000;
        }else if(ambilTingkat.equalsIgnoreCase("S2")) {
            gaajii = 5000000;
        }

        int aAnak = Integer.parseInt(jumlahAnakaa);

        if (keluarga.equalsIgnoreCase("Sudah") && (nJumlahAnak.equalsIgnoreCase("0"))) {
            aAnak = 700000;
        } else if (keluarga.equalsIgnoreCase("Sudah") && (nJumlahAnak.equalsIgnoreCase("1"))) {
            aAnak = 1000000;
        } else if (keluarga.equalsIgnoreCase("Sudah") && (nJumlahAnak.equalsIgnoreCase("2"))) {
            aAnak = 2000000;
        }else if (keluarga.equalsIgnoreCase("Sudah") && (nJumlahAnak.equalsIgnoreCase("3"))) {
            aAnak = 3000000;
        }

        int jumlaah = gaajii + aAnak;

        lblUser.setText("Username : " + uuser);
        lblFull.setText("FullName : " + ffull);
        lblEmail.setText("Email : " + eemail);
        lblSex.setText("Phone Number : " + pphone);
        lblPhone.setText("Address : " + aadress);
        lblAddress.setText("Gender : " + ggender);
        lblPendidikan.setText("Pendidikan Terakhir : " + ambilPendidikan);
        lblTingkat.setText("Tingkat Pendidikan : " + ambilTingkat);
        lblIpk.setText("IPK : " + ambilIpk);
        lblJurusan.setText("Major : " + ambilJurusan);
        lblIbu.setText("Nama Ibu : " + nIbu);
        lblAyah.setText("Nama Ayah : " + nBapak);
        lblIstri.setText("Nama Istri : " + nIstri);
        lblJumlahAnak.setText("Jumlah Anak : " + nJumlahAnak);
        lblGaji.setText("Total Gaji = Rp." + jumlaah);

        startActivity(naa);
    }
}
