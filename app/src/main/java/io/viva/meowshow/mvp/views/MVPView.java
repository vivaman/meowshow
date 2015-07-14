package io.viva.meowshow.mvp.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface MVPView {

    Context getContext();

    void init(LayoutInflater inflater, ViewGroup container);

    View getView();
}
