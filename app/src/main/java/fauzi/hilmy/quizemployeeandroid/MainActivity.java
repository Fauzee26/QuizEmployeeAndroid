package fauzi.hilmy.quizemployeeandroid;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etFull, etEmail, etPhone, etAddress;
    Spinner spinSex;
    Button btnNext1;

    String itemSex;
    String[] dataSex = new String[]{
            "Laki Laki", "Perempuan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText)findViewById(R.id.etUser);
        etFull = (EditText)findViewById(R.id.etFull);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etAddress = (EditText)findViewById(R.id.etAddress);
        spinSex = (Spinner)findViewById(R.id.spinSex);
        btnNext1 = (Button)findViewById(R.id.btnNext1);

        ArrayAdapter<String> adaptersex = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSex);
        spinSex.setAdapter(adaptersex);

        spinSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemSex = parent.getItemAtPosition(position).toString();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nUser = etUser.getText().toString();
                String nFull = etFull.getText().toString();
                String nEmail = etEmail.getText().toString();
                String nPhone = etPhone.getText().toString();
                String nAddress = etAddress.getText().toString();

                if(nUser.isEmpty()){
                    etUser.setError("Nilai Tidak Boleh Kosong");
                }else if (nFull.isEmpty()){
                    etFull.setError("Nilai tidak boleh kosong");
                }else if (nEmail.isEmpty()){
                    etEmail.setError("Nilai tidak boleh kosong");
                }else if (nPhone.isEmpty()){
                    etPhone.setError("Nilai tidak boleh kosong");
                }else if (nAddress.isEmpty()){
                    etAddress.setError("Nilai tidak boleh kosong");
                }else{
                    Intent nP = new Intent(getApplicationContext(), ActivityDataPendidikan.class);
                    nP.putExtra("user", nUser);
                    nP.putExtra("full", nFull);
                    nP.putExtra("email", nEmail);
                    nP.putExtra("phone", nPhone);
                    nP.putExtra("address", nAddress);
                    nP.putExtra("sex", itemSex);


                    startActivity(nP);
                }
            }
        });

    }
}
