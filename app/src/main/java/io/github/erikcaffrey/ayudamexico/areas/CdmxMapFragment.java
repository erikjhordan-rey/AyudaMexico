package io.github.erikcaffrey.ayudamexico.areas;

public class CdmxMapFragment extends MapFragment {

    public static CdmxMapFragment newInstance() {
        return new CdmxMapFragment();
    }

    @Override String getAffectedAreasUrl() {
        return MapSource.CDMX_MAP_URL;
    }
}
