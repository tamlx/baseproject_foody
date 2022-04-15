package foody02.project.myapplication.ui.views.fragment.customer.listproduct_bycategory;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.adapter.customer.ListAllProductAdapter;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ProductModel;

public class FragmentAllProductByCategoryView extends BaseView<FragmentAllProductByCategoryView.UIContainer> implements FragmentAllProductByCategoryViewInterface {

    HomeActivity activity;
    FragmentAllProductByCategoryViewCallback callback;

    ArrayList<ProductModel> arrayList = new ArrayList<>();

    ListAllProductAdapter productAdapter;
    boolean enableLoadMore = true;

    @Override
    public void init(HomeActivity activity, FragmentAllProductByCategoryViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        setVisible(ui.btnShowCart);
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackPressed();
        });

        ui.btnShowCart.setOnClickListener(v -> {
            if (callback != null)
                 callback.onClickShowCart();
        });
        initRecycleview();
    }

    private void initRecycleview() {
        ui.recycler_view_list_data.getRecycledViewPool().clear();
        productAdapter = new ListAllProductAdapter(activity, arrayList);
        ui.recycler_view_list_data.setLayoutManager(new GridLayoutManager(activity, 2));
        ui.recycler_view_list_data.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
        productAdapter.setListener(new ListAllProductAdapter.ListLoadMoreProductAdapterListener() {
            @Override
            public void setOnItemClick(ProductModel item) {
                if (callback != null)
                    callback.onCLickProductDetail(item);
            }
        });
    }

    @Override
    public void setNoMoreLoading() {

    }

    @Override
    public void clearListDataProduct() {
        arrayList.clear();
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDataProductByCategory(ArrayList<ProductModel> data, CategoryProductModel model) {
        if (data == null || data.size() == 0) {
            if (arrayList.size() == 0) {
                showEmptyList();
            }
            return;
        }
        if (model != null) {
            ui.title_header.setText(model.getCategory_name());
        }
        arrayList.addAll(data);
        productAdapter.notifyDataSetChanged();
    }

    private void showEmptyList() {
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_all_product;
    }


    public class UIContainer extends BaseUiContainer {

        @UiElement(R.id.btnBackHeader)
        public View btnBackHeader;

        @UiElement(R.id.btnShowCart)
        public View btnShowCart;

        @UiElement(R.id.tvTitleHeader)
        public TextView title_header;

        @UiElement(R.id.recycler_view_list_data)
        public RecyclerView recycler_view_list_data;
    }
}
