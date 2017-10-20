package com.example.jashaswee.multithreadingbasics_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static String xyz;
    public static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            onStop();
        textView = (TextView) findViewById(R.id.changeable);
//        textView.setText("dhbasudbsdbcseigiured");
        Second second = new Second();
        second.execute();}
//    Thread t = new Thread(this,"this thread");
//    t.start();
// }

    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                textView.append(j + " ");
            }
            textView.append("\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Second extends AsyncTask<Void, String, String> {
   private String results;


    @Override
    protected String doInBackground(Void... params) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                results += j + " ";
            }
            results += "\n";
            try {
                if(results==null)
                {
                    publishProgress(results);

                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return (results);

    }
    @Override
    protected void onProgressUpdate(String... progress)
    {
        while
       MainActivity.textView.append(progress[0]);

    }

}
