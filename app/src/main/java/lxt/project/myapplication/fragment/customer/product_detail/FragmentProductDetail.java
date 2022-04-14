package lxt.project.myapplication.fragment.customer.product_detail;

import android.os.Bundle;
import android.widget.Toast;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.customer.OrderDetailModel;
import lxt.project.myapplication.model.customer.ProductModel;
import lxt.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailView;
import lxt.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailViewCallback;
import lxt.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailViewInterface;

import static lxt.project.myapplication.activity.HomeActivity.PRODUCT_CHOOSE_MODELS;

public class FragmentProductDetail extends BaseFragment<FragmentProductDetailViewInterface, BaseParameters> implements FragmentProductDetailViewCallback {

    HomeActivity activity;
    ProductModel model;

    public static FragmentProductDetail newIntance(ProductModel item) {
        FragmentProductDetail frag = new FragmentProductDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", item);
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
            model = (ProductModel) extras.get("model");
            view.setDataProductDetail(model);
        }
    }

    @Override
    public void onClickShowCart() {
        if (activity != null) {
            activity.changeToFragmentShowCart();
        }
    }

    @Override
    protected FragmentProductDetailViewInterface getViewInstance() {
        return new FragmentProductDetailView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onclickBackHeader() {
        if (activity != null) {
            activity.checkBack();
        }
    }

    @Override
    public void onClickAddProductToCart() {
        if (model == null)
            return;
        OrderDetailModel chooseModel = new OrderDetailModel();
        chooseModel.setProduct_detail_id(model.getId());
        chooseModel.setName(model.getName());
        chooseModel.setImage(model.getProduct_image());
        chooseModel.setQuantity("1");
        chooseModel.setPrice_sell(model.getProduct_price());

        int count1 = 0;
        //kiểm tra sản phẩm đã được thêm vào giỏ hàng chưa
        if (PRODUCT_CHOOSE_MODELS.size() > 0) {
            //duyệt hết list sản phẩm đã được thêm vào giỏ hàng
            for (int i = 0; i < PRODUCT_CHOOSE_MODELS.size(); i++) {
                //nếu đã có sản phẩm trong giở hàng thì cập nhật lại số lượng
                if (PRODUCT_CHOOSE_MODELS.get(i).getProduct_detail_id() == chooseModel.getProduct_detail_id()) {
                    String old_quantity = PRODUCT_CHOOSE_MODELS.get(i).getQuantity();
                    int new_quantity = Integer.valueOf("1") + Integer.valueOf(old_quantity);
                    PRODUCT_CHOOSE_MODELS.get(i).setQuantity(String.valueOf(new_quantity));
                    break;
                } else {
                    //nếu chưa có thì duyệt sản phẩm tiếp theo, tăng biến count lên 1
                    count1 += 1;
                }
            }
            // nếu duyệt hết danh sách mà ko có sản phẩm thì thêm mới
            if (count1 == PRODUCT_CHOOSE_MODELS.size()) {
                PRODUCT_CHOOSE_MODELS.add(chooseModel);
            }
        } else {
            //nếu chưa có sản phẩm nào được thêm thì thêm mới luôn vào danh sách
            PRODUCT_CHOOSE_MODELS.add(chooseModel);
        }
        Toast.makeText(getContext(), "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
    }
}
