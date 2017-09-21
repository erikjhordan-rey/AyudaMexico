package io.github.erikcaffrey.ayudamexico.areas;

public class PueblaMapFragment extends MapFragment {

    public static PueblaMapFragment newInstance() {
        return new PueblaMapFragment();
    }

    @Override String getAffectedAreasUrl() {
        return MapSource.PUEBLA_MAP_URL;
    }
}
