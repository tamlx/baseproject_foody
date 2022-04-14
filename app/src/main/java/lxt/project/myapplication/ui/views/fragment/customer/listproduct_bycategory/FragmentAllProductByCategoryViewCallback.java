package lxt.project.myapplication.ui.views.fragment.customer.listproduct_bycategory;

import lxt.project.myapplication.model.customer.ProductModel;

public interface FragmentAllProductByCategoryViewCallback {
    void onBackPressed();

    void onCLickProductDetail(ProductModel item);

    void onClickShowCart();
}
