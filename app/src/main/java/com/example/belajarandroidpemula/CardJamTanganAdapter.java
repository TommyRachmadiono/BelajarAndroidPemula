package com.example.belajarandroidpemula;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardJamTanganAdapter extends RecyclerView.Adapter<CardJamTanganAdapter.CardViewHolder> {
    private ArrayList<JamTangan> listJamTangan;
    private OnItemClickCallback onItemClickCallback;

    public CardJamTanganAdapter(ArrayList<JamTangan> list) {
        this.listJamTangan = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onBtnDetailClcked(JamTangan data);
    }

    @NonNull
    @Override
    public CardJamTanganAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        JamTangan jamTangan = listJamTangan.get(position);

        Glide.with(holder.itemView.getContext())
                .load(jamTangan.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvMerk.setText(jamTangan.getMerk());
        holder.tvPrice.setText(jamTangan.getPrice());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onBtnDetailClcked(listJamTangan.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJamTangan.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvMerk, tvPrice;
        Button btnDetail;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto =itemView.findViewById(R.id.img_item_photo);
            tvMerk = itemView.findViewById(R.id.tv_item_merk);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
