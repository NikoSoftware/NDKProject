package com.example.niko.ndkproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niko.ndkproject.R;
import com.example.niko.ndkproject.model.A;
import com.example.niko.ndkproject.model.B;
import com.example.niko.ndkproject.model.C;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.AndroidInjection;

/**
 * title:
 * Created by niko on 2018/5/5
 */


public class DaggerTestActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tv;
    private EditText etCheck;
    private Button btCheck;

    @Inject
    public B b;

    @Inject
    public Lazy<C> c;

    @Inject
    public A a;

    private Button btC;
    private Button btA;
    private TextView tvJump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);

        // Example of a call to a native method
        tvJump = (TextView) findViewById(R.id.tv_jump);

        btCheck = (Button) findViewById(R.id.bt_check);
        btC = (Button) findViewById(R.id.bt_C);
        btA = (Button) findViewById(R.id.bt_A);

        tvJump.setOnClickListener(this);
        btCheck.setOnClickListener(this);
        btC.setOnClickListener(this);
        btA.setOnClickListener(this);

    }


    public void showToast(String text){

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_jump:
                Intent intent = new Intent(this,MainActivity.class);

                startActivity(intent);

                break;
            case R.id.bt_check:
                showToast(b.getKey());
                break;
            case R.id.bt_C:
                showToast( c.get().getB().getKey());
                break;
            case R.id.bt_A:
                a.setValue("this is A");
                showToast(a.getValue());
                break;




        }



    }
}
