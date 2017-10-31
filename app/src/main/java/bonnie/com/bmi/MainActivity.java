package bonnie.com.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bmi(View view){
     /*System.out.println("what???"); 用android monitor可以看到這行有被執行
         Log.wtf()    全名what a terrible failure*/
        Log.d("MainActivity","testing bmi method");  //除錯
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
     /*String s = edWeight.getText().toString();
         float weight = Float.parseFloat(s); 22,23可以變24*/
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi =weight/(height*height);
        new AlertDialog.Builder(this).setMessage("Your BMI is"+ bmi).setTitle("my title").setPositiveButton("ok",null).show();
     /*   Log.d("MainActivity","Your BMI is "+bmi);
        Toast.makeText(this, "Your BMI is"+bmi,  Toast.LENGTH_LONG).show();*/
    }
}
