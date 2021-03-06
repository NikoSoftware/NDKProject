package com.example.niko.ndkproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niko.ndkproject.R;
import com.example.niko.ndkproject.model.Hello;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView tv;
    private EditText etCheck;
    private Button btCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);

        etCheck = (EditText) findViewById(R.id.et_check);
        btCheck = (Button) findViewById(R.id.bt_check);

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etCheck.getText().toString();
                if(TextUtils.isEmpty(data)){
                    return;
                }
                tv.setText(Hello.callObjectMethod(data));

                etCheck.setText(null);


            }
        });



        tv.setText(Hello.callStaticMethod());
    }


    public void showToast(String text) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
