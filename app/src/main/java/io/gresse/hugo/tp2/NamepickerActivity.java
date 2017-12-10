package io.gresse.hugo.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NamepickerActivity extends AppCompatActivity {
    public static final String TAG = NamepickerActivity.class.getSimpleName();
    private EditText mInputEditTextName;
    private EditText mInputEditTextMail;
    private TextView wrongField;
    private Button mSendButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namepicker);

        mInputEditTextMail = findViewById(R.id.userMail);
        mInputEditTextName = findViewById(R.id.userName);
        mSendButton = findViewById(R.id.userSave);
        wrongField = findViewById(R.id.wrongField);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mInputEditTextName.getText().toString();
                String mail = mInputEditTextMail.getText().toString();
                if(!name.isEmpty() && !mail.isEmpty() && saveUserStorage(name, mail)){
                    goToMainActivity();
                }
                wrongField.setVisibility(View.VISIBLE);
                mInputEditTextName.setText("");
                mInputEditTextMail.setText("");
            }
        });
    }

    private void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    private boolean saveUserStorage(String name, String mail){
        UserStorage.saveUserInfo(this, name, mail);
        return true;
    }

}
