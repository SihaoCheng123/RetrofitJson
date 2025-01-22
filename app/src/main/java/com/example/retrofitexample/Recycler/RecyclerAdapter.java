package com.example.retrofitexample.Recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.retrofitexample.ApiClient;
import com.example.retrofitexample.ApiInterface;
import com.example.retrofitexample.CoctailDetail;
import com.example.retrofitexample.Drinks;
import com.example.retrofitexample.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<Drinks.Coctail> listaBebidas;

    public RecyclerAdapter(Context context, ArrayList<Drinks.Coctail> listaBebidas){
        this.context = context;
        this.listaBebidas = listaBebidas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coctail_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textoTarjeta.setText(listaBebidas.get(position).name);
        Glide.with(this.context)
                .load(listaBebidas.get(position).imageUrl)
                .into(holder.imagenTarjeta);
        String idBebida = listaBebidas.get(position).id;

        holder.itemView.setOnClickListener(v -> {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<CoctailDetail> detalleCall = apiInterface.getDrinkDetail(idBebida);
            detalleCall.enqueue(new Callback<>() {
                @Override
                public void onResponse(@NonNull Call<CoctailDetail> call, @NonNull Response<CoctailDetail> response) {
                    assert response.body() != null;
                    List<CoctailDetail.Coctails> newCoctailDetail = response.body().getCoctails();
                    CoctailDetail.Coctails coctailDetallado = newCoctailDetail.get(0);

                    Log.d("LOL", newCoctailDetail.get(0).toString());
                    Log.d("info", coctailDetallado.toString());

                    MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                            .setIcon(R.drawable.baseline_bookmark_24)
                            .setTitle(coctailDetallado.getName())
                            .setMessage("Categoría: " + coctailDetallado.getCategory() + "\n" + "\nInstrucciones: " + coctailDetallado.getInstruction())
                            .setPositiveButton("Preparar", (dialogInterface, i) -> {
                                Toast toast = Toast.makeText(context,"Vamos allá", Toast.LENGTH_LONG);
                                toast.show();
                            })
                            .setNegativeButton("Otro día", (dialogInterface, i) -> dialogInterface.cancel());
                    materialAlertDialogBuilder.show();
                }

                @Override
                public void onFailure(@NonNull Call<CoctailDetail> call, @NonNull Throwable throwable) {

                }
            });

        });
    }

    @Override
    public int getItemCount() {
        return listaBebidas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        final TextView textoTarjeta;
        final ImageView imagenTarjeta;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textoTarjeta = itemView.findViewById(R.id.textoTarjeta);
            this.imagenTarjeta = itemView.findViewById(R.id.imagenTarjeta);
        }

        static MyViewHolder create(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coctail_cardview, parent, false);
            return new MyViewHolder(view);
        }

        }
    }

