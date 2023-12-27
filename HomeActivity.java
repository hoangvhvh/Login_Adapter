package org.coolstyles.demologin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import adapter.ConstantAdapter;
import org.coolstyles.demologin.util.Constants;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        intent.getIntExtra(Constants.PRODUCT_ID, 1);
    }

    private void initGUI(){
        String dataList[] = {"DucHoang", "HuuLoi", "SyHung", "VanChinh"};

        rvContact = findViewById(R.id.rv_contact);
        rvContact.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        ConstantAdapter adapter = new ConstantAdapter(dataList);
        rvContact.setAdapter(adapter);
    }
}