package com.example.miresycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView fv1;
    String[] nombres = {"juan", "alex", "maria"};
    int[]edades ={25,35,45};
    int[]fotos = {R.drawable.persona1,R.drawable.persona3,R.drawable.persona2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fv1 = findViewById(R.id.fv1);

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       fv1.setLayoutManager(linearLayoutManager);

       fv1.setAdapter(new AdaptadorPersona());


    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.layout_tarjeta,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersona.AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder {
           ImageView iv1;
           TextView tv1, tv2;


            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                iv1=itemView.findViewById(R.id.imageView);
                tv1=itemView.findViewById(R.id.tvnombre);
                tv2=itemView.findViewById(R.id.tvedad);
            }

            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText("Edad"+edades[position]);
            }
        }

    }
}