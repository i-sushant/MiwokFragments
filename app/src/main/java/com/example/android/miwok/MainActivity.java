/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout myTab;
    ViewPager myPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        myTab = (TabLayout)findViewById(R.id.myTab);
        myPage = (ViewPager)findViewById(R.id.myPager);
        myPage.setAdapter(new myOwnPagerAdapter(getSupportFragmentManager())); // to set an adapter to pager
        myTab.setupWithViewPager(myPage); // to sync pager and tab
        myTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
class myOwnPagerAdapter extends FragmentPagerAdapter{
    String data[] = {"Numbers","Family","Colors","Phrases"};
    public myOwnPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new NumberFragment();
        } else if (i == 1) {
            return new FamilyFragment();
        } else if (i == 2) {
            return new ColorFragment();
        } else if (i == 3) {
            return new PhrasesFragment();
        } else {
            return null;
        }
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }
}
