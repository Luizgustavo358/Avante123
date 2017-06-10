package com.luizgbraganca.avante123;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    // definir dados
    private FloatingActionButton fab;
    public List<Projetos> projetos;
    public ProjetosAdapter projetosAdapter;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference();

        mDatabase.child("projetos").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {
                Projetos p = dataSnapshot.getValue(Projetos.class);

                projetos.add(p);

                projetosAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, p.getNomeProjeto(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, p.getDescricao(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        // esse aqui ta pegando os dados do firebase
        mDatabase.limitToLast(2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.child("projetos").getChildren())
                {
                    Projetos pj = dataSnapshot1.getValue(Projetos.class);
                    projetos.add(pj);
                    projetosAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        projetos = new ArrayList<>();

        Projetos p1 = new Projetos("Avante", "Tipo Trello");

        projetos.add(p1);

        projetosAdapter = new ProjetosAdapter(projetos, this);

        recyclerView.setAdapter(projetosAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        projetosAdapter.notifyDataSetChanged();

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProjeto.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy( )
    {
        super.onDestroy();
        projetos.clear();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tarefas) {
            tarefas( );
        } else if (id == R.id.nav_grupo) {
            grupo( );
        } else if (id == R.id.nav_config) {
            config( );
        } else if (id == R.id.nav_sobre) {
            sobre( );
        } else if (id == R.id.nav_deslogar) {
            deslogar( );
        }// end if

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void tarefas( )
    {
        Intent intent = new Intent(MainActivity.this, MinhasTarefas.class);
        startActivity(intent);
    }

    public void grupo( )
    {
        Intent intent = new Intent(MainActivity.this, EscolheGrupo.class);
        startActivity(intent);
    }

    public void config( )
    {
        Intent intent = new Intent(MainActivity.this, Configuracoes.class);
        startActivity(intent);
    }

    public void sobre( )
    {
        Intent intent = new Intent(MainActivity.this, Sobre.class);
        startActivity(intent);
    }

    public void deslogar( )
    {
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}