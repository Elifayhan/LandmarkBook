package com.elifayhan.landmarkbook;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.elifayhan.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        //inflate xml ile kodumuzu bağlamaya çalıştığımız yerdir.
        View view = binding.getRoot(); //bu bağladığımız şeyi bir görünüme çeviriyor.
        setContentView(view); //xml yerine bağlama işlemini kullandığımız yer karşımıza çıkıyor.bunu her aktivite
        //oluşturduğumuzda 1 kere yapıyoruz.
        //binding.countryText.setText("Test"); //yani findViewById dememize gerek yok.
        //oluşturduğumuz her görünüm için binding. diyip ulaşabiliriz.
        //Intenti alabiliriz.
        //Intent intent =getIntent();

        //Landmark selectedLandmark= (Landmark) intent.getSerializableExtra("landmark"); //casting işlemi yaptık.
        //Landmark selectedLandmark= chosenLandmark;

        Singleton singleton =Singleton.getInstance();
        Landmark selectedLandmark= singleton.getSetLandmark();
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}