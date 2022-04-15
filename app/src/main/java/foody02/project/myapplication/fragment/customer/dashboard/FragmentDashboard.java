package foody02.project.myapplication.fragment.customer.dashboard;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.fragment.customer.listproduct_bycategory.FragmentAllProductByCategory;
import foody02.project.myapplication.model.customer.CategoryProductModel;
import foody02.project.myapplication.model.customer.ImageSlideModel;
import foody02.project.myapplication.model.customer.ProductModel;
import foody02.project.myapplication.ui.views.fragment.customer.dashboard.FragmentDashboardView;
import foody02.project.myapplication.ui.views.fragment.customer.dashboard.FragmentDashboardViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.dashboard.FragmentDashboardViewInterface;

public class FragmentDashboard extends BaseFragment<FragmentDashboardViewInterface, BaseParameters> implements FragmentDashboardViewCallback {

    private HomeActivity activity;

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);

        requestGetSlideHeader();
        requestGetProductHot();
        requestGetProductFreeShip();
        requestGetProductCategory();
        requestGetProduct();
    }

    private void requestGetProduct() {
        ArrayList<ProductModel> list = new ArrayList<>();
        for(int i = 0 ; i < 10; i ++){
            ProductModel model = new ProductModel();
            model.setId(""+i);
            model.setName("Product " + i);
            model.setProduct_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(model);
        }
        view.setDataListProduct(list);
    }

    private void requestGetProductCategory() {
        ArrayList<CategoryProductModel> list = new ArrayList<>();

        for(int i = 0 ; i < 5; i ++){
            CategoryProductModel model = new CategoryProductModel();
            model.setId_category(""+i);
            model.setCategory_name("category " + i);
            model.setTotal_product(""+i);
            model.setCategory_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(model);
        }
        view.setDataProductCategory(list);
    }

    private void requestGetProductFreeShip() {
        ArrayList<ProductModel> list = new ArrayList<>();
        for(int i = 0 ; i < 10; i ++){
            ProductModel model = new ProductModel();
            model.setId(""+i);
            model.setName("Product " + i);
            model.setProduct_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(model);
        }
        view.setDataProductFreeShip(list);
    }

    private void requestGetProductHot() {
        ArrayList<ProductModel> list = new ArrayList<>();
        for(int i = 0 ; i < 10; i ++){
            ProductModel model = new ProductModel();
            model.setId(""+i);
            model.setName("Product " + i);
            model.setProduct_image("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");
            list.add(model);
        }
        view.setDataProductHot(list);
    }


    private void requestGetSlideHeader() {

        ImageSlideModel[] arrSlideFake = new ImageSlideModel[4];

        ImageSlideModel model1 = new ImageSlideModel();
        model1.setImage("https://internetofbusiness.com/wp-content/uploads/2018/03/Lamborghini-Egoista-LF-3-4-HERO-640x354.jpg");

        ImageSlideModel model2 = new ImageSlideModel();
        model2.setImage("https://www.topgear.com/sites/default/files/images/news-article/carousel/2018/01/257f6643d5128765c9381fba72aa3c69/2bc8e460427441.5a4cdc300deb9.jpg?w=892&h=502");


        ImageSlideModel model3 = new ImageSlideModel();
        model3.setImage("https://www.topgear.com/sites/default/files/images/news-article/carousel/2018/01/257f6643d5128765c9381fba72aa3c69/0017d160427441.5a4cdc300f4c3.jpg?w=892&h=502");

        ImageSlideModel model4 = new ImageSlideModel();
        model4.setImage("https://www.topgear.com/sites/default/files/images/news-article/carousel/2018/01/257f6643d5128765c9381fba72aa3c69/d0dce960427441.5a4cdc300d8b7.jpg?w=892&h=502");

        arrSlideFake[0] = model1;
        arrSlideFake[1] = model2;
        arrSlideFake[2] = model3;
        arrSlideFake[3] = model4;

        view.setDataImageSlide(arrSlideFake);
    }


    @Override
    protected FragmentDashboardViewInterface getViewInstance() {
        return new FragmentDashboardView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void showMoreProductHot() {
    }

    @Override
    public void showMoreProductNew() {
    }

    @Override
    public void showMoreProductCategory(CategoryProductModel model) {
        if (activity!=null){
            activity.replaceFragment(new FragmentAllProductByCategory().newIntance(model), true);

        }
    }

    @Override
    public void goToShopCart() {
//        if (activity != null) {
//            activity.replaceFragment(new FragmentLayoutCart(), true);
//        }
    }
}
