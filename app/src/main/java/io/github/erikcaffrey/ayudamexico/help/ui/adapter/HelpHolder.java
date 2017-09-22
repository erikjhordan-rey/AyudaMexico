package io.github.erikcaffrey.ayudamexico.help.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HelpHolder extends RecyclerView.ViewHolder  {

    private HelpPresenter presenter;

    @BindView(R.id.nivel)
    TextView nivel;

    @BindView(R.id.title_help_no_required)
    TextView title_help_no_required;

    @BindView(R.id.help_required)
    TextView help_required;

    @BindView(R.id.help_no_required)
    TextView help_no_required;

    @BindView(R.id.direction)
    TextView direction;


    @BindView(R.id.zone)
    TextView zone;


    @BindView(R.id.detail)
    TextView detail;

    @BindView(R.id.date_update)
    TextView date_update;


    public HelpHolder(View itemView, HelpPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this,itemView);
    }

    private void onItemClick(final Help help) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(help);
            }
        });
    }

        public void render(Help help) {
            onItemClick(help);
            renderNivel(help);

            help_required.setText(help.getHelpRequired());
            renderNoRequired(help);
            direction.setText(help.getAddress());
            zone.setText(help.getZone());
            detail.setText(help.getDetail());
            date_update.setText(help.getUpdateDate());

    }

    private void renderNoRequired(Help help) {
        if (help.getNotRequired().trim().equals("")){
            title_help_no_required.setVisibility(View.GONE);
            help_no_required.setVisibility(View.GONE);
        }else{
            help_no_required.setText(help.getNotRequired());
        }
    }

    private void renderNivel(Help help) {

        String nivelText = help.getLevelOfUrgency().toLowerCase().trim();

            if (nivelText.equalsIgnoreCase("alto"))
                nivel.setBackgroundResource(R.color.colorAccent);
            else if (nivelText.equalsIgnoreCase("medio"))
                nivel.setBackgroundResource(R.color.orange);
            else if (nivelText.equalsIgnoreCase("bajo"))
                nivel.setBackgroundResource(R.color.colorPrimaryDark);


        nivel.setText(help.getLevelOfUrgency());
    }
}
