package lxt.project.myapplication.ui.views.fragment.demo.collapsinglayout;

import android.graphics.Color;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import lxt.project.myapplication.R;

public class FragmentCollapsingDemoView extends BaseView<FragmentCollapsingDemoView.UIContainer> implements FragmentCollapsingDemoViewInterface {

    private int mMaskColor;

    @Override
    public void init() {
        ui.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

//                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
//                {
//                    //  Collapsed
//                    setVisible(ui.layoutFilterContent);
//
//                }
//                else
//                {
//                    //Expanded
//                    setGone(ui.layoutFilterContent);
//
//                }

                int absVerticalOffset = Math.abs(verticalOffset);
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int argb = Color.argb(absVerticalOffset, Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor));
                int argbDouble = Color.argb(absVerticalOffset * 2, Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor));
                int title_small_offset = (200 - absVerticalOffset) < 0 ? 0 : 200 - absVerticalOffset;
                int title_small_argb = Color.argb(title_small_offset * 2, Color.red(mMaskColor),
                        Color.green(mMaskColor), Color.blue(mMaskColor));
                if (absVerticalOffset <= totalScrollRange / 2) {
                    ui.include_toolbar_search.setVisibility(View.VISIBLE);
                    ui.include_toolbar_small.setVisibility(View.GONE);
                    //为了和下面的大图标渐变区分,乘以2倍渐变
                    ui.v_toolbar_search_mask.setBackgroundColor(argbDouble);
                } else {
                    ui.include_toolbar_search.setVisibility(View.GONE);
                    ui.include_toolbar_small.setVisibility(View.VISIBLE);
//                    ui.v_toolbar_small_mask.setBackgroundColor(title_small_argb);
                }

                ui.v_title_big_mask.setBackgroundColor(argb);
            }
        });

        mMaskColor = getContext().getResources().getColor(R.color.colorPrimary);
    }


    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.demo_layout_fragment_collapsing2;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.appBarLayout)
        public AppBarLayout appBarLayout;

//        @UiElement(R.id.layoutFilterContent)
//        public View layoutFilterContent;

        @UiElement(R.id.include_toolbar_search)
        public View include_toolbar_search;

        @UiElement(R.id.include_toolbar_small)
        public View include_toolbar_small;

        @UiElement(R.id.v_toolbar_search_mask)
        public View v_toolbar_search_mask;

        @UiElement(R.id.v_title_big_mask)
        public View v_title_big_mask;

        @UiElement(R.id.v_toolbar_small_mask)
        public View v_toolbar_small_mask;


    }
}
