package io.github.erikcaffrey.ayudamexico.areas;

public class MorelosMapFragment extends MapFragment {

    public static MorelosMapFragment newInstance() {
        return new MorelosMapFragment();
    }

    @Override String getAffectedAreasUrl() {
        return MapSource.MORELOS_MAP_URL;
    }
}
