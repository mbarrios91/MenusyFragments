package com.mbarrios.petagram;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.Adapter.PageAdapter;
import com.mbarrios.petagram.Fragment.MascotasFragment;
import com.mbarrios.petagram.Fragment.PerfilFragment;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablaLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }


    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_dog);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
                case R.id.action_mascotas:
                    Toast.makeText(this, getResources().getString(R.string.text_menu), Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_acerca_de:
                    Intent i = new Intent(MainActivity.this, BioActivity.class);
                    startActivity(i);
                    return true;
                case R.id.action_contacto:
                    Intent i2 = new Intent(MainActivity.this, ContactoActivity.class);
                    startActivity(i2);
                    return true;
                case R.id.action_star:
                    Toast.makeText(this, getResources().getString(R.string.favoritas), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
