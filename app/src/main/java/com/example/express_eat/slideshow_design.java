package com.example.express_eat;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class slideshow_design extends PagerAdapter {

    String string1 = "Discover the best foods from \n different restaurants.";
    String string2 = "Fast delivery to your home, office\n" + "and whenever you are.";
    String string3 = "Tracking of your food on the\n" + "app after ordered.";

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.food_pic,R.drawable.delivery_image,R.drawable.location_image};
    private String[]  header = {"Craving for food?" , "Fast Delivery" , "Tracking"};
    private String [] texts ={string1, string2, string3 };


    public slideshow_design(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slideshow_design,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.menu_icon);
        TextView textView = (TextView) view.findViewById(R.id.hello_world2);
        TextView textView2 = (TextView) view.findViewById(R.id.hello_world);
        imageView.setImageResource(images[position]);
        textView.setText(texts[position]);
        textView2.setText(header[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}