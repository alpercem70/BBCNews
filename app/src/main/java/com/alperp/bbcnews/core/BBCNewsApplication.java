package com.alperp.bbcnews.core;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

public class BBCNewsApplication extends Application {

    private static final int IMAGE_CACHE_SIZE_IN_MB = 20;
    private static final String IMAGE_CACHE_DIR_NAME = "bbcnews_cache";

    @Override
    public void onCreate() {
        super.onCreate();

        initFresco();
    }

    private void initFresco() {
        final DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setMaxCacheSize(IMAGE_CACHE_SIZE_IN_MB * ByteConstants.MB)
                .setBaseDirectoryPathSupplier(new Supplier<File>() {
                    @Override
                    public File get() {
                        return getApplicationContext().getCacheDir();
                    }
                })
                .setBaseDirectoryName(IMAGE_CACHE_DIR_NAME)
                .build();

        final ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this, config);
    }
}
