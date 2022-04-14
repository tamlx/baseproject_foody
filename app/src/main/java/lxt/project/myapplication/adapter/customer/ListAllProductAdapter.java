package lxt.project.myapplication.adapter.customer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import lxt.project.myapplication.R;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.model.customer.ProductModel;

public class ListAllProductAdapter extends SuperAdapter<ProductModel> {

    private ListLoadMoreProductAdapterListener listener;

    public interface ListLoadMoreProductAdapterListener {
        void setOnItemClick(ProductModel item);
    }

    public ListAllProductAdapter(Context context, List<ProductModel> items) {
        super(context, items, R.layout.row_item_product_vertical_dashboard);
    }

    public void setListener(ListLoadMoreProductAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, final ProductModel item) {

        ImageView image_product_avatar = holder.findViewById(R.id.image_product_avatar);
        TextView text_product_name = holder.findViewById(R.id.text_product_name);
        RatingBar ratingBarProduct = holder.findViewById(R.id.ratingBarProduct);
        TextView text_product_price = holder.findViewById(R.id.text_product_price);
        View layoutItemProductDetail = holder.findViewById(R.id.layoutItemProductDetail);

        AppProvider.getImageHelper().displayImage(Consts.HOST_API + item.getProduct_image(), image_product_avatar, null, R.drawable.no_image_full);
        text_product_name.setText(item.getName());
        text_product_price.setText(CurrencyFormater.formatCurrency(item.getProduct_price()));

        layoutItemProductDetail.setOnClickListener(v -> {
            if (listener != null)
                listener.setOnItemClick(item);
        });
    }
}