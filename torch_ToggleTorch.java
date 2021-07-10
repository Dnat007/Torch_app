package com.example.torch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class ToggleTorch extends AppCompatActivity
{
    ToggleButton t1;
    Button b1;
    CameraManager cm;
    private boolean camera =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_torch);
        b1 = (Button)findViewById(R.id.button9);
        t1 = (ToggleButton)findViewById(R.id.toggleButton);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);

        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
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
                else
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
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(ToggleTorch.this,TorchImage.class);
                startActivity(intent4);
                finish();
            }
        });

    }
}