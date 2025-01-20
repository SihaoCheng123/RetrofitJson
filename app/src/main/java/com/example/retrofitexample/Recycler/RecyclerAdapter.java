package com.example.retrofitexample.Recycler;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    public RecyclerAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coctail_cardview, parent, false);
        return new RecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                    .setIcon(R.drawable.baseline_bookmark_24)
                    .setTitle("Detalles")
                    .setMessage("Detalles del coctail")
                    .setPositiveButton("Cocinar", (dialogInterface, i) -> {

                    })
                    .setNegativeButton("Oro día", (dialogInterface, i) -> {

                    });
            materialAlertDialogBuilder.show();
        });
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView nombre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textoTarjeta);
        }

        public void bind(String text){
            nombre.setText(text);
        }

        static MyViewHolder create(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coctail_cardview, parent, false);
            return new MyViewHolder(view);
        }

        }
    }

