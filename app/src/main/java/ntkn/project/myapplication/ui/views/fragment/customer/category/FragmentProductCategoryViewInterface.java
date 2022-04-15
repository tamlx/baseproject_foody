package ntkn.project.myapplication.ui.views.fragment.customer.category;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import ntkn.project.myapplication.activity.HomeActivity;
import ntkn.project.myapplication.model.customer.CategoryProductModel;

public interface FragmentProductCategoryViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentProductCategoryViewCallback callback);

    void setDataProductCategory(ArrayList<CategoryProductModel> list);
}
