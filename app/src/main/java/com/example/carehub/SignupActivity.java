package com.example.carehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    EditText edName, edEmail, edPassword, edrepeatpass;

    public static final String TAG = "SignupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edrepeatpass = findViewById(R.id.edPasswordrepeat);


    }

    public void signup(View view) {


        if(TextUtils.isEmpty(edName.getText())){
            edName.setError("Name is required");

        }else if(TextUtils.isEmpty(edEmail.getText())){
            edEmail.setError("Email is required");
        }

        else if(TextUtils.isEmpty(edPassword.getText())){
            edPassword.setError("Password is required");
        }
        else if(TextUtils.isEmpty(edrepeatpass.getText())){
            edrepeatpass.setError("Confirm password is required");
        }
        else if(!edPassword.getText().toString().equals(edrepeatpass.getText().toString())){
            Toast.makeText(SignupActivity.this, "Passwords are not the same!", Toast.LENGTH_SHORT).show();
        }
        else{
            ParseUser user = new ParseUser();
// Set the user's username and password, which can be obtained by a forms
            user.setUsername(edName.getText().toString().trim());
            user.setEmail(edEmail.getText().toString().trim());
            user.setPassword(edPassword.getText().toString());
            user.put("name", edName.getText().toString().trim());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {

                        Toast.makeText(SignupActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this,ProfileImageActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        ParseUser.logOut();
                        Log.e(TAG, "issue with logout", e);
                        Toast.makeText(SignupActivity.this, "Loged out", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

//    public void signup(View view){
//
//        if(TextUtils.isEmpty(edName.getText())){
//            edName.setError("Name is required");
//
//        }else if(TextUtils.isEmpty(edEmail.getText())){
//            edEmail.setError("Email is required");
//        }
//
//        else if(TextUtils.isEmpty(edPassword.getText())){
//            edPassword.setError("Password is required");
//        }
//        else if(TextUtils.isEmpty(edrepeatpass.getText())){
//            edrepeatpass.setError("Confirm password is required");
//        }
//        else if(!edPassword.getText().toString().equals(edrepeatpass.getText().toString())){
//            Toast.makeText(SignupActivity.this, "Passwords are not the same!", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            ParseUser user = new ParseUser();
//// Set the user's username and password, which can be obtained by a forms
//            user.setUsername(edEmail.getText().toString().trim());
//            user.setEmail(edEmail.getText().toString().trim());
//            user.setPassword(edPassword.getText().toString());
//            user.put("name", edName.getText().toString().trim());
//            user.signUpInBackground(new SignUpCallback() {
//                @Override
//                public void done(ParseException e) {
//                    if (e == null) {
//                        Toast.makeText(SignupActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(SignupActivity.this,ProfileImageActivity.class);
//                        startActivity(intent);
//                        finish();
//
//
//
//                    } else {
//                        ParseUser.logOut();
//                        Toast.makeText(SignupActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }


}