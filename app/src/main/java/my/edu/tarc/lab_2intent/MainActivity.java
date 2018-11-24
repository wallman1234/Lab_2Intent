package my.edu.tarc.lab_2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.tarc.lab2intent.MESSAGE1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText editTextMessage;
        editTextMessage = findViewById(R.id.editTextMessage);
        EditText editTextMessage2;
        editTextMessage2 = findViewById(R.id.editTextMessage2);

        if (TextUtils.isEmpty(editTextMessage.getText())) {
            editTextMessage.setError(getString(R.string.error_message));
            return;
        }

        if (TextUtils.isEmpty(editTextMessage2.getText())) {
            editTextMessage2.setError(getString(R.string.error_message));
            return;
        }

        double weight, height;
        weight = Double.parseDouble(editTextMessage.getText().toString());
        height = Double.parseDouble(editTextMessage2.getText().toString());

        double BMI = weight / (height * height);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, Double.toString(BMI));
        startActivity(intent);
    }
}
