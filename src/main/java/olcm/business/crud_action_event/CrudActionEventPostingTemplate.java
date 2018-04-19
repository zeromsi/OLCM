/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

/**
 *
 * @author Admin
 */
public class CrudActionEventPostingTemplate {

    private Long id;

    private Long classType;
    private Long classStatus;

    private Long actionEvent;

    private Long role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassType() {
        return classType;
    }

    public void setClassType(Long classType) {
        this.classType = classType;
    }

    public Long getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Long classStatus) {
        this.classStatus = classStatus;
    }

    public Long getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(Long actionEvent) {
        this.actionEvent = actionEvent;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

}
