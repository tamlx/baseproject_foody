package ntkn.project.myapplication.adapter.customer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import ntkn.project.myapplication.R;
import ntkn.project.myapplication.dependency.AppProvider;
import ntkn.project.myapplication.helper.Consts;
import ntkn.project.myapplication.model.customer.ProductModel;

public class ListProductHorizontalAdapter extends SuperAdapter<ProductModel> {

    private ListProductHorizontalAdapterListener listener;

    public interface ListProductHorizontalAdapterListener {
        void setOnItemClick(ProductModel item);
    }

    public ListProductHorizontalAdapter(Context context, List<ProductModel> items) {
        super(context, items, R.layout.row_item_product_horizontal_dashboard);
    }

    public void setListener(ListProductHorizontalAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, final ProductModel itemProduct) {

        ImageView image_product_avatar = holder.findViewById(R.id.image_product_avatar);
        TextView text_product_name = holder.findViewById(R.id.text_product_name);
        TextView text_product_price_discount = holder.findViewById(R.id.text_product_price_discount);
        TextView tvSaleOff = holder.findViewById(R.id.tvSaleOff);
        TextView text_product_price = holder.findViewById(R.id.text_product_price);
        RatingBar ratingBarProduct = holder.findViewById(R.id.ratingBarProduct);
        ImageView btnProductFavorite = holder.findViewById(R.id.btnProductFavorite);
        LinearLayout layoutSaleOff = holder.findViewById(R.id.layoutSaleOff);
        RoundRelativeLayout btnAddItemToCart = holder.findViewById(R.id.btnAddItemToCart);
        LinearLayout rowItemStore = holder.findViewById(R.id.rowItemStore);

        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        try {
            AppProvider.getImageHelper().displayImage(Consts.HOST_API + itemProduct.getProduct_image(), image_product_avatar, null, R.drawable.no_image_full);
            text_product_name.setText(itemProduct.getName());

            layoutSaleOff.setVisibility(View.GONE);
//            if (Long.valueOf(detailModels.get(0).getProduct_detail_price_sell_discount()) > 0) {
//                text_product_price_discount.setText(decimalFormat.format(Long.valueOf(detailModels.get(0).getProduct_detail_price_sell_discount())) + " đ");
//
//                String product_detail_price_sell = "<strike>" + decimalFormat.format(Long.valueOf(detailModels.get(0).getProduct_detail_price_sell())) + "</strike>";
//                if ((detailModels.get(0).getProduct_detail_price_sell()).equals(detailModels.get(0).getProduct_detail_price_sell_discount())) {
//                    text_product_price.setVisibility(View.GONE);
//                } else {
//                    text_product_price.setText(android.text.Html.fromHtml(product_detail_price_sell + " đ"));
//                }
//            } else {
//                text_product_price_discount.setText("Hết hàng");
//            }
            rowItemStore.setOnClickListener(v -> {
                if (listener != null)
                    listener.setOnItemClick(itemProduct);
            });
            btnAddItemToCart.setOnClickListener(v -> {
                if (listener != null)
                    listener.setOnItemClick(itemProduct);
            });
        } catch (Exception e) {
            Log.e("AAAA", e.getMessage());
        }
    }
}

