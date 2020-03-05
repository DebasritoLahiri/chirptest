package com.android.debasrito.chirptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;

import io.chirp.chirpsdk.ChirpSDK;
import io.chirp.chirpsdk.models.ChirpError;
import io.chirp.chirpsdk.interfaces.ChirpEventListener;


public class MainActivity extends AppCompatActivity {





    String CHIRP_APP_KEY = "2f7C3e47146cB3503B605D48a";
    String CHIRP_APP_SECRET = "BD11BFa4aEA4956F59491BbA8c0D9F1cC919BD4AAc17C2fbD7";
    String CHIRP_APP_CONFIG = "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";
    String message;


    ChirpSDK chirp;
    Button sender,receiverbutton;
    TextView messagesender,messagereceiver;
    private static final int RESULT_REQUEST_RECORD_AUDIO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chirp = new ChirpSDK(this, CHIRP_APP_KEY, CHIRP_APP_SECRET);
        chirp.setVolume(1.0f);
        ChirpError error = chirp.setConfig(CHIRP_APP_CONFIG);
        if (error.getCode() == 0) {
            Log.v("ChirpSDK: ", "Configured ChirpSDK");
        } else {
            Log.e("ChirpError: ", error.getMessage());
        }
        sender = (Button) findViewById(R.id.button);
        receiverbutton = (Button) findViewById(R.id.receiver);
        messagesender = (TextView) findViewById(R.id.input);
        messagereceiver = (TextView) findViewById(R.id.receivedmessage);
        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String identifier = String.valueOf(messagesender.getText());
                byte[] payload = identifier.getBytes(Charset.forName("UTF-8"));

                ChirpError error = chirp.send(payload);
                if (error.getCode() > 0) {
                    Log.e("ChirpError: ", error.getMessage());
                } else {
                    Log.v("ChirpSDK: ", "Sent " + identifier);
                }
            }
        });
        receiverbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("TEST1");
                ChirpEventListener chirpeventlistener = new ChirpEventListener() {
                    @Override
                    public void onSent(@NotNull byte[] bytes, int i) {
                        System.out.println("TEST2");
                    }

                    @Override
                    public void onSending(@NotNull byte[] bytes, int i) {
                        System.out.println("TEST3");
                    }

                    @Override
                    public void onReceived(@Nullable byte[] data, int i) {
                        System.out.println("TEST4");
                        if (data != null) {
                            message = new String(data);
                            System.out.println(message);
                            Log.v("ChirpSDK: ", "Received " + message);
                        } else {
                            Log.e("ChirpError: ", "Decode failed");
                        }
                    }

                    @Override
                    public void onReceiving(int i) {
                        System.out.println("TEST5");
                    }

                    @Override
                    public void onStateChanged(int i, int i1) {
                        System.out.println("TEST6");
                    }

                    @Override
                    public void onSystemVolumeChanged(float v, float v1) {
                        System.out.println("TEST7");
                    }
                };
                System.out.println("TEST8");
                chirp.setListener(chirpeventlistener);
                messagereceiver.setText(message);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, RESULT_REQUEST_RECORD_AUDIO);
        }
        else {
            // Start ChirpSDK sender and receiver, if no arguments are passed both sender and receiver are started
            ChirpError error = chirp.start(true, true);
            if (error.getCode() > 0) {
                Log.e("ChirpError: ", error.getMessage());
            } else {
                Log.v("ChirpSDK: ", "Started ChirpSDK");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RESULT_REQUEST_RECORD_AUDIO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ChirpError error = chirp.start();
                    if (error.getCode() > 0) {
                        Log.e("ChirpError: ", error.getMessage());
                    } else {
                        Log.v("ChirpSDK: ", "Started ChirpSDK");
                    }
                }
                return;
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //chirp.stop();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        chirp.stop();
        try {
            chirp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
