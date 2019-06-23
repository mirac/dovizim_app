package com.mir.dovizim;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    if(!isAPIConnectionAvaible(getApplicationContext())) {
                        throw new Exception("Http connection error!");
                    }
                    // Splash screeni göstermek için kasten durduruyorum
                    Thread.sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(MainActivity.this, CurrencyActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    private boolean isAPIConnectionAvaible(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
