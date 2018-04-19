/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_status_mapping;

import olcm.data.class_type.*;
import olcm.data.crud_action_event.*;
import olcm.data.edge.*;
import olcm.data.edge_role_mapping.*;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_classStatusMapping extends Repo_OLCM<ClassStatusMappings>{

    public Repo_classStatusMapping() {
        super(ClassStatusMappings.class);
    }
    
}
