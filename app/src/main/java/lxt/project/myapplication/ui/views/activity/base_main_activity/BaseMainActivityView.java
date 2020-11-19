package lxt.project.myapplication.ui.views.activity.base_main_activity;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hk.kbottomnavigation.KBottomNavigation;
import com.simform.custombottomnavigation.SSCustomBottomNavigation;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import b.laixuantam.myaarlibrary.widgets.bottomnavigationbar.BottomItem;
import b.laixuantam.myaarlibrary.widgets.bottomnavigationbar.BottomNavigationBar;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.scaletouchlistener.ScaleTouchListener;
import b.laixuantam.myaarlibrary.widgets.tutorial.TutorialModel;
import b.laixuantam.myaarlibrary.widgets.tutorial.TutorialView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import lxt.project.myapplication.R;
import lxt.project.myapplication.activity.DemoSingleActivity;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.model.UserResponseModel;
import lxt.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

//import b.laixuantam.myaarlibrary.widgets.bottomnavigationbar.BottomNavigationBar;

public class BaseMainActivityView extends BaseView<BaseMainActivityView.UIContainer> implements BaseMainActivityViewInterface {
    private HomeActivityViewCallback homeActivityViewCallback;
    private String mPackageName;

    @Override
    public void init(final BaseMainActivityViewCallback callback) {

        mPackageName = getContext().getApplicationInfo().packageName;

        ui.warning_confirm_test.setOnTouchListener(new ScaleTouchListener(confScaleTouch) {
            @Override
            public void onClick(View v) {
                callback.onClickButtonAlert();
            }
        });

        configKBottomNavigation();
        configSSCustomBottomNavigation();
    }

    @Override
    public void init(HomeActivity activity, HomeActivityViewCallback callback) {
        homeActivityViewCallback = callback;
        mPackageName = getContext().getApplicationInfo().packageName;
//        configBottomMenuBar();

    }

