package jp.techacademy.takefumi.onishi.uitest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button)
            text.setText(edit.getText().toString());
        else if (view.getId() == R.id.button2)
            showAlertDialog();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Title");
        alertDialogBuilder.setMessage("message");

        alertDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS","肯定ボタン");
                    }
                });
        alertDialogBuilder.setNeutralButton("中立",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS","中立ボタン");
                    }
                });
        alertDialogBuilder.setNegativeButton("否定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("UI_PARTS","否定ボタン");
                    }
                });

        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();

    }
}
