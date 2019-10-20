package com.irsyaad.dicodingsubmission.myacademyjava.ui.detail;

import androidx.lifecycle.ViewModel;

import com.irsyaad.dicodingsubmission.myacademyjava.data.CourseEntity;
import com.irsyaad.dicodingsubmission.myacademyjava.data.ModuleEntity;
import com.irsyaad.dicodingsubmission.myacademyjava.utils.DataDummy;

import java.util.List;

public class DetailCourseViewModel extends ViewModel {
    private CourseEntity mCourse;
    private String courseId;

    CourseEntity getCourse() {
        for (int i = 0; i < DataDummy.generateDummyCourses().size(); i++) {
            CourseEntity courseEntity = DataDummy.generateDummyCourses().get(i);
            if (courseEntity.getCourseId().equals(courseId)) {
                mCourse = courseEntity;
            }
        }
        return mCourse;
    }

    List<ModuleEntity> getModules() {
        return DataDummy.generateDummyModules(getCourseId());
    }

    void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    String getCourseId(){
        return courseId;
    }
}
