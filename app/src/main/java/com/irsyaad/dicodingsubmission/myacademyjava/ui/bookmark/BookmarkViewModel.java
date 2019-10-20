package com.irsyaad.dicodingsubmission.myacademyjava.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.irsyaad.dicodingsubmission.myacademyjava.data.CourseEntity;
import com.irsyaad.dicodingsubmission.myacademyjava.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}
