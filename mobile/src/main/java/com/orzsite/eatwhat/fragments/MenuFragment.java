package com.orzsite.eatwhat.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.activity.AddFoodActivity;

/**
 * Created by Jimmy on 15/5/29.
 */
public class MenuFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    protected void fillViews(View view) {

        Button addButton = (Button) view.findViewById(R.id.add_food);
        Button deleteButton = (Button) view.findViewById(R.id.delete_food);
        addButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        Intent intent = null;
        if (id == R.id.add_food) {
            intent = new Intent(getActivity(), AddFoodActivity.class);
        } else if (id == R.id.delete_food) {
            //TODO DeleteActivity implement.
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
