package com.example.shruthisports.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.shruthisports.R;
import com.example.shruthisports.fragments.RegisterFragment;

public class OTPVerification extends Dialog implements TextWatcher {

    EditText editText_one;
    EditText editText_two;
    EditText editText_three;
    EditText editText_four;
    Button otp_submit;
    TextView otpDialopTextView;
    String OTP = RegisterFragment.OTP;
    public static boolean Verified = false;

    public OTPVerification(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_verify);

        otpDialopTextView = findViewById(R.id.otp_dialog_textView);
        otpDialopTextView.setText(OTP);
        otp_submit = findViewById(R.id.otp_submit);
        editText_one = findViewById(R.id.editTextone);
        editText_two = findViewById(R.id.editTexttwo);
        editText_three = findViewById(R.id.editTextthree);
        editText_four = findViewById(R.id.editTextfour);
        editText_one.addTextChangedListener(this);
        editText_two.addTextChangedListener(this);
        editText_three.addTextChangedListener(this);
        editText_four.addTextChangedListener(this);

        otp_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { verifyOTP();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
        public void afterTextChanged(Editable editable) {
        if (editable.length() == 1) {
            if (editText_one.length() == 1) {
                editText_two.requestFocus();
            }

            if (editText_two.length() == 1) {
                editText_three.requestFocus();
            }
            if (editText_three.length() == 1) {
                editText_four.requestFocus();
            }
        } else if (editable.length() == 0) {
            if (editText_four.length() == 0) {
                editText_three.requestFocus();
            }
            if (editText_three.length() == 0) {
                editText_two.requestFocus();
            }
            if (editText_two.length() == 0) {
                editText_one.requestFocus();
            }
        }
    }
    public void verifyOTP(){
        char[] userOtp = new char[4];
        userOtp[0]=editText_one.getText().charAt(0);
        userOtp[1]=editText_two.getText().charAt(0);
        userOtp[2]=editText_three.getText().charAt(0);
        userOtp[3]=editText_four.getText().charAt(0);
        String userOTP = new String(userOtp);
        if(OTP.equals(userOTP)){
            Verified = true;
            Toast.makeText(getContext(),"OTP verified",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getContext(),RegisterFragment.class);
        }else{
            Toast.makeText(getContext(),"Wrong OTP please try again later",Toast.LENGTH_LONG).show();
        }
    }
}