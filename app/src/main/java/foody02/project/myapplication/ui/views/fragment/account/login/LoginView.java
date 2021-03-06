package foody02.project.myapplication.ui.views.fragment.account.login;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

//import com.facebook.CallbackManager;
//import com.facebook.FacebookCallback;
//import com.facebook.FacebookException;
//import com.facebook.login.LoginResult;
//import com.facebook.login.widget.LoginButton;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.scaletouchlistener.ScaleTouchListener;
import foody02.project.myapplication.R;

public class LoginView extends BaseView<LoginView.UiContainer> implements LoginViewInterface {
    private boolean isVisiblePassword;
    private boolean isLoginAdmin = false;
    private LoginViewCallback callback;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initialize(final LoginViewCallback callback) {
        this.callback = callback;

        ui.edtLoginPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ui.edtLoginPhone.getText().length() > 0) {
                    ui.edtLoginPhone.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ui.edtLoginPhone.getText().length() > 0) {
                    ui.edtLoginPhone.setError(null);
                }
            }
        });
        ui.edtLoginPassowrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ui.edtLoginPassowrd.getText().length() > 0) {
                    ui.edtLoginPassowrd.setError(null);
                }
            }
        });
        ui.edtLoginPassowrd.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                doLogin();
            }
            return false;
        });

        ui.btnVisiblePassword.setOnClickListener(v -> {
            if (!isVisiblePassword) {
                isVisiblePassword = true;
                ui.edtLoginPassowrd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                if (!"".contentEquals(ui.edtLoginPassowrd.getText()))
                    ui.edtLoginPassowrd.setSelection(ui.edtLoginPassowrd.getText().length());
                ui.btnVisiblePassword.setBackgroundResource(R.drawable.eyes_selected_64);
            } else {
                isVisiblePassword = false;
                ui.edtLoginPassowrd.setInputType(129);
                if (!"".contentEquals(ui.edtLoginPassowrd.getText()))
                    ui.edtLoginPassowrd.setSelection(ui.edtLoginPassowrd.getText().length());
                ui.btnVisiblePassword.setBackgroundResource(R.drawable.ic_hide_eys);
            }
        });


        ui.btnLogin.setOnClickListener(new ScaleTouchListener(confScaleTouch) {
            @Override
            public void onClick(View v) {
                AppUtils.hideKeyBoard(ui.btnLogin);
                doLogin();
            }
        });

        ui.btnShowRegisterForm.setOnClickListener(new ScaleTouchListener(confScaleTouch) {
            @Override
            public void onClick(View v) {
                callback.onClickShowRegister();
            }
        });

        ui.btnForgotPassword.setOnClickListener(v -> {
            callback.onClickForgotPassword();
        });
    }

    private void doLogin() {
        if (!TextUtils.isEmpty(ui.edtLoginPhone.getText()) && !TextUtils
                .isEmpty(ui.edtLoginPhone.getText())) {

            callback.onClickLogin(ui.edtLoginPhone.getText()
                    .toString(), ui.edtLoginPassowrd
                    .getText()
                    .toString(), isLoginAdmin);
        } else if (TextUtils.isEmpty(ui.edtLoginPhone.getText())) {
            ui.edtLoginPhone.setError("Nh???p username");
            ui.edtLoginPhone.requestFocus();
        } else {
            ui.edtLoginPassowrd.setError("Nh???p m???t kh???u");
            ui.edtLoginPassowrd.requestFocus();
        }
    }

    @Override
    public void showRootViewLogin() {
        setVisible(ui.layoutRootViewLogin);
    }

    @Override
    public void hideRootViewLogin() {
        setGone(ui.layoutRootViewLogin);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UiContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_login;
    }

    public static class UiContainer extends BaseUiContainer {

        @UiElement(R.id.layoutRootViewLogin)
        public View layoutRootViewLogin;

        @UiElement(R.id.edtLoginPhone)
        public EditText edtLoginPhone;

        @UiElement(R.id.edtLoginPassowrd)
        public EditText edtLoginPassowrd;

        @UiElement(R.id.btnVisiblePassword)
        public View btnVisiblePassword;

        @UiElement(R.id.btnLoginButton)
        public View btnLogin;

        @UiElement(R.id.btnShowRegisterForm)
        public View btnShowRegisterForm;

        @UiElement(R.id.btnForgotPassword)
        public View btnForgotPassword;


    }
}
