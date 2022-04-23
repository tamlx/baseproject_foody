package foody02.project.myapplication.ui.views.fragment.customer.category;

import foody02.project.myapplication.model.customer.CategoryProductModel;

public interface FragmentProductCategoryViewCallback {

    void showMoreProductCategory(CategoryProductModel item);

    void onClickShowCart();

    void onClickLogout();

    void onClickOrderHistory();
}
