package foody02.project.myapplication.fragment.customer.category;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.fragment.customer.listproduct_bycategory.FragmentAllProductByCategory;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.ui.views.fragment.customer.category.FragmentProductCategoryView;
import foody02.project.myapplication.ui.views.fragment.customer.category.FragmentProductCategoryViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.category.FragmentProductCategoryViewInterface;

public class FragmentProductCategory extends BaseFragment<FragmentProductCategoryViewInterface, BaseParameters> implements FragmentProductCategoryViewCallback {

    HomeActivity activity;

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);
        getData();
    }

    private void getData() {
        ArrayList<CategoryProductModel> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CategoryProductModel model = new CategoryProductModel();
            model.setId_category("" + i);
            model.setCategory_name("Danh mục " + i);
            model.setTotal_product("" + i);
            model.setCategory_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(model);
        }
        view.setDataProductCategory(list);
    }

    @Override
    protected FragmentProductCategoryViewInterface getViewInstance() {
        return new FragmentProductCategoryView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onBackPressed() {
        if (activity != null)
            activity.checkBack();
    }

    @Override
    public void onClickShowCart() {
        if (activity != null)
            activity.changeToFragmentShowCart();
    }

    @Override
    public void showMoreProductCategory(CategoryProductModel model) {
        if (activity != null) {
            activity.replaceFragment(new FragmentAllProductByCategory().newIntance(model), true);

        }
    }
}
