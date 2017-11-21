package bonnie.com.bmi;

import android.content.Intent;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edHeight;
    private EditText edWeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        getResources().getString(R.string.app_name);
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("xxx")
                        .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
    private void findViews() {
        edHeight = (EditText) findViewById(R.id.ed_height);
        edWeight = (EditText) findViewById(R.id.ed_weight);
        bHelp = (Button) findViewById(R.id.b_help);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    public void bmi(View view) {
     /*System.out.println("what???"); 用android monitor可以看到這行有被執行
         Log.wtf()    全名what a terrible failure*/
        Log.d("MainActivity", "testing bmi method");  //除錯
     /*String s = edWeight.getText().toString();
         float weight = Float.parseFloat(s); 22,23可以變24*/
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(getString(R.string.extra_bmi),bmi);
        startActivity(intent);
       /* if (height > 3) {
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }else if (bmi < 20) {
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is) + bmi + "請多吃點")
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }else {
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is) + bmi)
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();

    }*/
     /*   Log.d("MainActivity","Your BMI is "+bmi);
        Toast.makeText(this, "Your BMI is"+bmi,  Toast.LENGTH_LONG).show();*/

    }
}


