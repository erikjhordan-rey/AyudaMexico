package io.github.erikcaffrey.ayudamexico.realtime;

public class CdmxRTFragment extends RealTimeFragment {

    public static CdmxRTFragment newInstance() {
        return new CdmxRTFragment();
    }

    @Override String getAffectedAreasUrl() {
        return MapUrl.CDMX;
    }
}
