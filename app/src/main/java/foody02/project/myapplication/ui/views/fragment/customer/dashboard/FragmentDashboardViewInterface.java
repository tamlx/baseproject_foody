package foody02.project.myapplication.ui.views.fragment.customer.dashboard;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ImageSlideModel;
import foody02.project.myapplication.model.customer.ProductModel;

public interface FragmentDashboardViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentDashboardViewCallback callback);

    void setDataImageSlide(ImageSlideModel[] data);

    void setDataProductHot(ArrayList<ProductModel> data);

    void setDataProductFreeShip(ArrayList<ProductModel> data);

    void setDataListProduct(ArrayList<ProductModel> data);

    void setDataProductCategory(ArrayList<CategoryProductModel> arrDataCategory);
}
