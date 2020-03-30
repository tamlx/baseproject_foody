package lxt.project.myapplication.ui.views.fragment.account.password_manager;

public interface FragmentPasswordManagerViewCallback {
    void onClickBackHeader();

    void onSubmitChangePassword(String oldPassword, String newPass);

    void onClickForgotPassword();
}
