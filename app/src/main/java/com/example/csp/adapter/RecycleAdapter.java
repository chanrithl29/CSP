package com.example.csp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.csp.R;
import com.example.csp.model.Password;
import java.util.List;
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    //List to hold Password Objects
    private List<Password> passwords;
    // Constructor to initialize the adapter with a list of passwords
    public RecycleAdapter(List<Password> passwords) {
        this.passwords = passwords;
    }
    // ViewHolder class to define how each item in the RecyclerView will look
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewWebsite,textViewUsername,textViewpw;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Initialize TextViews for displaying website, username, and password
            textViewWebsite = itemView.findViewById(R.id.textViewWebsite);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewpw = itemView.findViewById(R.id.textViewpw);
        }
        }
        @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each RecyclerView item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_password, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        // Bind data from the Password object to the TextViews
        Password password = passwords.get(position);
        holder.textViewWebsite.setText("Website:" + password.getWebsite());
        holder.textViewUsername.setText("Username:" +password.getUsername());
        holder.textViewpw.setText("Password:" +password.getPassword());

    }

    @Override
    public int getItemCount() {
        // Return the number of items in the list
        return passwords.size();
    }
}
