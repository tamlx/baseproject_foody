package ntkn.project.myapplication.ui.views.fragment.customer.dashboard;

import ntkn.project.myapplication.model.customer.CategoryProductModel;

public interface FragmentDashboardViewCallback {
    void showMoreProductHot();

    void showMoreProductNew();

    void showMoreProductCategory(CategoryProductModel model);

    void goToShopCart();
}
