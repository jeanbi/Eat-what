package com.orzsite.eatwhat.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.adapter.ShopAdapter;
import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.bean.Shop;
import com.orzsite.eatwhat.dao.DbHelper;
import com.orzsite.eatwhat.dialog.CreateShopDialogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public class AddFoodFragment extends BaseFragment {

    private static final int CREATE_NEW_SHOP = -1;
    private EditText nameEt;
    private EditText priceEt;
    private Spinner shopSelector;
    private List<Shop> shops = new ArrayList<>();
    private ShopAdapter adapter;
    private Food food = new Food();
    private Button saveButton;

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_add_food, container, false);
    }

    @Override
    protected void fillViews(View view) {

        nameEt = (EditText) view.findViewById(R.id.et_food_name);
        priceEt = (EditText) view.findViewById(R.id.et_food_price);
        shopSelector = (Spinner) view.findViewById(R.id.shop_spinner);
        adapter = new ShopAdapter(getActivity(), R.layout.shop_item_view, shops);
        shopSelector.setAdapter(adapter);

        bindShopData();

        shopSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Shop selectedShop = shops.get(position);
                if (selectedShop.getId() == CREATE_NEW_SHOP) {
                    CreateShopDialogFragment dialog = new CreateShopDialogFragment();
                    dialog.setOnPositiveButtonClickListener(new CreateShopDialogFragment.OnPositiveButtonClickListener() {
                        @Override
                        public void onDaoSuccess(Shop newShop) {
                            food.setShop(newShop);
                            shops.add(0, newShop);
                            adapter.notifyDataSetChanged();
                        }
                    });
                    dialog.show(getFragmentManager(), getString(R.string.create_new_shop));
                } else {
                    food.setShop(selectedShop);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveButton = (Button) view.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveButton.setEnabled(false);
                saveButtonClicked();

            }
        });

    }

    private void saveButtonClicked() {
        DbHelper helper = new DbHelper(getActivity());
        String foodName = nameEt.getText().toString();
        float foodPrice = Float.parseFloat(priceEt.getText().toString());
        food.setName(foodName);
        food.setPrice(foodPrice);

        Food newFood = helper.saveFood(food);
        if (newFood != null) {
            Toast.makeText(getActivity(), R.string.create_food_success, Toast.LENGTH_SHORT).show();
            nameEt.setText("");
            priceEt.setText("");
        } else {
            Toast.makeText(getActivity(), R.string.create_food_fail, Toast.LENGTH_SHORT).show();
        }
        saveButton.setEnabled(true);
    }

    private void bindShopData() {
        DbHelper helper = new DbHelper(getActivity());
        shops.clear();
        List<Shop> tmpShops = helper.queryShopList();
        shops.addAll(tmpShops);

        Shop createNewShop = new Shop();
        createNewShop.setId(CREATE_NEW_SHOP);
        createNewShop.setName(getActivity().getString(R.string.create_new_shop));
        shops.add(createNewShop);

        adapter.notifyDataSetChanged();
    }
}
