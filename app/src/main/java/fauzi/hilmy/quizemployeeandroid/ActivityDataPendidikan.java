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

public class ActivityDataPendidikan extends AppCompatActivity {

    EditText etPendidikan, etIPK;
    Spinner spinTingkat, spinMajor;
    Button btnNext2;

    String itemMajor, itemTingkat;
    String[] dataMajor = new String[]{
            "RPL", "TKJ", "Multimedia", "Mesin", "Ekonomi", "Elektrik"
    };

    String[] dataTingkat = new String[]{
            "SD", "SMP", "SMK", "D3", "S1", "S2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pendidikan);

        etPendidikan = (EditText)findViewById(R.id.etPendidikan);
        etIPK = (EditText)findViewById(R.id.etIpk);
        spinTingkat = (Spinner)findViewById(R.id.spinTingkat);
        spinMajor = (Spinner)findViewById(R.id.spinMajor);
        btnNext2= (Button)findViewById(R.id.btnNext2);

        ArrayAdapter<String> adapterpendidikan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMajor);
        spinMajor.setAdapter(adapterpendidikan);

        spinMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemMajor = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> adaptertingkat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataTingkat);
        spinTingkat.setAdapter(adaptertingkat);

        spinTingkat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemTingkat = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nPendidikan = etPendidikan.getText().toString();
                String nIpk = etIPK.getText().toString();

                if(nPendidikan.isEmpty()){
                    etPendidikan.setError("Nilai Tidak Boleh Kosong");
                }else if (nIpk.isEmpty()){
                    etIPK.setError("Nilai tidak boleh kosong");
                }else {
                    Intent n2 = new Intent(getApplicationContext(), ActivityDataKeluarga.class);
                    String ambilUser = n2.getStringExtra("user");
                    String ambilFull = n2.getStringExtra("full");
                    String ambilEmail = n2.getStringExtra("email");
                    String phonee = n2.getStringExtra("phone");
                    String addresss = n2.getStringExtra("address");
                    String sexxxx = n2.getStringExtra("sex");
                    n2.putExtra("pendidikan", nPendidikan);
                    n2.putExtra("ipk", nIpk);
                    n2.putExtra("tingkat", itemTingkat);
                    n2.putExtra("jurusan", itemMajor);
                    n2.putExtra("user", ambilUser);
                    n2.putExtra("full", ambilFull);
                    n2.putExtra("email", ambilEmail);
                    n2.putExtra("phone", phonee);
                    n2.putExtra("address", addresss);
                    n2.putExtra("sex", sexxxx);
                    startActivity(n2);
                }
            }
        });
    }
}
