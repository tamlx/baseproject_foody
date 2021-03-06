package foody02.project.myapplication.ui.views.fragment.customer.dashboard;

import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.adapter.customer.RvHeaderDashboardAdapter;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ImageSlideModel;
import foody02.project.myapplication.model.customer.ProductModel;

public class FragmentDashboardView extends BaseView<FragmentDashboardView.UIContainer> implements FragmentDashboardViewInterface {

    HomeActivity activity;
    FragmentDashboardViewCallback callback;

    @Override
    public void init(HomeActivity activity, FragmentDashboardViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        setUpListDataDashboard();
    }

    @Override
    public void setDataImageSlide(ImageSlideModel[] data) {
        if (data != null && data.length > 0) {
            if (rvHeaderDashboardAdapter != null) {
                rvHeaderDashboardAdapter.setDataImageSlideCoupon(data);
            }
        }
    }

    @Override
    public void setDataProductHot(ArrayList<ProductModel> data) {
        if (rvHeaderDashboardAdapter != null) {
            rvHeaderDashboardAdapter.setDataProductHot(data);
        }

    }

    @Override
    public void setDataProductFreeShip(ArrayList<ProductModel> data) {
        if (rvHeaderDashboardAdapter != null) {
            rvHeaderDashboardAdapter.setDataProductNew(data);
        }
    }

    @Override
    public void setDataProductCategory(ArrayList<CategoryProductModel> arrDataCategory) {
        if (rvHeaderDashboardAdapter != null) {
            rvHeaderDashboardAdapter.setDataProductCategory(arrDataCategory);
        }
    }

    @Override
    public void setDataListProduct(ArrayList<ProductModel> data) {
        if (rvHeaderDashboardAdapter != null) {
            rvHeaderDashboardAdapter.setDataListProduct(data);
        }

//        callback.dismissProgressLoading();
    }

    private final ArrayList<ProductModel> listDataProduct = new ArrayList<>();

    private RvHeaderDashboardAdapter rvHeaderDashboardAdapter;

    private void setUpListDataDashboard() {
        ui.recycler_view_list_data_dashboard.getRecycledViewPool().clear();

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        ui.recycler_view_list_data_dashboard.setLayoutManager(gridLayoutManager);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return rvHeaderDashboardAdapter.isHeader(position) ? gridLayoutManager.getSpanCount() : 1;
            }
        });

        ui.recycler_view_list_data_dashboard.setHasFixedSize(true);

        rvHeaderDashboardAdapter = new RvHeaderDashboardAdapter(getContext());
        rvHeaderDashboardAdapter.setData(listDataProduct);
        rvHeaderDashboardAdapter.setListener(new RvHeaderDashboardAdapter.RvHeaderDashboardAdapterListener() {
            @Override
            public void onRequestLoadMoreProduct() {
//                callback.onRequestLoadMoreList();
            }

            @Override
            public void showBtnScrollUp() {
//                setVisible(ui.btnScrollUp);
            }

            @Override
            public void hideBtnScrollUp() {
//                setGone(ui.btnScrollUp);
            }

            @Override
            public void onClickShowMoreProductHot() {
                if (callback != null)
                    callback.showMoreProductHot();
            }

            @Override
            public void onClickShowMoreProductFreeShip() {
                if (callback != null)
                    callback.showMoreProductNew();
            }

            @Override
            public void onClickItem(ProductModel model, int position) {
//                activity.replaceFragment(new FragmentProductDetail().newIntance(model), true);
            }

            @Override
            public void setOnClickProductNew(ProductModel model) {
//                activity.replaceFragment(new FragmentProductDetail().newIntance(model), true);
            }

            @Override
            public void setOnClickProductHot(ProductModel item) {
//                activity.replaceFragment(new FragmentProductDetail().newIntance(item), true);
            }

            @Override
            public void setOnClickProductByCategory(CategoryProductModel model) {
                if (callback!=null) {
                    callback.showMoreProductCategory(model);
                }
            }
        });

        ui.recycler_view_list_data_dashboard.setAdapter(rvHeaderDashboardAdapter);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_dashboard;
    }

    public static class UIContainer extends BaseUiContainer {

        @UiElement(R.id.recycler_view_list_data_dashboard)
        public RecyclerView recycler_view_list_data_dashboard;

        @UiElement(R.id.btnNotificationHeaderDashboard)
        public ImageView btnNotificationHeaderDashboard;

    }
}
