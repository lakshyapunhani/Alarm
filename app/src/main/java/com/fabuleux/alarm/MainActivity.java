package com.fabuleux.alarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

    @BindView(R.id.timePicker)
    TimePicker timePicker;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;

    BottomSheetBehavior sheetBehaviorAlarmList;
    BottomSheetBehavior sheetBehaviorNewAlarm;

    AlarmAdapter alarmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sheetBehaviorAlarmList = BottomSheetBehavior.from(bottom_sheet);
        sheetBehaviorAlarmList.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehaviorNewAlarm = BottomSheetBehavior.from(new_alarm_bottom_sheet);
        sheetBehaviorNewAlarm.setState(BottomSheetBehavior.STATE_HIDDEN);

        int peekHeight = Resources.getSystem().getDisplayMetrics().heightPixels - (Resources.getSystem().getDisplayMetrics().heightPixels/8);
        int peekHeight1 = Resources.getSystem().getDisplayMetrics().heightPixels/2;
        sheetBehaviorAlarmList.setPeekHeight(peekHeight1);
        sheetBehaviorNewAlarm.setPeekHeight(peekHeight);

        timePicker.setIs24HourView(true);
        alarmAdapter = new AlarmAdapter();
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycler_view_alarm.setLayoutManager(mLayoutManager);
        recycler_view_alarm.setItemAnimator(new DefaultItemAnimator());
        recycler_view_alarm.setNestedScrollingEnabled(false);
        recycler_view_alarm.setAdapter(alarmAdapter);

        sheetBehaviorNewAlarm.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int state) {
                switch (state){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        floatingActionButton.show();
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        //bottom_sheet.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @OnClick(R.id.floatingActionButton)
    public void openNewAlarmBottomSheet()
    {

        floatingActionButton.hide();
        sheetBehaviorNewAlarm.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

}
