package com.irsyaad.dicodingsubmission.myacademyjava.ui.detail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.irsyaad.dicodingsubmission.myacademyjava.R;
import com.irsyaad.dicodingsubmission.myacademyjava.data.ModuleEntity;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseAdapter extends RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder> {

    private List<ModuleEntity> mModules = new ArrayList<>();

    void setModules(List<ModuleEntity> modules) {
        if (modules == null) return;
        mModules.clear();
        mModules.addAll(modules);
    }

    @NonNull
    @Override
    public DetailCourseAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_module_list, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailCourseAdapter.ModuleViewHolder viewHolder, int position) {
        Log.d("course", ""+mModules);
        viewHolder.bind(mModules.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mModules.size();
    }

    class ModuleViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitle;

        ModuleViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);
        }

        void bind(String title) {
            textTitle.setText(title);
        }
    }
}
