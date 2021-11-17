package com.example.voicerecorder;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    private static int MICROPHONE_PERMISSION_CODE=200;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        textView = findViewById(R.id.text);
        }



    public void btnManjeet(View view) {
        Toast.makeText(this,"Testing Start !!! \n Wait for Response",Toast.LENGTH_LONG).show();
        textView.setText("You choose Manjeet voice as test. \n Please wait, for training complete");
        textView.setText(startTesting("Manjeet"));


    }

    public void btnRohit(View view) {
        Toast.makeText(this,"Testing Start !!! \n Wait for Response",Toast.LENGTH_LONG).show();
        textView.setText("You choose Rohit voice as test. \n Please wait, for training complete");
        textView.setText(startTesting("Rohit"));
    }

    public void btnDurjoy(View view) {
        Toast.makeText(this,"Testing Start !!! \n Wait for Response",Toast.LENGTH_LONG).show();
        textView.setText("You choose Durjoy voice as test. \n Please wait, for training complete");
        textView.setText(startTesting("Durjoy"));
    }

    public void btnPrakash(View view) {
        Toast.makeText(this,"Testing Start !!! \n Wait for Response",Toast.LENGTH_LONG).show();
        textView.setText("You choose Prakash voice as test. \n Please wait, for training complete");
        textView.setText(startTesting("Prakash"));
    }
    public String startTesting(String str){
        Python py = Python.getInstance();
        PyObject pyobj= py.getModule("test");
        PyObject obj =pyobj.callAttr("main",str);
    return obj.toString();
    }
}