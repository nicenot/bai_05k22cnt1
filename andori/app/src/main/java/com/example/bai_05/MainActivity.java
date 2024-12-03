package com.example.bai_05;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtMaSo, edtHoTen, edtSoDienThoai;

    private ArrayList<String> nhanVienList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view
        edtMaSo = findViewById(R.id.edtMaSo);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        Button btnThem = findViewById(R.id.btnThem);
        ListView lvNhanVien = findViewById(R.id.lvNhanVien);

        // Tạo danh sách nhân viên và adapter
        nhanVienList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanVienList);
        lvNhanVien.setAdapter(adapter);

        // Xử lý nút thêm
        btnThem.setOnClickListener(v -> {
            String maSo = edtMaSo.getText().toString().trim();
            String hoTen = edtHoTen.getText().toString().trim();
            String soDienThoai = edtSoDienThoai.getText().toString().trim();

            if (maSo.isEmpty() || hoTen.isEmpty() || soDienThoai.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            String nhanVien = "Mã: " + maSo + ", Tên: " + hoTen + ", SĐT: " + soDienThoai;
            nhanVienList.add(nhanVien);
            adapter.notifyDataSetChanged();

            // Xóa dữ liệu nhập
            edtMaSo.setText("");
            edtHoTen.setText("");
            edtSoDienThoai.setText("");

            Toast.makeText(this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
        });

        // Xử lý click vào item
        lvNhanVien.setOnItemClickListener((parent, view, position, id) -> {
            String nhanVien = nhanVienList.get(position);
            String[] parts = nhanVien.split(", ");
            edtMaSo.setText(parts[0].split(": ")[1]);
            edtHoTen.setText(parts[1].split(": ")[1]);
            edtSoDienThoai.setText(parts[2].split(": ")[1]);
        });

        // Xử lý long click để xóa item
        lvNhanVien.setOnItemLongClickListener((parent, view, position, id) -> {
            nhanVienList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa nhân viên thành công", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}