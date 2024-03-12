/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import domain.GenericEntity;
import repository.Repository;

/**
 *
 * @author HP
 * @param <T>
 * @param <K>
 */
public interface DBRepository <T extends GenericEntity, K> extends Repository<GenericEntity, K>{
    
    default void connect() throws Exception{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    default void disconnect() throws Exception{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    default void commit() throws Exception{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    default void rollback() throws Exception{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
