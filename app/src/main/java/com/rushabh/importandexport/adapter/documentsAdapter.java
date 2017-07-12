package com.rushabh.importandexport.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rushabh.importandexport.R;
import com.rushabh.importandexport.dataObject.topic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Rushabh on 7/7/2017.
 */

public class documentsAdapter extends RecyclerView.Adapter<documentsAdapter.PersonViewHolder> implements View.OnClickListener {

    private ArrayList<topic> topicList;
    private Context context;

    public documentsAdapter(ArrayList<topic> topicList, Context context) {
        this.topicList = topicList;
        this.context = context;
    }

    @Override
    public documentsAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_document, parent, false);
        return new documentsAdapter.PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(documentsAdapter.PersonViewHolder holder, int position) {
        topic topic = topicList.get(position);
        holder.docName.setText(topic.getTitle());
        holder.download.setTag(R.string.about_us,holder.cv);
        holder.download.setTag(R.string.app_name, topic.getDescription());//topic.getDescription() is file name
        File file = new File("/sdcard/importExport/" + topic.getDescription());
        if (file.exists())
            holder.cv.setBackgroundColor(ContextCompat.getColor(context, R.color.LightGrey));
        holder.download.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    @Override
    public void onClick(View v) {
        String fileName = (String) v.getTag(R.string.app_name);
        CardView cv = (CardView) v.getTag(R.string.about_us);
        if (isStoragePermissionGranted()) {
            copyAssets(fileName,cv);
        } else {
            Toast.makeText(context, "Permission is not granted", Toast.LENGTH_SHORT).show();
        }
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView download;
        TextView docName;
        CardView cv;

        public PersonViewHolder(View itemView) {
            super(itemView);
            docName = (TextView) itemView.findViewById(R.id.docName);
            cv = (CardView) itemView.findViewById(R.id.cv);
            download = (ImageView) itemView.findViewById(R.id.download);
        }
    }

    private void copyAssets(String fileName, CardView cv) {
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) {
            for (String filename : files) {
                InputStream in = null;
                OutputStream out = null;
                try {
                    if (filename.equals(fileName)) {
                        in = assetManager.open(filename);
                        String path = "/sdcard/importExport/";
                        File dir = new File(path);
                        if (!dir.exists()) dir.mkdirs();
                        if (new File(path + filename).exists()) {
                            Toast.makeText(context, "FIle already exists to your storage in importExport folder", Toast.LENGTH_SHORT).show();
                        } else {
                            File outFile = new File(dir, filename);
                            out = new FileOutputStream(outFile);
                            copyFile(in, out);
                            Toast.makeText(context, "file added to your storage in importExport folder", Toast.LENGTH_SHORT).show();
                            cv.setBackgroundColor(ContextCompat.getColor(context, R.color.LightGrey));
                        }
                    }
                } catch (IOException e) {
                    Log.e("tag", "Failed to copy asset file: " + filename, e);
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }
}
