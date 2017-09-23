package io.github.erikcaffrey.ayudamexico.realtime;

public class VerificadosRTFragment extends RealTimeFragment {

    public static VerificadosRTFragment newInstance() {
        return new VerificadosRTFragment();
    }

    @Override String getAffectedAreasUrl() {
        return MapUrl.VERIFICADOS;
    }
}
