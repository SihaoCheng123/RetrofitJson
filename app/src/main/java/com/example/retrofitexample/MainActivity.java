package com.example.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.Recycler.RecyclerAdapter;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Drinks.Coctail> listaBebidas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText filtro = findViewById(R.id.filtro);
        ImageView buscar = findViewById(R.id.buscar);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, listaBebidas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        buscar.setOnClickListener(v -> {
            String textoFiltro = String.valueOf(filtro.getText());
            Call<Drinks> call = apiInterface.getDrinksByLicour(textoFiltro);
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(@NonNull Call<Drinks> call, @NonNull Response<Drinks> response) {
                    Log.d("Código", response.code() + "");
                    Drinks drinks = response.body();
//                    StringBuilder todoInfo = new StringBuilder();
                    assert drinks != null;
                    //todoInfo.append(cocktail.name).append("\n");
                    //pasarle el id a la interfaz para que me traiga los detalles
                    //                        apiInterface.getDrinkDetail(cocktail.id);
                    listaBebidas.addAll(drinks.drinks);
                    //Log.d("id", listaBebidas.get(1).id);
                    adapter.notifyDataSetChanged();
                    //Log.d("Toda la info", todoInfo.toString());

                }

                @Override
                public void onFailure(@NonNull Call<Drinks> call, @NonNull Throwable throwable) {

                }

            });

        });


    }
}