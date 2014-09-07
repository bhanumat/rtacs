/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.Title;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface ITitleService {

    public JqGridResponse<Title> getListTitle(JqGridRequest req);

    public MessageResponse setDeleteTitle(MessageRequest req);
    
    public MessageResponse setSaveNewTitle(Title title);
    
    public MessageResponse setSaveEditTitle(Title title);
    
    public Title getLoadTitle(Title title);

    public List<Title> getListInJSONTitle(char status);

}
