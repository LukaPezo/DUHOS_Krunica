package hr.ferit.kreso.krunica;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class Dialog extends AppCompatDialogFragment {

    private RadioButton radioButtonWe,radioButtonThem;

    private Call_dialogListener listener;

    @NonNull
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder=new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater=getActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View view=inflater.inflate(R.layout.activity_dialog,null);

        radioButtonWe=view.findViewById(R.id.callWe);
        radioButtonThem=view.findViewById(R.id.callThem);

        builder.setView(view).setTitle(" ")
                .setPositiveButton("OK", (dialog, which) -> {
                    if (!radioButtonWe.isChecked() && !radioButtonThem.isChecked()) {
                        Dialog call_dialog = new Dialog();
                        call_dialog.setCancelable(false);
                        assert getFragmentManager() != null;
                        call_dialog.show(getFragmentManager(), "tag");
                    }
                    if (radioButtonWe.isChecked()) {
                        listener.applySelected("Krunica");
                    }
                    if (radioButtonThem.isChecked()){
                        listener.applySelected("Litanije");
                    }
                })
                .setOnKeyListener((dialog, keyCode, event) -> {
                    if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_UP){
                        Toast.makeText(getContext(),"Odaberi tko je zvao",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    return false;
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(Call_dialogListener)context;
        } catch (ClassCastException e) {
            throw  new ClassCastException((context.toString() + "must implement Call_dialogListener"));
        }
    }

    public interface Call_dialogListener{
        void applySelected(String data);
    }

}
