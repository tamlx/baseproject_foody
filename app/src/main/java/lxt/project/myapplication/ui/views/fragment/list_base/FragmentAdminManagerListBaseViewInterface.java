package lxt.project.myapplication.ui.views.fragment.list_base;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.adapter.OptionListAdapter;
import lxt.project.myapplication.model.BaseResponseModel;

public interface FragmentAdminManagerListBaseViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentAdminManagerListBaseViewCallback callback);

    void showEmptyList();

    void hideEmptyList();

    void setDataList(BaseResponseModel dataList);

    void setDataListType(OptionListAdapter.OptionListType listType);

    void setNoMoreLoading();

    void resetListData();

    void hideRootView();

    void showRootView();

}
