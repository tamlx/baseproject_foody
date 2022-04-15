package foody02.project.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseActionbarView;
import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import foody02.project.myapplication.R;
import foody02.project.myapplication.fragment.account.login.FragmentLogin;
import foody02.project.myapplication.fragment.account.register.FragmentRegister;
import foody02.project.myapplication.fragment.customer.cart.FragmentLayoutCart;
import foody02.project.myapplication.fragment.customer.category.FragmentProductCategory;
import foody02.project.myapplication.fragment.customer.dashboard.FragmentDashboard;
import foody02.project.myapplication.fragment.customer.product_detail.FragmentProductDetail;
import foody02.project.myapplication.model.customer.OrderDetailModel;
import foody02.project.myapplication.model.customer.ProductModel;
import foody02.project.myapplication.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewInterface;
import foody02.project.myapplication.ui.views.activity.base_main_activity.BaseMainActivityView;
import foody02.project.myapplication.ui.views.activity.base_main_activity.BaseMainActivityViewInterface;
import foody02.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public class HomeActivity extends BaseFragmentActivity<BaseMainActivityViewInterface, BaseActionbarView, BaseParameters> implements HomeActivityViewCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    @Override
    protected void initialize(Bundle bundle) {

        view.init(this, this);

//        changeToFragmentDashboard();
        changeToFragmentLogin();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected BaseMainActivityViewInterface getViewInstance() {
        return new BaseMainActivityView();
    }


    @Override
    protected BaseMainActionbarViewInterface getActionbarInstance() {
        return null;
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.LayoutBaseMainFragmentActivity;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onBackPressed() {
    }

    private int isShowContainer = 0;

    public void checkBack() {

        if (isShowContainer > 0) {
            isShowContainer--;
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }

            if (isShowContainer == 0) {
//                if (listProductOrder != null) {
//                    int countItemOrder = countOrderProduct();
//                    if (countItemOrder > 0) {
//                        view.setBadgeCart(countItemOrder);
//                    }
//
//
//                }
            }

        } else {
            checkFragment();
        }
    }

    private void checkFragment() {

        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();

        } else {
            super.onBackPressed();
        }
    }

    //============ view callback =====================

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    ///////////////////////////////////////////////////////////////////////////
    // overight customer alert
    ///////////////////////////////////////////////////////////////////////////

    public void showConfirmAlert(String title, String mess, KAlertDialog.KAlertClickListener actionConfirm, int type) {
        showConfirmAlert(title, mess, "", "", actionConfirm, null, type);
    }

    public void showConfirmAlert(String title, String mess, KAlertDialog.KAlertClickListener actionConfirm, KAlertDialog.KAlertClickListener actionCancel, int type) {
        showConfirmAlert(title, mess, "", "", actionConfirm, actionCancel, type);
    }

    public void showConfirmAlert(String title, String mess, String titleButtonConfirm, String titleButtonCancel, KAlertDialog.KAlertClickListener actionConfirm, KAlertDialog.KAlertClickListener actionCancel, int type) {

        switch (type) {
            case KAlertDialog.SUCCESS_TYPE:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_confirm_bg, titleButtonCancel, R.drawable.alert_dialog_button_cancel_bg, actionConfirm, actionCancel, R.drawable.ic_img_alert_success);
                break;
            case KAlertDialog.WARNING_TYPE:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_confirm_bg, titleButtonCancel, R.drawable.alert_dialog_button_cancel_bg, actionConfirm, actionCancel, R.drawable.ic_img_alert_warning);
                break;
            case -1:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_confirm_bg, titleButtonCancel, R.drawable.alert_dialog_button_cancel_bg, actionConfirm, actionCancel, R.drawable.ic_img_alert_warning_logout);
                break;
        }

    }

    ///////////////////////////////////////////////////////////////////////////
    // MAIN FUCTION
    ///////////////////////////////////////////////////////////////////////////


    public void changeToFragmentDashboard() {
        replaceFragment(new FragmentDashboard(), false);
    }

    public void changeToFragmentProductCategory() {
        replaceFragment(new FragmentProductCategory(), false);
    }


    public void changeToFragmentLogin() {
        replaceFragment(new FragmentLogin(), true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentRegister() {
        isShowContainer++;
        replaceFragment(new FragmentRegister(), true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentProductDetail(ProductModel item) {
        isShowContainer++;
        replaceFragment(FragmentProductDetail.newIntance(item), true);
    }

    public void changeToFragmentShowCart() {
        isShowContainer++;
        replaceFragment(new FragmentLayoutCart(), true);
    }

    public static ArrayList<OrderDetailModel> PRODUCT_CHOOSE_MODELS = new ArrayList<>();



}
