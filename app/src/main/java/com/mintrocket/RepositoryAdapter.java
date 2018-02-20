package com.mintrocket;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private final List<Repository> mRepositories = new ArrayList<>();
    private final RepositoryViewHolder.Listener mListener;

    public interface Listener {
        void onClick(Repository repository);
    }

    RepositoryAdapter(final Listener listener) {
        mListener = new RepositoryViewHolder.Listener() {
            @Override
            public void onClick(int position) {
                listener.onClick(mRepositories.get(position));
            }
        };
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new RepositoryViewHolder(inflater.inflate(R.layout.item_repository, parent, false), mListener);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bind(mRepositories.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    void addRepositories(List<Repository> repositories) {
        mRepositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
