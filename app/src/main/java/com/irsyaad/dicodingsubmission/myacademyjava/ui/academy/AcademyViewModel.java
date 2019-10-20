package com.irsyaad.dicodingsubmission.myacademyjava.ui.academy;

import androidx.lifecycle.ViewModel;

import com.irsyaad.dicodingsubmission.myacademyjava.data.CourseEntity;
import com.irsyaad.dicodingsubmission.myacademyjava.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {
    public List<CourseEntity> getCourses() {
        return DataDummy.generateDummyCourses();
    }
}
