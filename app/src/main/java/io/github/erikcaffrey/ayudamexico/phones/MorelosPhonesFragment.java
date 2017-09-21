package io.github.erikcaffrey.ayudamexico.phones;

import java.util.ArrayList;

/**
 * Created by silmood on 9/21/17.
 */

public class MorelosPhonesFragment extends PhonesFragment{
    @Override
    ArrayList<Phone> getPhones() {
        return PhoneSource.getMorelosPhones();
    }
}
