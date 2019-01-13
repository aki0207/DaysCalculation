package com.example.dayscalculation;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);

        //現在の日付
        Calendar current_day = Calendar.getInstance();
        //現在の日付から1ヵ月後
        Calendar target_day = Calendar.getInstance();
        target_day.add(Calendar.MONTH, + 1);

        int result = getDiffDays(target_day,current_day);
        TextView textView = new TextView(this);
        textView.setText(String.valueOf(result));
        linearLayout.addView(textView);

    }

    public int getDiffDays(Calendar calendar1, Calendar calendar2) {
        //==== ミリ秒単位での差分算出 ====//
        long diffTime = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();

        //==== 日単位に変換 ====//
        int MILLIS_OF_DAY = 1000 * 60 * 60 * 24;
        int diffDays = (int)(diffTime / MILLIS_OF_DAY);

        return diffDays;
    }

}
