package com.example.demo.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;

import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import android.widget.LinearLayout.LayoutParams;

import com.example.demo.R;


public class AdFragment extends Fragment {
    private View rootView;
    private static AdFragment adFragment;
    //控件的声明
    private ViewPager viewPager;
    private TextView imageDesc;
    private LinearLayout dotsGroup;

    //数据声明
    final int[] imageIds = {R.drawable.ad, R.drawable.ad,
            R.drawable.ad};
    private int lastPoint;
    private boolean isFirstCreateView = true;
    //图片标题集合
    private final String[] imageDescriptions = {
            "信用卡分期活动",
            "信用卡分期活动",
            "信用卡分期活动",
    };
    List<ImageView> imageList = new ArrayList<ImageView>();
    List<String> descList = new ArrayList<String>();

    public AdFragment() {
    }

    public static AdFragment getNewInstance() {
        if (adFragment == null) {
            adFragment = new AdFragment();
        }
        return adFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_ad, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        initView();
        initData();
        initEvent();
        return rootView;
    }

    private void initView() {
        viewPager = (ViewPager) rootView.findViewById(R.id.id_viewpager);
        imageDesc = (TextView) rootView.findViewById(R.id.id_image_desc);
        dotsGroup = (LinearLayout) rootView.findViewById(R.id.id_dots);
        imageDesc.setText(imageDescriptions[0]);
    }

    private void initData() {
        if (isFirstCreateView) {
            for (int i = 0; i < imageIds.length; i++) {
                //初始化图片资源
                ImageView imageView = new ImageView(getActivity());
                imageView.setBackgroundResource(imageIds[i]);
                imageList.add(imageView);
                //初始化点
                ImageView point = new ImageView(getActivity());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                if (i == 0) {
                    isFirstCreateView = false;
                    point.setEnabled(true);
                    layoutParams.rightMargin = 30;
                    layoutParams.leftMargin = 30;
                    point.setLayoutParams(layoutParams);
                } else {
                    layoutParams.rightMargin = 30;
                    point.setLayoutParams(layoutParams);
                    point.setEnabled(false);
                }
                point.setBackgroundResource(R.drawable.point_bg);
                dotsGroup.addView(point);
            }
        }
    }

    private void initEvent() {
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageList.size()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            /**
             * 页面正在滑动的时候，回调
             */
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            /**
             * 页面切换后调用
             * position  新的页面位置
             */
            public void onPageSelected(int position) {
                position = position % imageList.size();
                imageDesc.setText(imageDescriptions[position]);
                dotsGroup.getChildAt(lastPoint).setEnabled(false);
                dotsGroup.getChildAt(position).setEnabled(true);
                lastPoint = position;
            }

            @Override
            /**
             * 当页面状态发生变化的时候，回调
             */
            public void onPageScrollStateChanged(int state) {

            }
        });
        isRunning = true;
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    /**
     * 判断是否自动滚动
     */
    private boolean isRunning = false;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            //让viewPager 滑动到下一页
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        }
    };


    public void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }

    ;

    @Override
    public void onResume() {
        super.onResume();
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        /**
         * 获得页面的总数
         */
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        /**
         * 获得相应位置上的view
         * container  view的容器，其实就是viewpager自身
         * position     相应的位置
         */
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageList.get(position % imageList.size()));
            return imageList.get(position % imageList.size());
        }

        @Override
        /**
         * 判断 view和object的对应关系
         */
        public boolean isViewFromObject(View view, Object object) {
            if (view == object) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        /**
         * 销毁对应位置上的object
         */
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            object = null;
        }
    }

}
