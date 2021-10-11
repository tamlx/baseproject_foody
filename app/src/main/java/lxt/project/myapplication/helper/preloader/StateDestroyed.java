package lxt.project.myapplication.helper.preloader;

class StateDestroyed extends StateBase {
    StateDestroyed(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean destroy() {
        return false;
    }

    @Override
    public String name() {
        return "StateDestroyed";
    }
}
