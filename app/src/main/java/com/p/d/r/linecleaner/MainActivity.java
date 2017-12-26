package com.p.d.r.linecleaner;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "LineCleaner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String path = Environment.getExternalStorageDirectory().getPath();
        path += "/Android/data/jp.naver.line.android/storage";
        File file = new File(path);
        if(file.exists()){
            FilenameFilter filenameFilter = new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    Log.w(TAG,file.getName()+" s:"+s);
                    if ( s.equals("p") ||
                            s.equals("mo") ||
                            s.equals("temp") ||
                            s.equals("toyboximg"))
                        return true;
                    return false;
                }
            };
            File[] files = file.listFiles(filenameFilter);
            for ( File test : files ) {
                Log.w(TAG, test.toString());
            }
        } else {
            Log.w(TAG,"no line install");
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
