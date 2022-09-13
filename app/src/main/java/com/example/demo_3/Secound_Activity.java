package com.example.demo_3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Secound_Activity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE =1000 ;
    private ArrayAdapter adapter;
private ListView listView;
private ArrayList<String> list;
private RecyclerView recyclerView;
private Button button;
private TextView textView;
private ImageView imageView;
private PdfRenderer mPdfRenderer;
private ParcelFileDescriptor fileDescriptor;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        listView=findViewById(R.id.listview);
        recyclerView=findViewById(R.id.re);
        button=findViewById(R.id.button2);
        textView=findViewById(R.id.textView2);
        editText=findViewById(R.id.editTextTextPersonName);
     RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
imageView=findViewById(R.id.imageView1);
;
        list=new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("orange");
        list.add("orange");
        list.add("orange");
        list.add("orange");
        list.add("orange"); list.add("orange"); list.add("orange");
        list.add("orange");
        list.add("orange");

        recyclerView.setLayoutManager(layoutManager);
        Recycle_Adapter adapter1=new Recycle_Adapter(list);
        recyclerView.setAdapter(adapter1);
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    button.setOnClickListener(new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
           String num= editText.getText().toString();
        long number=Long.parseLong(num);
        NmberToWordConvert wordConvert=new NmberToWordConvert();
        String result=wordConvert.convert(number);
textView.setText(result);
requestPermission();
        }
    });


        File fileCopy = new File(getApplicationContext().getExternalFilesDir("/"), "QuoBot"+"/"+123 + ".pdf");

     

      //  File fileCopy= new File(file2, 123 + ".pdf");



        // We will get a page from the PDF file by calling openPage

/*
        try {
            fileDescriptor = ParcelFileDescriptor.open(fileCopy,
                    ParcelFileDescriptor.MODE_READ_ONLY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // PdfRenderer mPdfRenderer = null;
        try {
          mPdfRenderer = new PdfRenderer(fileDescriptor);
        } catch (IOException e) {


        }
        int pageNumber=1;
        PdfRenderer.Page mPdfPage = mPdfRenderer.openPage(pageNumber);

        // Create a new bitmap and render the page contents on to it
        Bitmap bitmap = Bitmap.createBitmap(mPdfPage.getWidth(),
                mPdfPage.getHeight(),
                Bitmap.Config.ARGB_8888);
        mPdfPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

        // Set the bitmap in the ImageView so we can view it
        imageView.setImageBitmap(bitmap);

 */
    }
    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                startActivityForResult(intent, 2296);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 2296);
            }
        } else {
            //below android 11
            ActivityCompat.requestPermissions(Secound_Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
}