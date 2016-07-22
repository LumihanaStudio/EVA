package kr.edcan.eva;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView drawername, drawerEmail;
    ListView drawerListView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAppbarLayout();
        setDefault();
    }

    private void setDefault() {
        drawerListView = (ListView) findViewById(R.id.main_drawer_listview);
        drawername = (TextView) findViewById(R.id.main_drawer_name);
        drawerEmail = (TextView) findViewById(R.id.main_drawer_email);
        ArrayList<DrawerData> arr = new ArrayList<>();
        arr.add(new DrawerData("충전하기"));
        arr.add(new DrawerData("거래 가능 여부", "토글을 끄면 거래 신청 알림이 오지 않습니다", false));
        arr.add(new DrawerData("거래 내역"));
        arr.add(new DrawerData("마이페이지"));
        arr.add(new DrawerData("문의하기"));
        arr.add(new DrawerData("친구 초대"));
        arr.add(new DrawerData("이벤트"));
        DrawerListViewAdapter drawerListViewAdapter = new DrawerListViewAdapter(getApplicationContext(), arr);
        drawerListView.setAdapter(drawerListViewAdapter);
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                        Switch s = (Switch) view.findViewById(R.id.drawer_listview_switch);
                        s.setChecked(!s.isChecked());
                }
            }
        });
    }

    private void setAppbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(toggle);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("EVA");
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

// Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class DrawerData {
        String title, content;
        boolean canDeal;
        int type = 1;

        public DrawerData(String title, String content, boolean canDeal) {
            this.title = title;
            this.content = content;
            this.type = 0;
            this.canDeal = canDeal;
        }

        public DrawerData(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public boolean isCanDeal() {
            return canDeal;
        }

        public int getType() {
            return type;
        }
    }

    class DrawerListViewAdapter extends ArrayAdapter<DrawerData> {

        private LayoutInflater inflater;

        public DrawerListViewAdapter(Context c, ArrayList<DrawerData> arr) {
            super(c, 0, arr);
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.drawer_listview_content, null);
            DrawerData data = this.getItem(position);
            TextView title = (TextView) view.findViewById(R.id.drawer_listview_title);
            TextView content = (TextView) view.findViewById(R.id.drawer_listview_content);
            Switch switchS = (Switch) view.findViewById(R.id.drawer_listview_switch);
            if (data != null) {
                if(data.getType() == 0){
                    switchS.setVisibility(View.VISIBLE);
                    content.setVisibility(View.VISIBLE);
                    switchS.setChecked(data.isCanDeal());
                    content.setText(data.getContent());
                }
                title.setText(data.getTitle());
            }
            return view;
        }
    }
}
