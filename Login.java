package com.example.oheunji.chungmuro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etphone;
    private Button btnRegist;
    private EditText etpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etphone = (EditText) findViewById(R.id.etphone);
        btnRegist = (Button) findViewById(R.id.btnRegist);
        etpwd = (EditText)findViewById(R.id.etPassword_re);
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Regist.class);

                // SINGLE_TOP : 이미 만들어진게 있으면 그걸 쓰고, 없으면 새로 만들기
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                // intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // intent를 보내면서 다음 액티비티로부터 데이터를 받기 위해 식별번호(1000)을 준다.
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // setResult를 통해 받아온 요청번호, 상태, 데이터
        Log.d("RESULT", requestCode + "");
        Log.d("RESULT", resultCode + "");
        Log.d("RESULT", data + "");


        if(requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(Login.this, "회원가입을 완료했습니다!", Toast.LENGTH_SHORT).show();
            etphone.setText(data.getStringExtra("phone_number"));
            etpwd.setText(data.getStringExtra("pwd"));
        }

    }


    public void loginbutton(View v) {
        String user1_id = etphone.getText().toString();
        String user1_pwd = etpwd.getText().toString();

        //Toast.makeText(getApplicationContext(),user1_id+user1_pwd,Toast.LENGTH_SHORT).show();
        if ((user1_id.equals("010"))&&(user1_pwd.equals("1234"))) {
            Intent intent = new Intent(getApplicationContext(), Start.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"휴대폰번호와 패스워드를 확인해주세요",Toast.LENGTH_LONG).show();
        }
    }



}