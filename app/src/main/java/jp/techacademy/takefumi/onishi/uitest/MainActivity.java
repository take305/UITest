package jp.techacademy.takefumi.onishi.uitest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button3.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button)
            text.setText(edit.getText().toString());
        else if (view.getId() == R.id.button2)
            showAlertDialog();
        else if (view.getId() == R.id.button3)
            showTimePickerDialog();
        else if (view.getId() == R.id.button4)
            showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.d("UI-PARTS",String.valueOf(year)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(dayOfMonth));

                    }
                },
                2016,
                6,
                1);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13, 0, true);
        timePickerDialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Title");
        alertDialogBuilder.setMessage("message");

        alertDialogBuilder.setPositiveButton("はい",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });
        alertDialogBuilder.setNeutralButton("どちらでもない",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS", "中立ボタン");
                    }
                });
        alertDialogBuilder.setNegativeButton("いいえ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
