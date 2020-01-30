package com.qrbarcodescanner;

import android.app.Application;
import android.content.Context;



public class QrBarcodeScannerApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());



        // UNIVERSAL IMAGE LOADER SETUP
 /*       try {

            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.rapidboxwms",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
               // Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            //

        } catch (NoSuchAlgorithmException e) {
////
        }catch (RuntimeException e)
        {
            //
        }*/
       /* DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCacheExtraOptions(480, 800)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(60 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);*/
    }

    @Override
    public void onTerminate() {
     /*   AnalyticsEventHandler handler = AnalyticsEventHandler.getInstance(this, false);
        if (handler != null) {
            handler.onTerminate();
        }*/
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }


}
