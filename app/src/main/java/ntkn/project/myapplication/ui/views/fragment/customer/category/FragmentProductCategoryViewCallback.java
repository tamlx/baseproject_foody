package ntkn.project.myapplication.ui.views.fragment.customer.category;

import ntkn.project.myapplication.model.customer.CategoryProductModel;

public interface FragmentProductCategoryViewCallback {
    void onBackPressed();

    void showMoreProductCategory(CategoryProductModel item);

    void onClickShowCart();
}
