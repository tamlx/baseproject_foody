package lxt.project.myapplication.ui.views.activity.base_main_activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import lxt.project.myapplication.R;

/**
 * Created by laixuantam on 7/6/17.
 */

public class BaseMainActivityView extends BaseView<BaseMainActivityView.UIContainer> implements BaseMainActivityViewInterface, View.OnClickListener {
    private BaseMainActivityViewCallback callback;

    @Override
    public void init(BaseMainActivityViewCallback callback) {
        this.callback = callback;

//        ui.rLayoutTabRecent.setOnClickListener(this);
//        ui.imvTabChatRecent.setOnClickListener(this);
//        ui.tvTabChatRecent.setOnClickListener(this);
//
//        ui.rLayoutTabContact.setOnClickListener(this);
//        ui.imvTabContact.setOnClickListener(this);
//        ui.tvTabContact.setOnClickListener(this);
//
//        ui.rLayoutTabProfile.setOnClickListener(this);
//        ui.imvTabProfile.setOnClickListener(this);
//        ui.tvTabProfile.setOnClickListener(this);
//
//        ui.rLayoutTabSeting.setOnClickListener(this);
//        ui.imvTabSetting.setOnClickListener(this);
//        ui.tvTabSetting.setOnClickListener(this);
    }

    @Override
    public void showToolBar() {
        setVisible(ui.layoutToolBar);
    }

    @Override
    public void hideToolBar() {
        setGone(ui.layoutToolBar);
    }

    @Override
    public void showTabControl() {
        setVisible(ui.rLayoutTabControl);
    }

    @Override
    public void hideTabControl() {
        setGone(ui.rLayoutTabControl);
    }

    @Override
    public void setupTabView(int pos) {
        clearTabView();
        switch (pos) {
//            case 1:
//                ui.imvTabChatRecent.setColorFilter(getColor(R.color.colorPrimary));
//                ui.tvTabChatRecent.setTextColor(getColor(R.color.colorPrimary));
//                break;
//
//            case 2:
//                ui.imvTabContact.setColorFilter(getColor(R.color.colorPrimary));
//                ui.tvTabContact.setTextColor(getColor(R.color.colorPrimary));
//                break;
//
//            case 3:
//                ui.imvTabProfile.setColorFilter(getColor(R.color.colorPrimary));
//                ui.tvTabProfile.setTextColor(getColor(R.color.colorPrimary));
//                break;
//
//            case 4:
//                ui.imvTabSetting.setColorFilter(getColor(R.color.colorPrimary));
//                ui.tvTabSetting.setTextColor(getColor(R.color.colorPrimary));
//
//                break;

        }
    }

    private void clearTabView() {
//        ui.imvTabChatRecent.setColorFilter(getColor(R.color.txt_default));
//        ui.tvTabChatRecent.setTextColor(getColor(R.color.txt_default));
//
//        ui.imvTabContact.setColorFilter(getColor(R.color.txt_default));
//        ui.tvTabContact.setTextColor(getColor(R.color.txt_default));
//
//        ui.imvTabProfile.setColorFilter(getColor(R.color.txt_default));
//        ui.tvTabProfile.setTextColor(getColor(R.color.txt_default));
//
//        ui.imvTabSetting.setColorFilter(getColor(R.color.txt_default));
//        ui.tvTabSetting.setTextColor(getColor(R.color.txt_default));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.rLayoutTabRecent:
//            case R.id.imvTabChatRecent:
//            case R.id.tvTabChatRecent:
//
//                setupTabView(1);
//                callback.reloadDataTab(1);
//
//                break;
//
//            case R.id.rLayoutTabContact:
//            case R.id.imvTabContact:
//            case R.id.tvTabContact:
//
//                setupTabView(2);
//                callback.reloadDataTab(2);
//
//                break;
//
//            case R.id.rLayoutTabProfile:
//            case R.id.imvTabProfile:
//            case R.id.tvTabProfile:
//
//                setupTabView(3);
//                callback.reloadDataTab(3);
//
//                break;
//
//            case R.id.rLayoutTabSeting:
//            case R.id.imvTabSetting:
//            case R.id.tvTabSetting:
//
//                setupTabView(4);
//                callback.reloadDataTab(4);
//
//                break;

        }


    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new BaseMainActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_base_container_and_toolbar;
    }

    public static class UIContainer extends BaseUiContainer {

        @UiElement(R.id.container)
        public FrameLayout container;

        @UiElement(R.id.layoutToolBar)
        public View layoutToolBar;

        @UiElement(R.id.rLayoutTabControl)
        public View rLayoutTabControl;

        //-----------------------tab attribute--------------------

//        @UiElement(R.id.rLayoutTabRecent)
//        public View rLayoutTabRecent;
//
//        @UiElement(R.id.imvTabChatRecent)
//        public ImageView imvTabChatRecent;
//
//        @UiElement(R.id.tvTabChatRecent)
//        public TextView tvTabChatRecent;
//
//        @UiElement(R.id.rLayoutTabContact)
//        public View rLayoutTabContact;
//
//        @UiElement(R.id.imvTabContact)
//        public ImageView imvTabContact;
//
//        @UiElement(R.id.tvTabContact)
//        public TextView tvTabContact;
//
//        @UiElement(R.id.rLayoutTabProfile)
//        public View rLayoutTabProfile;
//
//        @UiElement(R.id.imvTabProfile)
//        public ImageView imvTabProfile;
//
//        @UiElement(R.id.tvTabProfile)
//        public TextView tvTabProfile;
//
//        @UiElement(R.id.rLayoutTabSeting)
//        public View rLayoutTabSeting;
//
//        @UiElement(R.id.imvTabSetting)
//        public ImageView imvTabSetting;
//
//        @UiElement(R.id.tvTabSetting)
//        public TextView tvTabSetting;

        //----------------end tab attribute------------------------
    }
}
