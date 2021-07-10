package com.example.torch;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TorchImage extends AppCompatActivity {
    ImageButton i1;
    Button b1;
    CameraManager cm;
    private boolean torch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch_image);
        b1 = (Button)findViewById(R.id.button7);
        i1 = (ImageButton)findViewById(R.id.imageButton);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(TorchImage.this,MainActivity.class);
                startActivity(intent4);
                finish();
            }
        });



        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(torch == false)
                {
                      torchon();
                      Toast.makeText(TorchImage.this,"open torch",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    torchoff();
                    Toast.makeText(TorchImage.this,"close torch",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    private void torchon()
    {
        try {
            String id =cm.getCameraIdList()[0];
            cm.setTorchMode(id,true);
            torch = true;
            i1.setImageResource(R.drawable.onn);

        }
        catch (CameraAccessException e)
        {

        }
    }
    private void torchoff()
    {
        try {
            String id =cm.getCameraIdList()[0];
            cm.setTorchMode(id,false);
            torch = false;
            i1.setImageResource(R.drawable.offf);
        }
        catch (CameraAccessException e)
        {

        }
    }

}