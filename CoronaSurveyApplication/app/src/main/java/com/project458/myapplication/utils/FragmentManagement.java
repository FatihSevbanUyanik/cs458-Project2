package com.project458.myapplication.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.project458.myapplication.fragments.FragmentAnswers;
import com.project458.myapplication.fragments.FragmentEnter;
import com.project458.myapplication.fragments.FragmentPoll;

public class FragmentManagement {

    public static final String FRAGMENT_POLL = "FragmentPoll";
    public static final String FRAGMENT_ENTER = "FragmentEnter";
    public static final String FRAGMENT_ANSWERS = "FragmentAnswers";

    public static void switchFragment(String fragmentName, int containerId, FragmentManager fragmentManager, boolean addToBackStack) {
        Fragment fragment;

        switch (fragmentName) {
            case FRAGMENT_ENTER:
                fragment = new FragmentEnter();
                break;
            case FRAGMENT_POLL:
                fragment = new FragmentPoll();
                break;
            case FRAGMENT_ANSWERS:
                fragment = new FragmentAnswers();
                break;
            default:
                return;
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        if (addToBackStack) transaction.addToBackStack(fragmentName);
        transaction.commit();
    }

    public static void clearBackStack(FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(0);
            fragmentManager.popBackStack(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

}
