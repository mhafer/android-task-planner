package com.example.missm.taskplannerapp.utilities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.missm.taskplannerapp.MainActivity;
import com.example.missm.taskplannerapp.R;

/**
 * Created by missm on 2017-10-07.
 */

public class InterfaceUtils {

    /**
     * Depending on the build this class will set the tool bar color accordingly
     * TODO: Add Theme preference which will set the status bar depending on theme selected
     * lollipop - set status bar color
     * kitkat - make status bar translucent
     */

    public static void setTranslucentStatusBar(Window window) {
        if (window == null) return;
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= Build.VERSION_CODES.LOLLIPOP) {
            setTranslucentStatusBarLollipop(window);
        } else if (sdkInt >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatusBarKiKat(window);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static void setTranslucentStatusBarLollipop(Window window) {

        Resources.Theme theme = window.getContext().getTheme();
        TypedArray ta = theme.obtainStyledAttributes(new int[] {R.attr.colorPrimaryDark});
        int attributeResourceId = ta.getResourceId(0, 0);
        ta.recycle();
                window.setStatusBarColor(
                window.getContext()
                        .getResources()
                        .getColor(attributeResourceId)); // TODO: getColor(int) is depreciated, possibly think of a better solution

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static void setTranslucentStatusBarKiKat(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

}
