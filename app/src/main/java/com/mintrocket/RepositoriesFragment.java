package com.mintrocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoriesFragment extends Fragment implements RepositoryAdapter.Listener {

    private boolean mLoading;
    private RepositoryAdapter mAdapter;
    private LinearLayoutManager layoutManager;

    public static RepositoriesFragment newInstance() {
        return new RepositoriesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        request();
    }

    private void initUI(View root) {
        RecyclerView mRepositoryList = root.findViewById(R.id.repository_list);
        layoutManager = new LinearLayoutManager(getContext());
        mRepositoryList.setLayoutManager(layoutManager);
        mAdapter = new RepositoryAdapter(this);
        mRepositoryList.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                layoutManager.getOrientation());
        mRepositoryList.addItemDecoration(dividerItemDecoration);
        mRepositoryList.addOnScrollListener(listener);
    }

    private void request() {
        final int since = mAdapter.getItemCount();
        Call<List<Repository>> call = App.getApi().getData(since);
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                List<Repository> repositories = response.body();
                mAdapter.addRepositories(repositories);
                mLoading = false;
            }
            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
            }
        });
    }

    private final RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int totalItem = layoutManager.getItemCount();
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            if (!mLoading && lastVisibleItem == totalItem - 1) {
                mLoading = true;
                request();
            }
        }
    };

    @Override
    public void onClick(Repository repository) {
        RepositoryFragment fragment = RepositoryFragment.newInstance(repository.getHtmlUrl());
        MainActivity activity = (MainActivity) getActivity();
        activity.replaceFragment(fragment);
    }
}
