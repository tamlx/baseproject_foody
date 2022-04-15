package ntkn.project.myapplication.model.customer;

import ntkn.project.myapplication.model.BaseResponseModel;

public class OrderDetailModel extends BaseResponseModel {

    private String product_detail_id;
    private String quantity;
    private String name;
    private String image;
    private String price_sell;

    public String getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(String product_detail_id) {
        this.product_detail_id = product_detail_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(String price_sell) {
        this.price_sell = price_sell;
    }

}
