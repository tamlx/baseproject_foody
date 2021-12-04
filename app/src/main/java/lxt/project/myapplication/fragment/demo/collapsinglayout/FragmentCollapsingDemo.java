package lxt.project.myapplication.fragment.demo.collapsinglayout;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import lxt.project.myapplication.ui.views.fragment.demo.collapsinglayout.FragmentCollapsingDemoView;
import lxt.project.myapplication.ui.views.fragment.demo.collapsinglayout.FragmentCollapsingDemoViewInterface;

public class FragmentCollapsingDemo extends BaseFragment<FragmentCollapsingDemoViewInterface, BaseParameters> {

    @Override
    protected void initialize() {
        view.init();
    }

    @Override
    protected FragmentCollapsingDemoViewInterface getViewInstance() {
        return new FragmentCollapsingDemoView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
