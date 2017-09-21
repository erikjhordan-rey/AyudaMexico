package io.github.erikcaffrey.ayudamexico.home;

import android.support.v4.app.Fragment;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.announcement.AnnouncementFragment;
import io.github.erikcaffrey.ayudamexico.areas.AreasFragment;
import io.github.erikcaffrey.ayudamexico.bloodbank.BloodBankFragment;
import io.github.erikcaffrey.ayudamexico.centers.GatheringFragment;
import io.github.erikcaffrey.ayudamexico.donations.DonationsFragment;
import io.github.erikcaffrey.ayudamexico.finder.PeopleFinderFragment;
import io.github.erikcaffrey.ayudamexico.hospitals.HospitalsFragment;
import io.github.erikcaffrey.ayudamexico.hostels.HostelsFragment;
import io.github.erikcaffrey.ayudamexico.internet.InternetFragment;
import io.github.erikcaffrey.ayudamexico.phones.PhonesFragment;
import io.github.erikcaffrey.ayudamexico.realtime.RealTimeFragment;

class NavigationFragmentFactory {

    private static int title = 0;

    static Fragment create(int itemId) {
        Fragment fragment = null;
        switch (itemId) {
            case R.id.nav_hospitals:
                fragment = HospitalsFragment.newInstance();
                title = R.string.hospitals;
                break;
            case R.id.nav_blood_bank:
                fragment = BloodBankFragment.newInstance();
                title = R.string.blood_bank;
                break;
            case R.id.nav_hotels:
                fragment = HostelsFragment.newInstance();
                title = R.string.hostels;
                break;
            case R.id.nav_gathering:
                fragment = GatheringFragment.newInstance();
                title = R.string.gathering_center;
                break;
            case R.id.nav_phones:
                fragment = PhonesFragment.newInstance();
                title = R.string.phones;
                break;
            case R.id.nav_areas:
                fragment = AreasFragment.newInstance();
                title = R.string.affected_areas;
                break;
            case R.id.nav_real_time:
                fragment = RealTimeFragment.newInstance();
                title = R.string.real_time;
                break;
            case R.id.nav_person_finder:
                fragment = PeopleFinderFragment.newInstance();
                title = R.string.person_finder;
                break;
            case R.id.nav_wifi:
                fragment = InternetFragment.newInstance();
                title = R.string.internet_connection;
                break;

            case R.id.nav_announcement:
                fragment = AnnouncementFragment.newInstance();
                title = R.string.announcement;
                break;

            case R.id.nav_donations:
                fragment = DonationsFragment.newInstance();
                title = R.string.donations;
                break;
        }
        return fragment;
    }

    static int getTitle() {
        return title;
    }
}
