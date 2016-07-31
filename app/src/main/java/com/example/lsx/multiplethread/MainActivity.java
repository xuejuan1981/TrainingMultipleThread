package com.example.lsx.multiplethread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mLoadImageButton;
    private Button mToastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= (ImageView) findViewById(R.id.activity_main_image_view);
        mLoadImageButton=(Button)findViewById(R.id.activity_main_load_image_button);
        mToastButton=(Button)findViewById(R.id.activity_main_tosat_button);

       mLoadImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new LoadImageTask().execute();
           }
       });

        mToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"多线程",Toast.LENGTH_SHORT).show();
            }
        });
    }
    class LoadImageTask extends AsyncTask<Void,Void,Bitmap>{
        @Override
        protected  Bitmap doInBackground(Void... params){
            try {
                Thread.sleep(4000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            mImageView.setImageBitmap(bitmap);
        }
    }

}
