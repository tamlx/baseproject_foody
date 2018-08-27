package lxt.project.myapplication.ui.views.action_bar.base_main_actionbar;

import android.support.annotation.ColorRes;

import b.laixuantam.myaarlibrary.base.BaseActionbarView;


/**
 * Created by laixuantam on 23/7/18.
 */

public interface BaseMainActionbarViewInterface extends BaseActionbarView
{
    void initialize(String title, BaseMainActionbarViewCallback callback);

    void setActionbarColor(@ColorRes int resId);

    void setTitle(String title);

    void showActionbar();

    void hideActionbar();

    void showButtonLeftActionBar();

    void hideButtonLeftActionBar();

    void showButtonRightActionBar();

    void hideButtonRightActionBar();

    void showLayoutFilter();

    void hideLayoutFilter();

}
