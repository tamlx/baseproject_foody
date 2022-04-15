package foody02.project.myapplication.ui.views.fragment.customer.category;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.adapter.customer.ListCategoryProductAdapter;
import foody02.project.myapplication.model.customer.CategoryProductModel;

public class FragmentProductCategoryView extends BaseView<FragmentProductCategoryView.UIContainer> implements FragmentProductCategoryViewInterface {
    HomeActivity activity;
    FragmentProductCategoryViewCallback callback;

    @Override
    public void init(HomeActivity activity, FragmentProductCategoryViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        ui.title_header.setText("Danh mục");

        setGone(ui.btnBackHeader);
        setVisible(ui.btnShowCart);
        ui.btnShowCart.setOnClickListener(v -> {
            if (callback != null)
                callback.onClickShowCart();
        });
    }

    @Override
    public void setDataProductCategory(ArrayList<CategoryProductModel> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ui.recycler_view_list.setLayoutManager(linearLayoutManager);
        ListCategoryProductAdapter listCategoryProductAdapter = new ListCategoryProductAdapter(getContext(), list);
        ui.recycler_view_list.setAdapter(listCategoryProductAdapter);

        listCategoryProductAdapter.setListener(new ListCategoryProductAdapter.ListCategoryProductAdapterListener() {
            @Override
            public void onItemCategoryProductClick(CategoryProductModel item) {
                if (callback != null) {
                    callback.showMoreProductCategory(item);
                }
            }
        });
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_product_category;
    }


    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public View btnBackHeader;

        @UiElement(R.id.btnShowCart)
        public View btnShowCart;

        @UiElement(R.id.tvTitleHeader)
        public TextView title_header;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

    }
}
