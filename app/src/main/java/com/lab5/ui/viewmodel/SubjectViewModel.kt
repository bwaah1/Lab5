package com.lab5.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lab5.data.dao.SubjectDao
import com.lab5.data.dao.SubjectLabsDao
import com.lab5.data.entity.SubjectEntity
import com.lab5.data.entity.SubjectLabEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectViewModel(
    private val subjectDao: SubjectDao,
    private val subjectLabsDao: SubjectLabsDao
) : ViewModel() {

    private val _subjects = MutableStateFlow<List<SubjectEntity>>(emptyList())
    val subjects: StateFlow<List<SubjectEntity>> = _subjects

    private val _subjectDetails = MutableStateFlow<SubjectEntity?>(null)
    val subjectDetails: StateFlow<SubjectEntity?> = _subjectDetails

    private val _labs = MutableStateFlow<List<SubjectLabEntity>>(emptyList())
    val labs: StateFlow<List<SubjectLabEntity>> = _labs

    fun fetchSubjects() {
        viewModelScope.launch {
            _subjects.value = subjectDao.getAllSubjects()
        }
    }

    fun fetchSubjectDetails(subjectId: Int) {
        viewModelScope.launch {
            _subjectDetails.value = subjectDao.getSubjectById(subjectId)
            _labs.value = subjectLabsDao.getSubjectLabsBySubjectId(subjectId)
        }
    }

    fun updateLab(lab: SubjectLabEntity) {
        viewModelScope.launch {
            subjectLabsDao.updateSubjectLab(lab)
            fetchSubjectDetails(lab.subjectId)
        }
    }
}
