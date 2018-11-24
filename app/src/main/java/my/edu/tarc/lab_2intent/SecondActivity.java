package my.edu.tarc.lab_2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        TextView textViewMsg;
        textViewMsg = findViewById(R.id.textViewMessage);
        String stringMsg;
        double BMI = 0.0;
        Intent intent = getIntent(); //Who called me?
        if(intent.hasExtra(my.edu.tarc.lab_2intent.MainActivity.TAG_MESSAGE)) {
            BMI = Double.parseDouble(intent.getStringExtra(my.edu.tarc.lab_2intent.MainActivity.TAG_MESSAGE));
        }
        ImageView imageView;
        imageView = findViewById(R.id.imageView);
        if(BMI < 18.5) {
            stringMsg = "You are underweight.";
            imageView.setImageResource(R.drawable.under);
        }
        else if(BMI < 25) {
            stringMsg = "You are normal.";
            imageView.setImageResource(R.drawable.normal);
        }
        else {
            stringMsg = "You are overweight.";
            imageView.setImageResource(R.drawable.over);
        }

        textViewMsg.setText(stringMsg);

    }
}
