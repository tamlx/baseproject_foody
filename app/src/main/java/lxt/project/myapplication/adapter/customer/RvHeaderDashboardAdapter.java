package lxt.project.myapplication.adapter.customer;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.mikhaellopez.hfrecyclerview.HFRecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import lxt.project.myapplication.R;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.model.customer.CategoryProductModel;
import lxt.project.myapplication.model.customer.ImageSlideModel;
import lxt.project.myapplication.model.customer.ProductModel;

public class RvHeaderDashboardAdapter extends HFRecyclerView<ProductModel> {

    private Context mContext;
    private Handler handler;

    public RvHeaderDashboardAdapter(Context context) {
        super(true, false);
        this.mContext = context;
        handler = new Handler();
    }

    private RvHeaderDashboardAdapterListener listener;

    public interface RvHeaderDashboardAdapterListener {
        void onRequestLoadMoreProduct();

        void showBtnScrollUp();

        void hideBtnScrollUp();

        void onClickShowMoreProductHot();

        void onClickShowMoreProductFreeShip();

        void onClickItem(ProductModel model, int position);

        void setOnClickProductNew(ProductModel item);

        void setOnClickProductHot(ProductModel item);

        void setOnClickProductByCategory(CategoryProductModel model);
    }

    public void setListener(RvHeaderDashboardAdapterListener listener) {
        this.listener = listener;
    }

    private ImageSlideModel[] dataSlideImages;

    public void setDataImageSlideCoupon(ImageSlideModel[] data) {
        this.dataSlideImages = data;
        notifyDataSetChanged();
    }

    private final ArrayList<ProductModel> dataProductHot = new ArrayList<>();

    public void setDataProductHot(ArrayList<ProductModel> data) {
        if (data == null || data.size() == 0) {
            if (dataProductHot.size() == 0) {
            }
            return;
        }
        for (ProductModel item : data) {
            dataProductHot.add(item);
//            notifyItemInserted(listDataProduct.size() - 1);
        }
        setData(dataProductHot);
        notifyDataSetChanged();
    }

    private final ArrayList<ProductModel> dataProductNew = new ArrayList<>();

    public void setDataProductNew(ArrayList<ProductModel> data) {
        if (data == null || data.size() == 0) {
            if (dataProductNew.size() == 0) {
            }
            return;
        }
        for (ProductModel item : data) {
            dataProductNew.add(item);
//            notifyItemInserted(listDataProduct.size() - 1);
        }
        setData(dataProductNew);
        notifyDataSetChanged();
    }

    private final ArrayList<CategoryProductModel> dataProductCategory = new ArrayList<>();

    public void setDataProductCategory(ArrayList<CategoryProductModel> data) {
        if (data == null || data.size() == 0) {
            if (dataProductCategory.size() == 0) {
            }
            return;
        }
        for (CategoryProductModel item : data) {
            dataProductCategory.add(item);
//            notifyItemInserted(listDataProduct.size() - 1);
        }
        notifyDataSetChanged();
    }

    //all product
    private final ArrayList<ProductModel> listDataProduct = new ArrayList<>();

