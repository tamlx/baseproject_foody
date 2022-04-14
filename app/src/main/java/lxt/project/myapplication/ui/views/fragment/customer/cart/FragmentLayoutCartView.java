package lxt.project.myapplication.ui.views.fragment.customer.cart;

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
import lxt.project.myapplication.R;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.adapter.customer.ListItemCartAdapter;
import lxt.project.myapplication.model.customer.OrderDetailModel;

public class FragmentLayoutCartView extends BaseView<FragmentLayoutCartView.UIContainer> implements FragmentLayoutCartViewInterface {

    HomeActivity activity;
    FragmentLayoutCartViewCallback callback;
    @Override
    public void init(HomeActivity activity, FragmentLayoutCartViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        showIconToolbar();
        onClick();
    }

    @Override
    public void sendData(ArrayList<OrderDetailModel> arrayList) {
        if (arrayList.size() > 0) {
            ui.layoutEmpty.setVisibility(View.GONE);
            ui.layoutTinhTien.setVisibility(View.VISIBLE);
            ui.layoutMainCart.setVisibility(View.VISIBLE);
        } else {
            ui.layoutEmpty.setVisibility(View.VISIBLE);
            ui.layoutTinhTien.setVisibility(View.GONE);
            ui.layoutMainCart.setVisibility(View.GONE);
        }
        tinhTien(arrayList);
        ui.recycler_view_list.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        ListItemCartAdapter cartAdapter = new ListItemCartAdapter(activity, arrayList);
        ui.recycler_view_list.setAdapter(cartAdapter);
        RecyclerTouchListener onTouchListener;
        onTouchListener = new RecyclerTouchListener(activity, ui.recycler_view_list);
        onTouchListener.setSwipeable(true);

        onTouchListener.setSwipeOptionViews(R.id.delete)
                .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                        if (viewID == R.id.delete) {
                            if (arrayList != null && arrayList.size() > position) {
                                arrayList.remove(position);
                                cartAdapter.notifyItemRemoved(position);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        cartAdapter.notifyDataSetChanged();
                                        if (arrayList.size() > 0) {
                                            tinhTien(arrayList);
                                        } else {
                                            ui.layoutMainCart.setVisibility(View.GONE);
                                            ui.layoutEmpty.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }, 100);

                            }
                        }

                    }
                });
        ui.recycler_view_list.addOnItemTouchListener(onTouchListener);

        cartAdapter.setListener(new ListItemCartAdapter.ListItemCartAdapterListener() {
            @Override
            public void onClickItem(OrderDetailModel model) {

            }

            @Override
            public void onClickThemSoLuong(OrderDetailModel model) {
                if (model.getProduct_detail_id() != null) {
                    String old_quantity = model.getQuantity();
                    int new_quantity = Integer.valueOf(old_quantity) + 1;
                    model.setQuantity(String.valueOf(new_quantity));
                    cartAdapter.notifyDataSetChanged();
                }
                tinhTien(arrayList);
            }

            @Override
            public void onClickGiamSoLuong(OrderDetailModel model) {
                if (model.getProduct_detail_id() != null) {
                    String old_quantity = model.getQuantity();
                    int new_quantity = Integer.valueOf(old_quantity) - 1;
                    if (new_quantity <= 1) {
                        new_quantity = 1;
                        model.setQuantity(String.valueOf(1));
                    } else {
                        model.setQuantity(String.valueOf(new_quantity));
                    }
                    cartAdapter.notifyDataSetChanged();
                }
                tinhTien(arrayList);
            }

            @Override
            public void onClickXoaItem(OrderDetailModel model) {
                if (model.getProduct_detail_id() != null) {
                    arrayList.remove(model);
                    cartAdapter.notifyDataSetChanged();
                    if (arrayList.size() == 0) {
                        ui.layoutEmpty.setVisibility(View.VISIBLE);
                        ui.layoutTinhTien.setVisibility(View.GONE);
                        ui.layoutMainCart.setVisibility(View.GONE);
                    }
                }
                tinhTien(arrayList);
            }
        });
        cartAdapter.notifyDataSetChanged();

        //dat hang
        ui.btn_buy.setOnClickListener(v -> {
            if (callback != null)
                callback.goToInfoOrder(arrayList);
        });
    }

    public void tinhTien(List<OrderDetailModel> arrayList) {
        int tongtien = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int tongitem = Integer.valueOf(arrayList.get(i).getQuantity()) * Integer.valueOf(arrayList.get(i).getPrice_sell());
            tongtien += tongitem;
        }
        ui.tongTienThanhToan.setText(CurrencyFormater.formatCurrency(tongtien) + " đ");
    }

    private void onClick() {
        //back
        ui.btnBackHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null)
                    callback.onBackProgress();
            }
        });
    }

    private void showIconToolbar() {
        ui.title_header.setText("Giỏ hàng");
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
        public TextView title_header;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

        @UiElement(R.id.tongTienThanhToan)
        public TextView tongTienThanhToan;

        @UiElement(R.id.layoutTinhTien)
        public LinearLayout layoutTinhTien;

        @UiElement(R.id.layoutMainCart)
        public LinearLayout layoutMainCart;

        @UiElement(R.id.layoutEmpty)
        public LinearLayout layoutEmpty;

        @UiElement(R.id.btn_buy)
        public RoundRelativeLayout btn_buy;


    }
}
