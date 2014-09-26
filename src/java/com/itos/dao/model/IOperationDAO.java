/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.ext.OperationView;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IOperationDAO {

    public JqGridResponse<Operation> getList(JqGridRequest req);

    public MessageResponse setDeleteOperation(MessageRequest req);

    public MessageResponse setSaveNewOperation(Operation operation);

    public Operation saveNewOperation(Operation operation);

    public MessageResponse setSaveEditOperation(Operation operation);

    public Operation getLoadOperation(Operation operation);

    public List<Operation> getListInJSONOperation(char status);

    public MessageResponse setSaveNewOperationList(Operation operationPost);

    public JqGridResponse<OperationView> getListAPP041(JqGridRequest req);

    public JqGridResponse<OperationView> getListAPP031(JqGridRequest req);

    public JqGridResponse<Operation> getList(JqGridRequest req, int operationTypeCode);

}
