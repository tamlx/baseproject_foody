package foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ProductModel;

public interface FragmentAllProductByCategoryViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentAllProductByCategoryViewCallback callback);

    void setNoMoreLoading();

    void clearListDataProduct();

    void setDataProductByCategory(ArrayList<ProductModel> data, CategoryProductModel model);
}
