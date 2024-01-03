package org.coolstyles.demologin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adapter.ConstantAdapter;
import org.coolstyles.demologin.util.Constants;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvContact;
    private Button showAlertDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showAlertDialogButton = findViewById(R.id.showAlertDialogButton);
        rvContact = findViewById(R.id.rv_contact);

      //  initGUI();

        showAlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CustomDialogActivity.class);
                AlertDialogExample.showAlertDialog(HomeActivity.this, intent);
            }
        });
    }

   // private void initGUI() {
    //    String dataList[] = {"DucHoang", "HuuLoi", "SyHung", "VanChinh"};

    //    rvContact.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    //    ConstantAdapter adapter = new ConstantAdapter(dataList);
     //   rvContact.setAdapter(adapter);
  //  }
}
