package com.sony.task1;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//[Comment] Wrong colors, fonts, paddings. Bad design
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Claim> claimsList = new ArrayList<Claim>(); //[Comment] ArrayList<>(); Wrong name
    private ClaimsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ClaimsAdapter(claimsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData(); //[Comment] Movie? What movie?

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView1.setImageDrawable(loadDrawableFromAssets(this, "image1.jpg")); //[Comment] Hardcode
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageDrawable(loadDrawableFromAssets(this, "image2.jpg"));
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setImageDrawable(loadDrawableFromAssets(this, "image1.jpg")); //[Comment] Use recycler view for images not for textviews

    }

    public Drawable loadDrawableFromAssets(Context context, String doc) {
        InputStream stream = null;
        try {
            stream = context.getAssets().open(doc);
            return Drawable.createFromStream(stream, null);
        } catch (Exception ignored) {
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    private void prepareMovieData() {
        Claim claim1 = new Claim("Створено", "14 жовтня 2015");
        claimsList.add(claim1);
        Claim claim2 = new Claim("Зареєстровано", "15 жовтня 2015"); //[Comment] Hardcode
        claimsList.add(claim2);
        Claim claim3 = new Claim("Вирішити до", "24 листопад 2015");
        claimsList.add(claim3);
        Claim claim4 = new Claim("Відповідальній", "Дніпропетровський МВК()");
        claimsList.add(claim4);
        Claim claim5 = new Claim("", "Відкритий люк (біля рекламного щита), район поворота 18 и 19 трамваїв на проспект Миру з Донецького шоссе");
        claimsList.add(claim5);

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.textView: {
                Toast.makeText(getApplicationContext(), getString(R.string.press) + " " + getString(R.string.nameOrganization), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button: {
                Toast.makeText(getApplicationContext(), getString(R.string.press) + " " + getString(R.string.processStatus), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.imageView: {
            }
            case R.id.imageView2: {
            }
            case R.id.imageView3: {
                Toast.makeText(getApplicationContext(), getString(R.string.press) + " " + getString(R.string.imageTxt), Toast.LENGTH_SHORT).show();
                break;
            } //[Comment] Bad code. Refactor it
            default: {
                Toast.makeText(getApplicationContext(), getString(R.string.press) + " " + getString(R.string.otherItem), Toast.LENGTH_SHORT).show();
            }


        }

    }
}