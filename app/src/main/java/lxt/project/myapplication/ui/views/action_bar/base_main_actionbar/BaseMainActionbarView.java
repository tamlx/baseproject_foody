package lxt.project.myapplication.ui.views.action_bar.base_main_actionbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import lxt.project.myapplication.R;

/**
 * Created by laixuantam on 23/7/18.
 */

public class BaseMainActionbarView extends BaseView<BaseMainActionbarView.UIContainer> implements BaseMainActionbarViewInterface, View.OnClickListener {

    private BaseMainActionbarViewCallback callback;

    private boolean showFilter = false;

    @Override
    public void initialize(String title, final BaseMainActionbarViewCallback callback) {
        this.callback = callback;

        setTitle(title);

        ui.btnLeftActionBar.setOnClickListener(this);
        ui.btnRightActionBar.setOnClickListener(this);

//        ui.buttonBackFilter.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                showFilter = false;
//                toggleFilter();
//            }
//        });

        ui.buttonClear.setOnClickListener(this);

        ui.editFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                callback.onFiltering(s.toString());
            }
        });
    }


    @Override
    public void setSubtitle(String subtitle) {

        setVisible(ui.subtitle);
        ui.subtitle.setText(subtitle);

    }

    @Override
    public void showLayoutFilter() {
        setVisible(ui.layoutFilter);
    }

    @Override
    public void hideLayoutFilter() {
        setGone(ui.layoutFilter);
    }

    private void toggleFilter() {
        ui.editFilter.setText("");
        if (showFilter) {
            setGone(ui.layout_actionbar);
            setVisible(ui.layoutFilter);
            ui.editFilter.requestFocus();
            AppUtils.showKeyboard(ui.editFilter);
        } else {
            setVisible(ui.layout_actionbar);
            setGone(ui.layoutFilter);
            ui.editFilter.clearFocus();
            AppUtils.hideKeyBoard(ui.editFilter);
        }
        callback.onFilterToggle(showFilter);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnLeftActionBar:

                break;

            case R.id.btnRightActionBar:

                break;

            case R.id.button_clear:
                ui.editFilter.setText("");
                break;
        }

    }

    @Override
    public void setActionbarColor(int resId) {
        ui.layout_actionbar.setBackgroundColor(getColor(resId));
    }

    @Override
    public void showActionbar() {
        setVisible(ui.layout_actionbar);
    }

    @Override
    public void hideActionbar() {
        setGone(ui.layout_actionbar);
    }

    @Override
    public void setTitle(String title) {
        ui.title.setText(title);
    }

    @Override
    public void showButtonLeftActionBar() {
        setVisible(ui.btnLeftActionBar);
    }

    @Override
    public void hideButtonLeftActionBar() {
        setGone(ui.btnLeftActionBar);
    }

    @Override
    public void showButtonRightActionBar() {
        setVisible(ui.btnRightActionBar);
    }

    @Override
    public void hideButtonRightActionBar() {
        setGone(ui.btnRightActionBar);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new BaseMainActionbarView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_base_main_actionbar_view;
    }

    public static class UIContainer extends BaseUiContainer {

        @UiElement(R.id.layout_actionbar)
        public RelativeLayout layout_actionbar;

        @UiElement(R.id.title)
        public TextView title;

        @UiElement(R.id.subtitle)
        public TextView subtitle;

        @UiElement(R.id.btnLeftActionBar)
        public View btnLeftActionBar;

        @UiElement(R.id.btnRightActionBar)
        public View btnRightActionBar;

        @UiElement(R.id.layout_filter)
        public View layoutFilter;

        @UiElement(R.id.button_back_filter)
        public View buttonBackFilter;

        @UiElement(R.id.button_clear)
        public View buttonClear;

        @UiElement(R.id.edit_filter)
        public EditText editFilter;

    }


}
