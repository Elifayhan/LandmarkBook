package com.elifayhan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.elifayhan.landmarkbook.databinding.ActivityDetailsBinding;
import com.elifayhan.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    //static Landmark chosenLandmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Data
        landmarkArrayList=new ArrayList<>();
        Landmark pisa=new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark eiffel= new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark colosseum=new Landmark("Colosseum", "Italy", R.drawable.colosseum);
        Landmark londonBridge= new Landmark("London Bridge", "UK", R.drawable.londonbridghe);
        //ArrayList
        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this)); //yan yana mı alt alta mı
        //göstereceğiz onu dedik. yan yana olması için gridlayoutu seçmemiz lazım.
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList); //adaptörden bir liste oluşturduk.
        binding.recycleView.setAdapter(landmarkAdapter);


        //internetten bir şey indirdiğimiz zaman da Bitmap kullanacağız. Bu bitmap ı alıp intent ile yollayamıyoruz.
        //çünkü intentlerde bir limit var.ama singletonda bunu istediğimiz kadar kullanabiliyoruz.

        //Adapter; listeleri, list viewları ve recyle viewları kullanırken adaptör denilen yapıyı kullanırız.
        //Adaptör; veri kaynağımız ile xlm'i ve List View'ı birbirine bağlayan yapıdır.
        /*List<String> list = new ArrayList<>();
        for (Landmark landmark : landmarkArrayList) {
            String name = landmark.name;
            list.add(name);
        }

         */
        /*
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list);
        //sadece 1 tane metin göstereceğimiz için hazır olan layoutu kullanıyoruz. Ama biz metin de görsel de
        // buton da her şeyi gösterebiliriz. bunları daha sonra göreceğiz.
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //bunu test amaçlı yaptık.
                // Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();
                //diğer aktiviteye geçmemiz lazım dolayısıyla intent yapmamız lazım.
                Intent intent =new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(i));
                startActivity(intent);
            }
        });
        //her bir itema tıklandığında ne olacağını diyoruz.
        */

    }
}