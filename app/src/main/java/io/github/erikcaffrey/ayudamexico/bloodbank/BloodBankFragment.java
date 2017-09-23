package io.github.erikcaffrey.ayudamexico.bloodbank;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class BloodBankFragment extends CoreFragment {

    private final static String map_hospital_angeles_pedregal = "https://www.google.com.mx/maps/place/Hospital+Angeles+del+Pedregal/@19.3119327,-99.2205768,15z/data=!4m5!3m4!1s0x0:0x68a20f8cccd3943!8m2!3d19.3119327!4d-99.2205768";
    private final static String map_hospital_angeles_lindavista = "https://www.google.com.mx/maps/place/Hospital+Angeles+Lindavista/@19.486621,-99.1323367,17z/data=!3m1!4b1!4m5!3m4!1s0x85cdff8c00000000:0x1b5b45a44293f318!8m2!3d19.486621!4d-99.130148";
    private final static String map_hospital_abc_constituyentes = "https://www.google.com.mx/maps/place/Centro+Medico+ABC+-+Campus+Observatorio/@19.3973859,-99.2130121,14z/data=!4m8!1m2!2m1!1sCentro+Medico+ABC+-+Campus+Observatorio!3m4!1s0x85d201c481cfa5b7:0xcc2f04a533f18aa9!8m2!3d19.4000673!4d-99.2034149";
    private final static String map_hospital_abc_observatorio = "https://www.google.com.mx/maps/place/Centro+Medico+ABC+-+Campus+Observatorio/@19.3973859,-99.2130121,14z/data=!4m8!1m2!2m1!1sCentro+Medico+ABC+-+Campus+Observatorio!3m4!1s0x85d201c481cfa5b7:0xcc2f04a533f18aa9!8m2!3d19.4000673!4d-99.2034149";
    private final static String map_hospital_siglo_xxi = "https://www.google.com.mx/maps/place/Centro+M%C3%A9dico+Nacional+Siglo+XXI/@19.4099388,-99.1527171,15z/data=!4m2!3m1!1s0x0:0xb3f49e0900720c7e?sa=X&ved=0ahUKEwiIpOmIsrXWAhVqy1QKHUoEBhsQ_BIIiQEwCg";
    private final static String map_hospital_abc_de_santa_fe = "https://www.google.com.mx/maps/place/Centro+M%C3%A9dico+ABC/@19.3781755,-99.2605491,14z/data=!4m8!1m2!2m1!1scentro+medico+abc+santa+fe!3m4!1s0x85d20735ee6910b5:0xf86253a248f5bed2!8m2!3d19.3562854!4d-99.282664";
    private final static String map_hospitals_del_imss = "https://www.google.com.mx/maps/search/imss+ciudad+de+mexico/@19.4189499,-99.2294785,12z/data=!3m1!4b1";
    private final static String map_hospitals_del_issste = "https://www.google.com.mx/maps/search/issste+ciudad+de+mexico/@19.4189231,-99.2294786,12z/data=!3m1!4b1";

    @BindView(R.id.label_hospital_angeles_pedregal)
    TextView labelHospitalAngelesPedregal;
    @BindView(R.id.label_hospital_angeles_lindavista)
    TextView labelHospitalAngelesLindavista;
    @BindView(R.id.label_hospital_abc_constituyentes)
    TextView labelHospitalAbcConstituyentes;
    @BindView(R.id.label_hospital_abc_observatorio)
    TextView labelHospitalAbcObservatorio;
    @BindView(R.id.label_hospital_siglo_xxi)
    TextView labelHospitalSigloXxi;
    @BindView(R.id.label_hospital_abc_de_santa_fe)
    TextView labelHospitalAbcDeSantaFe;
    @BindView(R.id.label_hospitals_del_imss)
    TextView labelHospitalsDelImss;
    @BindView(R.id.label_hospitals_del_issste)
    TextView labelHospitalsDelIssste;

    public static BloodBankFragment newInstance() {
        return new BloodBankFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.blood_bank_fragment;
    }

    @Override
    protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        setupLabels();
    }

    private void setupLabels() {
        labelHospitalAngelesPedregal.setPaintFlags(labelHospitalAngelesPedregal.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalAngelesLindavista.setPaintFlags(labelHospitalAngelesLindavista.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalAbcConstituyentes.setPaintFlags(labelHospitalAbcConstituyentes.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalAbcObservatorio.setPaintFlags(labelHospitalAbcObservatorio.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalSigloXxi.setPaintFlags(labelHospitalSigloXxi.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalAbcDeSantaFe.setPaintFlags(labelHospitalAbcDeSantaFe.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalsDelImss.setPaintFlags(labelHospitalsDelImss.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        labelHospitalsDelIssste.setPaintFlags(labelHospitalsDelIssste.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }


    @OnClick({R.id.label_hospital_angeles_pedregal, R.id.label_hospital_angeles_lindavista,
            R.id.label_hospital_abc_constituyentes, R.id.label_hospital_abc_observatorio,
            R.id.label_hospital_siglo_xxi, R.id.label_hospital_abc_de_santa_fe,
            R.id.label_hospitals_del_imss, R.id.label_hospitals_del_issste})
    public void clickLabelHospital(View view) {

        switch (view.getId()) {
            case R.id.label_hospital_angeles_pedregal:
                showMap(map_hospital_angeles_pedregal);
                break;
            case R.id.label_hospital_angeles_lindavista:
                showMap(map_hospital_angeles_lindavista);
                break;
            case R.id.label_hospital_abc_constituyentes:
                showMap(map_hospital_abc_constituyentes);
                break;
            case R.id.label_hospital_abc_observatorio:
                showMap(map_hospital_abc_observatorio);
                break;
            case R.id.label_hospital_siglo_xxi:
                showMap(map_hospital_siglo_xxi);
                break;
            case R.id.label_hospital_abc_de_santa_fe:
                showMap(map_hospital_abc_de_santa_fe);
                break;
            case R.id.label_hospitals_del_imss:
                showMap(map_hospitals_del_imss);
                break;
            case R.id.label_hospitals_del_issste:
                showMap(map_hospitals_del_issste);
                break;
        }

    }

    public void showMap(String urlMap) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(urlMap));
        startActivity(i);
    }
}
