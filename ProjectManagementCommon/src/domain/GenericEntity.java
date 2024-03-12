/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface GenericEntity extends Serializable{
    
    String getTableName();
    
    String getInsertColumns();

    String getInsertValues();

    void setDbId(Long id);

    String getUpdateQuery();

    String getWhereQuery();
    
    List<GenericEntity> getAllObjects(ResultSet rs);

    String getWhereQueryWithFilter(Object filter);

    String getWhereQueryWithObject(Object object);    
    
}
