/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.jqGrid;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Maps a jQgrid JSON query to a {@link JqgridFilter} instance
 */
public class JqgridObjectMapper {

    public static Filter map(String jsonString) {

        if (jsonString != null) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                return mapper.readValue(jsonString, Filter.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}
