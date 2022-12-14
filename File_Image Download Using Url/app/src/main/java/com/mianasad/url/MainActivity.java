package com.mianasad.url;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://jpeg.org/images/jpegxt-home.jpg");
                DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI |
                        DownloadManager.Request.NETWORK_MOBILE);

                request.setTitle("File is downloaded Now From Url");
                request.setDescription("Url Download Android Studio");

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"/images/"+"/"+"pic"+".png");
                request.setMimeType("*/*");
                downloadManager.enqueue(request);
            }
        });
    }
}

