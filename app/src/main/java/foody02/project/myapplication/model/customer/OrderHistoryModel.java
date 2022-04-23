package foody02.project.myapplication.model.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderHistoryModel implements Serializable {
    private ArrayList<OrderModel> listOrderHistory;

    public ArrayList<OrderModel> getListOrderHistory() {
        return listOrderHistory;
    }

    public void setListOrderHistory(ArrayList<OrderModel> listOrderHistory) {
        this.listOrderHistory = listOrderHistory;
    }
}
