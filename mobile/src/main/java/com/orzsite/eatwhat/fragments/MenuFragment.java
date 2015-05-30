package com.orzsite.eatwhat.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.activity.AddFoodActivity;
import com.orzsite.eatwhat.adapter.FoodAdapter;
import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.dao.DbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public class MenuFragment extends BaseFragment implements View.OnClickListener {
    private FoodAdapter adapter;
    private List<Food> foods = new ArrayList<>();

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

        GridView foodGrid = (GridView) view.findViewById(R.id.food_list);
        adapter = new FoodAdapter(getActivity(), R.layout.food_item_view, foods);
        foodGrid.setAdapter(adapter);

        bindData();
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

    private void bindData() {
        DbHelper helper = new DbHelper(getActivity());
        foods.clear();
        List<Food> tmpFoods = helper.queryFoodList();
        foods.addAll(tmpFoods);
        adapter.notifyDataSetChanged();
    }
}
