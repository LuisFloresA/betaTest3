package com.example.betatest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    private Button mBtn;
    private ListView mListView;
    private List<String> mLista = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    private String last;
    Bundle variable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mListView = findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);
        agregar();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                variable = new Bundle();
                variable.putString("key1",last);
                Intent act2 = new Intent(this,Mapita.class);
                act2.putExtras(variable);
                startActivity(act2);
        }
    }

    public void agregar(){
        mLista.add("PDI");
        mLista.add("Hospital");
        mLista.add("Clinica Dental");
        mLista.add("Farmacia");
        mLista.add("Carabineros");
        mLista.add("Veterinaria");
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mLista);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        last = mLista.get(position);
        Toast.makeText(this,"Seleccionó " + last, Toast.LENGTH_SHORT).show();

    }
}