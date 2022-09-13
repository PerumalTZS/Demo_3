package com.example.demo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class Demo_activity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
 button=findViewById(R.id.button4);


 button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        // String PLACEHOLDER = "file:///android_asset/QUOT_2016_10(test).pdf";

         File file2 = new File(getApplicationContext().getExternalFilesDir("/"), "QuoBot/"+"/"+"Google"+"/");
         if (file2.isDirectory() == false) {
             file2.mkdirs();
         }
         //download button method

     File    file3 = new File(file2, 1212+ ".pdf");


         Uri uri = Uri.fromFile(file3);

         Intent share = new Intent();
         share.setAction(Intent.ACTION_SEND);
         share.putExtra(Intent.EXTRA_TEXT, "hi");
         share.setPackage("com.whatsapp");

         share.putExtra(Intent.EXTRA_STREAM, uri);
         share.setType("application/pdf");

        startActivity(share);
     }
 });
    }
}