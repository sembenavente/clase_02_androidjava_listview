package com.example.clase_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtName, txtEmail, txtPhone;
    private Button btn;
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    private ArrayList<String> arrayList = new ArrayList<String>();
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText) findViewById(R.id.edtName);
        txtEmail = (EditText) findViewById(R.id.edtEmail);
        txtPhone = (EditText) findViewById(R.id.edtPhone);
        btn = (Button) findViewById(R.id.button);
        list = (ListView) findViewById(R.id.lista);

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);

        list.setAdapter(adapter);

        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String name = txtName.getText().toString();
                        String email = txtEmail.getText().toString();
                        String phone = txtPhone.getText().toString();
                        Contacto nuevo = new Contacto(name, email, phone);
                        contactos.add(nuevo);

                        arrayList.add("name: " + name + " email: " + email + " phone" + phone);

                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }

}

class Contacto{
    private String name;
    private String email;
    private String phone;

    public Contacto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}