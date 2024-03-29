package com.irsyaad.dicodingsubmission.myacademyjava.ui.bookmark;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
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
public class BookmarkFragment extends Fragment implements BookmarkFragmentCallback{

    private RecyclerView rvBookmark;
    private ProgressBar progressBar;
    private BookmarkAdapter adapter;

    private BookmarkViewModel viewModel;
    private List<CourseEntity> courses;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new BookmarkFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvBookmark = view.findViewById(R.id.rv_bookmark);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onShareClick(CourseEntity course) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(String.format("Segera daftar kelas %s di dicoding.com", course.getTitle()))
                    .startChooser();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            Log.d("buka", "BookmarkFragment");
            viewModel = ViewModelProviders.of(this).get(BookmarkViewModel.class);
            courses = viewModel.getBookmarks();

            adapter = new BookmarkAdapter(getActivity(), this);
            adapter.setListCourses(DataDummy.generateDummyCourses());

            rvBookmark.setLayoutManager(new LinearLayoutManager(getContext()));
            rvBookmark.setHasFixedSize(true);
            rvBookmark.setAdapter(adapter);
        }
    }
}
