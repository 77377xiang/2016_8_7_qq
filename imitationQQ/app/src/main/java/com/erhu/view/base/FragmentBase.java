package com.erhu.view.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erhu.view.loading.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class FragmentBase extends Fragment {
    LoadingDialog loadingDialog;

    public abstract int getContentViewId();

    protected Context context;
    protected View rootView;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadingDialog = new LoadingDialog(this.getActivity());
        rootView = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        this.context = getActivity();
        initViews(savedInstanceState);
        return rootView;
    }

    protected abstract void initViews(Bundle bundle);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       unbinder.unbind();
    }

    public void showDialog() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public void showDialogwithString(String string) {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
            loadingDialog.setDialogString(string);
        }
    }

    public void dissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}
