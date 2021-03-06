package com.khiancode.android.farmtogetherguide.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.khiancode.android.farmtogetherguide.MainActivity;
import com.khiancode.android.farmtogetherguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {


    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.btnMenu1)
    FrameLayout btnMenu1;
    @BindView(R.id.btnMenu2)
    FrameLayout btnMenu2;
    @BindView(R.id.btnMenu3)
    FrameLayout btnMenu3;
    Unbinder unbinder;
    @BindView(R.id.panelMenu)
    FrameLayout panelMenu;

    boolean shouldClick = false;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        imgLogo.setVisibility(View.INVISIBLE);
        panelMenu.setVisibility(View.INVISIBLE);

        startView();

        return view;
    }

    private void startView() {
        ((MainActivity) getActivity()).createSoundOpenPage(getActivity());

        panelMenu.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.BounceIn)
                .duration(600)
                .playOn(panelMenu);

        imgLogo.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.ZoomInUp)
                .duration(800)
                .playOn(imgLogo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnMenu1, R.id.btnMenu2, R.id.btnMenu3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnMenu1:
                MediaPlayer.create(getActivity(), R.raw.widget_wood_select_3).start();
                ((MainActivity) getActivity()).setStat(1);
                ((MainActivity) getActivity()).setFram(new MenuOneFragment());
                break;
            case R.id.btnMenu2:
                ((MainActivity) getActivity()).createSoundActionDenied(getActivity());
                break;
            case R.id.btnMenu3:
                MediaPlayer.create(getActivity(), R.raw.widget_wood_select_3).start();
                ((MainActivity) getActivity()).setStat(3);
                ((MainActivity) getActivity()).setFram(new SettingFragment());
                break;
        }
    }
}
