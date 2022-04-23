package foody02.project.myapplication.adapter.customer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.superadapter.IMulItemViewType;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import b.laixuantam.myaarlibrary.widgets.ultils.ConvertDate;
import foody02.project.myapplication.R;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.model.customer.OptionModel;
import foody02.project.myapplication.model.customer.OrderDetailModel;
import foody02.project.myapplication.model.customer.OrderModel;

public class ListOrderHistoryAdapter extends SuperAdapter<OptionModel> {

    public ListOrderHistoryAdapter(Context context, List<OptionModel> items, IMulItemViewType<OptionModel> multiItemViewType) {
        super(context, items, multiItemViewType);
    }

    private ListItemCartAdapterListener listener;

    public interface ListItemCartAdapterListener {
        void onClickItem(OrderModel model);
    }

    public void setListener(ListItemCartAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, OptionModel item) {

        switch (viewType) {
            case 1: // layout item order detail
                OrderDetailModel orderDetailModel = (OrderDetailModel) item.getDtaCustom();
                ImageView imgProduct = holder.findViewById(R.id.imgProduct);
                ImageView image_minus = holder.findViewById(R.id.image_minus);
                ImageView image_plus = holder.findViewById(R.id.image_plus);
                TextView nameProduct = holder.findViewById(R.id.nameProduct);
                TextView quantity_product = holder.findViewById(R.id.quantity_product);
                TextView priceProduct = holder.findViewById(R.id.priceProduct);
                image_minus.setVisibility(View.GONE);
                image_plus.setVisibility(View.GONE);

                AppProvider.getImageHelper().displayImage(item.getImage(), imgProduct, null, R.drawable.app_logo);
                nameProduct.setText(orderDetailModel.getName());
                quantity_product.setText("Số lượng: " + orderDetailModel.getQuantity());
                priceProduct.setText(CurrencyFormater.formatCurrency(orderDetailModel.getPrice_sell()));

                break;

            case 2: // layout item order
                final View rowItem = holder.findViewById(R.id.layout_item);
                OrderModel orderModel = (OrderModel) item.getDtaCustom();
                TextView tvOrderCode = holder.findViewById(R.id.tvOrderCode);
                TextView tvOrderCreateDate = holder.findViewById(R.id.tvOrderCreateDate);

                tvOrderCode.setText(orderModel.getId_order());

                if (!TextUtils.isEmpty(orderModel.getOrder_date())) {
                    tvOrderCreateDate.setText(orderModel.getOrder_date());
                }

                rowItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null)
                            listener.onClickItem(orderModel);
                    }
                });
                break;

        }

    }

    @Override
    protected IMulItemViewType<OptionModel> offerMultiItemViewType() {
        return new IMulItemViewType<OptionModel>() {
            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, OptionModel model) {
                if (model.getOptionType() == OptionModel.OptionType.CUSTOM_TYPE_ORDER) {
                    return 2;
                }
                return 1;
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 2) {
                    return R.layout.row_item_order;
                }
                return R.layout.row_custom_item_cart;
            }
        };
    }
}
