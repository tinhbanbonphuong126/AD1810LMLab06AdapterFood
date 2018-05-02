package com.example.admin.ad1810lmlab06adapterfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Tập hợp dữ liệu mẫu
    String arrFruit[] = new String[]{"Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt",
            "Bưởi", "Táo", "Cam", "Quýt"};

    ArrayList<Food> bkapRestaurant = new ArrayList<>();
    AdapterFood adapterFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_food_app);

        // Fake dữ liệu
        bkapRestaurant.add(new Food(R.drawable.food1, "Mỳ chay", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food2, "Phở bò", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food3, "Bánh xúc xích", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food4, "Cháo bào ngư", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food5, "Bánh tẻ", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food1, "Bún bò", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food2, "Bún mọc", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food3, "Bún ốc", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food4, "Cơm tấm", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food5, "Cơm sườn", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food2, "Cơm gà", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food3, "Mầm đá", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food4, "Cháo nấm", "Mỳ sợi nguyên chất làm từ thịt chó"));
        bkapRestaurant.add(new Food(R.drawable.food5, "Lá Ngón luộc", "Mỳ sợi nguyên chất làm từ thịt chó"));

        /*
        setContentView(R.layout.activity_main);

        // Bước 1: Lấy Listview từ trên layout xuống
        ListView lstF = (ListView) findViewById(R.id.listFruit);

        // Bước 2: Tạo Adapter
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrFruit);

        // Bước 3: đổ adapter lên ListView
        lstF.setAdapter(adapter);
        */

        // Bước 1: lấy ListView từ layout
        ListView lstFood = (ListView) findViewById(R.id.listFood);

        // Bước 2: tạo Adapter
        adapterFood = new AdapterFood(this, R.layout.item_food, bkapRestaurant);

        // Bước 3: đổ adapter cho ListView
        lstFood.setAdapter(adapterFood);

        // Cập nhật dữ liệu
        // 1. cập nhật trên List
        // 2. gọi adapter và hàm notify
        // adapterFood.notifyDataSetChanged();

        // Gán Context Menu cho ListView
        registerForContextMenu(lstFood);

        // Cài đặt sự kiện khi click vào item trên ListView => PopupMenu
        lstFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.inflate(R.menu.demo_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int idMenu = item.getItemId();
                        switch (idMenu) {
                            case R.id.menu_them:
                                Toast.makeText(MainActivity.this, "Thêm", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_sua:
                                Toast.makeText(MainActivity.this, "Sửa", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_xoa:
                                Toast.makeText(MainActivity.this, "Xóa", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Lựa chọn");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int idMenu = item.getItemId();
        switch (idMenu) {
            case R.id.menu_them:
                Toast.makeText(this, "Thêm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sua:
                Toast.makeText(this, "Sửa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_xoa:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idMenu = item.getItemId();
        switch (idMenu) {
            case R.id.menu_them:
                Toast.makeText(this, "Thêm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sua:
                Toast.makeText(this, "Sửa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_xoa:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