    @Override
    public void toggleMenuNavigation() {
        if (isDrawerOpen()) {
            ui.drawer.closeDrawer(GravityCompat.START);
        } else {
            ui.drawer.openDrawer(GravityCompat.START);
        }
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
    public void configLayoutBaseMainActivity() {
        setVisible(ui.LayoutBaseMainActivity);
        setGone(ui.LayoutBaseMainFragmentActivity);
    }

    @Override
    public void configLayoutBaseMainFragmentActivity() {
        setGone(ui.LayoutBaseMainActivity);
        setVisible(ui.LayoutBaseMainFragmentActivity);
    }

    @Override
    public void showMenuNavigation() {
        setVisible(ui.navView);
    }

    @Override
    public void hideMenuNavigation() {
        setGone(ui.navView);
    }

    private void setUpViewControll() {

        ScaleTouchListener.Config conf = new ScaleTouchListener.Config(100, 1f, 0.5f);

        reloadMenuNavigation();
    }

    @Override
    public void reloadMenuNavigation() {
        UserResponseModel userResponseModel = AppProvider.getPreferences().getUserModel();
        if (userResponseModel != null) {
            ui.bnb_menu_control.setTitleItem(4, userResponseModel.getFirst_name());
        } else {
            ui.bnb_menu_control.setTitleItem(4, "Tôi");
        }
    }

    @Override
    public void setDrawerEnabled(boolean enabled) {
        int lockMode = enabled ? DrawerLayout.LOCK_MODE_UNLOCKED :
                DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
        ui.drawer.setDrawerLockMode(lockMode);
    }

    @Override
    public void openDrawer() {
        AppUtils.hideKeyBoard(getView());

        ui.drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        if (isDrawerOpen()) {
            ui.drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean isDrawerOpen() {
        return ui.drawer.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void setNavigationItemSelected(int id) {
        ui.navView.setCheckedItem(id);
    }

    @Override
    public void clearNavigationItemSelected() {
        ui.navView.setSelected(false);
    }

    @Override
    public void showTutorial(TutorialModel tutorial, TutorialView.TutorialListener listener) {
        ui.tutorialView.setVisibility(View.VISIBLE);
        ui.tutorialView.setListener(listener);
        ui.tutorialView.showTutorialDelay(tutorial);
    }

    @Override
    public void showBottomMenuBar() {
        setVisible(ui.bnb_menu_control);
    }

    @Override
    public void setBadgeCart(int countItemOrder) {
        setBadgeNumberBottomMenu(1, countItemOrder);
    }

    @Override
    public void setBadgePromotionCart(int countItemOrder) {
        setBadgeNumberBottomMenu(3, countItemOrder);
    }

    @Override
    public void setBadgeNumberBottomMenu(int pos, int value) {
        ui.bnb_menu_control.setBadgeNumber(pos, value);
    }

    @Override
    public void hideBottomMenuBar() {
        setGone(ui.bnb_menu_control);
    }

    @Override
    public void setBottomMenuBarPossitionSelected(int pos) {
        if (ui.bnb_menu_control != null) {
            ui.bnb_menu_control.setSelectedPosition(pos);
        }
    }

    private void configSSCustomBottomNavigation() {
        //https://github.com/SimformSolutionsPvtLtd/SSCustomBottomNavigation

        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(1, R.drawable.ic_home, "Home"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(2, R.drawable.ic_notification, "Notify"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(3, R.drawable.ic_explore, "Explore"));

        ui.layout_SSCustomBottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
//                    Toast.makeText(getContext(), "Click Item 1", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
//                    Toast.makeText(getContext(), "Click Item 2", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
//                    Toast.makeText(getContext(), "Click Item 3", Toast.LENGTH_SHORT).show();
                    break;

            }
            return null;
        });

        ui.layout_SSCustomBottomNavigation.show(1, true);
    }

    private void configKBottomNavigation() {

        //https://github.com/hamzaahmedkhan/KBottomNavigation
        ui.layout_KBottomNavigation.add(new KBottomNavigation.Model(1, R.drawable.ic_home));
        ui.layout_KBottomNavigation.add(new KBottomNavigation.Model(2, R.drawable.ic_notification));
        ui.layout_KBottomNavigation.add(new KBottomNavigation.Model(3, R.drawable.ic_explore));

        ui.layout_KBottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
//                    Toast.makeText(getContext(), "Click Item 1", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
//                    Toast.makeText(getContext(), "Click Item 2", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
//                    Toast.makeText(getContext(), "Click Item 3", Toast.LENGTH_SHORT).show();
                    break;

            }
            return null;
        });

