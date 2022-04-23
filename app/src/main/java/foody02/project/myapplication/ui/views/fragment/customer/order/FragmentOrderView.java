package foody02.project.myapplication.ui.views.fragment.customer.order;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.recyclerviewenhanced.RecyclerTouchListener;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.adapter.customer.ListItemCartAdapter;
import foody02.project.myapplication.adapter.customer.ListOrderHistoryAdapter;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.model.customer.OptionModel;
import foody02.project.myapplication.model.customer.OrderDetailModel;
import foody02.project.myapplication.model.customer.OrderHistoryDetailModel;
import foody02.project.myapplication.model.customer.OrderHistoryModel;
import foody02.project.myapplication.model.customer.OrderModel;

public class FragmentOrderView extends BaseView<FragmentOrderView.UIContainer> implements FragmentOrderViewInterface {

    HomeActivity activity;
    FragmenOrderViewCallback callback;
    private ListOrderHistoryAdapter adapter;
    private ArrayList<OptionModel> listDataOrder = new ArrayList<>();

    @Override
    public void init(HomeActivity activity, FragmenOrderViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Lịch sử mua hàng");

        setupDataListOrder();
        onClick();
        fillDataListOrder();
    }

    private void fillDataListOrder() {
        OrderHistoryModel historyModel = AppProvider.getPreferences().getOrderHistoryModel();
        if (historyModel != null) {
            listDataOrder.clear();
            ArrayList<OrderModel> listOrderHistory = historyModel.getListOrderHistory();
            if (listOrderHistory != null && listOrderHistory.size() > 0) {
                for (OrderModel item : listOrderHistory) {
                    OptionModel optionModel = new OptionModel();
                    optionModel.setDtaCustom(item);
                    optionModel.setOptionType(OptionModel.OptionType.CUSTOM_TYPE_ORDER);
                    listDataOrder.add(optionModel);
                }
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void fillDataListOrderDetail(OrderModel model) {

        OrderHistoryDetailModel orderHistoryDetailModel = AppProvider.getPreferences().getOrderHistoryDetailModel();
        if (orderHistoryDetailModel != null) {
            ArrayList<OrderDetailModel> PRODUCT_CHOOSE_MODELS = orderHistoryDetailModel.getPRODUCT_CHOOSE_MODELS();
            List<OrderDetailModel> arrayList = new ArrayList<>();
            if (PRODUCT_CHOOSE_MODELS != null && PRODUCT_CHOOSE_MODELS.size() > 0) {
                listDataOrder.clear();
                for (OrderDetailModel item : PRODUCT_CHOOSE_MODELS) {
                    if (item.getId_order().equalsIgnoreCase(model.getId_order())) {
                        arrayList.add(item);
                        OptionModel optionModel = new OptionModel();
                        optionModel.setDtaCustom(item);
                        optionModel.setOptionType(OptionModel.OptionType.CUSTOM_TYPE_ORDER_DETAIL);
                        listDataOrder.add(optionModel);
                    }
                }
                adapter.notifyDataSetChanged();
                tinhTien(arrayList);
            }
        }
    }

    private void setupDataListOrder() {
        ui.recycler_view_list.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        adapter = new ListOrderHistoryAdapter(activity, listDataOrder, null);
        adapter.setListener(new ListOrderHistoryAdapter.ListItemCartAdapterListener() {
            @Override
            public void onClickItem(OrderModel model) {
                fillDataListOrderDetail(model);
            }
        });
        ui.recycler_view_list.setAdapter(adapter);
    }

    public void tinhTien(List<OrderDetailModel> arrayList) {
        setVisible(ui.layoutTinhTien);
        setGone(ui.btn_buy);
        int tongtien = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int tongitem = Integer.valueOf(arrayList.get(i).getQuantity()) * Integer.valueOf(arrayList.get(i).getPrice_sell());
            tongtien += tongitem;
        }
        ui.tongTienThanhToan.setText(CurrencyFormater.formatCurrency(tongtien) + " đ");
    }

    private void onClick() {
        ui.btnBackHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ui.layoutTinhTien.getVisibility() == View.VISIBLE) {
                    setGone(ui.layoutTinhTien);
                    fillDataListOrder();
                } else {
                    if (callback != null)
                        callback.onBackPress();
                }
            }
        });
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_cart;
    }


    public class UIContainer extends BaseUiContainer {

        //header
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

        @UiElement(R.id.tongTienThanhToan)
        public TextView tongTienThanhToan;

        @UiElement(R.id.layoutTinhTien)
        public View layoutTinhTien;

        @UiElement(R.id.layoutMainCart)
        public LinearLayout layoutMainCart;

        @UiElement(R.id.layoutEmpty)
        public LinearLayout layoutEmpty;

        @UiElement(R.id.btn_buy)
        public RoundRelativeLayout btn_buy;


    }
}
