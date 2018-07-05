package ente.quack.quack;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EntenFragment extends Fragment {

    private ImageView enteView;
    private Button optionButton;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //RootView
        final View view = inflater.inflate(R.layout.fragment_ente, container, false);

        //Referenzattribute für Button, Bild und Text
        enteView = view.findViewById(R.id.entenView);
        optionButton = view.findViewById(R.id.optionButton);
        textView = view.findViewById(R.id.textView);

        //Listeners
        enteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(FullscreenActivity.this, entenSound);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });

                mp.start();
            }
        });

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.fragment_container, new OptionFragment());
                ft.commit();
            }
        });

        return view;
    }
}
