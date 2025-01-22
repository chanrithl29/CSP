package com.example.csp;

import android.os.Bundle;

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

import java.util.List;

public class Password_list extends AppCompatActivity {
    private RecyclerView recycleview;
    private RecycleAdapter adapter;
    private PasswordDatabase passwordDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_list);
        recycleview = findViewById(R.id.recyclerViewPasswords);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        passwordDatabase = new PasswordDatabase(this);
        loadPasswords();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void loadPasswords() {
        List<Password> passwords = passwordDatabase.getAllPasswords();
        adapter = new RecycleAdapter(passwords);
        recycleview.setAdapter(adapter);

    }
}