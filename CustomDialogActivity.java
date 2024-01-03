package org.coolstyles.demologin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        // Lấy các thành phần trong custom dialog layout
        TextView dialogTitle = findViewById(R.id.dialogTitle);
        TextView dialogContent = findViewById(R.id.dialogContent);
        Button cancelButton = findViewById(R.id.cancelButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedTechnology = extras.getString("selectedTechnology", "");
            dialogTitle.setText("Công nghệ được chọn");
            dialogContent.setText(selectedTechnology);
        }

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomDialogActivity.this, "Đã đóng hộp thoại Custom Dialog", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
