package lxt.project.myapplication.fragment.customer.listproduct_bycategory;

import android.os.Bundle;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.customer.CategoryProductModel;
import lxt.project.myapplication.model.customer.ProductModel;
import lxt.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryView;
import lxt.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryViewCallback;
import lxt.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryViewInterface;

public class FragmentAllProductByCategory extends BaseFragment<FragmentAllProductByCategoryViewInterface, BaseParameters> implements FragmentAllProductByCategoryViewCallback {

    HomeActivity activity;
    int page = 1;
    private int totalPage = 0;
    CategoryProductModel model;

    public static FragmentAllProductByCategory newIntance(CategoryProductModel model) {
        FragmentAllProductByCategory frag = new FragmentAllProductByCategory();
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", model);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);
        getDataToBundle();
    }

    private void getDataToBundle() {
        Bundle extras = getArguments();
        if (extras != null) {
            model = (CategoryProductModel) extras.get("model");
            if (model != null) {
                getAllDataByCategoryId(model);
            }
        }
    }

    private void getAllDataByCategoryId(CategoryProductModel model) {

        ArrayList<ProductModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductModel modelProduct = new ProductModel();
            modelProduct.setId("" + i);
            modelProduct.setName("Product " + i);
            modelProduct.setProduct_price("100000");
            modelProduct.setDescription("Thông tin mô tả sản phẩm");
            modelProduct.setProduct_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(modelProduct);
        }
        view.setDataProductByCategory(list, model);
    }

    @Override
    public FragmentAllProductByCategoryViewInterface getViewInstance() {
        return new FragmentAllProductByCategoryView();
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
    public void onCLickProductDetail(ProductModel item) {
        if (activity != null)
            activity.changeToFragmentProductDetail(item);
    }
}
