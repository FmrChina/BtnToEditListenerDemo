package btntoeditlistener.fmr.btntoeditlistenerdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends AppCompatActivity {

    private EditText editPhone,editPwd,editVerify,editPwd1,editPwd2;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init(){
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editPwd = (EditText) findViewById(R.id.edit_pwd);
        editPwd1 = (EditText) findViewById(R.id.edit_pwd1);
        editPwd2 = (EditText) findViewById(R.id.edit_pwd2);
        editVerify = (EditText) findViewById(R.id.edit_verification);
        btnRegister = (Button) findViewById(R.id.btn_register);

        BtnToEditListenerUtils.getInstance()
                .setBtn(btnRegister)
                .addEditView(editPhone)
                .addEditView(editPwd)
                .addEditView(editPwd1)
                .addEditView(editPwd2)
                .addEditView(editVerify)
                .build();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Register",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
