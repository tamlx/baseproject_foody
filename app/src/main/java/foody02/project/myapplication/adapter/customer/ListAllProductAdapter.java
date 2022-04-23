package foody02.project.myapplication.adapter.customer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import b.laixuantam.myaarlibrary.helper.AccentRemove;
import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import foody02.project.myapplication.R;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.helper.Consts;
import foody02.project.myapplication.model.customer.ProductModel;

public class ListAllProductAdapter extends SuperAdapter<ProductModel> {
    private ListLoadMoreProductAdapterListener listener;

    public interface ListLoadMoreProductAdapterListener {
        void setOnItemClick(ProductModel item);
    }

    public ListAllProductAdapter(Context context, List<ProductModel> items) {
        super(context, items, R.layout.row_item_product_vertical_dashboard);
        filter = new ProductCategoryFilter();
    }

    public void setListener(ListLoadMoreProductAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, final ProductModel item) {

        ImageView image_product_avatar = holder.findViewById(R.id.image_product_avatar);
        TextView text_product_name = holder.findViewById(R.id.text_product_name);
        RatingBar ratingBarProduct = holder.findViewById(R.id.ratingBarProduct);
        TextView text_product_price = holder.findViewById(R.id.text_product_price);
        View layoutItemProductDetail = holder.findViewById(R.id.layoutItemProductDetail);

        AppProvider.getImageHelper().displayImage(Consts.HOST_API + item.getProduct_image(), image_product_avatar, null, R.drawable.app_logo);
        text_product_name.setText(item.getName());
        text_product_price.setText(CurrencyFormater.formatCurrency(item.getProduct_price()));

        layoutItemProductDetail.setOnClickListener(v -> {
            if (listener != null)
                listener.setOnItemClick(item);
        });
    }

    private String filterString;
    private ArrayList<ProductModel> listData = new ArrayList<>();
    private ArrayList<ProductModel> listDataBackup = new ArrayList<>();
    private ProductCategoryFilter filter;

    public ProductCategoryFilter getFilter() {
        return filter;
    }

    public ArrayList<ProductModel> getListData() {
        return listData;
    }

    public ArrayList<ProductModel> getListDataBackup() {
        return listDataBackup;
    }

    public class ProductCategoryFilter extends Filter {
        public ProductCategoryFilter() {
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (!TextUtils.isEmpty(constraint)) {
                filterString = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();
                if (listData != null && listData.size() > 0) {
                    int count = listData.size();
                    List<ProductModel> tempItems = new ArrayList<ProductModel>();

                    // search exactly
                    for (int i = 0; i < count; i++) {
                        String name = listData.get(i).getName().toLowerCase();
                        if (name.contains(filterString)) {
                            tempItems.add(listData.get(i));
                        }
                    }
                    // search for no accent if no exactly result
//                    filterString = AccentRemove.removeAccent(filterString);
//                    if (tempItems.size() == 0) {
//                        for (int i = 0; i < count; i++) {
//                            String name = AccentRemove.removeAccent(listData.get(i).getName().toLowerCase());
//                            if (name.contains(filterString)) {
//                                tempItems.add(listData.get(i));
//                            }
//                        }
//                    }
                    results.values = tempItems;
                    results.count = tempItems.size();
                    return results;
                } else {
                    return null;
                }
            } else {
                filterString = "";
                return null;
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData.clear();
            if (results != null) {
                List<ProductModel> listProductResult = (List<ProductModel>) results.values;
                if (listProductResult != null && listProductResult.size() > 0) {
                    listData.addAll(listProductResult);
                }
            } else {
                listData.addAll(listDataBackup);
            }

            replaceAll(listData);
        }
    }
}