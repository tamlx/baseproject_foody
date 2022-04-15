package ntkn.project.myapplication.adapter.customer;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import ntkn.project.myapplication.R;
import ntkn.project.myapplication.dependency.AppProvider;
import ntkn.project.myapplication.model.customer.OrderDetailModel;

public class ListItemCartAdapter extends SuperAdapter<OrderDetailModel> {

    public ListItemCartAdapter(Context context, List<OrderDetailModel> items) {
        super(context, items, R.layout.row_custom_item_cart);
    }

    private ListItemCartAdapterListener listener;

    public interface ListItemCartAdapterListener {
        void onClickItem(OrderDetailModel model);

        void onClickThemSoLuong(OrderDetailModel model);

        void onClickGiamSoLuong(OrderDetailModel model);

        void onClickXoaItem(OrderDetailModel model);
    }

    public void setListener(ListItemCartAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, OrderDetailModel item) {
        ImageView imgProduct = holder.findViewById(R.id.imgProduct);
        ImageView image_minus = holder.findViewById(R.id.image_minus);
        ImageView image_plus = holder.findViewById(R.id.image_plus);
        TextView nameProduct = holder.findViewById(R.id.nameProduct);
        TextView quantity_product = holder.findViewById(R.id.quantity_product);
        TextView priceProduct = holder.findViewById(R.id.priceProduct);
        LinearLayout layoutItemCart = holder.findViewById(R.id.layoutItemCart);

        try {
            AppProvider.getImageHelper().displayImage(item.getImage(), imgProduct, null, R.drawable.no_image_full);
            nameProduct.setText(item.getName());
            quantity_product.setText(item.getQuantity());
            priceProduct.setText(CurrencyFormater.formatCurrency(item.getPrice_sell()));

            layoutItemCart.setOnClickListener(v -> {
                if (listener != null)
                    listener.onClickItem(item);
            });
            //tru
            image_minus.setOnClickListener(v -> {
                int new_quantity = Integer.valueOf(item.getQuantity()) - 1;
                if (new_quantity <= 1) {
                    new_quantity = 1;
                    quantity_product.setText(String.valueOf(1));
                } else {
                    quantity_product.setText(String.valueOf(new_quantity));
                }
                listener.onClickGiamSoLuong(item);
            });
            //cong
            image_plus.setOnClickListener(v -> {
                int new_quantity = Integer.valueOf(item.getQuantity()) + 1;
                quantity_product.setText(String.valueOf(new_quantity));
                listener.onClickThemSoLuong(item);

            });
        } catch (Exception e) {
            Log.e("Er", e.getMessage());
        }
    }
}
