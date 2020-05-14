package com.test.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        arrayList = new ArrayList<>();

        arrayList.add("Teste");
        arrayList.add("abc");
        arrayList.add("pale");
        arrayList.add("you");
        arrayList.add("ok");

        System.out.println("ArrayList - " + arrayList);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        Button btn_search = (Button) findViewById(R.id.btn_search);
        Button btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ArrayList - " + arrayList);

                ArrayList<String> arrayListSearch = new ArrayList<>();
                TextInputEditText edit_search = (TextInputEditText) findViewById(R.id.edit_search);
                String edit_value = edit_search.getText().toString();
                Search search = new Search();

                for (String arrayValue : arrayList) {
                    if(arrayValue.toLowerCase().contains(edit_value.toLowerCase())) {
                        arrayListSearch.add(arrayValue);
                    } else if (search.hasTypo(arrayValue, edit_value)) {
                        arrayListSearch.add(arrayValue);
                    }
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(arrayListSearch);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = new ArrayList<>();

                arrayList.add("Teste");
                arrayList.add("abc");
                arrayList.add("pale");
                arrayList.add("you");
                arrayList.add("ok");

                arrayAdapter.clear();
                arrayAdapter.addAll(arrayList);

                TextInputEditText edit_search = (TextInputEditText) findViewById(R.id.edit_search);
                edit_search.setText("");
            }
        });



    }
}
