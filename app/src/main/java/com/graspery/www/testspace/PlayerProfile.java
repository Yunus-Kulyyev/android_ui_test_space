package com.graspery.www.testspace;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerProfile extends AppCompatActivity {

    private Button fantasyButton;
    private Button seasonButton;
    private TextView bleacherTextView;
    private TextView rotoworldTextView;
    private TextView statsCell0;
    private TextView statsCell1;
    private TextView statsCell2;
    private TextView statsCell3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        assignElements();
        assignListeners();
    }

    private void assignElements() {
        fantasyButton = findViewById(R.id.fantasy_category);
        seasonButton = findViewById(R.id.season_category);

        bleacherTextView = findViewById(R.id.bleacherreport_textview);
        rotoworldTextView = findViewById(R.id.rotoworld_textview);
    }

    private void assignListeners() {
        fantasyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipStatsCards(true);

                fantasyButton.setTextColor(Color.WHITE);
                fantasyButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_frame_box));
                seasonButton.setBackgroundColor(Color.TRANSPARENT);
                seasonButton.setTextColor(Color.DKGRAY);
            }
        });
        seasonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipStatsCards(false);

                seasonButton.setTextColor(Color.WHITE);
                seasonButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_frame_box));
                fantasyButton.setBackgroundColor(Color.TRANSPARENT);
                fantasyButton.setTextColor(Color.DKGRAY);
            }
        });

        bleacherTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.bleach_underline).setBackgroundColor(Color.parseColor("#2BE191"));
                findViewById(R.id.rotoworld_underline).setBackgroundColor(Color.TRANSPARENT);
            }
        });

        rotoworldTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.rotoworld_underline).setBackgroundColor(Color.parseColor("#2BE191"));
                findViewById(R.id.bleach_underline).setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }

    private void flipStatsCards(boolean isFantasyCategory) {
        TextView statsTitle0 =  findViewById(R.id.stats_title_0);
        TextView statsTitle1 =  findViewById(R.id.stats_title_1);
        TextView statsTitle2 =  findViewById(R.id.stats_title_2);
        TextView statsTitle3 =  findViewById(R.id.stats_title_3);
        statsCell0 = findViewById(R.id.stats_cell_0);
        statsCell1 = findViewById(R.id.stats_cell_1);
        statsCell2 = findViewById(R.id.stats_cell_2);
        statsCell3 = findViewById(R.id.stats_cell_3);

        if(isFantasyCategory) {
            statsTitle0.setText("WKLY AVG");
            statsTitle1.setText("RANKS");
            statsTitle2.setText("TTL FPS");
            statsTitle3.setText("PRJ FPS");

            counterAnimation(statsCell0, Integer.parseInt(statsCell0.getText().toString()), 23);
            counterAnimation(statsCell1, Integer.parseInt(statsCell0.getText().toString()), 21);
            counterAnimation(statsCell2, Integer.parseInt(statsCell0.getText().toString()), 209);
            counterAnimation(statsCell3, Integer.parseInt(statsCell0.getText().toString()), 9);
        } else {
            statsTitle0.setText("TDS");
            statsTitle1.setText("PASS YDS");
            statsTitle2.setText("INTS");
            statsTitle3.setText("QBR");

            counterAnimation(statsCell0, Integer.parseInt(statsCell0.getText().toString()), 17);
            counterAnimation(statsCell1, Integer.parseInt(statsCell0.getText().toString()), 2140);
            counterAnimation(statsCell2, Integer.parseInt(statsCell0.getText().toString()), 4);
            counterAnimation(statsCell3, Integer.parseInt(statsCell0.getText().toString()), 110);
        }
    }

    private void counterAnimation(final TextView counterTextView, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.setDuration(350);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                counterTextView.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }
}
