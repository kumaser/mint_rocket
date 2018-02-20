package com.mintrocket;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class RepositoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mName;
    private TextView mOwnerLogin;
    private TextView mDescription;
    private Listener mListener;

    interface Listener {
        void onClick(int position);
    }

    RepositoryViewHolder(View itemView, Listener listener) {
        super(itemView);
        mListener = listener;
        mName = itemView.findViewById(R.id.name);
        mOwnerLogin = itemView.findViewById(R.id.owner_login);
        mDescription = itemView.findViewById(R.id.description);
        itemView.setOnClickListener(this);
    }

    void bind(Repository repository) {
        mName.setText(repository.getName());
        mOwnerLogin.setText(repository.getOwner().getLogin());
        mDescription.setText(repository.getDescription());
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(getAdapterPosition());
    }
}
