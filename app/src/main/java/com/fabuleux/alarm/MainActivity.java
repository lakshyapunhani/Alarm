package com.fabuleux.alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_sheet)
    LinearLayout bottom_sheet;

    @BindView(R.id.new_alarm_bottom_sheet)
    LinearLayout new_alarm_bottom_sheet;

    @BindView(R.id.recycler_view_alarm)
    RecyclerView recycler_view_alarm;

    BottomSheetBehavior sheetBehaviorAlarmList;
    BottomSheetBehavior sheetBehaviorNewAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sheetBehaviorAlarmList = BottomSheetBehavior.from(bottom_sheet);
        sheetBehaviorAlarmList.setState(BottomSheetBehavior.STATE_HIDDEN);
        sheetBehaviorNewAlarm = BottomSheetBehavior.from(new_alarm_bottom_sheet);
        sheetBehaviorNewAlarm.setState(BottomSheetBehavior.STATE_HIDDEN);

        int peekHeight = Resources.getSystem().getDisplayMetrics().heightPixels - (Resources.getSystem().getDisplayMetrics().heightPixels/8);
        int peekHeight1 = Resources.getSystem().getDisplayMetrics().heightPixels/2;
        sheetBehaviorAlarmList.setPeekHeight(peekHeight1);
        sheetBehaviorNewAlarm.setPeekHeight(peekHeight);
        //bottom_sheet.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @OnClick(R.id.floatingActionButton)
    public void openNewAlarmBottomSheet()
    {
        sheetBehaviorNewAlarm.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

}
