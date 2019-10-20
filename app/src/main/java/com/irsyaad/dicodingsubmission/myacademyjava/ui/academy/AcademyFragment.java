package com.irsyaad.dicodingsubmission.myacademyjava.ui.academy;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.irsyaad.dicodingsubmission.myacademyjava.R;
import com.irsyaad.dicodingsubmission.myacademyjava.data.CourseEntity;
import com.irsyaad.dicodingsubmission.myacademyjava.utils.DataDummy;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcademyFragment extends Fragment {

    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private AcademyAdapter academyAdapter;

    private AcademyViewModel viewModel;
    private List<CourseEntity> courses;


    public AcademyFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new AcademyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCourse = view.findViewById(R.id.rv_academy);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            Log.d("buka", "AcademyFragment");
            viewModel = ViewModelProviders.of(this).get(AcademyViewModel.class);
            courses = viewModel.getCourses();

            academyAdapter = new AcademyAdapter(getActivity());
            academyAdapter.setListCourses(courses);

            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(academyAdapter);
        }
    }
}
