package lxt.project.myapplication.ui.views.fragment.account.profile_manager;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;

public interface FragmentProfileManagerViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, FragmentProfileManagerViewCallback callback);

    void setDataUserImage(String outfile);

    void configTypeShowUpdateInfo(String type);
}
