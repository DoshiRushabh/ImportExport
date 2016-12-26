package com.rushabh.importandexport.fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    WebView webView;

    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_web_view, container, false);

        webView = (WebView) v.findViewById(R.id.webview);

        Bundle bundle = getArguments();

        ((MainActivity) getActivity()).setActionBarTitle(bundle.getString("title"));

        webView = (WebView) v.findViewById(R.id.webview);


        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (!isNetwokAvailable()){
                    Toast.makeText(v.getContext(), "Internet is not avalable", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
                v.findViewById(R.id.loadingContainer).setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                v.findViewById(R.id.loadingContainer).setVisibility(View.GONE);
                //show webview
                webView.setVisibility(View.VISIBLE);
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl((String) bundle.get("url"));

        return v;
    }

    private boolean isNetwokAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onBackPressed()
    {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }

}
