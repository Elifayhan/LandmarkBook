package com.elifayhan.landmarkbook;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elifayhan.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding= RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LandmarkHolder(recyclerRowBinding);
        //ViewHolder sınıfından bir obje oluşturulduğunda çağırılacak method
        //xml imizi bağlama işlemini burada yapacağız.
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        //ViewHolder sınıfı bağlandığında neler olacak onu söyleyecek.
        //layout içerisinde hangi verileri göstermek isteyeceksek burada gösterecek.
        holder.binding.recycleViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tıklandığında ne olacağını yazıyoruz.
                //diğer aktiviteye geçeceğiz dolayısıyla Intenti kullanacağız.

                Intent intent= new Intent(holder.itemView.getContext(), DetailsActivity.class);
                //chosenLandmark =landmarkArrayList.get(holder.getAdapterPosition());
                //intent.putExtra("landmark", landmarkArrayList.get(holder.getAdapterPosition()));
                Singleton singleton=Singleton.getInstance();
                singleton.setSetLandmark(landmarkArrayList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        //xml in kaç kere oluşturulacağını söyleyecek.
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;
        //bu sınıf görünümlerimizi tutuyor.
        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
