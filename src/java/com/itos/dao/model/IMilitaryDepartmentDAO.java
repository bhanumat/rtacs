/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.MilitaryDepartment;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IMilitaryDepartmentDAO {

    public JqGridResponse<MilitaryDepartment> getList(JqGridRequest req);
    
    public MessageResponse setDeleteMilitaryDepartment(MessageRequest req);
    
    public MessageResponse setSaveNewMilitaryDepartment(MilitaryDepartment militaryDepartment);

    public MessageResponse setSaveEditMilitaryDepartment(MilitaryDepartment militaryDepartment);
    
    public MilitaryDepartment getLoadMilitaryDepartment(MilitaryDepartment militaryDepartment);
    
    public List<MilitaryDepartment> getListInJSONMilitaryDepartment(char status);
    
    /**
     * Lightweight get list of military departments.
     * @param status the active status
     * @return a collection of military departments if any; otherwise return empty collection
     */
    public List<MilitaryDepartment> getMilitaryDepartments(char status);
}
