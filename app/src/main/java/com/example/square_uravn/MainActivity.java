package com.example.square_uravn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button run;
    private Button del;
    double a;
    double b;
    double c;
    String r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        run =(Button) findViewById(R.id.run);

        run.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                solveEquation(view);
            }
        });

        del = (Button) findViewById(R.id.del);

        del.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText edit = (EditText)findViewById(R.id.a);
                edit.setText("");
                EditText edit1 = (EditText)findViewById(R.id.b);
                edit1.setText("");
                EditText edit2 = (EditText)findViewById(R.id.c);
                edit2.setText("");
                TextView result = findViewById(R.id.res);
                result.setText("");
            }
        });

    }
    public void solveEquation(View view) {

        EditText edit = (EditText)findViewById(R.id.a);
        EditText edit1 = (EditText)findViewById(R.id.b);
        EditText edit2 = (EditText)findViewById(R.id.c);
        if((edit.getText().toString().trim().length() == 0) || (edit1.getText().toString().trim().length() == 0) || (edit2.getText().toString().trim().length() == 0)){
            Toast.makeText(getApplicationContext(),
                    "НЕОБХОДИМО ВВЕСТИ a, b, c!!!",
                    Toast.LENGTH_SHORT).show();
        }
        if(!((edit.getText().toString().trim().length() == 0) || (edit1.getText().toString().trim().length() == 0) || (edit2.getText().toString().trim().length() == 0))) {

            a = Double.parseDouble(edit.getText().toString());

            b = Double.parseDouble(edit1.getText().toString());

            c = Double.parseDouble(edit2.getText().toString());

            double d = b * b - 4 * a * c;


            if (a == 0 && b == 0 && c == 0)
                r = "any";

            if ((a == 0 && b == 0 && c != 0) || (d < 0))
                r = "none";

            if (!(a == 0 && b == 0 && c == 0) && (d == 0))
                r = Double.toString(-b / (2 * a));

            if (d > 0)
                r = Double.toString((-b + Math.sqrt(d)) / (2 * a)) + "  " + (-b - Math.sqrt(d)) / (2 * a);

            TextView result = findViewById(R.id.res);
            result.setText("Ответ: " + r);
        }
    }


    }

