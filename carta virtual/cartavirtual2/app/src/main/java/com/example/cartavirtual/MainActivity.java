package com.example.cartavirtual;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    }
    public void consultarSedes (View v){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
    public void RealizarReserva (View v){
       // Intent i = new Intent(this, ReservaActivity.class);
       // startActivity(i);


        //informacion del restaurante
        String phone = "+57 3112294908";
        String message = "hola, desea hacer una reserva";

        String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + Uri.encode(message);



        //proveedor de contenido de aplicaciones de terceros
        PackageManager pm;
        pm = getPackageManager();
// configurar numero, mensaje por defecto
        Intent i = pm.getLaunchIntentForPackage("com.whatsapp");
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void verMenu (View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}