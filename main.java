package com.example.readinglamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar brightnessSeekBar;
    private WindowManager.LayoutParams layoutParams;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);
        layoutParams = getWindow().getAttributes();

        // Get WakeLock to prevent screen from turning off
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "ReadingLamp:WakeLock");

        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float brightness = progress / 100f;
                layoutParams.screenBrightness = brightness;
                getWindow().setAttributes(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Acquire WakeLock when the user starts interacting
                wakeLock.acquire();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Release WakeLock when the user stops interacting
                if (wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        });
    }
}
