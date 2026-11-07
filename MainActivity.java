package com.yuma.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int red = Color.rgb(190, 24, 42);
    private LinearLayout root;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        showHome();
    }

    private TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(12, 12, 12, 12);
        return t;
    }

    private void showHome() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(22, 30, 22, 22);
        root.setBackgroundColor(Color.WHITE);

        TextView logo = text("YUMA", 34, red);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, 1);
        root.addView(logo);
        TextView tagline = text("OLD TASTE IN A NEW LOOK", 12, Color.DKGRAY);
        tagline.setGravity(Gravity.CENTER);
        root.addView(tagline);
        TextView welcome = text("Добро пожаловать!", 23, Color.BLACK);
        welcome.setPadding(12, 35, 12, 16);
        root.addView(welcome);
        root.addView(text("Выберите удобный способ:", 16, Color.DKGRAY));

        addButton("Меню", "Раздел меню\nЗдесь будут актуальные блюда, фотографии и цены.");
        addButton("Доставка", "Доставка\nОформление заказа и выбор адреса будут подключены после настройки сервера.");
        addButton("Бронирование столика", "Бронирование\nВы сможете выбрать филиал, дату, время и количество гостей.");
        addButton("Мои заказы", "Мои заказы\nИстория заказов появится после подключения backend.");
        addButton("Филиалы", "Филиал YUMA\nБурхониддин Маргилоний, 60, Фергана.");
        setContentView(root);
    }

    private void addButton(String label, String message) {
        Button b = new Button(this);
        b.setText(label);
        b.setTextColor(Color.WHITE);
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(red));
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.setMargins(0, 10, 0, 4);
        root.addView(b, p);
        b.setOnClickListener(v -> {
            new android.app.AlertDialog.Builder(this)
                .setTitle(label).setMessage(message)
                .setPositiveButton("Понятно", (d, w) -> {}).show();
        });
    }
}