        ui.layout_KBottomNavigation.show(1, true);
    }

    private void configBottomMenuBar() {

        BottomItem item_home = new BottomItem();
//        item_home.setText("Trang chủ");
        item_home.setTextSize(11);
        item_home.setInactiveIconResID(getContext().getResources().getIdentifier("ic_home", "drawable", mPackageName));
        item_home.setActiveIconResID(getContext().getResources().getIdentifier("ic_home_active", "drawable", mPackageName));
        item_home.setActiveTextColor(Color.parseColor("#023373"));
        item_home.setInactiveTextColor(Color.parseColor("#d9d9d9"));
        item_home.setMode(BottomItem.DRAWABLE_MODE);

        BottomItem item_shopping_cart = new BottomItem();
//        item_shopping_cart.setText("Giỏ hàng");
        item_shopping_cart.setTextSize(11);
        item_shopping_cart.setInactiveIconResID(getContext().getResources().getIdentifier("ic_shopping_cart", "drawable", mPackageName));
        item_shopping_cart.setActiveIconResID(getContext().getResources().getIdentifier("ic_shopping_cart_active", "drawable", mPackageName));
        item_shopping_cart.setActiveTextColor(Color.parseColor("#023373"));
        item_shopping_cart.setInactiveTextColor(Color.parseColor("#d9d9d9"));
        item_shopping_cart.setMode(BottomItem.DRAWABLE_MODE);

        BottomItem item_order = new BottomItem();
//        item_order.setText("Đơn hàng");
        item_order.setTextSize(11);
        item_order.setInactiveIconResID(getContext().getResources().getIdentifier("ic_order", "drawable", mPackageName));
        item_order.setActiveIconResID(getContext().getResources().getIdentifier("ic_order_active", "drawable", mPackageName));
        item_order.setActiveTextColor(Color.parseColor("#023373"));
        item_order.setInactiveTextColor(Color.parseColor("#d9d9d9"));
        item_order.setMode(BottomItem.DRAWABLE_MODE);

        BottomItem item_transaction = new BottomItem();
//        item_transaction.setText("Giao dịch");
        item_transaction.setTextSize(11);
        item_transaction.setInactiveIconResID(getContext().getResources().getIdentifier("ic_transaction", "drawable", mPackageName));
        item_transaction.setActiveIconResID(getContext().getResources().getIdentifier("ic_transaction_active", "drawable", mPackageName));
        item_transaction.setActiveTextColor(Color.parseColor("#023373"));
        item_transaction.setInactiveTextColor(Color.parseColor("#d9d9d9"));
        item_transaction.setMode(BottomItem.DRAWABLE_MODE);

        BottomItem item_user_account = new BottomItem();
        UserResponseModel userResponseModel = AppProvider.getPreferences().getUserModel();
//        item_user_account.setText("Tôi");

        item_user_account.setTextSize(11);
        item_user_account.setInactiveIconResID(getContext().getResources().getIdentifier("man_user", "drawable", mPackageName));
        item_user_account.setActiveIconResID(getContext().getResources().getIdentifier("man_user_red", "drawable", mPackageName));
        item_user_account.setActiveTextColor(Color.parseColor("#023373"));
        item_user_account.setInactiveTextColor(Color.parseColor("#d9d9d9"));
        item_user_account.setMode(BottomItem.DRAWABLE_MODE);

        ui.bnb_menu_control.addItem(item_home);
        ui.bnb_menu_control.addItem(item_shopping_cart);
        ui.bnb_menu_control.addItem(item_order);
        ui.bnb_menu_control.addItem(item_transaction);
        ui.bnb_menu_control.addItem(item_user_account);

        ui.bnb_menu_control.initialize();

        ui.bnb_menu_control.addOnSelectedListener((oldPosition, newPosition) -> {

            if (newPosition != oldPosition) {
                switch (newPosition) {
                    case 0:
                        //change to fragment home
                        homeActivityViewCallback.onClickBottomBarMenuHome();
                        break;

                    case 1:
                        //change to fragment shoping-cart
                        homeActivityViewCallback.onClickBottomBarMenuShoppingCart();

                        break;

                    case 2:
                        //change to fragment order
                        homeActivityViewCallback.onClickBottomBarMenuOrder();
                        break;

                    case 3:
                        //change to fragment Transaction
                        homeActivityViewCallback.onClickBottomBarMenuTransaction();
                        break;

                    case 4:
                        //change to fragment user_account
                        homeActivityViewCallback.onClickBottomBarMenuAccount();
                        break;
                }
            }

        });
        reloadMenuNavigation();
    }


    @Override
    public void hideTutorial() {
        ui.tutorialView.setVisibility(View.GONE);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new BaseMainActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_base_main_activity_view;
    }

    public static class UIContainer extends BaseUiContainer {

        @UiElement(R.id.drawer_layout)
        public DrawerLayout drawer;

        @UiElement(R.id.nav_view)
        public NavigationView navView;

        @UiElement(R.id.tutorial)
        public TutorialView tutorialView;

        @UiElement(R.id.layoutToolBar)
        public View layoutToolBar;

        @UiElement(R.id.LayoutBaseMainFragmentActivity)
        public FrameLayout LayoutBaseMainFragmentActivity;

        @UiElement(R.id.bnb_menu_control)
        public BottomNavigationBar bnb_menu_control;

        @UiElement(R.id.LayoutBaseMainActivity)
        public View LayoutBaseMainActivity;

        @UiElement(R.id.warning_confirm_test)
        public View warning_confirm_test;

        @UiElement(R.id.layout_SSCustomBottomNavigation)
        public SSCustomBottomNavigation layout_SSCustomBottomNavigation;

        @UiElement(R.id.layout_KBottomNavigation)
        public KBottomNavigation layout_KBottomNavigation;



    }
}
