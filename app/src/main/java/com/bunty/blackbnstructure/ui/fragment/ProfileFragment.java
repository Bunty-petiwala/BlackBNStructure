package com.bunty.blackbnstructure.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bunty.blackbnstructure.R;

public class ProfileFragment extends Fragment implements  View.OnClickListener{

    private Button mBtnNewFrag;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialized(view);
    }

    private void initialized(View view){
        mBtnNewFrag = view.findViewById(R.id.btn_new_frag);
        mBtnNewFrag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_new_frag:
                  Navigation.findNavController(v).navigate(
                          ProfileFragmentDirections.
                                  actionProfileFragmentToProfileSettingsFragment());
                break;

        }
    }
}
