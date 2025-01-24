package com.example.csp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csp.adapter.RecycleAdapter;
import com.example.csp.model.Password;
import com.example.csp.model.PasswordDatabase;
import com.example.csp.model.PasswordSave;

import java.util.List;

public class Password_list extends AppCompatActivity {

    private RecyclerView recycleview;
    private RecycleAdapter adapter;
    private PasswordDatabase passwordDatabase;
    private Button btnsavepw;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_list);
        // Initialize the RecyclerView and adapter
        recycleview = findViewById(R.id.recyclerViewPasswords);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        passwordDatabase = new PasswordDatabase(this);
        // Load the passwords from the database
        loadPasswords();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Set up the save password button
        btnsavepw = findViewById(R.id.btnsavepw);
        btnsavepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Password_list.this, PasswordSave.class);
                startActivity(intent);
            }
        });
    }
    // Load the passwords from the database
    private void loadPasswords() {
        // Retrieve the passwords from the database
        List<Password> passwords = passwordDatabase.getAllPasswords();
        // Create a new RecycleAdapter with the retrieved passwords and set it to the RecyclerView
        adapter = new RecycleAdapter(passwords);
        recycleview.setAdapter(adapter);

    }
}