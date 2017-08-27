package boss_android.transparent_factory.util;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lwkandroid.imagepicker.utils.IImagePickerDisplayer;

/**
 * ImageDisplayer（图片选择器用Glide实现加载到选择器界面）
 *
 * @author YangCihang
 * @since 17/8/19.
 * email yangcihang@hrsoft.net
 */

public class ImageDisplayer implements IImagePickerDisplayer {
    @Override
    public void display(Context context, String url, ImageView imageView, int maxWidth, int maxHeight) {
        Glide.with(context).
                load(url).
                asBitmap().
                override(maxWidth, maxHeight).
                diskCacheStrategy(DiskCacheStrategy.NONE).
                into(imageView);

    }

    @Override
    public void display(Context context, String url, ImageView imageView, int placeHolder, int errorHolder, int maxWidth, int maxHeight) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeHolder)
                .error(errorHolder)
                .override(maxWidth, maxHeight)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
}
