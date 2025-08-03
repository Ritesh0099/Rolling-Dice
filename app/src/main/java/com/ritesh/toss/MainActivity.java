package com.ritesh.toss;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView diceImage;
    private Button rollButton;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.dice_image);
        rollButton = findViewById(R.id.roll_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDiceWithAnimation();
            }
        });
    }

    private void rollDiceWithAnimation() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.scale);
        diceImage.startAnimation(rotate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int roll = random.nextInt(6) + 1;
                int drawableResource;

                switch (roll) {
                    case 1: drawableResource = R.drawable.dice_1; break;
                    case 2: drawableResource = R.drawable.dice_2; break;
                    case 3: drawableResource = R.drawable.dice_3; break;
                    case 4: drawableResource = R.drawable.dice_4; break;
                    case 5: drawableResource = R.drawable.dice_5; break;
                    default: drawableResource = R.drawable.dice_6; break;
                }

                diceImage.setImageResource(drawableResource);
            }
        }, 300); // Same as animation duration
    }
}
