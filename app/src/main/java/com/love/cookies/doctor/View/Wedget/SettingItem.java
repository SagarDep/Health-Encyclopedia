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
 * Created by xiekun on 2015/12/1 0001.
 *
 * 设置页菜单条目
 */
public class SettingItem extends FrameLayout {

    ImageView settingIcon;
    TextView settingTitle;

    public SettingItem(Context context) {
        super(context);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_setting_item, this);

        settingIcon = (ImageView)findViewById(R.id.setting_icon);
        settingTitle = (TextView)findViewById(R.id.setting_title);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SettingItem);

        Drawable icon = typedArray.getDrawable(R.styleable.SettingItem_Setting_Icon);
        settingIcon.setImageDrawable(icon);
        CharSequence title = typedArray.getText(R.styleable.SettingItem_Setting_Title);
        settingTitle.setText(title);
    }

}
