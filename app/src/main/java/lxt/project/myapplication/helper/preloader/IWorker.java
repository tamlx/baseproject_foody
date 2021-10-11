package lxt.project.myapplication.helper.preloader;


import java.util.concurrent.ExecutorService;

import lxt.project.myapplication.helper.preloader.interfaces.DataListener;

interface IWorker {

    /**
     * set thread-pool executor for current worker
     * @param threadPoolExecutor thread-pool executor
     */
    void setThreadPoolExecutor(ExecutorService threadPoolExecutor);

    /**
     * start to load data
     */
    boolean preLoad();

    /**
     * refresh worker
     */
    boolean refresh();

    /**
     * start to listen data with {@link DataListener}
     * @param dataListener {@link DataListener}
     */
    boolean listenData(DataListener dataListener);

    /**
     * start to listen data with no {@link DataListener}
     * you can add {@link DataListener} later
     */
    boolean listenData();

    /**
     * remove {@link DataListener} for worker
     * @param listener {@link DataListener}
     */
    boolean removeListener(DataListener listener);

    /**
     * destroy this worker
     */
    boolean destroy();
}
