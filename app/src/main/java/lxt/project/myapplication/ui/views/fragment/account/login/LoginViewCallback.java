
package lxt.project.myapplication.ui.views.fragment.account.login;

//import com.facebook.AccessToken;

public interface LoginViewCallback
{
    void onClickLogin(String username, String password, boolean isLoginAdmin);

    void onClickShowRegister();

    void onClickBackHeader();

}
