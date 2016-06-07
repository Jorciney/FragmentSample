package be.myitworld.fragmentsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.myitworld.fragmentsample.R;

/**
 * Created by Jorciney on 7/06/2016.
 */
public class Fragment02 extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_02, container, false);
        return view;
    }
}
