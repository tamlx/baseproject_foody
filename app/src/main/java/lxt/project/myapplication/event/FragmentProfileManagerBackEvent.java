package lxt.project.myapplication.event;

import b.laixuantam.myaarlibrary.helper.BusHelper;

public class FragmentProfileManagerBackEvent {

    public static void post() {
        BusHelper.post(new FragmentProfileManagerBackEvent());
    }
}
