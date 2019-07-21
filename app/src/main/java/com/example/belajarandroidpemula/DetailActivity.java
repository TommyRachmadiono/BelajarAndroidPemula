package com.example.belajarandroidpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String Merk = "Merk";
    public static final String Price = "Price";
    public static final String Photo = "Photo";
    public static final String Tag = "Tag";
    public static final String Description = "Description";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvMerk = findViewById(R.id.tvMerk);
        TextView tvPrice = findViewById(R.id.tvPrice);
        ImageView imgPhoto = findViewById(R.id.imgPhoto);
        TextView tvTag = findViewById(R.id.tvTag);
        TextView tvDescription = findViewById(R.id.tvDescription);

        String merk = getIntent().getStringExtra(Merk);
        String price = getIntent().getStringExtra(Price);
        String photo = getIntent().getStringExtra(Photo);
        String tag = getIntent().getStringExtra(Tag);
        String description = getIntent().getStringExtra(Description);
//        Log.i("opo", getIntent().getStringExtra(Merk) + "");
//        Log.i("opo", getIntent().getStringExtra(Price) + "");
//        Log.i("opo", getIntent().getStringExtra(Tag) + "");
//        Log.i("opo", getIntent().getStringExtra(Description) + "");
//        Log.i("opo", getIntent().getStringExtra(Photo) + "");
        tvMerk.setText(merk);
        tvPrice.setText(price);
        tvTag.setText("TAGS : " + tag);
        tvDescription.setText(description);

        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().override(350, 550))
                .into(imgPhoto);
    }
}
