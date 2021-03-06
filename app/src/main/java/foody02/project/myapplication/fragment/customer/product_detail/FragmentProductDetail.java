package foody02.project.myapplication.fragment.customer.product_detail;

import android.os.Bundle;
import android.widget.Toast;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.OrderDetailModel;
import foody02.project.myapplication.model.customer.ProductModel;
import foody02.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailView;
import foody02.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.product_detail.FragmentProductDetailViewInterface;

import static foody02.project.myapplication.activity.HomeActivity.PRODUCT_CHOOSE_MODELS;

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
        //ki???m tra s???n ph???m ???? ???????c th??m v??o gi??? h??ng ch??a
        if (PRODUCT_CHOOSE_MODELS.size() > 0) {
            //duy???t h???t list s???n ph???m ???? ???????c th??m v??o gi??? h??ng
            for (int i = 0; i < PRODUCT_CHOOSE_MODELS.size(); i++) {
                //n???u ???? c?? s???n ph???m trong gi??? h??ng th?? c???p nh???t l???i s??? l?????ng
                if (PRODUCT_CHOOSE_MODELS.get(i).getProduct_detail_id() == chooseModel.getProduct_detail_id()) {
                    String old_quantity = PRODUCT_CHOOSE_MODELS.get(i).getQuantity();
                    int new_quantity = Integer.valueOf("1") + Integer.valueOf(old_quantity);
                    PRODUCT_CHOOSE_MODELS.get(i).setQuantity(String.valueOf(new_quantity));
                    break;
                } else {
                    //n???u ch??a c?? th?? duy???t s???n ph???m ti???p theo, t??ng bi???n count l??n 1
                    count1 += 1;
                }
            }
            // n???u duy???t h???t danh s??ch m?? ko c?? s???n ph???m th?? th??m m???i
            if (count1 == PRODUCT_CHOOSE_MODELS.size()) {
                PRODUCT_CHOOSE_MODELS.add(chooseModel);
            }
        } else {
            //n???u ch??a c?? s???n ph???m n??o ???????c th??m th?? th??m m???i lu??n v??o danh s??ch
            PRODUCT_CHOOSE_MODELS.add(chooseModel);
        }
        Toast.makeText(getContext(), "Th??m v??o gi??? h??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
    }
}
