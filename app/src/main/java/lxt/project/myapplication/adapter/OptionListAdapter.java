package lxt.project.myapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import b.laixuantam.myaarlibrary.helper.CurrencyFormater;
import b.laixuantam.myaarlibrary.widgets.superadapter.IMulItemViewType;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.pushdownanim.PushDownAnim;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.scaletouchlistener.ScaleTouchListener;
import lxt.project.myapplication.R;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.dialog.option.OptionModel;
import lxt.project.myapplication.helper.Consts;

public class OptionListAdapter extends SuperAdapter<OptionModel> {

    private final ArrayList<OptionModel> listData = new ArrayList<>();
    private final ArrayList<OptionModel> listDataBackup = new ArrayList<>();
    private final OptionListAdapterFilter filter;
    private OptionListAdapterListener listener;
    private OptionListType optionListType;

    public OptionListAdapter(Context context, List<OptionModel> items, OptionListType optionListType) {
        super(context, items, null);
        this.optionListType = optionListType;
        listDataBackup.addAll(items);
        filter = new OptionListAdapterFilter();
    }

    public interface OptionListAdapterListener {

        void onItemSelected(OptionModel item, int pos);

    }

    public void setOptionListType(OptionListType optionListType) {
        this.optionListType = optionListType;
    }

    public void setListener(OptionListAdapterListener listener) {
        this.listener = listener;
    }

    public ArrayList<OptionModel> getListData() {
        return listData;
    }

    public ArrayList<OptionModel> getListDataBackup() {
        return listDataBackup;
    }

    public OptionListAdapterFilter getFilter() {
        return filter;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, final int layoutPosition, final OptionModel item) {

        switch (viewType) {

            case 0:
                View rLayoutItemDefault = holder.findViewById(R.id.rLayoutItem);
                View imvStatusSelected = holder.findViewById(R.id.imvStatusSelected);
                TextView tvTitle = holder.findViewById(R.id.tvTitle);
                ImageView image = holder.findViewById(R.id.image);

                tvTitle.setText(item.getTitle());

                if (!TextUtils.isEmpty(item.getImage())) {
                    image.setVisibility(View.VISIBLE);
                    String imgProductLink = Consts.HOST_API + item.getImage();
                    AppProvider.getImageHelper().displayImage(imgProductLink, image, null, R.drawable.no_image_full);
                } else {
                    image.setVisibility(View.GONE);
                }

                imvStatusSelected.setVisibility(item.isSelected() ? View.VISIBLE : View.GONE);

                rLayoutItemDefault.setOnClickListener(new ScaleTouchListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onItemSelected(item, layoutPosition);
                        }
                    }
                });
                break;

        }
    }


    @Override
    protected IMulItemViewType<OptionModel> offerMultiItemViewType() {
        return new IMulItemViewType<OptionModel>() {
            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public int getItemViewType(int position, OptionModel model) {
//                if (optionListType == OptionListType.LIST_CUSTOMER) {
//                    return 1;
//                } else if (optionListType == OptionListType.LIST_CUSTOMER_LOAN) {
//                    return 2;
//                }
                return 0;
            }

            @Override
            public int getLayoutId(int viewType) {
//                if (viewType == 1) {
//                    return R.layout.sales_row_item_customer;
//                } else if (viewType == 2) {
//                    return R.layout.sales_row_item_customer_loan;
//                }
                return R.layout.row_item_option_default;
            }
        };
    }


    public class OptionListAdapterFilter extends Filter {
        OptionListAdapterFilter() {
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString;
            if (!TextUtils.isEmpty(constraint)) {
                filterString = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();
                if (listData != null && listData.size() > 0) {
                    int count = listData.size();
                    List<OptionModel> tempItems = new ArrayList<>();

                    // search exactly
                    for (int i = 0; i < count; i++) {
//                        if (optionListType == OptionListType.LIST_CUSTOMER) {
//
//                        } else {
                        String name = listData.get(i).getTitle().toLowerCase();
                        if (name.contains(filterString)) {
                            tempItems.add(listData.get(i));
                        }
//                        }
                    }
                    // search for no accent if no exactly result
//                    filterString = AccentRemove.removeAccent(filterString);
//                    if (tempItems.size() == 0) {
//                        for (int i = 0; i < count; i++) {
//                            String name = AccentRemove.removeAccent(listData.get(i).getTenSanPham().toLowerCase());
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
                return null;
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData.clear();
            if (results != null) {
                List<OptionModel> listProductResult = (List<OptionModel>) results.values;
                if (listProductResult != null && listProductResult.size() > 0) {
                    listData.addAll(listProductResult);
                }
            } else {
                listData.addAll(listDataBackup);
            }

            replaceAll(listData);
        }
    }

    public enum OptionListType {
        DEFAULT,
    }
}

