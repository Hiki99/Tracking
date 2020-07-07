package com.example.broadcastreceiver;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {


    private static final int MY_PERMISSION_REQUEST_SEND_SMS = 0;
    static final int REQUEST_CODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check if the permission is not granted
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) +
                ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
        {
            //if permission is not granted then check if the user has denied the permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.SEND_SMS) || ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_PHONE_STATE))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("GRANT THOSE PERMISSION");
                builder.setMessage("SMS AND PHONE");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(
                                MainActivity.this,
                                new String[]{
                                        Manifest.permission.SEND_SMS,
                                        Manifest.permission.READ_PHONE_STATE
                                },
                                REQUEST_CODE
                        );
                    }
                });
                builder.setNegativeButton("Cancel",null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
            else
            {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.READ_PHONE_STATE
                        },
                        REQUEST_CODE
                );
            }
        }else {

        }

    }
}