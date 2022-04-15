package foody02.project.myapplication.ui.views.fragment.account.register;


import foody02.project.myapplication.model.UserRegisterModel;

public interface FragmentRegisterViewCallback {
    void onClickBackHeader();

    void onClickShowLoginForm();

    void onSignUp(UserRegisterModel userRegisterModel);

    void onRequestCheckPhoneRegister(UserRegisterModel userRegisterModel);

}
