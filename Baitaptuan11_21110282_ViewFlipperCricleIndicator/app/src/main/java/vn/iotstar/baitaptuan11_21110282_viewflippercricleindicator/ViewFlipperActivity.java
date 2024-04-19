package vn.iotstar.baitaptuan11_21110282_viewflippercricleindicator;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper viewFlipperMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        actionViewFlipperMain();
    }

    private void actionViewFlipperMain() {
        List<String> arrayListFlipper = new ArrayList<>();
        arrayListFlipper.add("https://images.wondershare.com/virtulook/articles/random-background-generator-2.jpg");
        arrayListFlipper.add("https://as1.ftcdn.net/v2/jpg/01/22/33/26/1000_F_122332604_2GoEwq1Wlue7AscVlfsEhKK87NxQ5BZx.jpg");
        arrayListFlipper.add("https://i.pinimg.com/originals/86/8b/48/868b48f0ec5b3d88216f4a484b880f59.jpg");
        arrayListFlipper.add("https://img.pikbest.com/ai/illus_our/20230526/2b649155813d57c0af6e457060509b7a.jpg!w700wp");

        for (int i = 0; i < arrayListFlipper.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(arrayListFlipper.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imageView);
        }
        viewFlipperMain.setFlipInterval(3000);
        viewFlipperMain.setAutoStart(true);

        //thiết lập animation cho flipper
        Animation slide_in = AnimationUtils.loadAnimation (getApplicationContext(), R. anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation (getApplicationContext(), R. anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation (slide_out);
    }
}
