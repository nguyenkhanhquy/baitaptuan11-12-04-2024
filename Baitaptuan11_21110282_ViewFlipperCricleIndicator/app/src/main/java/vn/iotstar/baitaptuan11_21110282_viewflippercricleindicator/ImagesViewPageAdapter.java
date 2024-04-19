package vn.iotstar.baitaptuan11_21110282_viewflippercricleindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import vn.iotstar.baitaptuan11_21110282_viewflippercricleindicator.Images;
import vn.iotstar.baitaptuan11_21110282_viewflippercricleindicator.R;

import java.util.List;

public class ImagesViewPageAdapter extends PagerAdapter {
    private List<Images> imagesList;
    private Context context;

    public ImagesViewPageAdapter(List<Images> imagesList, Context context) {
        this.imagesList = imagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_images, container, false);
        ImageView imageView = view.findViewById(R.id.imgView);
        Images images = imagesList.get(position);
        imageView.setImageResource(images.getImagesId());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return imagesList != null ? imagesList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
