package fauzi.hilmy.quizemployeeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ActivityDataKeluarga extends AppCompatActivity {

    EditText etIbu, etBapak, etIstri;
    Spinner spinKeluarga, spinAnak;
    Button btnSubmit;

    String user1, full1, email1, phone1, address1, sex1, pndidik1, ipk1, tngkat1, jrusan1;
    String itemKeluarga, itemAnak;
    String[] dataKeluarga = new String[]{
            "Apakah Sudah Berkeluarga", "Sudah", "Belum"
    };
    String[] dataAnak = new String[]{
            "Berapa Anak Anda", "1", "2", "3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_keluarga);

        Intent zxcv = getIntent();
        user1 = zxcv.getStringExtra("user");
        full1 = zxcv.getStringExtra("full");
        email1 = zxcv.getStringExtra("email");
        phone1 = zxcv.getStringExtra("phone");
        address1 = zxcv.getStringExtra("address");
        sex1 = zxcv.getStringExtra("sex");
        pndidik1 = zxcv.getStringExtra("pendidikan");
        ipk1 = zxcv.getStringExtra("ipk");
        tngkat1 = zxcv.getStringExtra("tingkat");
        jrusan1 = zxcv.getStringExtra("jurusan");

        etIbu = (EditText)findViewById(R.id.etIbu);
        etBapak = (EditText)findViewById(R.id.etBapak);
        etIstri = (EditText)findViewById(R.id.etIstri);
        spinKeluarga = (Spinner)findViewById(R.id.spinKeluarga);
        spinAnak = (Spinner)findViewById(R.id.spinAnak);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapterKel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataKeluarga);
        spinKeluarga.setAdapter(adapterKel);

        spinKeluarga.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemKeluarga = parent.getItemAtPosition(position).toString();
                if (itemKeluarga.equalsIgnoreCase("Apakah Sudah Berkeluarga")) {
                    etIstri.setVisibility(View.GONE);
                    spinAnak.setVisibility(View.GONE);
                } else if (itemKeluarga.equalsIgnoreCase("Sudah")) {
                    etIstri.setVisibility(View.VISIBLE);
                    spinAnak.setVisibility(View.VISIBLE);
                } else if (itemKeluarga.equalsIgnoreCase("Belum")) {
                    etIstri.setVisibility(View.GONE);
                    spinAnak.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapteraanak = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataAnak);
        spinAnak.setAdapter(adapteraanak);

        spinAnak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemAnak = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nIbu = etIbu.getText().toString();
                String nBapak = etBapak.getText().toString();
                String nIstri = etIstri.getText().toString();

                if(nIbu.isEmpty()){
                    etIbu.setError("Nilai Tidak Boleh Kosong");
                }else if (nBapak.isEmpty()){
                    etBapak.setError("Nilai tidak boleh kosong");
                }else if (nIstri.isEmpty()){
                    etIstri.setError("Nilai tidak boleh kosong");
                }else {
                    Intent n11 = new Intent(getApplicationContext(), ActivityShowData.class);
                    n11.putExtra("pendidikan", pndidik1);
                    n11.putExtra("ipk", ipk1);
                    n11.putExtra("tingkat", tngkat1);
                    n11.putExtra("jurusan", jrusan1);
                    n11.putExtra("user", user1);
                    n11.putExtra("full", full1);
                    n11.putExtra("email", email1);
                    n11.putExtra("phone", phone1);
                    n11.putExtra("address", address1);
                    n11.putExtra("sex", sex1);
                    n11.putExtra("ibu", nIbu);
                    n11.putExtra("bapak", nBapak);
                    n11.putExtra("istri", nIstri);
                    n11.putExtra("anak", itemAnak);
                    n11.putExtra("keluargaa", itemKeluarga);
                    startActivity(n11);
                }
            }
        });
    }
}
