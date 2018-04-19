/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.role;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.class_type.ClassTypes;
import olcm.data.role.Repo_role;
import olcm.data.role.Roles;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_role {

    @Inject
    Repo_role repo_role;

       public Boolean save(Role object) {
        Roles roles = new Roles();
        try {
            Converter_role.ViewToDataModelConverter(roles, object);
            repo_role.create(roles);
            Role role = new Role();
            Converter_role.dataToViewModelConverter(roles, role);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public Role getById(Object Id) {
        Roles roles = new Roles();
        roles = repo_role.read(Id);
        Role role = new Role();
        Converter_role.dataToViewModelConverter(roles, role);
        return role;
    }

    public List<Role> getAll() {
        List<Role> allRole = new ArrayList();
        List<Roles> allRoles = repo_role.readAll();
        for (int i = 0; i < allRoles.size(); i++) {
            Role role = new Role();
            Converter_role.dataToViewModelConverter(allRoles.get(i), role);
            allRole.add(role);
        }
        return allRole;
    }

}
