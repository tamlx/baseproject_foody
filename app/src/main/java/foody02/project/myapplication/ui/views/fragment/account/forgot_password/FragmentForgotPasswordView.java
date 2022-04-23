package foody02.project.myapplication.ui.views.fragment.account.forgot_password;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AnimationHelper;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.scaletouchlistener.ScaleTouchListener;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;

public class FragmentForgotPasswordView extends BaseView<FragmentForgotPasswordView.UIContainer> implements FragmentForgotPasswordViewInterface {

    private boolean isShowFormInputPhoneCheck = true;
    private boolean isVisiblePassword;

    @Override
    public void init(HomeActivity activity, FragmentForgotPasswordViewCallback callback) {
        ui.tvTitleHeader.setText("Quên mật khẩu");

        ui.btnBackHeader.setOnClickListener(new ScaleTouchListener(confScaleTouch) {
            @Override
            public void onClick(View v) {
                if (!isShowFormInputPhoneCheck) {
                    showLayoutInputPhoneCheck();
                    return;
                }

                callback.onClickBackHeader();
            }
        });

        ui.btnShowFormInputNewPassword.setOnClickListener(v -> {
            if (TextUtils.isEmpty(ui.edtUserPhoneRegister.getText())) {
                ui.edtUserPhoneRegister.setError("Nhập số điện thoại đăng ký");
                ui.edtUserPhoneRegister.requestFocus();
                return;
            }

            String phone = ui.edtUserPhoneRegister.getText().toString();

            callback.onRequestCheckPhoneRegister(phone);
        });

        ui.btnSubmitNewPass.setOnClickListener(v -> {
            if (TextUtils.isEmpty(ui.edtNewsPassword.getText())) {
                ui.edtNewsPassword.setError("Nhập mật khẩu mới");
                ui.edtNewsPassword.requestFocus();
                return;
            }

            String phone = ui.edtUserPhoneRegister.getText().toString().replaceAll(" ", "");
            String newPassword = ui.edtNewsPassword.getText().toString().trim();

            callback.onRequestUpdatePassword(phone, newPassword);
        });

        ui.btnVisiblePassword.setOnClickListener(v -> {
            if (!isVisiblePassword) {
                isVisiblePassword = true;
                ui.edtNewsPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                if (!"".contentEquals(ui.edtNewsPassword.getText()))
                    ui.edtNewsPassword.setSelection(ui.edtNewsPassword.getText().length());
                ui.btnVisiblePassword.setBackgroundResource(R.drawable.eyes_selected_64);
            } else {
                isVisiblePassword = false;
                ui.edtNewsPassword.setInputType(129);
                if (!"".contentEquals(ui.edtNewsPassword.getText()))
                    ui.edtNewsPassword.setSelection(ui.edtNewsPassword.getText().length());
                ui.btnVisiblePassword.setBackgroundResource(R.drawable.ic_hide_eys);
            }
        });
        showLayoutInputPhoneCheck();
    }

    @Override
    public void checkPhoneRegisterSuccessExists() {
        showLayoutInputNewPassword();
    }

    private void showLayoutInputPhoneCheck() {
        isShowFormInputPhoneCheck = true;

        setVisible(ui.layout_form_input_phone);
        setGone(ui.layout_form_input_new_pass);

        AnimationHelper.fade(ui.layout_form_input_phone, true);
    }

    private void showLayoutInputNewPassword() {
        isShowFormInputPhoneCheck = false;

        setGone(ui.layout_form_input_phone);
        setVisible(ui.layout_form_input_new_pass);

        AnimationHelper.fade(ui.layout_form_input_new_pass, true);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_forgot_password;
    }

    public static class UIContainer extends BaseUiContainer {

        @UiElement(R.id.btnBackHeader)
        public View btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        ///////////////////////////////////////////////////////////////////////////
        // layout_form_input_phone
        ///////////////////////////////////////////////////////////////////////////
        @UiElement(R.id.layout_form_input_phone)
        public View layout_form_input_phone;

        @UiElement(R.id.edtUserPhoneRegister)
        public EditText edtUserPhoneRegister;

        @UiElement(R.id.btnShowFormInputNewPassword)
        public View btnShowFormInputNewPassword;

        ///////////////////////////////////////////////////////////////////////////
        // layout_form_input_new_pass
        ///////////////////////////////////////////////////////////////////////////

        @UiElement(R.id.layout_form_input_new_pass)
        public View layout_form_input_new_pass;

        @UiElement(R.id.edtNewsPassword)
        public EditText edtNewsPassword;

        @UiElement(R.id.btnVisiblePassword)
        public ImageView btnVisiblePassword;

        @UiElement(R.id.btnSubmitNewPass)
        public View btnSubmitNewPass;

    }
}
