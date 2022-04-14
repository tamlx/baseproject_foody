package lxt.project.myapplication.adapter.customer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import lxt.project.myapplication.R;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.model.customer.CategoryProductModel;

public class ListCategoryProductAdapter extends SuperAdapter<CategoryProductModel> {

    private ListCategoryProductAdapterListener listener;

    public interface ListCategoryProductAdapterListener {
        void onItemCategoryProductClick(CategoryProductModel item);
    }

    public ListCategoryProductAdapter(Context context, List<CategoryProductModel> items) {
        super(context, items, R.layout.row_item_category);
    }

    public void setListener(ListCategoryProductAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, final CategoryProductModel item) {

        View rowItemCategory = holder.findViewById(R.id.rowItemCategory);
        View layoutBgCateogry1 = holder.findViewById(R.id.layoutBgCateogry1);
        View layoutBgCateogry2 = holder.findViewById(R.id.layoutBgCateogry2);
        ImageView imgCategoryBG1 = holder.findViewById(R.id.imgCategoryBG1);
        TextView tvName1 = holder.findViewById(R.id.tvName1);
        TextView  tvQuantity1 = holder.findViewById(R.id.tvQuantity1);
        ImageView imgCategoryBG2 = holder.findViewById(R.id.imgCategoryBG2);
        TextView tvName2 = holder.findViewById(R.id.tvName2);
        TextView  tvQuantity2 = holder.findViewById(R.id.tvQuantity2);

        if (layoutPosition % 2 == 0) {
            layoutBgCateogry1.setVisibility(View.VISIBLE);
            layoutBgCateogry2.setVisibility(View.GONE);
            tvName1.setText(item.getCategory_name());
            tvQuantity1.setText(item.getTotal_product()+" sản phẩm");
            AppProvider.getImageHelper().displayImage(Consts.HOST_API+item.getCategory_image(),imgCategoryBG1,null,R.drawable.no_image_full);
        } else {
            layoutBgCateogry1.setVisibility(View.GONE);
            layoutBgCateogry2.setVisibility(View.VISIBLE);
            tvName2.setText(item.getCategory_name());
            tvQuantity2.setText(item.getTotal_product()+" sản phẩm");
            AppProvider.getImageHelper().displayImage(Consts.HOST_API+item.getCategory_image(),imgCategoryBG2,null,R.drawable.no_image_full);
        }

        layoutBgCateogry1.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemCategoryProductClick(item);
            }
        });

        layoutBgCateogry2.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemCategoryProductClick(item);
            }
        });

    }
}

