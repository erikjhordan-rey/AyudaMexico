package io.github.erikcaffrey.ayudamexico.phones;

import java.util.ArrayList;


public class CdmxPhonesFragment extends PhonesFragment {
    @Override
    ArrayList<Phone> getPhones() {
        return PhoneSource.getCdmxPhones();
    }
}
