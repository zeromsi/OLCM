/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.edge.Converter_edge;
import olcm.business.edge.Edge;
import olcm.data.edge.Edges;
import olcm.data.edge_role_mapping.EdgeRoleMappings;
import olcm.data.edge_role_mapping.Repo_edgeRoleMapping;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_edgeRoleMapping {

    @Inject
    Repo_edgeRoleMapping repo_edgeRoleMapping;

    public Boolean save(EdgeRoleMapping object) {
        EdgeRoleMappings edgeRoleMappings = new EdgeRoleMappings();
        try {
            Converter_edgeRoleMapping.ViewToDataModelConverter(edgeRoleMappings, object);
            repo_edgeRoleMapping.create(edgeRoleMappings);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<EdgeRoleMapping> getAll() {
        List<EdgeRoleMapping> allEdgeRoleMapping = new ArrayList();
        List<EdgeRoleMappings> allEdgeRoleMappings = repo_edgeRoleMapping.readAll();
        for (int i = 0; i < allEdgeRoleMappings.size(); i++) {
            EdgeRoleMapping edgeRoleMapping = new EdgeRoleMapping();
            Converter_edgeRoleMapping.dataToViewModelConverter(allEdgeRoleMappings.get(i), edgeRoleMapping);
            allEdgeRoleMapping.add(edgeRoleMapping);
        }
        return allEdgeRoleMapping;
    }
}
