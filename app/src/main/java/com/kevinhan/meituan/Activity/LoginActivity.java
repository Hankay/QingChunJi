package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin Han on 2015/5/20.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kevinhan.meituan.Data.Login;
import com.kevinhan.meituan.R;
import com.kevinhan.meituan.Utils.AsyncHttpLoginDate;

import java.util.List;


/**
 * Created by Kevin han on 2015/5/6.
 */

public class LoginActivity extends Activity implements AsyncHttpLoginDate.IcallBack {

    private String TAG ="LoginActivity";
    private List<Login> loginDateList;

    private Button button;
    private EditText et_login_name;
    private EditText et_login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        AsyncHttpLoginDate asyncHttpLoginDate = new AsyncHttpLoginDate(this);
        asyncHttpLoginDate.RequestHttp();
    }


    public void init(){
        et_login_name = (EditText)findViewById(R.id.et_login_name);
        et_login_password = (EditText)findViewById(R.id.et_login_password);
        button = (Button)findViewById(R.id.bt_login);
    }


    @Override
    public void callBackResult(final List<Login> loginDateList) {
        this.loginDateList = loginDateList;
        Log.e(TAG,"loginDateList->"+loginDateList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_name = et_login_name.getText().toString();
                String input_password = et_login_password.getText().toString();
                Log.e(TAG,"input_name->"+input_name);
                Log.e(TAG,"input_password->"+input_password);
                for (int i=0;i<loginDateList.size();i++){
                    Log.e(TAG,"getName->"+loginDateList.get(i).getName());
                    Log.e(TAG,"getPassword->"+loginDateList.get(i).getPassword());
                    if (loginDateList.get(i).getName().equals(input_name) && loginDateList.get(i).getPassword().equals(input_password)){
                        Intent intent = new Intent(LoginActivity.this,StaggeredGridActivity.class);
                        startActivity(intent);
                        break;
                    }else {
                            Toast.makeText(LoginActivity.this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
