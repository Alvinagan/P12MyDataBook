package sg.edu.rp.c346.p11_mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;
    private String[] drawerItems;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    String currentTitle;
    ActionBar ab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerItems = new String[] { "Bio", "Vaccination", "Anniversary", "About Us" };
        ab = getSupportActionBar();

        Adapter adapter = new Adapter(this, R.layout.row, drawerItems);
        drawerList.setAdapter(adapter);


        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                if (position == 3){
                    Intent i = new Intent(MainActivity.this, AboutUs.class);
                    startActivity(i);
                    return;
                }

                Fragment fragment = null;
                if (position == 0){
                    fragment = new BioFragment();

                } else if (position == 1){
                    fragment = new VaccinationFragment();
                } else if (position == 2){
                    fragment = new AnniversaryFragment();

                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction trans = fm.beginTransaction();
                trans.replace(R.id.content_frame, fragment);
                trans.commit();

                drawerList.setItemChecked(position, true);
                currentTitle = drawerItems[position];
                ab.setTitle(currentTitle);
                drawerLayout.closeDrawer(drawerList);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerList);
            }
        });

        currentTitle = this.getTitle().toString();

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){
            /** Would be called when a drawer has completely closed */
            @Override
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                ab.setTitle(currentTitle);
            }

            /** Would be called when a drawer has completely open */
            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                ab.setTitle("P12 - My Data Book");
            }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(drawerToggle);
        ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected void onPostCreate(Bundle saveInstanceState){
        // Sync toggle state so the indicator is shown properly.
        //  Have to call in onPostCreate()
        super.onPostCreate(saveInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
