/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_status.Repo_classStatus;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_classStatus {

    @Inject
    Repo_classStatus repo_classStatus;

    public Boolean save(ClassStatus object) {
        ClassStatuses classStatuses = new ClassStatuses();
        try {
            Converter_classStatus.ViewToDataModelConverter(classStatuses, object);
            repo_classStatus.create(classStatuses);
            ClassStatus classStatus = new ClassStatus();
            Converter_classStatus.dataToViewModelConverter(classStatuses, classStatus);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

     public Boolean edit(ClassStatus classStatus) {
        ClassStatuses classStatuses = new ClassStatuses();
        try {
            Converter_classStatus.ViewToDataModelConverter(classStatuses, classStatus);
            repo_classStatus.update(classStatuses);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public ClassStatus getById(Object Id) {
        ClassStatuses classStatuses = new ClassStatuses();
        classStatuses = repo_classStatus.read(Id);
        ClassStatus classStatus = new ClassStatus();
        Converter_classStatus.dataToViewModelConverter(classStatuses, classStatus);
        return classStatus;
    }

    public List<ClassStatus> getAll() {
        List<ClassStatus> allClassStatus = new ArrayList();
        List<ClassStatuses> ClassStatuses = repo_classStatus.readAll();
        getListOfViewModelFromDataModel(ClassStatuses, allClassStatus);
        return allClassStatus;
    }

    private void getListOfViewModelFromDataModel(List<ClassStatuses> ClassStatuses, List<ClassStatus> allClassStatus) {
        for (int i = 0; i < ClassStatuses.size(); i++) {
            ClassStatus classStatus = new ClassStatus();
            Converter_classStatus.dataToViewModelConverter(ClassStatuses.get(i), classStatus);
            allClassStatus.add(classStatus);
        }
    }

    public List<ClassStatus> allStatusOfAClass(long classId) throws ParseException {
        List<ClassStatus> allClassStatus = new ArrayList();
        List<ClassStatuses> ClassStatuses = repo_classStatus.allStatusOfAClass(classId);
        getListOfViewModelFromDataModel(ClassStatuses, allClassStatus);
        return allClassStatus;
    }
    
    
}
