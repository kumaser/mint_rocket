package com.mintrocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class RepositoryFragment extends Fragment {

    public static RepositoryFragment newInstance(String homeUrl) {
        Bundle bundle = new Bundle();
        bundle.putString(Arguments.HOME_URL, homeUrl);
        RepositoryFragment fragment = new RepositoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repository, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView mRepositoryPage = view.findViewById(R.id.repository_page);
        String homeUrl = getArguments().getString(Arguments.HOME_URL);
        mRepositoryPage.loadUrl(homeUrl);
    }

    interface Arguments {
        String HOME_URL = "home_url";
    }
}
