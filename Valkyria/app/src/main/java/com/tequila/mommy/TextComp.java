package com.tequila.mommy;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class TextComp {

    private Context context;
    private LinearLayout layout;
    Typeface gothic;

    public TextComp(Context context, LinearLayout layout) {
        this.context =  context;
        this.layout = layout;
        gothic = Typeface.createFromAsset(context.getAssets(), Constants.FUTURA);
    }

    public TextView getTitle(String content) {


        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView txtBlank = new TextView(context);
        txtBlank.setLayoutParams(params);
        txtBlank.setTextSize(18);
        txtBlank.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtBlank.setText(content);
        txtBlank.setTypeface(gothic);
        txtBlank.setTextColor(context.getResources().getColor(android.R.color.black));
        txtBlank.setLayoutParams(params);
        return txtBlank;
    }

    public TextView getCont(String content) {


        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        TextView txtBlank = new TextView(context);
        txtBlank.setLayoutParams(params);



        txtBlank.setText(content);
        txtBlank.setTypeface(gothic);
        txtBlank.setTextSize(16);
        txtBlank.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
        txtBlank.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtBlank.setLayoutParams(params);
        return txtBlank;
    }



}
