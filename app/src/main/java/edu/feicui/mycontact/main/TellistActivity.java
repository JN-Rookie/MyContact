package edu.feicui.mycontact.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.feicui.mycontact.R;
import edu.feicui.mycontact.adapter.TelclassApdater;
import edu.feicui.mycontact.adapter.Tellistadapter;
import edu.feicui.mycontact.bean.Telnumberbean;
import edu.feicui.mycontact.db.DBReader;

public class TellistActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView       mListView;
    private Tellistadapter adapter;
    private              int    idx = 0;
    private static final String TAG = "TellistActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellist);
//        用来判断是哪一种电话列表
        idx = getIntent().getIntExtra("idx", -1);
        Log.d(TAG, "onCreate: "+ idx);
        mListView = (ListView) findViewById(R.id.listview);
        adapter=new Tellistadapter(this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String name = adapter.getItem(position).name;
        String number = adapter.getItem(position).number;
        showCallDialog(name, number);
    }

    public void onResume() {
        super.onResume();
        try {
//            添加数据
        adapter.addDatatoadapter(DBReader.readTeldbtable(idx));
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }

    public void showCallDialog(final String name, final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("是否开始拨打" + name + "电话？\n\nTEL:" + number);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("拨号", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                拨打电话
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://" + number));
                startActivity(intent);
            }
        });
        builder.show();
    }
}
