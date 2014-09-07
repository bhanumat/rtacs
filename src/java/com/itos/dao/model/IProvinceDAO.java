/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Province;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IProvinceDAO {

    public JqGridResponse<Province> getList(JqGridRequest req);
    
    public MessageResponse setDeleteProvince(MessageRequest req);
    
    public MessageResponse setSaveNewProvince(Province province);

    public MessageResponse setSaveEditProvince(Province province);
    
    public Province getLoadProvince(Province province);

    public List<Province> getListInJSONProvince(char status);
}
