package foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory;

import foody02.project.myapplication.model.customer.ProductModel;

public interface FragmentAllProductByCategoryViewCallback {
    void onBackPressed();

    void onCLickProductDetail(ProductModel item);

    void onClickShowCart();
}
