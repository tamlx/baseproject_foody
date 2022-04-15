package foody02.project.myapplication.ui.views.fragment.customer.product_detail;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.ProductModel;

public interface FragmentProductDetailViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentProductDetailViewCallback callback);

    void setDataProductDetail(ProductModel model);
}
