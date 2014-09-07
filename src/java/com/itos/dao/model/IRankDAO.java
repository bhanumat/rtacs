/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Rank;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IRankDAO {

    public JqGridResponse<Rank> getList(JqGridRequest req);
    
    public MessageResponse setDeleteRank(MessageRequest req);
    
    public MessageResponse setSaveNewRank(Rank rank);

    public MessageResponse setSaveEditRank(Rank rank);
    
    public Rank getLoadRank(Rank rank);

    public List<Rank> getListInJSONRank(char status);
}
