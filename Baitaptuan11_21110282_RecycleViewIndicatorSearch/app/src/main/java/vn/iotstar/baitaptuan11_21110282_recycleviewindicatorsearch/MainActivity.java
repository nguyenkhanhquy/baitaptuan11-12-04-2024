package vn.iotstar.baitaptuan11_21110282_recycleviewindicatorsearch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcIcon;
    ArrayList<IconModel> arrayList1;
    IconAdapter iconAdapter;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcIcon = findViewById(R.id.rcIcon);
        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.java1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.java1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.java1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.java1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.java1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.java1, "dfgfhyh sxdff"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2,
                GridLayoutManager.HORIZONTAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(getApplicationContext(), arrayList1);
        rcIcon.setAdapter(iconAdapter);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(MainActivity.this));

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
            if (list.isEmpty()) {
                Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                iconAdapter.setListenerList(list);
            }
        }
    }

    public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
        private final Paint paint = new Paint();
        private final float indicatorHeight;
        private final float indicatorWidth;
        private final float indicatorPadding;

        public LinePagerIndicatorDecoration(Context context) {
            this.indicatorHeight = dpToPx(context, 4); // Chiều cao của chỉ mục
            this.indicatorWidth = dpToPx(context, 20); // Chiều rộng của chỉ mục
            this.indicatorPadding = dpToPx(context, 8); // Khoảng cách giữa các chỉ mục
            paint.setColor(context.getResources().getColor(android.R.color.black)); // Màu của chỉ mục
            paint.setStrokeWidth(indicatorHeight); // Độ dày của chỉ mục
        }

        @Override
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, parent, state);

            // Vẽ các chỉ mục
            int itemCount = parent.getAdapter().getItemCount();
            int totalWidth = (int) ((indicatorWidth + indicatorPadding) * itemCount - indicatorPadding);
            int startX = (parent.getWidth() - totalWidth) / 2;
            int startY = parent.getHeight() - (int) indicatorHeight;

            for (int i = 0; i < itemCount; i++) {
                int cx = startX + (int) ((indicatorWidth + indicatorPadding) * i);
                int cy = startY;
                canvas.drawLine(cx, cy, cx + indicatorWidth, cy, paint);
            }
        }

        private float dpToPx(Context context, float dp) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        }
    }
}