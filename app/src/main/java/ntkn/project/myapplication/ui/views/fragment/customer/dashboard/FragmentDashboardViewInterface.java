package ntkn.project.myapplication.ui.views.fragment.customer.dashboard;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import ntkn.project.myapplication.activity.HomeActivity;
import ntkn.project.myapplication.model.customer.CategoryProductModel;
import ntkn.project.myapplication.model.customer.ImageSlideModel;
import ntkn.project.myapplication.model.customer.ProductModel;

public interface FragmentDashboardViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentDashboardViewCallback callback);

    void setDataImageSlide(ImageSlideModel[] data);

    void setDataProductHot(ArrayList<ProductModel> data);

    void setDataProductFreeShip(ArrayList<ProductModel> data);

    void setDataListProduct(ArrayList<ProductModel> data);

    void setDataProductCategory(ArrayList<CategoryProductModel> arrDataCategory);
}
