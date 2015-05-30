package com.orzsite.eatwhat.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orzsite.eatwhat.dao.DbHelper;
import com.orzsite.eatwhat.dialog.ConfirmDialogFragment;
import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.bean.Food;

import java.util.List;

/**
 * Created by Jimmy on 15/5/29.
 */
public class ShakeFragment extends BaseFragment {

    private static final int MSG_WHAT_SHOOK = 0;
    private final static float MAX_SHAKE_VALUE = 19;
    private final static long DELAY_VIBRATOR = 20;

    private TextView foodNameView;
    private SensorManager sensorManager;
    private Vibrator vibrator;

    private boolean isShook = false;

    private Button changeBtn;
    private Button chooseBtn;
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.choose_it) {
                foodNameView.setText(R.string.chosen);
                resetButtons(View.GONE);
                isShook = false;
            } else if (id == R.id.change_it) {
                showConfirmDialog();
            } else {

            }

        }
    };

    private Food food = null;

    private Handler sensorHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            isShook = true;

            if (msg.what == MSG_WHAT_SHOOK) {
                foodNameView.setText(getString(R.string.generic_food_done, food.getName(), food.getPrice()));

                resetButtons(View.VISIBLE);
            }
        }
    };

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            if (x > MAX_SHAKE_VALUE || y > MAX_SHAKE_VALUE || z > MAX_SHAKE_VALUE) {
                if (isShook) {
                    return;
                }

                vibrator.vibrate(DELAY_VIBRATOR);
                randomFood();

                Message msg = new Message();
                msg.what = MSG_WHAT_SHOOK;
                sensorHandler.sendMessage(msg);
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private void showConfirmDialog() {
        ConfirmDialogFragment dialog = new ConfirmDialogFragment();
        dialog.setOnDialogCloseListener(new ConfirmDialogFragment.OnDialogCloseListener() {
            @Override
            public void onClose() {
                foodNameView.setText(R.string.what_to_eat_hint);
                resetButtons(View.GONE);
                isShook = false;
            }
        });
        dialog.show(getFragmentManager(), getString(R.string.changed));
    }

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.activity_shake_food, container, false);
    }

    @Override
    protected void fillViews(View view) {

        foodNameView = (TextView) view.findViewById(R.id.food_name);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        changeBtn = (Button) view.findViewById(R.id.change_it);
        chooseBtn = (Button) view.findViewById(R.id.choose_it);

        changeBtn.setOnClickListener(buttonClickListener);
        chooseBtn.setOnClickListener(buttonClickListener);

    }

    private void resetButtons(int visible) {
        changeBtn.setVisibility(visible);
        chooseBtn.setVisibility(visible);
    }

    @Override
    public void onResume() {
        super.onResume();

        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (sensorManager != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    private void randomFood() {

        DbHelper helper = new DbHelper(getActivity());
        List<Food> tmpFoods = helper.queryFoodList();
        int rangeMin = 0;
        int rangeMax = tmpFoods.size() - 1;
        int rangeIndex = (int)Math.round(Math.random() * (rangeMax - rangeMin) + rangeMin);

        food = tmpFoods.get(rangeIndex);
    }
}
