package com.love.cookies.doctor.View.Wedget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.love.cookies.doctor.R;

/**
 * Created by xiekun on 2015/11/24 0024.
 *
 * 主页菜单条目
 */
public class MianMenuItem extends FrameLayout {

    ImageView menuIcon;
    TextView menuTitle;
    TextView menuIntro;

    public MianMenuItem(Context context) {
        super(context);
    }

    public MianMenuItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public MianMenuItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public MianMenuItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_main_menu_item, this);

        menuIcon = (ImageView)findViewById(R.id.menu_icon);
        menuTitle = (TextView)findViewById(R.id.menu_title);
        menuIntro = (TextView)findViewById(R.id.menu_intro);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.MianMenuItem);

        Drawable icon = typedArray.getDrawable(R.styleable.MianMenuItem_MianMenu_Icon);
        menuIcon.setImageDrawable(icon);
        CharSequence title = typedArray.getText(R.styleable.MianMenuItem_MianMenu_Title);
        menuTitle.setText(title);
        CharSequence intro = typedArray.getText(R.styleable.MianMenuItem_MianMenu_Intro);
        menuIntro.setText(intro);
    }

}
