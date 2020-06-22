package com.example.shruthisports.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shruthisports.R;

import static android.widget.Toast.makeText;

public class RegisterTeamActivity extends AppCompatActivity {

    public LinearLayout linearLayoutParent;
    public EditText e;
    public String s1,s2,s3;

    private int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.linearLayoutparent);
        //this layout still needs to be vertical to hold the children.
        for (int i = 0; i < 6; i++) {
            TextView textViewm = new TextView(this);
            textViewm.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textViewm.setText("Player "+(i+1));
            //make a new horizontal LinearLayout each time to hold the children.
            LinearLayout temp = new LinearLayout(this);
            temp.setOrientation(LinearLayout.VERTICAL);

            LinearLayout temp1 = new LinearLayout(this);
            temp1.setOrientation(LinearLayout.HORIZONTAL);
            temp1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            TextView textView1 = new TextView(this);
            textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textView1.setText("NAME");
            temp1.addView(textView1); //add them to this temporary layout.

            EditText editText1 = new EditText(this);
            editText1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            editText1.setId(i*10+1);
            temp1.addView(editText1);


            LinearLayout temp2 = new LinearLayout(this);
            temp2.setOrientation(LinearLayout.HORIZONTAL);
            temp2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            TextView textView2 = new TextView(this);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textView2.setText("Roll No");
            temp2.addView(textView2); //add them to this temporary layout.

            EditText editText2 = new EditText(this);
            editText2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            editText2.setId(i*10+2);
            temp2.addView(editText2);


            LinearLayout temp3 = new LinearLayout(this);
            temp3.setOrientation(LinearLayout.HORIZONTAL);
            temp3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            TextView textView3 = new TextView(this);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textView3.setText("Class");
            temp3.addView(textView3); //add them to this temporary layout.

            EditText editText3 = new EditText(this);
            editText3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            editText3.setId(i*10+3);
            temp3.addView(editText3);

            temp.addView(temp1);
            temp.addView(temp2);
            temp.addView(temp3);
            rootLayout.addView(textViewm);
            rootLayout.addView(temp);
        }

        Button btn=new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        btn.setText("Register");
        rootLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func();
            }
        });
    }

    private void func() {
        for(int i=0;i<6;i++){
            EditText e1=(EditText)findViewById(10*i+1);
            EditText e2=(EditText)findViewById(10*i+2);
            EditText e3=(EditText)findViewById(10*i+3);
            s1=e1.getText().toString();
            s2=e2.getText().toString();
            s3=e3.getText().toString();
            makeText(this, "Name :"+s1, Toast.LENGTH_SHORT).show();
            makeText(this, "Roll no:"+s2, Toast.LENGTH_SHORT).show();
            makeText(this, "Class :"+s3, Toast.LENGTH_SHORT).show();
        }
    }
}