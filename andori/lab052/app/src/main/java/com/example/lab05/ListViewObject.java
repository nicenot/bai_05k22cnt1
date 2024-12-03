package com.example.lab05;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.MonHoc;

import java.util.ArrayList;

public class ListViewObject extends AppCompatActivity {
    ListView lstMonHoc; // Khai báo ListView
    ArrayAdapter<MonHoc> adapter; // Adapter hiển thị danh sách đối tượng
    ArrayList<MonHoc> dsMonHoc; // Danh sách các môn học

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_object);

        // Áp dụng WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addView();
        addEvent();
    }

    private void addView() {
        lstMonHoc = findViewById(R.id.lstMonHoc); // Gắn ListView từ XML

        // Khởi tạo danh sách các môn học
        dsMonHoc = new ArrayList<>();
        dsMonHoc.add(new MonHoc(1, "Toán", 45));
        dsMonHoc.add(new MonHoc(2, "Văn", 30));


        // Cài đặt adapter
        adapter = new ArrayAdapter<>(ListViewObject.this, android.R.layout.simple_list_item_1, dsMonHoc);
        lstMonHoc.setAdapter(adapter);
    }

    private void addEvent() {
        lstMonHoc.setOnItemClickListener((parent, view, position, id) -> {
            MonHoc selectedMonHoc = dsMonHoc.get(position); // Lấy môn học được chọn
            String message = "Bạn chọn: " + selectedMonHoc.getTenMH() + ", số tiết: " + selectedMonHoc.getSoTiet();
            Toast.makeText(ListViewObject.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
