package com.mianasad.image_url_download;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName;
    Button downloadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        downloadImage=findViewById(R.id.downloadImage);

        downloadImage.setOnClickListener(v -> {

            String url = editTextTextPersonName.getText().toString();
            DownloadImage("Your Developer Here",url);
        });
    }

    void DownloadImage(String fileName,String imageURl) {
        try{
            DownloadManager downloadManager = null ;
            downloadManager=(DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri downloaduri=Uri.parse(imageURl);
            DownloadManager.Request request = new DownloadManager.Request(downloaduri);

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE)
                            .setAllowedOverRoaming(false)
                            .setTitle(fileName)
                            .setMimeType("image/jpeg")
                            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator+fileName+".jpg");
                    //separator means "/" example : /image/pic1.jpg

            downloadManager.enqueue(request);

            Toast.makeText(this, "Image Download Done", Toast.LENGTH_SHORT).show();

        }catch (Exception e)
        {
            Toast.makeText(this, "Image Downloading Fail", Toast.LENGTH_SHORT).show();
        }
    }
}