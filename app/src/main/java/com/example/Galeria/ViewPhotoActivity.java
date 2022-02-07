package com.example.Galeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;

public class ViewPhotoActivity extends AppCompatActivity {
    private int current_image_index;
    private ImageView iv_display;
    private ConstraintLayout layout;
    private int imageID;

    int[] programImages={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,
            R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,
            R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        imageID = b.getInt("id");
        setContentView(R.layout.activity_view_photo);
        displayImage(imageID);
        onSwipe();
    }

    public void displayImage(int image){
        iv_display = (ImageView)findViewById(R.id.iv_display);
        iv_display.setImageResource(image);
    }

    public void onSwipe(){
        layout = findViewById(R.id.layout);
        layout.setOnTouchListener(new OnSwipeTouchListener(ViewPhotoActivity.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                current_image_index++;
                current_image_index = current_image_index % programImages.length;
                iv_display.setImageResource(programImages[current_image_index]);
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                current_image_index--;
                if(current_image_index < 0){
                    current_image_index = programImages.length - 1;
                }
                iv_display.setImageResource(programImages[current_image_index]);
            }
        });
    }
}