package lxt.project.myapplication.ui.views.fragment.customer.product_detail;

import android.view.View;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import lxt.project.myapplication.R;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.customer.ProductModel;

public class FragmentProductDetailView extends BaseView<FragmentProductDetailView.UIContainer> implements FragmentProductDetailViewInterface {

    HomeActivity activity;
    FragmentProductDetailViewCallback callback;

    @Override
    public void init(HomeActivity activity, FragmentProductDetailViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        setVisible(ui.btnShowCart);
        ui.title_header.setText("Chi tiết sản phẩm");

        onClick();
    }

    @Override
    public void setDataProductDetail(ProductModel model) {
        ui.tvProductName.setText(model.getName());
        String productPrice = CurrencyFormater.formatCurrency(model.getProduct_price());
        ui.price_sell.setText(productPrice);
        ui.description_product.setText(model.getDescription());

    }

    private void onClick() {
        //onBack
        ui.btnBackHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null)
                    callback.onclickBackHeader();
            }
        });

        ui.btn_add_cart.setOnClickListener(v -> {
            if (callback != null)
                callback.onClickAddProductToCart();
        });

        ui.btnShowCart.setOnClickListener(v -> {
            if (callback != null)
                callback.onClickShowCart();
        });
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_product_detail;
    }


    public class UIContainer extends BaseUiContainer {

        //header
        @UiElement(R.id.btnBackHeader)
        public View btnBackHeader;

        @UiElement(R.id.btnShowCart)
        public View btnShowCart;

        @UiElement(R.id.tvTitleHeader)
        public TextView title_header;

        //product detail
        @UiElement(R.id.tvProductName)
        public TextView tvProductName;

        @UiElement(R.id.price_sell)
        public TextView price_sell;

        @UiElement(R.id.description_product)
        public TextView description_product;

        @UiElement(R.id.btn_add_cart)
        public View btn_add_cart;

    }
}
