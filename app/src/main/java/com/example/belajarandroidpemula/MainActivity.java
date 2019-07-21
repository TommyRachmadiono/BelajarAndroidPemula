package com.example.belajarandroidpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvItem;
    private ArrayList<JamTangan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItem = findViewById(R.id.rvItem);
        rvItem.setHasFixedSize(true);

        list.addAll(DataJamTangan.getListData());
        Log.i("opo", list.size() + "");
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        CardJamTanganAdapter cardJamTanganAdapter = new CardJamTanganAdapter(list);
        rvItem.setAdapter(cardJamTanganAdapter);
//        rvItem.setOnItemClickCallback()
        cardJamTanganAdapter.setOnItemClickCallback(new CardJamTanganAdapter.OnItemClickCallback() {
            @Override
            public void onBtnDetailClcked(JamTangan data) {
                Intent pindahPakeData = new Intent(getApplicationContext(), DetailActivity.class);
                pindahPakeData.putExtra(DetailActivity.Merk, data.getMerk());
                pindahPakeData.putExtra(DetailActivity.Price, data.getPrice());
                pindahPakeData.putExtra(DetailActivity.Photo, data.getPhoto());
                pindahPakeData.putExtra(DetailActivity.Tag, data.getTag());
                pindahPakeData.putExtra(DetailActivity.Description, data.getDescription());

                startActivity(pindahPakeData);
//                Toast.makeText(getApplicationContext(), "k", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
