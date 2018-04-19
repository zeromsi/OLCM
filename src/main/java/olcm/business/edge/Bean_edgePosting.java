/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.action_event.ActionEvent;
import olcm.business.action_event.Bean_actionEvent;
import olcm.business.class_status.Bean_classStatus;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.Bean_classType;
import olcm.business.class_type.ClassType;
import olcm.business.edge_role_mapping.Bean_edgeRoleMappingPosting;
import olcm.business.edge_role_mapping.EdgeRoleMappingPostingTemplate;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_edgePosting {

    @Inject
    Bean_edge bean_edge;
    @Inject
    Bean_classType bean_classType;
    @Inject
    Bean_classStatus bean_classStatus;
    @Inject
    Bean_actionEvent bean_actionEvent;
    @Inject
    Bean_edgeRoleMappingPosting bean_edgeRoleMappingPosting;

    public Boolean save(EdgePostingTemplate edgePostingTemplate) {
        ClassType classType = new ClassType();
        ClassStatus classStatus = new ClassStatus();
        ActionEvent actionEvent = new ActionEvent();
        ClassStatus endStatus = new ClassStatus();
        classType = bean_classType.getById(edgePostingTemplate.getClassType());
        classStatus = bean_classStatus.getById(edgePostingTemplate.getStatus());
        actionEvent = bean_actionEvent.getById(edgePostingTemplate.getActionEvent());
        endStatus = bean_classStatus.getById(edgePostingTemplate.getEndStatus());

        Edge edge = new Edge();
        edge.setId(edgePostingTemplate.getId());
        edge.setActionEvent(actionEvent);
        edge.setClassType(classType);
        edge.setEdgeRolMappings(null);
        edge.setEndStatus(endStatus);
        edge.setStatus(classStatus);
        try {
            bean_edge.save(edge);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean save(List<EdgeAndEdgeRoleMappingPostingTemplate> edgeAndEdgeRoleMappingPostingTemplates) {

        try {
            for (int i = 0; i < edgeAndEdgeRoleMappingPostingTemplates.size(); i++) {
                EdgePostingTemplate edgePostingTemplate = new EdgePostingTemplate();
                edgePostingTemplate = edgeAndEdgeRoleMappingPostingTemplates.get(i).getEdgePostingTemplate();
                individualInsertionOfEdge(edgePostingTemplate);
                InsertionOfEdgeRoleMapping(edgeAndEdgeRoleMappingPostingTemplates, i, edgePostingTemplate);
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void InsertionOfEdgeRoleMapping(List<EdgeAndEdgeRoleMappingPostingTemplate> edgeAndEdgeRoleMappingPostingTemplates, int i, EdgePostingTemplate edgePostingTemplate) {
        List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List = new ArrayList<>();
        for (int j = 0; j < edgeAndEdgeRoleMappingPostingTemplates.get(i).getRole().size(); j++) {
            EdgeRoleMappingPostingTemplate edgeRoleMappingPostingTemplate = new EdgeRoleMappingPostingTemplate();
            edgeRoleMappingPostingTemplate.setEdge(edgePostingTemplate.getId());
            edgeRoleMappingPostingTemplate.setRole(edgeAndEdgeRoleMappingPostingTemplates.get(i).getRole().get(j));
            edgeRoleMappingPostingTemplate_List.add(edgeRoleMappingPostingTemplate);
        }
        bean_edgeRoleMappingPosting.save(edgeRoleMappingPostingTemplate_List);
    }

    private void individualInsertionOfEdge(EdgePostingTemplate edgePostingTemplate) {
        ClassType classType = new ClassType();
        ClassStatus classStatus = new ClassStatus();
        ActionEvent actionEvent = new ActionEvent();
        ClassStatus endStatus = new ClassStatus();
        classType = bean_classType.getById(edgePostingTemplate.getClassType());
        classStatus = bean_classStatus.getById(edgePostingTemplate.getStatus());
        actionEvent = bean_actionEvent.getById(edgePostingTemplate.getActionEvent());
        endStatus = bean_classStatus.getById(edgePostingTemplate.getEndStatus());
        Edge edge = new Edge();
        edge.setId(edgePostingTemplate.getId());
        edge.setActionEvent(actionEvent);
        edge.setClassType(classType);
        edge.setEdgeRolMappings(null);
        edge.setEndStatus(endStatus);
        edge.setStatus(classStatus);
        bean_edge.save(edge);
    }
}
