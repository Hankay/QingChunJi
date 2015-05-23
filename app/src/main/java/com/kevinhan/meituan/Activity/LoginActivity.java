package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin Han on 2015/5/20.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhan.meituan.Adapter.FoodGridAdapter;
import com.kevinhan.meituan.Adapter.SampleAdapter;
import com.kevinhan.meituan.Data.Businesses;
import com.kevinhan.meituan.Data.SampleData;
import com.kevinhan.meituan.R;

import java.util.List;


/**
 * Created by Kevin han on 2015/5/6.
 */

public class LoginActivity extends Activity /*implements AdapterView.OnItemClickListener*/ {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        /*setTitle("ListView");

        final ListView listView = (ListView) findViewById(R.id.list_view);

        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        View footer = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
        TextView txtFooterTitle =  (TextView) footer.findViewById(R.id.txt_title);
        txtHeaderTitle.setText("THE HEADER!");
        txtFooterTitle.setText("THE FOOTER!");

        listView.addHeaderView(header);
        listView.addFooterView(footer);

        final SampleAdapter adapter = new SampleAdapter(this,R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        final List<String> sampleData = SampleData.generateSampleData();
        for (String data : sampleData) {
            adapter.add(data);
        }*/
    }

/*    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }*/


    public void init(){
        button = (Button)findViewById(R.id.bt_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,StaggeredGridActivity.class);
                startActivity(intent);
            }
        });
    }

}
