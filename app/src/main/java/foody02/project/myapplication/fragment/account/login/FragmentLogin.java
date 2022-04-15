package foody02.project.myapplication.fragment.account.login;

import android.content.Intent;

import java.util.Objects;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.KeyboardUtils;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginView;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginViewCallback;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginViewInterface;

public class FragmentLogin extends BaseFragment<LoginViewInterface, BaseParameters> implements LoginViewCallback {

    private HomeActivity activity;

    @Override
    protected void initialize() {
        view.initialize(this);
        activity = (HomeActivity) getActivity();
        KeyboardUtils.setupUI(Objects.requireNonNull(getView()), getActivity());


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected LoginViewInterface getViewInstance() {
        return new LoginView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }


    @Override
    public void onClickShowRegister() {
        if (activity != null) {
            activity.changeToFragmentRegister();

            handler.postDelayed(() -> view.hideRootViewLogin(), 700);
        }
    }

    @Override
    public void onClickLogin(String phone, String password, boolean isAdminLogin) {
        if (activity != null) {
            activity.changeToFragmentProductCategory();

            return;
        }
    }

}