    public void setDataListProduct(ArrayList<ProductModel> data) {

        if (data == null || data.size() == 0) {
            if (listDataProduct.size() == 0) {
            }
            return;
        }
        for (ProductModel item : data) {
            listDataProduct.add(item);
//            notifyItemInserted(listDataProduct.size() - 1);
        }
        setData(listDataProduct);
        notifyDataSetChanged();
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    protected RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        return new ItemViewHolder(inflater.inflate(R.layout.row_item_product_vertical_dashboard, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder getHeaderView(LayoutInflater inflater, ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(R.layout.layout_header_recyclerview_dashboard, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder getFooterView(LayoutInflater inflater, ViewGroup parent) {
        return null;
//        return new FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            if (listDataProduct.size() > (position - 1) && listDataProduct.get((position - 1)) != null) {
                itemViewHolder.bind(listDataProduct.get((position - 1)));
                if (position == listDataProduct.size() - 1) {
                    if (listener != null)
                        listener.onRequestLoadMoreProduct();
                }
                if (position > 5)
                    if (listener != null) {
                        listener.showBtnScrollUp();
                    }

                if (position < 1)
                    if (listener != null) {
                        listener.hideBtnScrollUp();
                    }
            }
        } else if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder itemHeaderView = (HeaderViewHolder) holder;
            itemHeaderView.bind();
        } else if (holder instanceof FooterViewHolder) {

        }
    }

    //region ViewHolder Header and Footer
    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image_product_avatar, btnProductFavorite;
        RatingBar ratingBarProduct;
        RoundRelativeLayout layoutItemProductDetail;
        RoundRelativeLayout btnAddItemToCart;
        LinearLayout layoutSaleOff;
        TextView text_product_name, text_product_price_discount, text_product_price, tvSaleOff;

        ItemViewHolder(View holder) {
            super(holder);
            text_product_name = holder.findViewById(R.id.text_product_name);
            image_product_avatar = holder.findViewById(R.id.image_product_avatar);
            btnProductFavorite = holder.findViewById(R.id.btnProductFavorite);
            ratingBarProduct = holder.findViewById(R.id.ratingBarProduct);
            text_product_price_discount = holder.findViewById(R.id.text_product_price_discount);
            text_product_price = holder.findViewById(R.id.text_product_price);
            layoutItemProductDetail = holder.findViewById(R.id.layoutItemProductDetail);
            btnAddItemToCart = holder.findViewById(R.id.btnAddItemToCart);
            layoutSaleOff = holder.findViewById(R.id.layoutSaleOff);
            tvSaleOff = holder.findViewById(R.id.tvSaleOff);
        }

        void bind(ProductModel itemProduct) {
            if (itemProduct == null)
                return;

            String pattern = "###,###.###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            AppProvider.getImageHelper().displayImage(Consts.HOST_API + itemProduct.getProduct_image(), image_product_avatar, null, R.drawable.no_image_full);
            text_product_name.setText(itemProduct.getName());

            //sale
            layoutSaleOff.setVisibility(View.GONE);

        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        ViewPager pager_slider_image_coupon;
        View layoutBannerCoupon;

        View btnSeeMoreProductHot, btnSeeMoreProductFreeShip, layoutEmptyListDataProductFreeShip, layoutEmptyListDataProductHot, layoutEmptyListDataProductCategory;

        RecyclerView rv_list_data_item_product_hot, rv_list_data_item_product_free_ship, rv_list_data_item_product_category;

        HeaderViewHolder(View itemView) {
            super(itemView);
            layoutBannerCoupon = itemView.findViewById(R.id.layoutBannerCoupon);
            pager_slider_image_coupon = itemView.findViewById(R.id.pager_slider_image_coupon);

            rv_list_data_item_product_hot = itemView.findViewById(R.id.rv_list_data_item_product_hot);
            rv_list_data_item_product_free_ship = itemView.findViewById(R.id.rv_list_data_item_product_free_ship);
            rv_list_data_item_product_category = itemView.findViewById(R.id.rv_list_data_item_product_category);

            btnSeeMoreProductHot = itemView.findViewById(R.id.btnSeeMoreProductHot);
            btnSeeMoreProductFreeShip = itemView.findViewById(R.id.btnSeeMoreProductFreeShip);

            layoutEmptyListDataProductHot = itemView.findViewById(R.id.layoutEmptyListDataProductHot);
            layoutEmptyListDataProductFreeShip = itemView.findViewById(R.id.layoutEmptyListDataProductFreeShip);
            layoutEmptyListDataProductCategory = itemView.findViewById(R.id.layoutEmptyListDataProductCategory);

            btnSeeMoreProductHot.setOnClickListener(view -> {
                if (listener != null)
                    listener.onClickShowMoreProductHot();
            });

            btnSeeMoreProductFreeShip.setOnClickListener(view -> {
                if (listener != null)
                    listener.onClickShowMoreProductFreeShip();
            });
        }

        void bind() {

            if (dataSlideImages != null && dataSlideImages.length > 0) {

                layoutBannerCoupon.setVisibility(View.VISIBLE);

                ArrayList<String> listImage = new ArrayList<>();

                for (ImageSlideModel itemSlide : dataSlideImages) {
                    listImage.add(itemSlide.getImage());
                }

                NUM_PAGES_SLIDE_COUPON = listImage.size();
                SlidingImage_Adapter slidingImage_adapter = new SlidingImage_Adapter(mContext, SlidingImage_Adapter.SliderImageType.LINK);
                slidingImage_adapter.setIMAGE_LINK(listImage);
                pager_slider_image_coupon.setAdapter(slidingImage_adapter);

                if (!isStartLoopingSlideCoupon) {
                    isStartLoopingSlideCoupon = true;
                    handler.post(loopSliderImageCoupon);
                }

            } else {
                layoutBannerCoupon.setVisibility(View.GONE);
            }

            //bind data list product hot
            if (dataProductHot != null && dataProductHot.size() > 0) {
                GridLayoutManager horizontalManagerProductHot = new GridLayoutManager(getContext(), 1, LinearLayoutManager.HORIZONTAL, false);

                rv_list_data_item_product_hot.setLayoutManager(horizontalManagerProductHot);

                rv_list_data_item_product_hot.setHasFixedSize(true);

                rv_list_data_item_product_hot.setNestedScrollingEnabled(false);

                layoutEmptyListDataProductHot.setVisibility(View.GONE);
                rv_list_data_item_product_hot.setVisibility(View.VISIBLE);

                ArrayList<ProductModel> listDataProdcutHot = new ArrayList<>();
                listDataProdcutHot.addAll(dataProductHot);

                ListProductHorizontalAdapter listProductHotAdapter = new ListProductHorizontalAdapter(getContext(), listDataProdcutHot);
                rv_list_data_item_product_hot.setAdapter(listProductHotAdapter);
                listProductHotAdapter.setListener(new ListProductHorizontalAdapter.ListProductHorizontalAdapterListener() {
                    @Override
                    public void setOnItemClick(ProductModel item) {
                        if (listener != null)
                            listener.setOnClickProductHot(item);
                    }
                });


            } else {
                layoutEmptyListDataProductHot.setVisibility(View.VISIBLE);
                rv_list_data_item_product_hot.setVisibility(View.GONE);
            }

            //bind data list product free ship
            if (dataProductNew != null && dataProductNew.size() > 0) {
                layoutEmptyListDataProductFreeShip.setVisibility(View.GONE);
                rv_list_data_item_product_free_ship.setVisibility(View.VISIBLE);

                GridLayoutManager horizontalManagerProductFreeShip = new GridLayoutManager(getContext(), 1, LinearLayoutManager.HORIZONTAL, false);

                rv_list_data_item_product_free_ship.setLayoutManager(horizontalManagerProductFreeShip);

                rv_list_data_item_product_free_ship.setHasFixedSize(true);

                rv_list_data_item_product_free_ship.setNestedScrollingEnabled(false);

                ArrayList<ProductModel> listDataProdcutFreeship = new ArrayList<>();
                listDataProdcutFreeship.addAll(dataProductNew);

                ListProductHorizontalAdapter listProductFreeshipAdapter = new ListProductHorizontalAdapter(getContext(), listDataProdcutFreeship);
                listProductFreeshipAdapter.setListener(new ListProductHorizontalAdapter.ListProductHorizontalAdapterListener() {
                    @Override
                    public void setOnItemClick(ProductModel item) {
                        if (listener != null)
                            listener.setOnClickProductNew(item);
                    }
                });

                rv_list_data_item_product_free_ship.setAdapter(listProductFreeshipAdapter);

            } else {
                layoutEmptyListDataProductFreeShip.setVisibility(View.VISIBLE);
                rv_list_data_item_product_free_ship.setVisibility(View.GONE);
            }

            //bind data list product category
            if (dataProductCategory != null && dataProductCategory.size() > 0) {
                layoutEmptyListDataProductCategory.setVisibility(View.GONE);
                rv_list_data_item_product_category.setVisibility(View.VISIBLE);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rv_list_data_item_product_category.setLayoutManager(linearLayoutManager);

                ArrayList<CategoryProductModel> listCategoryProduct = new ArrayList<>();
                listCategoryProduct.addAll(dataProductCategory);

                ListCategoryProductAdapter listCategoryProductAdapter = new ListCategoryProductAdapter(getContext(), listCategoryProduct);
                listCategoryProductAdapter.setListener(new ListCategoryProductAdapter.ListCategoryProductAdapterListener() {
                    @Override
                    public void onItemCategoryProductClick(CategoryProductModel item) {
                        if (listener != null)
                            listener.setOnClickProductByCategory(item);
                    }
                });
                rv_list_data_item_product_category.setAdapter(listCategoryProductAdapter);

            } else {
                layoutEmptyListDataProductCategory.setVisibility(View.VISIBLE);
                rv_list_data_item_product_category.setVisibility(View.GONE);
            }
        }

        private int currentPageSlideCoupon = 0;
        private int NUM_PAGES_SLIDE_COUPON = 0;

        private final Runnable loopSliderImageCoupon = new Runnable() {
            public void run() {
                if (currentPageSlideCoupon == NUM_PAGES_SLIDE_COUPON) {
                    currentPageSlideCoupon = 0;
                }
                pager_slider_image_coupon.setCurrentItem(currentPageSlideCoupon++, true);
                handler.postDelayed(this, 3000);
            }
        };

    }

    private boolean isStartLoopingSlideCoupon = false;

    class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
    //endregion


    private Context getContext() {
        return mContext;
    }


}
