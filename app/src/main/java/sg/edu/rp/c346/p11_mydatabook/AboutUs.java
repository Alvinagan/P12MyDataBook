package sg.edu.rp.c346.p11_mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ActionBar ab;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        iv = findViewById(R.id.iv);
        String image = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(image).error(R.drawable.error).placeholder(R.drawable.ajax_loader).into(iv);


    }
}
