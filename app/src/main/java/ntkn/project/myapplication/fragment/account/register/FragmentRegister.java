package ntkn.project.myapplication.fragment.account.register;

import java.util.Objects;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.KeyboardUtils;
import ntkn.project.myapplication.activity.HomeActivity;
import ntkn.project.myapplication.model.UserRegisterModel;
import ntkn.project.myapplication.ui.views.fragment.account.register.FragmentRegisterView;
import ntkn.project.myapplication.ui.views.fragment.account.register.FragmentRegisterViewCallback;
import ntkn.project.myapplication.ui.views.fragment.account.register.FragmentRegisterViewInterface;

public class FragmentRegister extends BaseFragment<FragmentRegisterViewInterface, BaseParameters> implements FragmentRegisterViewCallback {

    private HomeActivity activity;

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);

        KeyboardUtils.setupUI(Objects.requireNonNull(getView()), activity);
    }

    @Override
    protected FragmentRegisterViewInterface getViewInstance() {
        return new FragmentRegisterView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onClickBackHeader() {
        if (activity != null) {
            activity.checkBack();
        }
    }

    @Override
    public void onClickShowLoginForm() {
        if (activity != null) {
            activity.checkBack();
        }
    }

    @Override
    public void onSignUp(UserRegisterModel userRegisterModel) {

        showToast("Đăng ký thành công!");
        if (activity != null) {
            activity.changeToFragmentProductCategory();

            return;
        }

    }

    @Override
    public void onRequestCheckPhoneRegister(UserRegisterModel registerModel) {

    }

}
