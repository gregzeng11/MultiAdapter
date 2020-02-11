package com.example.android.multiadapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {
    private MultiTypeAdapter adapter;
    private Items items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);

        adapter = new MultiTypeAdapter();

        adapter.register(SimpleData.class).to(
                new SimpleTextViewBinder(),
                new SimpleImageViewBinder()
        ).withLinker((position, SimpleData) -> {
            if (SimpleData.content instanceof SimpleText) {
                return 0;
            } else if (SimpleData.content instanceof SimpleImage) {
                return 1;
            }
            return 0;
        });

        recyclerView.setAdapter(adapter);

        items = new Items();

        User user = new User("drakeet", R.drawable.avatar_drakeet);
        SimpleText simpleText = new SimpleText("A simple text Weibo: Hello World.");
        SimpleImage simpleImage = new SimpleImage(R.drawable.img_10);
        for (int i = 0; i < 20; i++) {
            items.add(new SimpleData(user, simpleText));
            items.add(new SimpleData(user, simpleImage));
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
