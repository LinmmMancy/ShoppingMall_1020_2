package com.mancy.shoppingmall_1020_2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.mancy.shoppingmall_1020_2.CommunityFragment.fragment.CommunityFragment;
import com.mancy.shoppingmall_1020_2.home.fragment.HomeFragment;
import com.mancy.shoppingmall_1020_2.shoppingcart.ShoppingCartFragment;
import com.mancy.shoppingmall_1020_2.type.TypeFragment;
import com.mancy.shoppingmall_1020_2.user.UserFragemnt;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;


    //  集合
    private ArrayList<Fragment> fragments;

    //根据相应的fragment 来切换
    private int position;


    //  缓存的fragment
    private Fragment tempfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        // 初始化  fragment

        initFragment();


        // 根据点击事件

        initListener();

    }

    private void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.rb_home:

                        position = 0;

                        break;
                    case R.id.rb_type:
                        position = 1;

                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;

                        break;
                    case R.id.rb_user:
                        position = 4;

                        break;
                }

                // 根据不同的fragment 切换到相应的页面

                Fragment currentfragment = fragments.get(position);

                switchFragment(currentfragment);


            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(Fragment currentfragment) {

        //   切换的不同的页面
        if (tempfragment != currentfragment) {

            // 得到 fragmentmanner

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // 如果没有添加
            if (!currentfragment.isAdded()) {

                // 缓存的隐藏

                if (tempfragment != null) {
                    ft.hide(tempfragment);
                }

                // 添加

                ft.add(R.id.fl_main, currentfragment);
            } else {
                // 缓存的隐藏

                if (tempfragment != null) {


                    ft.hide(tempfragment);

                }

                // 显示

                ft.show(currentfragment);
            }

            // 事务的提交

            ft.commit();

            //  把当前的赋值设置成缓存

            tempfragment = currentfragment;


        }
    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragemnt());

    }


}
