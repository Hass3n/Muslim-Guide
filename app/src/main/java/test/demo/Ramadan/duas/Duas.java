package test.demo.Ramadan.duas;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import test.demo.Ramadan.R;
import test.demo.Ramadan.universal.Utils;

/**
 * Created by Shahzad on 03-July-15.
 */
public class Duas extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    Context context;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duas);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.customactionbar);
        getSupportActionBar().setTitle("الدعاء");
        context = this;

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_ramadan_dua);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(Utils.Interstitial);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice(Utils.Banner)
                .build();
        mAdView.loadAd(adRequest2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private int[] mImages = new int[]{


                R.drawable.dua2,
                R.drawable.dualaylatulqadrthumb,
                R.drawable.dua4,
                R.drawable.dua5,
                R.drawable.dua3,
                R.drawable.daua4,
                R.drawable.duaallahslovethumb,
                R.drawable.duachildren,
                R.drawable.duahealsickthumb,
                R.drawable.duagooddeedsthumb,


        };

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            Context context = Fragment6NamesOfAllah.this;
            ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(
                    R.dimen.padding_small);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(mImages[position]);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}
