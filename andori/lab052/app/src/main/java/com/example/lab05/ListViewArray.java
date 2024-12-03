package com.example.lab05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewArray extends AppCompatActivity {
    ListView lstMonHoc; // Khai báo ListView
    String[] arrMonHoc = new String[]{"Toan", "Van", "Ngoai ngu"}; // Dữ liệu hiển thị trong ListView
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_array);

        // Áp dụng WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Gọi các phương thức khởi tạo
        addview();
        addEvent();
    }

    private void addEvent() {
        lstMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = arrMonHoc[position];
                Toast.makeText(ListViewArray.this, "Bạn đã chọn: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addview() {
        lstMonHoc = findViewById(R.id.lstMonHoc);
        adapter = new ArrayAdapter<>(ListViewArray.this, android.R.layout.simple_list_item_1, arrMonHoc);
        lstMonHoc.setAdapter(adapter);
    }
}
