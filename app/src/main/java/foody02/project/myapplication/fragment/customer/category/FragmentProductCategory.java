package foody02.project.myapplication.fragment.customer.category;

import android.app.Dialog;
import android.content.Intent;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.dependency.AppProvider;
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
//        getData();
        getDataDanhMuc();
    }

    private void getDataDanhMuc() {
        ArrayList<CategoryProductModel> list = new ArrayList<>();

        CategoryProductModel model1 = new CategoryProductModel();
        model1.setId_category("1" ); // id danh mục 1
        model1.setCategory_name("Danh mục 1"); // tên danh mục 1
        model1.setTotal_product("0" ); // số lượng sản phẩm của danh mục 1
        model1.setCategory_image(""); // link hình ảnh danh mục 1
        list.add(model1);

        CategoryProductModel model2 = new CategoryProductModel();
        model2.setId_category("2" ); // id danh mục 2
        model2.setCategory_name("Danh mục 2"); // tên danh mục 2
        model2.setTotal_product("0" ); // số lượng sản phẩm của danh mục 2
        model2.setCategory_image(""); // link hình ảnh danh mục 2
        list.add(model2);

        view.setDataProductCategory(list);
    }

    private void getData() {
        ArrayList<CategoryProductModel> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CategoryProductModel model = new CategoryProductModel();
            model.setId_category("" + i);
            model.setCategory_name("Danh mục " + i);
            model.setTotal_product("" + i);
            model.setCategory_image("");
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
    public void onClickLogout() {
        doLogout();
    }

    public void doLogout() {

        showConfirmAlert("Đăng xuất", "Bạn có muốn đăng xuất tài khoản?", kAlertDialog -> {
            kAlertDialog.dismiss();
            AppProvider.getPreferences().saveStatusLogin(false);
            if (activity != null)
                activity.changeToFragmentLogin();

        }, Dialog::dismiss, -1);
    }

    @Override
    public void onClickOrderHistory() {
        if (activity != null)
            activity.changeToFragmentOrderHistory();
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
