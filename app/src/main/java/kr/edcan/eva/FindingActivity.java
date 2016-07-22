package kr.edcan.eva;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class FindingActivity extends AppCompatActivity {

    Toolbar toolbar;

    ListView listview;
    TextView count, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding);
        setAppbarLayout();
        setDefault();
    }

    private void setDefault() {
        listview = (ListView) findViewById(R.id.finding_listview);
        count = (TextView) findViewById(R.id.finding_personcount);
        cancelBtn = (TextView) findViewById(R.id.finding_reqCancel);
        ArrayList<PersonFindData> arrayList = new ArrayList<>();
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        arrayList.add(new PersonFindData("오준석", "바로 근처에 있음. 2시간 후 거래 가능", ""));
        FindingAdapter adapter = new FindingAdapter(getApplicationContext(), arrayList);
        listview.setAdapter(adapter);
    }

    private void setAppbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("EVA 찾는중");
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        drawable.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
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

    class PersonFindData {
        public PersonFindData(String name, String content, String profileurl) {
            this.name = name;
            this.content = content;
            this.profileurl = profileurl;
        }

        String name, content, profileurl;

        public String getName() {
            return name;
        }

        public String getContent() {
            return content;
        }

        public String getProfileurl() {
            return profileurl;
        }
    }

    class FindingAdapter extends ArrayAdapter<PersonFindData> {

        private LayoutInflater inflater;

        public FindingAdapter(Context c, ArrayList<PersonFindData> arr) {
            super(c, 0, arr);
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.finding_listview_content, null);

            PersonFindData data = this.getItem(position);
            if (data != null) {
                TextView name = (TextView) view.findViewById(R.id.finding_listview_name);
                TextView content = (TextView) view.findViewById(R.id.finding_listview_content);
                RoundImageView profile = (RoundImageView) view.findViewById(R.id.finding_listview_profileImg);
                name.setText(data.getName());
                content.setText(data.getContent());
//                profile.setImageUrl(data.getProfileurl(), ImageSingleTon.getInstance(getApplicationContext()).getImageLoader());
            }
            return view;
        }
    }
}
