package kr.edcan.eva;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setDefault();
        setAppbarLayout();
    }


    private void setAppbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("거래 내역");
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        drawable.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    private void setDefault() {
        listview = (ListView) findViewById(R.id.history_listview);
        ArrayList<HistoryData> arr = new ArrayList<>();
        arr.add(new HistoryData(0, "오준석", "2025.07.22에 거래함", "5400 KRW"));
        arr.add(new HistoryData(1, "오준석", "2025.07.22에 거래함", "5400 KRW"));
        arr.add(new HistoryData(1, "오준석", "2025.07.22에 거래함", "5400 KRW"));
        arr.add(new HistoryData(0, "오준석", "2025.07.22에 거래함", "5400 KRW"));
        arr.add(new HistoryData(0, "오준석", "2025.07.22에 거래함", "5400 KRW"));
        HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), arr);
        listview.setAdapter(adapter);
    }

    class HistoryData {

        int res;
        String name, date, money;

        /* 0 받음 1 보냄  */
        public HistoryData(int res, String name, String date, String money) {
            this.res = res;
            this.name = name;
            this.date = date;
            this.money = money;
        }

        public int getRes() {
            return res;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getMoney() {
            return money;
        }
    }

    class HistoryAdapter extends ArrayAdapter<HistoryData> {

        private LayoutInflater inflater;

        public HistoryAdapter(Context c, ArrayList<HistoryData> arr) {
            super(c, 0, arr);
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.history_listview_content, null);

            int res[] = new int[]{R.drawable.ic_histoty_badum, R.drawable.ic_histoty_bonem};
            HistoryData data = this.getItem(position);
            TextView title = (TextView) view.findViewById(R.id.history_listview_name);
            TextView content = (TextView) view.findViewById(R.id.history_listview_content);
            TextView money = (TextView) view.findViewById(R.id.history_listview_money);
            ImageView icon = (ImageView) view.findViewById(R.id.history_listview_icon);

            if (data != null) {
                title.setText(data.getName());
                content.setText(data.getDate());
                money.setText(data.getMoney());
                icon.setImageResource(res[data.getRes()]);
            }
            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}