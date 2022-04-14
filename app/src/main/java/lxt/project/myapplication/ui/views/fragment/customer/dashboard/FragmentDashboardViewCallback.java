package lxt.project.myapplication.ui.views.fragment.customer.dashboard;

import lxt.project.myapplication.model.customer.CategoryProductModel;

public interface FragmentDashboardViewCallback {
    void showMoreProductHot();

    void showMoreProductNew();

    void showMoreProductCategory(CategoryProductModel model);

    void goToShopCart();
}
