package com.example.project02_cloneapp.etcviewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_cloneapp.R;


public class EtcFragment extends Fragment {
    int i = 0 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_etc, container, false);
        ViewPager2 pager2_1 = v.findViewById(R.id.pager2_1);
        ViewPager2 pager2_2 = v.findViewById(R.id.pager2_2);
        EtcAdapter adapter = new EtcAdapter(inflater);
        pager2_1.setAdapter(adapter);
        pager2_2.setAdapter(adapter);
        //pager에 어떤 효과주기 예제
        pager2_1.setPageTransformer(new ZoomOutPageTransformer());

         new Thread(new Runnable() {
            @Override
            public void run() {
            for(int i = 0 ; i < 10 ; i++){
                pager2_1.setCurrentItem(i , true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i == 9){ // 9
                    for(int j = i ; j>=0 ; j--){
                        pager2_1.setCurrentItem(j , true);
                        try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                    i = 0 ;

                }
            }


            }
        }).start();
        return v ;
    }

    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

}