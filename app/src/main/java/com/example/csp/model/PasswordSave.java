package com.example.csp.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

import com.example.csp.Password_list;
import com.example.csp.R;

public class PasswordSave extends AppCompatActivity {
    private EditText webname,login,pw;
    private Button save, passwordList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_save);
        initViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        passwordList = findViewById(R.id.passwordList);
        passwordList.setOnClickListener(v -> {
            Intent intent = new Intent(PasswordSave.this, Password_list.class);
            startActivity(intent);
        });
    }
    private void initViews(){
        webname = findViewById(R.id.webname);
        login = findViewById(R.id.login);
        pw = findViewById(R.id.pw);
        save = findViewById(R.id.btn_save);
        passwordList = findViewById(R.id.passwordList);



        save.setOnClickListener(v->{
            PasswordDatabase dbHelper = new PasswordDatabase(PasswordSave.this);
            Password password = new Password(webname.getText().toString(),login.getText().toString(),pw.getText().toString());
            boolean saved = dbHelper.insert(password);
            if(saved){
                Toast.makeText(this, "Password is saved", Toast.LENGTH_SHORT).show();
                save.setEnabled(false);
            }
        });
    }

}