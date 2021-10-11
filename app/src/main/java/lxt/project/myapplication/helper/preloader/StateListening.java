package lxt.project.myapplication.helper.preloader;

import lxt.project.myapplication.helper.preloader.interfaces.DataListener;

class StateListening extends StateBase {
    StateListening(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean dataLoadFinished() {
        super.dataLoadFinished();
        return worker.doSendLoadedDataToListenerWork();
    }

    @Override
    public boolean listenData(DataListener listener) {
        super.listenData(listener);
        return worker.doAddListenerWork(listener);
    }

    @Override
    public String name() {
        return "StateListening";
    }
}
