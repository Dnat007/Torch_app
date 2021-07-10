package com.example.torch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Torch extends AppCompatActivity
{
    Button b1,b2,b3;
    CameraManager cm;
    private boolean camera = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        b1 = (Button)findViewById(R.id.button4);
        b2 = (Button)findViewById(R.id.button5);
        b3 = (Button)findViewById(R.id.button6);
        cm =(CameraManager)getSystemService(CAMERA_SERVICE);


        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                        String id =cm.getCameraIdList()[0];
                        cm.setTorchMode(id,true);
                        camera = true;
                }
                catch (CameraAccessException e)
                {

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    String s2 =cm.getCameraIdList()[0];
                    cm.setTorchMode(s2,false);
                    camera = false;

                }
                catch (CameraAccessException e)
                {

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 =new Intent(Torch.this,ToggleTorch.class);
                startActivity(intent3);
                finish();
            }
        });




    }
}