package foody02.project.myapplication.fragment.customer.listproduct_bycategory;

import android.os.Bundle;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ProductModel;
import foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryView;
import foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory.FragmentAllProductByCategoryViewInterface;

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
//                getAllDataByCategoryId(model);
                getSanPhamTheoDanhMuc(model);
            }
        }
    }

    private void getSanPhamTheoDanhMuc(CategoryProductModel model) {

        ArrayList<ProductModel> list = new ArrayList<>();

        switch (model.getId_category()) {
            case "1": // danh s??ch s???n ph???m ???ng v???i danh m???c 1
                ProductModel modelProduct1_1 = new ProductModel();
                modelProduct1_1.setId("1"); // id c???a s???n ph???m
                modelProduct1_1.setName("T??n s???n ph???m 1"); // t??n s???n ph???m 1
                modelProduct1_1.setProduct_price("100000"); // gi?? s???n ph???m 1
                modelProduct1_1.setDescription("Th??ng tin m?? t??? s???n ph???m"); // m?? t???
                modelProduct1_1.setProduct_image(""); // link h??nh s???n ph???m
                list.add(modelProduct1_1);

                ProductModel modelProduct2_1 = new ProductModel();
                modelProduct2_1.setId("2"); // id c???a s???n ph???m
                modelProduct2_1.setName("T??n s???n ph???m 2"); // t??n s???n ph???m 1
                modelProduct2_1.setProduct_price("100000"); // gi?? s???n ph???m 1
                modelProduct2_1.setDescription("Th??ng tin m?? t??? s???n ph???m"); // m?? t???
                modelProduct2_1.setProduct_image(""); // link h??nh s???n ph???m
                list.add(modelProduct2_1);
                break;

            case "2":// danh s??ch s???n ph???m ???ng v???i danh m???c 2
                ProductModel modelProduct1_2 = new ProductModel();
                modelProduct1_2.setId("1"); // id c???a s???n ph???m
                modelProduct1_2.setName("T??n s???n ph???m 1"); // t??n s???n ph???m 1
                modelProduct1_2.setProduct_price("100000"); // gi?? s???n ph???m 1
                modelProduct1_2.setDescription("Th??ng tin m?? t??? s???n ph???m"); // m?? t???
                modelProduct1_2.setProduct_image(""); // link h??nh s???n ph???m
                list.add(modelProduct1_2);

                ProductModel modelProduct2_2 = new ProductModel();
                modelProduct2_2.setId("2"); // id c???a s???n ph???m
                modelProduct2_2.setName("T??n s???n ph???m 2"); // t??n s???n ph???m 1
                modelProduct2_2.setProduct_price("100000"); // gi?? s???n ph???m 1
                modelProduct2_2.setDescription("Th??ng tin m?? t??? s???n ph???m"); // m?? t???
                modelProduct2_2.setProduct_image(""); // link h??nh s???n ph???m
                list.add(modelProduct2_2);
                break;

        }

        view.setDataProductByCategory(list, model);
    }

    private void getAllDataByCategoryId(CategoryProductModel model) {

        ArrayList<ProductModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductModel modelProduct = new ProductModel();
            modelProduct.setId("" + i);
            modelProduct.setName("Product " + i);
            modelProduct.setProduct_price("100000");
            modelProduct.setDescription("Th??ng tin m?? t??? s???n ph???m");
            modelProduct.setProduct_image("");
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
