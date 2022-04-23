package foody02.project.myapplication.model.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderHistoryDetailModel implements Serializable {
    private ArrayList<OrderDetailModel> PRODUCT_CHOOSE_MODELS;

    public ArrayList<OrderDetailModel> getPRODUCT_CHOOSE_MODELS() {
        return PRODUCT_CHOOSE_MODELS;
    }

    public void setPRODUCT_CHOOSE_MODELS(ArrayList<OrderDetailModel> PRODUCT_CHOOSE_MODELS) {
        this.PRODUCT_CHOOSE_MODELS = PRODUCT_CHOOSE_MODELS;
    }
}
