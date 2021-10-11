package lxt.project.myapplication.helper.preloader.interfaces;

public interface DataListener<DATA> {
    /**
     * do something with loaded data
     * Note: this method runs in main-thread
     * @param data loaded data (maybe null when load failed)
     */
    void onDataArrived(DATA data);
}
