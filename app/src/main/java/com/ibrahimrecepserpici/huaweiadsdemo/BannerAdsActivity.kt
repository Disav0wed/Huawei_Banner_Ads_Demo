package com.ibrahimrecepserpici.huaweiadsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize
import com.huawei.hms.ads.HwAds
import com.huawei.hms.ads.banner.BannerView
import kotlinx.android.synthetic.main.activity_bannerads.*

class BannerAdsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bannerads)

        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this);


        // Obtain BannerView based on the configuration in XML layout.
        val adParam = AdParam.Builder().build();
        //Loading add inside the bannerview which we defined at the XML file
        hwBannerView.loadAd(adParam);

        //Creating a banner ad programmaticaly without touching XML
        val bannerView =  BannerView(this);
        // "testw6vs28auh3" is a dedicated test ad slot ID. To get real one, you need to have an enterprise level Huawei developer account.
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_320_50);
        val parentLayout = findViewById<ConstraintLayout>(R.id.clBannerMain);
        val set =  ConstraintSet();
        // set view id, else getId() returns -1
        bannerView.id = View.generateViewId()
        parentLayout.addView(bannerView,0)
        set.clone(parentLayout)
        set.connect(bannerView.id, ConstraintSet.BOTTOM, parentLayout.id, ConstraintSet.BOTTOM, 0);
        set.applyTo(parentLayout);
        bannerView.loadAd(adParam)

        val adListener = object : AdListener() {
            override fun onAdImpression() {
                super.onAdImpression()
            }
            override fun onAdFailed(p0: Int) {
                super.onAdFailed(p0)
            }
            override fun onAdLeave() {
                super.onAdLeave()
            }
            override fun onAdClicked() {
                super.onAdClicked()
            }
            override fun onAdClosed() {
                super.onAdClosed()
            }
            override fun onAdOpened() {
                super.onAdOpened()
            }
            override fun onAdLoaded() {
                super.onAdLoaded()
            }
        }


        bannerView.adListener = adListener


    }
}
