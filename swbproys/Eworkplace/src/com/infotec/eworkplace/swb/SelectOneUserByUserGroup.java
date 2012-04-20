package com.infotec.eworkplace.swb;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

public class SelectOneUserByUserGroup extends com.infotec.eworkplace.swb.base.SelectOneUserByUserGroupBase 
{
    public SelectOneUserByUserGroup(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public boolean filterObject(HttpServletRequest request, SemanticObject base_obj, SemanticObject filter_obj, SemanticProperty prop, String propName, String type, String mode, String lang) {        
        SWBModel m = (SWBModel) filter_obj.getModel().getModelObject().createGenericInstance();
        UserGroup filterUserGroup = UserGroup.ClassMgr.getUserGroup(getFilterUserGroupId(), m);
        if (filter_obj != null && filterUserGroup != null) {
            User filterUser = (User) filter_obj.createGenericInstance();
            if (filterUser.hasUserGroup(filterUserGroup)) {
                return false;
            }
        }
        return true;
    }
}
